USE BT;

-- Question 1: Tạo view có chứa danh sách nhân viên thuộc phòng ban sale
CREATE OR REPLACE VIEW question1 AS
	SELECT 
        a.*, d.DepartmentName
    FROM
        account a
    JOIN department d ON a.DepartmentID = d.DepartmentID
WHERE
    d.DepartmentName = 'Sale';
    
SELECT 
    *
FROM
    question1;

-- Question 2: Tạo view có chứa thông tin các account tham gia vào nhiều group nhất
CREATE OR REPLACE VIEW question2 AS
	SELECT 
    a.*, COUNT(*) AS so_group_tham_gia
FROM
    account a
        JOIN
    groupaccount ga ON a.AccountID = ga.AccountID
GROUP BY a.AccountID
HAVING so_group_tham_gia = (SELECT 
        MAX(q2)
    FROM
        (SELECT 
            COUNT(AccountID) as q2
        FROM
            groupaccount
        GROUP BY AccountID) AS ab);
    
SELECT 
    *
FROM
    question2;

-- Question 3: Tạo view có chứa câu hỏi có những content quá dài (content quá 300 từ được coi là quá dài) và xóa nó đi
CREATE OR REPLACE VIEW question3 AS
SELECT 
    *
FROM
    Question
WHERE
    LENGTH(content) > 300;

DROP VIEW question3;

-- Question 4: Tạo view có chứa danh sách các phòng ban có nhiều nhân viên nhất
INSERT INTO Account (Email								, Username			, FullName				, DepartmentID	, PositionID, CreateDate)
VALUES 				 ('account5@gmail.com'	            , 'haidangzz'		,'Nguyen Ha Dang'		,   '2'			,   '1'		,'2020-03-05'),
					 ('account6@gmail.com'				, 'quanganhzz'		,'Tong Quang Do'		,   '5'			,   '2'		,'2020-03-05');
CREATE OR REPLACE VIEW question4 AS
SELECT 
    d.*, COUNT(*) AS so_nhan_vien
FROM
    department d
        JOIN
    account a ON a.DepartmentID = d.DepartmentID
GROUP BY a.DepartmentID
HAVING so_nhan_vien = (SELECT 
        MAX(q4)
    FROM
        (SELECT 
            COUNT(DepartmentID) as q4
        FROM
            account
        GROUP BY DepartmentID) AS ab)
        ORDER BY a.DepartmentID;

SELECT 
    *
FROM
    question4;

-- Question 5: Tạo view có chứa tất các các câu hỏi do user họ Nguyễn tạo
CREATE OR REPLACE VIEW question5 AS
SELECT 
    q.QuestionID,
    q.Content,
    q.CategoryID,
    q.TypeID,
    q.CreateDate,
    a.FullName AS Creator
FROM
    question q
        JOIN
    account a ON q.CreatorID = a.AccountID
WHERE
    a.FullName LIKE '%Nguyen%'
ORDER BY q.QuestionID;

SELECT*FROM question5;