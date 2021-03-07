/*============================== CREATE DATABASE =======================================*/
/*======================================================================================*/

DROP DATABASE IF EXISTS UserManager;
CREATE DATABASE UserManager;
USE UserManager;

/*============================== CREATE TABLE =======================================*/
/*======================================================================================*/

-- create table 1: Department  id, FullName, Email, Password
DROP TABLE IF EXISTS `User`; 
CREATE TABLE `User`(
	UserID 		TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	FullName 	VARCHAR(50) UNIQUE KEY NOT NULL,
    Email 		VARCHAR(50) UNIQUE KEY NOT NULL,
    `Password`	VARCHAR(50) NOT NULL CHECK(length(`Password`) >= 6 and length(`Password`) <= 12),
    `Position`	ENUM('Manager', 'Employee')
);
DROP TABLE IF EXISTS Project;
CREATE TABLE  `Project`(
	ProjectId	TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	TeamSize	TINYINT UNSIGNED NOT NULL,
	IdManager	TINYINT UNSIGNED NOT NULL,
	IdEmployees	TINYINT UNSIGNED NOT NULL
);

/*============================== INSERT DATABASE =======================================*/
/*======================================================================================*/

INSERT INTO `User`  (UserID   , FullName, 			Email,				 `Password`,			`Position`		) 
VALUES
					(1,			N'Nguyễn Thị Mỵ',	'my.ngyenthi@vti.com.vn', 'Mynguyen123',		'Employee'	),
					(2,			N'Nguyễn Ngọc Duy',	'duy.nn@vti.com.vn', 'duyNguyen',			'Manager'	),
                    (3,			N'Nguyễn Hùng Mạnh','hung.manh@vti.com.vn', 'hunGmanh1',			'Employee'	),
                    (4,			N'Tống Thị Nhung',	'nhung.l@gvti.com.vn', 		'nhungTOng',		'Employee'	),
                    (5,			N'Trần Thị Kim Anh','kimoanh.tran@vti.com.vn', 'tranKim',		'Employee'	);