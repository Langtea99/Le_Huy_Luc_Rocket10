USE BT;

-- Question 1: lấy ra tất cả các phòng ban
SELECT 
    *
FROM
    department;
    
-- Question 2: lấy ra id của phòng ban có tên là "Sale"
SELECT 
    DepartmentID
FROM
    department
WHERE
    DepartmentName = "Sale";
    
-- Question 3: lấy ra thông tin account có full name dài nhất
SELECT 
    *
FROM
    Account
GROUP BY Fullname
HAVING LENGTH(Fullname) = (SELECT 
            MAX(LENGTH(Fullname))
        FROM
            Account)
ORDER BY Fullname ;

-- Question 4: Lấy ra tên group đã tham gia trước ngày 20/12/2019

SELECT 
    GroupName
FROM
    `Group`
WHERE
    YEAR(CreateDate) < YEAR('2019-12-20')
        AND MONTH(CreateDate) < MONTH('2019-12-20')
        AND DAY(CreateDate) < DAY('2019-12-20');
    
-- Question 5: Lấy ra ID của question có >= 4 câu trả lời
SELECT 
    QuestionID
FROM
    Answer
GROUP BY QuestionID
HAVING count(QuestionID) >=4
ORDER BY QuestionID;

-- Question 6: Lấy ra 5 group được tạo gần đây nhất
SELECT 
    *
FROM
    `Group`
WHERE
    CreateDate <= now()
LIMIT 5;

-- Question 8: Xóa tất cả các exam được tạo trước ngày 20/12/2019

DELETE 
FROM 	Exam
WHERE 	YEAR(CreateDate) < YEAR('2019-12-20')
        AND MONTH(CreateDate) < MONTH('2019-12-20')
        AND DAY(CreateDate) < DAY('2019-12-20');

-- Question 9: Update thông tin của account có id = 5 thành tên "Nguyễn Bá Lộc" và email thành loc.nguyenba@vti.com.vn
UPDATE 	Account
SET 			Username = 'Nguyễn Bá Lộc',
				Email = 'loc.nguyenba@vti.com.vn'
WHERE 	AccountID = 5;

-- Question 10: Viết lệnh để lấy ra danh sách nhân viên và thông tin phòng ban của họ
SELECT 
    a.*, d.DepartmentName
FROM
    Account a
        LEFT JOIN
    Department d ON a.DepartmentID = d.DepartmentID;
    
-- Question 11: Viết lệnh để lấy ra tất cả các developer
SELECT 
    *
FROM
    `Group` g
		LEFT JOIN
    GroupAccount ga ON g.GroupID = ga.GroupID 
		LEFT JOIN
    Account ac ON ac.AccountID = ga.AccountID
WHERE
    GroupName = 'Developement';

SELECT 
    *
FROM
    `Group`;
    
-- Question 12: Viết lệnh để lấy ra danh sách các phòng ban có >3 nhân viên
SELECT 
    d.*, COUNT(*) AS soluong
FROM
    Department d
        LEFT JOIN
    Account a ON d.DepartmentID = a.DepartmentID
GROUP BY d.DepartmentID
HAVING soluong > 3;

-- Question 13: Viết lệnh để lấy ra danh sách câu hỏi được sử dụng trong đề thi nhiều nhất
SELECT 
    QuestionID,MAX(soluongcauhoi)
FROM
    (SELECT 
        QuestionID,COUNT(QuestionID) AS soluongcauhoi
    FROM
        examquestion
    GROUP BY QuestionID) AS a;
    
-- Question 14:Thông kê mỗi category Question được sử dụng trong bao nhiêu Question
 SELECT 
    categoryquestion.CategoryID,
    categoryquestion.CategoryName,
    COUNT(*) AS SoluongduocdungtrongQuestion
FROM
    categoryquestion
        LEFT JOIN
    question ON categoryquestion.CategoryID = question.CategoryID
GROUP BY categoryquestion.CategoryID;

-- Question 15: Lấy ra Question có nhiều câu trả lời nhất 
SELECT 
    question.QuestionID, COUNT(*) AS Sctt
FROM
    question
        LEFT JOIN
    answer ON question.QuestionID = answer.QuestionID
GROUP BY question.QuestionID
HAVING Sctt = (SELECT 
        MAX(ab)
    FROM
        (SELECT 
            COUNT(QuestionID) AS ab
        FROM
            answer
        GROUP BY QuestionID) AS abc);
        
-- Question 16: Tìm chức vụ có ít người nhất
SELECT 
    p.PositionID, p.PositionName, COUNT(*) AS soluong
FROM
    Position p
        LEFT JOIN
    Account a ON p.PositionID = a.PositionID
GROUP BY p.PositionID
HAVING soluong = (SELECT 
        MIN(ab)
    FROM
        (SELECT 
            COUNT(PositionID) AS ab
        FROM
            Account
        GROUP BY PositionID) AS abc);
        
-- Question 17: Thống kê mỗi phòng ban có bao nhiêu dev, test, scrum master, PM
SELECT 
    t1.DepartmentID,
    t1.PositionID,
    t1.PositionName,
    IF((t2.number_of_account IS NULL),
        0,
        t2.number_of_account) AS number_of_account
FROM
    (SELECT 
        d.DepartmentID, p.PositionID,p.PositionName
    FROM 
        Department d
    CROSS JOIN `position` p
    WHERE
        p.PositionName IN ('Dev' , 'Test', 'Scrum Master', 'PM')
    ORDER BY d.DepartmentID , p.PositionID) AS t1
        LEFT JOIN
    (SELECT 
        d.DepartmentID,
            p.PositionID,
            COUNT(a.AccountID) AS number_of_account
    FROM
        Position p
    LEFT JOIN `account` a ON p.PositionID = a.PositionID
    RIGHT JOIN Department d ON a.DepartmentID = d.DepartmentID
    WHERE
        p.PositionName IN ('Dev' , 'Test', 'Scrum Master', 'PM')
    GROUP BY d.DepartmentID , p.PositionID) AS t2 ON t1.DepartmentID = t2.DepartmentID
        AND t1.PositionID = t2.PositionID
GROUP BY t1.DepartmentID , t1.PositionID
ORDER BY t1.DepartmentID , t1.PositionID;

-- Question 18: Lấy thông tin chi tiết của câu hỏi bao gồm: thông tin cơ bản của question, loại câu hỏi, ai là người tạo ra câu hỏi, câu trả lời là gì, …
SELECT*FROM Question
JOIN Typequestion
ON Typequestion.TypeID = Question.TypeID
JOIN Categoryquestion
ON Question.CategoryID = Categoryquestion.CategoryID
ORDER BY Question.QuestionID;

-- Question 19: Lấy ra số lượng câu hỏi của mỗi loại tự luận hay trắc nghiệm
SELECT Typequestion.TypeName,COUNT(*)AS soluong FROM Typequestion
JOIN Question 
ON Typequestion.TypeID =question.TypeID
GROUP BY Typequestion.TypeID;