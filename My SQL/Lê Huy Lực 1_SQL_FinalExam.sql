-- Question1: Tạo table với các ràng buộc và kiểu dữ liệu
-- Thêm ít nhất 3 bản ghi vào table

-- Tạo và sử dụng database

DROP DATABASE IF EXISTS QuanLyDiem;
CREATE DATABASE QuanLyDiem;
USE QuanLyDiem;

-- Tạo bảng Student

DROP TABLE IF EXISTS Student;
CREATE TABLE Student (
    StudentID INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    StudentName VARCHAR(50) NOT NULL,
    Age INT,
    Gender ENUM('1', '0', 'Null')
);

-- Tạo bảng Subject

DROP TABLE IF EXISTS `Subject`;
CREATE TABLE `Subject` (
    SubjectID INT UNSIGNED  PRIMARY KEY,
    SubjectName VARCHAR(50) NOT NULL
);

-- Tạo bảng StudentSubject

DROP TABLE IF EXISTS StudentSubject;
CREATE TABLE StudentSubject
(
	StudentID  		INT UNSIGNED NOT NULL,
    SubjectID 		INT UNSIGNED NOT NULL,
    Mark 		DECIMAL(4,2) NOT NULL,
    `Date` 		DATETIME DEFAULT NOW(),
    PRIMARY KEY(StudentID,SubjectID),
    CONSTRAINT 	StudentIDfk 	FOREIGN KEY (StudentID) REFERENCES Student (StudentID) ON DELETE CASCADE,
	CONSTRAINT 	SubjectIDfk 	FOREIGN KEY (SubjectID) REFERENCES `Subject` (SubjectID) ON DELETE CASCADE
);

-- INSERT giá trị vào bảng Student
INSERT INTO Student	(StudentName,				 Age,		Gender) 
VALUES 				('Le Huy Luc',	   		'20',		   '1'),
					('Le Thi Thuy',	  		'20',		   '0'),
					('Pham Van Truong',	   	'20',		   '1'),
                    ('Pham Hong Son',	   	'20',		'Null'),
                    ('Do Thanh Cong',	   	'20',		   '1');

-- INSERT giá trị vào bảng `Subject`
INSERT INTO `Subject`(SubjectID,SubjectName)
VALUES               (1,'Math'),
					 (2,'Physical'),
                     (3,'Chemistry'),
                     (4,'Biological'),
                     (5,'Philosophy');

-- INSERT giá trị vào bảng StudentSubject
INSERT INTO StudentSubject (StudentID,				SubjectID,			Mark,			`Date`)
VALUES                     ('1',			'1',			'9.5' ,	  '2021-01-12'),
						   ('1',			'4',			'9.0' ,	  '2021-01-12'),
                           ('1',			'5',			'9.75',	  '2021-01-12'),
                           ('2',			'1',			'9.0',	  '2021-01-12'),
                           ('3',			'3',			'8.5',	  '2021-01-12'),
                           ('5',			'3',			'9.0',	  '2021-01-12'),
                           ('5',			'5',			'9.0',	  '2021-01-12'),
                           ('3',			'5',			'8.75',	  '2021-01-12'),
                           ('3',			'4',			'7.5',	  '2021-01-12'),
                           ('4',			'4',			'8.0',	  '2021-01-12');
 
 -- Question2. Viết lệnh để
-- a) Lấy tất cả các môn học không có bất kì điểm nào
-- b) Lấy danh sách các môn học có ít nhất 2 điểm

-- a) Lấy tất cả các môn học không có bất kì điểm nào 
SELECT 
    *
FROM
    `Subject`
        LEFT JOIN
    StudentSubject ON `Subject`.SubjectID = StudentSubject.SubjectID
GROUP BY `Subject`.SubjectName
HAVING StudentSubject.SubjectID IS NULL;

-- b) Lấy danh sách các môn học có ít nhất 2 điểm
SELECT 
    `Subject`.SubjectName, COUNT(*) AS So_luong_diem
FROM
    `Subject`
        JOIN
    StudentSubject ON `Subject`.SubjectID = StudentSubject.SubjectID
GROUP BY `Subject`.SubjectName
HAVING So_luong_diem >= 2
ORDER BY `Subject`.SubjectID;

-- 3. Tạo view có tên là "StudentInfo" lấy các thông tin về học sinh bao gồm:
-- Student ID,Subject ID, Student Name, Student Age, Student Gender, Subject Name, Mark, Date
-- (Với cột Gender show 'Male' để thay thế cho 0, 'Female' thay thế cho 1 và 'Unknow' thay thế cho null)
CREATE OR REPLACE VIEW StudentInfo AS
    SELECT 
        Student.StudentID,
        `Subject`.SubjectID,
        Student.StudentName,
        Student.Age,
        CASE Student.Gender
            WHEN '0' THEN 'Male'
            WHEN '1' THEN 'Female'
            ELSE 'Unknow'
        END AS Gender,
        `Subject`.SubjectName,
        StudentSubject.Mark,
        StudentSubject.`Date`
    FROM
        Student
            JOIN
        StudentSubject ON Student.StudentID = StudentSubject.StudentID
            JOIN
        `Subject` ON StudentSubject.SubjectID = `Subject`.SubjectID
    ORDER BY StudentSubject.StudentID;

SELECT 
    *
FROM
    StudentInfo;

-- Question4. Không sử dụng On Update Cascade & On Delete Cascade
-- a) Tạo trigger cho table Subject có tên là SubjectUpdateID:
-- Khi thay đổi data của cột ID của table Subject, thì giá trị tương  ứng với cột SubjectID của table StudentSubject cũng thay đổi theo
-- b) Tạo trigger cho table Student có tên là StudentDeleteID:
-- Khi xóa data của cột ID của table Student, thì giá trị tương ứng với cột SubjectID của table StudentSubject cũng bị xóa theo

-- a) Tạo trigger cho table Subject có tên là SubjectUpdateID:
-- Khi thay đổi data của cột ID của table Subject, thì giá trị tương  ứng với cột SubjectID của table StudentSubject cũng thay đổi theo
DROP TRIGGER IF EXISTS SubjectUpdateID ;
DELIMITER $$
CREATE TRIGGER SubjectUpdateID 
AFTER UPDATE ON `Subject`
FOR EACH ROW
BEGIN 
UPDATE  StudentSubject
SET  SubjectID = NEW.SubjectID
WHERE
SubjectID =  OLD.SubjectID;
END $$
DELIMITER ;

SET FOREIGN_KEY_CHECKS=0;
SET SQL_SAFE_UPDATES = 0;
UPDATE `Subject`
   SET SubjectID=6
 WHERE SubjectID=3;
         
SELECT * FROM StudentSubject;

-- b) Tạo trigger cho table Student có tên là StudentDeleteID:
-- Khi xóa data của cột ID của table Student, thì giá trị tương ứng với cột SubjectID của table StudentSubject cũng bị xóa theo
DROP TRIGGER IF EXISTS StudentDeleteID ;
DELIMITER $$
CREATE TRIGGER StudentDeleteID
AFTER DELETE ON Student
FOR EACH ROW
BEGIN 
DELETE FROM StudentSubject WHERE StudentID = OLD.StudentID;
END $$
DELIMITER ;

DELETE FROM Student
WHERE StudentID = 4 ;

SELECT * FROM StudentSubject;

-- Question5. Viết 1 store procedure (có 2 parameters: student name,mark) sẽ xóa tất cả các thông tin liên quan tới học sinh có cùng tên như parameter 
-- và tất cả các điểm nhỏ hơn của các học sinh đó.
-- Trong trường hợp nhập vào student name = "*" thì procedure sẽ xóa tất cả các học sinh
DROP PROCEDURE IF EXISTS Delete_Student;
DELIMITER $$ 
CREATE PROCEDURE Delete_Student(IN student_name VARCHAR(35),IN mark VARCHAR(35))
BEGIN
IF (student_name = '*') THEN
				DELETE 
                FROM Student;
		END IF;
		IF (student_name = '*') THEN
				DELETE
				FROM StudentSubject
                WHERE Mark < mark;
		END IF;
        
        IF (student_name != '*' AND mark != '*') THEN
			DELETE 
			FROM Student
			WHERE StudentName = student_name;
		END IF;
        IF (student_name != '*' AND mark != '*') THEN
			DELETE
			FROM StudentSubject
			WHERE Mark < mark AND StudentID IN (SELECT 		StudentID 
											FROM 		Student 
											WHERE StudentName = student_name );
		END IF;
END $$
DELIMITER ;

CALL Delete_Student('Le Huy Luc','8.5');
CALL Delete_Student('*','8');