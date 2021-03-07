USE BT;

-- Question 1: Tạo trigger không cho phép người dùng nhập vào Group có ngày tạo trước 1 năm trước
DROP TRIGGER IF EXISTS question1;
DELIMITER $$

CREATE  TRIGGER question1
BEFORE INSERT ON `group`
FOR EACH ROW
BEGIN
IF DATEDIFF(NOW(),NEW.CreateDate) >= 365 THEN
SIGNAL SQLSTATE '12345'
SET MESSAGE_text =' Không insert được :)';
END IF;
END $$
DELIMITER ;

INSERT INTO `group`(  GroupName			, CreatorID		, CreateDate) VALUES(N'Testing System1'		,   5			,'2018-03-05');

-- Question 2: Tạo trigger Không cho phép người dùng thêm bất kỳ user nào vào department "Sale" nữa, khi thêm thì hiện ra thông báo "Department "Sale" cannot add more user"
DROP TRIGGER IF EXISTS question2;
DELIMITER $$
CREATE  TRIGGER question2
BEFORE INSERT ON account
FOR EACH ROW
BEGIN
DECLARE DepartmentID_Sale INT;
SELECT 
    a.DepartmentID INTO DepartmentID_Sale
FROM
    account a
        JOIN
    department d ON a.DepartmentID = d.DepartmentID
WHERE
    DepartmentName = 'Sale'
GROUP BY a.DepartmentID ;
IF NEW.DepartmentID = DepartmentID_Sale THEN
SIGNAL SQLSTATE '12345'
SET MESSAGE_text ='Department "Sale" cannot add more user';
END IF;
END $$
DELIMITER ;
INSERT INTO Account  (Email								, Username			, FullName				, DepartmentID	, PositionID, CreateDate)
VALUES 				 ('account100@gmail.com'	        , 'hidan'			,'Nguyen Hi Dan'		,   '5'			,   '1'		,'2020-03-05');

-- Question 3: Cấu hình 1 group có nhiều nhất là 5 user
DROP TRIGGER IF EXISTS question3;
DELIMITER $$
CREATE  TRIGGER question3
BEFORE INSERT ON groupaccount
FOR EACH ROW
BEGIN
IF NEW.GroupID IN (SELECT GroupID FROM (SELECT GroupID, COUNT(1) AS so_luong_account
											  FROM groupaccount
                                              GROUP BY GroupID
                                              HAVING so_luong_account >= 5) AS q4) THEN
SIGNAL SQLSTATE '12345'
SET MESSAGE_text ='Group có tối đa 5 user';
END IF;
END $$
DELIMITER ;

INSERT INTO GroupAccount	(  GroupID	, AccountID	, JoinDate	 )
VALUES 						(	1		,    6		,'2019-03-05');

-- Thống kê mỗi group có bao nhiêu account
SELECT 
    IFNULL(g.GroupID, 0) AS GroupID,
    IFNULL(so_luong_account, 0) AS so_luong_account
FROM
    (SELECT 
        GroupID, COUNT(1) AS so_luong_account
    FROM
        groupaccount
    GROUP BY GroupID) AS q4
        RIGHT JOIN
    `group` g ON g.GroupID = q4.GroupID
GROUP BY g.GroupID; 

-- Question 4: Cấu hình 1 bài thi có nhiều nhất là 10 Question
DROP TRIGGER IF EXISTS question4;
DELIMITER $$
CREATE  TRIGGER question4
BEFORE INSERT ON exam
FOR EACH ROW
BEGIN
IF NEW.ExamID IN (SELECT ExamID FROM (SELECT ExamID, COUNT(1) AS so_luong_question
											  FROM examquestion
                                              GROUP BY ExamID
                                              HAVING so_luong_question >= 10) AS q4) THEN
SIGNAL SQLSTATE '12345'
SET MESSAGE_text ='Exam có tối đa 10 question';
END IF;
END $$
DELIMITER ;

INSERT INTO Exam	( `Code`		, Title					, CategoryID	, Duration	, CreatorID		, CreateDate )
VALUES 				('VTIQ0011'		, N'Đề thi C#'			,	1			,	60		,   '5'			,'2019-04-05');

-- Question 5: Tạo trigger không cho phép người dùng xóa tài khoản có email là admin@gmail.com (đây là tài khoản admin, không cho phép user xóa),
-- còn lại các tài khoản khác thì sẽ cho phép xóa và sẽ xóa tất cả các thông tin liên quan tới user đó
DROP TRIGGER IF EXISTS question5;
DELIMITER $$
CREATE  TRIGGER question5
BEFORE DELETE ON `account`
FOR EACH ROW
BEGIN
DECLARE account_id INT;
    SELECT accountID INTO account_id
    FROM `account`
    WHERE email = OLD.email;
IF OLD.email = 'admin@gmail.com' THEN
SIGNAL SQLSTATE '12345'
SET MESSAGE_text ='Đây là tài khoản admin, không cho phép user xóa';
ELSE 
	DELETE FROM `account` WHERE AccountID = account_id;
END IF;
END $$
DELIMITER ;

DELETE FROM `account` WHERE email = 'admin@gmail.com';

-- Question 6: Không sử dụng cấu hình default cho field DepartmentID của table Account, hãy tạo trigger cho phép người dùng khi tạo account không điền
-- vào departmentID thì sẽ được phân vào phòng ban "waiting Department"
INSERT INTO Department(DepartmentName) 
VALUES
						(N'waiting Department'	);
SELECT 
    *
FROM
    department;
DROP TRIGGER IF EXISTS question6;
DELIMITER $$
CREATE TRIGGER question6 
BEFORE INSERT ON `account`
FOR EACH ROW
BEGIN
	DECLARE department_id INT;
    SELECT departmentID INTO department_id 
    FROM department
    WHERE DepartmentName = 'waiting Room';
    
    IF NEW.departmentID IS NULL THEN
		SET NEW.departmentId = department_id;
	END IF;
END$$
DELIMITER ; 
INSERT INTO Account  (Email								, Username			, FullName				,  PositionID, CreateDate)
VALUES 				 ('accountz1@gmail.com'	            , 'haidang'			,'Nguyen Hai Dang'		,    '1'	 ,'2020-03-05');

-- Question 7: Cấu hình 1 bài thi chỉ cho phép user tạo tối đa 4 answers cho mỗi question, trong đó có tối đa 2 đáp án đúng.
DROP TRIGGER IF EXISTS question7;
DELIMITER $$
CREATE TRIGGER question7
BEFORE INSERT ON Answer
FOR EACH ROW
BEGIN
	DECLARE number_of_answers TINYINT;
	DECLARE number_of_correct_answers TINYINT;

	SELECT COUNT(a.Answers) INTO number_of_answers
    FROM Answer a 
    JOIN question q ON a.questionID = q.questionID
    WHERE a.questionID = NEW.questionID;
    
    SELECT COUNT(a.Answers) INTO number_of_correct_answers
    FROM answer a 
    JOIN question q ON a.questionID= q.questionID
    WHERE a.questionID = NEW.questionID AND a.isCorrect = 1;
    
    IF number_of_answers >= 4 THEN
		SIGNAL SQLSTATE '12345' -- disallow insert this record
		SET MESSAGE_TEXT = 'One question has a maximum of 4 answers!';
	END IF;
    
    IF number_of_correct_answers >= 2 THEN
		SIGNAL SQLSTATE '12345' -- disallow insert this record
		SET MESSAGE_TEXT = 'One question has a maximum of 2 correct answers!';
	END IF;
END$$
DELIMITER ;

-- Question 8: Viết trigger sửa lại dữ liệu cho đúng: Nếu người dùng nhập vào gender của account là nam, nữ, chưa xác định
-- Thì sẽ đổi lại thành M, F, U cho giống với cấu hình ở database
DROP TRIGGER IF EXISTS Auto_Gender_Update;
DELIMITER $$
CREATE TRIGGER Auto_Gender_Update
BEFORE INSERT ON `Account`
FOR EACH ROW
BEGIN
      IF NEW.Gender = 'Nam' THEN
         SET NEW.Gender = 'M';
	  ELSEIF NEW.Gender = 'Nu' THEN
         SET NEW.Gender = 'F';
	  ELSEIF NEW.Gender = 'Chưa xác định' THEN
         SET NEW.Gender = 'U';
	  END IF ;
END $$
DELIMITER ;

ALTER TABLE `Account`
ADD Gender NVARCHAR(50);

-- Question 9: Viết trigger không cho phép người dùng xóa bài thi mới tạo được 2 ngày
DROP TRIGGER IF EXISTS before_delete_exam;
DELIMITER $$
CREATE TRIGGER before_delete_exam
BEFORE DELETE ON Exam
FOR EACH ROW
BEGIN
    IF OLD.ExamID IN (SELECT ExamID
					   FROM Exam
                       WHERE DAY(NOW()) - DAY(CreateDate) = 2) THEN
		SIGNAL SQLSTATE '12345' -- disallow delete this record
		SET MESSAGE_TEXT = 'This exam was created 2 days ago, you can not delete!';
	END IF;
    
    DELETE FROM ExamQuestion
    WHERE ExamID = OLD.ExamID;
END$$
DELIMITER ;

-- Question 10: Viết trigger chỉ cho phép người dùng chỉ được update, delete các question khi question đó chưa nằm trong exam nào
DROP TRIGGER IF EXISTS before_update_question;
DELIMITER $$
CREATE TRIGGER before_update_question
BEFORE UPDATE  ON Question
FOR EACH ROW
BEGIN
	DECLARE Not_On_Exam TINYINT;   
	SELECT q.QuestionID INTO Not_On_Exam
	FROM Question q
	LEFT JOIN ExamQuestion eq ON q.QuestionID = eq.QuestionID
	WHERE eq.ExamID IS NULL;
		IF NEW.QuestionID != Not_On_Exam THEN
		SIGNAL SQLSTATE '12345'
		SET MESSAGE_TEXT = 'Không thể INSERT'; 
		END IF ;
END $$
DELIMITER ;

DROP TRIGGER IF EXISTS before_delete_question;
DELIMITER $$
CREATE TRIGGER before_delete_question
BEFORE UPDATE  ON Question
FOR EACH ROW
BEGIN
	DECLARE Not_On_Exam TINYINT;   
	SELECT q.QuestionID INTO Not_On_Exam
	FROM Question q
	LEFT JOIN ExamQuestion eq ON q.QuestionID = eq.QuestionID
	WHERE eq.ExamID IS NULL;
		IF NEW.QuestionID != Not_On_Exam THEN
		SIGNAL SQLSTATE '12345'
		SET MESSAGE_TEXT = 'Không thể INSERT'; 
		END IF ;
END $$
DELIMITER ;

-- Question 12: Lấy ra thông tin exam trong đó: 
-- Duration <= 30 thì sẽ đổi thành giá trị "Short time" 
-- 30 < Duration <= 60 thì sẽ đổi thành giá trị "Medium time"
-- Duration > 60 thì sẽ đổi thành giá trị "Long time"
SELECT ExamID,
		CASE 
			WHEN Duration <= 30 THEN 'Short time'
            WHEN Duration <= 60 AND Duration >30 THEN 'Medium time'
            ELSE 'Longtime'
		END AS ExamDuration
FROM Exam;

-- Question 13: Thống kê số account trong mỗi group và in ra thêm 1 column nữa có tên là the_number_user_amount và mang giá trị được quy định như sau:
-- Nếu số lượng user trong group =< 5 thì sẽ có giá trị là few
-- Nếu số lượng user trong group <= 20 và > 5 thì sẽ có giá trị là normal
-- Nếu số lượng user trong group > 20 thì sẽ có giá trị là higher
SELECT GroupID, 
		CASE
			WHEN COUNT(AccountID) <=5 THEN 'Few'
            WHEN COUNT(AccountID) <=20 AND COUNT(AccountID)>5 THEN 'Normal'
            ELSE 'Higher'
		END AS the_number_user_amount
FROM GroupAccount
GROUP BY GroupID;

-- Question 14: Thống kê số mỗi phòng ban có bao nhiêu user, nếu phòng ban nào không có user thì sẽ thay đổi giá trị 0 thành "Không có User"
SELECT d.DepartmentName,
		CASE
			WHEN COUNT(a.AccountID) = 0 THEN 'Khong co User'
            ELSE COUNT(a.AccountID)
		END AS Number_of_Account
FROM Department d
JOIN `Account` a ON d.DepartmentID = a.DepartmentID
GROUP BY d.DepartmentName;
