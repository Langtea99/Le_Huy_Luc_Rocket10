USE BT;

-- Question 1: Tạo store để người dùng nhập vào tên phòng ban và in ra tất cả các account thuộc phòng ban đó
DROP PROCEDURE IF EXISTS question1;
DELIMITER $$
CREATE PROCEDURE question1(IN DepartmentName1 NVARCHAR(30) )
BEGIN
	SELECT 
    a.*,d.DepartmentName
FROM
    account a
        JOIN
    department d ON a.DepartmentID = d.DepartmentID
WHERE
    d.DepartmentName = DepartmentName1;
END$$
DELIMITER ;

CALL question1('Marketing');

-- Question 2: Tạo store để in ra số lượng account trong mỗi group
DROP PROCEDURE IF EXISTS question2;
DELIMITER $$
CREATE PROCEDURE question2(IN groupID1 TINYINT UNSIGNED)
BEGIN
	SELECT 
     IFNULL(GroupID,groupID1) AS GroupID, COUNT(*) AS soluong
FROM
    groupaccount 
WHERE GroupID = groupID1;
-- GROUP BY GroupID;
END$$
DELIMITER ;

CALL question2(2);

-- Question 3: Tạo store để thống kê mỗi type question có bao nhiêu question được tạo trong tháng hiện tại
 SET GLOBAL log_bin_trust_function_creators = 1;

DROP PROCEDURE IF EXISTS question3;
DELIMITER $$ 
CREATE PROCEDURE question3 ()
BEGIN
SELECT q3.TypeID,IFNULL(Sl,0)AS soluong FROM
(SELECT typequestion.TypeID,COUNT(*)AS Sl,question.CreateDate 
FROM typequestion
LEFT JOIN question 
ON typequestion.TypeID = question.TypeID
WHERE MONTH(question.CreateDate) = MONTH(NOW())
GROUP BY typequestion.TypeID
ORDER BY typequestion.TypeID) AS q3;
END $$
DELIMITER ;

CALL question3();

-- Question 4: Tạo store để trả ra id của type question có nhiều câu hỏi nhất
DROP PROCEDURE IF EXISTS question4;
DELIMITER $$ 
CREATE PROCEDURE question4()
BEGIN
SELECT 
    TypeID, MAX(soluong) AS so_cau_hoi
FROM
    (SELECT 
        tq.*, COUNT(1) AS soluong
    FROM
        typequestion tq
    JOIN question q ON tq.TypeID = q.TypeID
    GROUP BY TypeID) AS q4;
END $$
DELIMITER ;

CALL question4();

-- Question 5: Sử dụng store ở question 4 để tìm ra tên của type question
DROP PROCEDURE IF EXISTS question5;
DELIMITER $$ 
CREATE PROCEDURE question5()
BEGIN
SELECT 
    TypeID,TypeName, MAX(soluong) AS so_cau_hoi
FROM
    (SELECT 
        tq.*, COUNT(1) AS soluong
    FROM
        typequestion tq
    JOIN question q ON tq.TypeID = q.TypeID
    GROUP BY TypeID) AS q4;
END $$
DELIMITER ;

CALL question5();

-- Question 6: Viết 1 store cho phép người dùng nhập vào 1 chuỗi và trả về group có tên chứa chuỗi của người dùng nhập vào hoặc trả về user có username chứa 
-- chuỗi của người dùng nhập vào
DROP PROCEDURE IF EXISTS question6;
DELIMITER $$ 
CREATE PROCEDURE question6(IN stringq6 NVARCHAR(100))
BEGIN
DECLARE str NVARCHAR(100) ;
SELECT CONCAT('%',stringq6,'%') into str;
	SELECT 
    *
FROM
    `group`
WHERE
    GroupName LIKE str;
SELECT 
    *
FROM
    `account`
WHERE
    Username LIKE str;
-- END IF;
END $$
DELIMITER ;

CALL question6('i');

-- Question 7: Viết 1 store cho phép người dùng nhập vào thông tin fullName, email và trong store sẽ tự động gán:
-- username sẽ giống email nhưng bỏ phần @..mail đi
-- positionID: sẽ có default là developer
-- departmentID: sẽ được cho vào 1 phòng chờ
-- Sau đó in ra kết quả tạo thành công
DROP PROCEDURE IF EXISTS question7;
DELIMITER $$ 
CREATE PROCEDURE question7(IN in_fullName NVARCHAR(50),IN in_email NVARCHAR(50))
BEGIN
	DECLARE Username VARCHAR(50) DEFAULT SUBSTRING_INDEX(in_email,'@',1);
    DECLARE PositionID TINYINT UNSIGNED DEFAULT 1;
    DECLARE DepartmentID TINYINT UNSIGNED DEFAULT 10;
    DECLARE CreateDate DATETIME DEFAULT NOW();
	
	INSERT INTO `Account` 	(Email		,Username, FullName		, DepartmentID,	PositionID,	CreateDate)
    VALUE					(in_email	,Username, in_fullName	, DepartmentID, PositionID, CreateDate);
	
    SELECT 	*
    FROM 	`Account`A
    WHERE	A.Username = Username;
END $$
DELIMITER ;

CALL question7('Dang Le Huy','Huyml@gmail.com');

-- Question 8: Viết 1 store cho phép người dùng nhập vào Essay hoặc Multiple-Choice để thống kê câu hỏi essay hoặc multiple-choice nào có content dài nhất
DROP PROCEDURE IF EXISTS question8;
DELIMITER $$ 
CREATE PROCEDURE question8(IN in_string VARCHAR(50))
BEGIN
    IF (in_string = 'Esay') THEN 
		SELECT	Content, MAX(LENGTH(Content)) AS do_dai
		FROM	typequestion tq
        JOIN question q 
			ON tq.TypeID = q.TypeID
    WHERE TypeName = in_string ;
	ELSEIF (in_string = 'Multiple-Choice') THEN 
		SELECT	Content, MAX(LENGTH(Content)) AS do_dai
		FROM	typequestion tq
        JOIN
    question q ON tq.TypeID = q.TypeID
    WHERE TypeName = in_string ;
        END IF;
END $$
DELIMITER ;

CALL question8('Multiple-Choice');

-- Question 9: Viết 1 store cho phép người dùng xóa exam dựa vào ID
DROP PROCEDURE IF EXISTS question9;
DELIMITER $$ 
CREATE PROCEDURE question9(IN in_examID VARCHAR(50))
BEGIN
   DELETE FROM exam WHERE ExamID = in_examID;
END $$
DELIMITER ;

CALL question9(1);

-- Question 10: Tìm ra các exam được tạo từ 3 năm trước và xóa các exam đó đi (sử dụng store ở câu 9 để xóa)
-- Sau đó in số lượng record đã remove từ các table liên quan trong khi removing
DROP PROCEDURE IF EXISTS question10;
DELIMITER $$ 
CREATE PROCEDURE question10()
BEGIN
   DECLARE Record_Delete INT;
SELECT 
    COUNT(*) AS z
INTO RecordXoa FROM
    Exam
WHERE
    (YEAR(NOW()) - YEAR(CreateDate)) > 3;
DELETE FROM Exam 
WHERE
    (YEAR(NOW()) - YEAR(CreateDate)) > 3;
SELECT Record_Delete;
END $$
DELIMITER ;

CALL question10();

-- Question 11: Viết store cho phép người dùng xóa phòng ban bằng cách người dùng nhập vào tên phòng ban và các account thuộc phòng ban đó sẽ được
-- chuyển về phòng ban default là phòng ban chờ việc
DROP PROCEDURE IF EXISTS question11;
DELIMITER $$ 
CREATE PROCEDURE question11(IN in_NameDepartment VARCHAR(30))
BEGIN
UPDATE department 
SET 
    DepartmentID = 10,
    DepartmentName = 'phong ban cho viec'
WHERE
    DepartmentName = in_NameDepartment;
DELETE FROM department 
WHERE
    DepartmentName = in_NameDepartment;
END $$
DELIMITER ;

CALL question11('');

-- Question 12: Viết store để in ra mỗi tháng có bao nhiêu câu hỏi được tạo trong năm nay

DROP PROCEDURE IF EXISTS quesstion12;
DELIMITER $$
CREATE PROCEDURE quesstion12()
BEGIN
		SELECT abc.MONTH, COUNT(QuestionID) AS COUNT
		FROM
		(
             SELECT 1 AS MONTH
             UNION SELECT 2 AS MONTH
             UNION SELECT 3 AS MONTH
             UNION SELECT 4 AS MONTH
             UNION SELECT 5 AS MONTH
             UNION SELECT 6 AS MONTH
             UNION SELECT 7 AS MONTH
             UNION SELECT 8 AS MONTH
             UNION SELECT 9 AS MONTH
             UNION SELECT 10 AS MONTH
             UNION SELECT 11 AS MONTH
             UNION SELECT 12 AS MONTH
        ) AS abc
		LEFT JOIN Question ON abc.MONTH = MONTH(CreateDate)
		GROUP BY abc.MONTH
		ORDER BY abc.MONTH ASC;
END$$
DELIMITER ;
SELECT *FROM question;

CALL question12();

-- !ueston 13 :Viết store để in ra mỗi tháng có bao nhiêu câu hỏi được tạo trong 6 tháng gần đây nhất
-- (Nếu tháng nào không có thì sẽ in ra là "không có câu hỏi nào trong tháng")

DROP PROCEDURE IF EXISTS question13;
DELIMITER $$
CREATE PROCEDURE question13()
BEGIN
		SELECT abc.MONTH, COUNT(QuestionID) AS COUNT
		FROM
		(
			SELECT MONTH(CURRENT_DATE - INTERVAL 5 MONTH) AS MONTH
			UNION
			SELECT MONTH(CURRENT_DATE - INTERVAL 4 MONTH) AS MONTH
			UNION
			SELECT MONTH(CURRENT_DATE - INTERVAL 3 MONTH) AS MONTH
			UNION
			SELECT MONTH(CURRENT_DATE - INTERVAL 2 MONTH) AS MONTH
			UNION
			SELECT MONTH(CURRENT_DATE - INTERVAL 1 MONTH) AS MONTH
			UNION
			SELECT MONTH(CURRENT_DATE - INTERVAL 0 MONTH) AS MONTH
        ) AS abc
		LEFT JOIN Question ON abc.MONTH = MONTH(CreateDate)
		GROUP BY abc.MONTH
		ORDER BY abc.MONTH ASC;
END$$
DELIMITER ;

CALL question13();
