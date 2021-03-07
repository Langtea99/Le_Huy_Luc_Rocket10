package Program;
import java.util.Date;
import Exercise.Account;
import Exercise.Answer;
import Exercise.CategoryQuestion;
import Exercise.Department;
import Exercise.Exam;
import Exercise.ExamQuestion;
import Exercise.Group;
import Exercise.GroupAccount;
import Exercise.Position;
import Exercise.PositionName;
import Exercise.Question;
import Exercise.TypeName;
import Exercise.TypeQuestion;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// create department
				Department department1 = new Department();
				department1.departmentID = 1;
				department1.departmentName = "Sale";

				Department department2 = new Department();
				department2.departmentID = 2;
				department2.departmentName = "Marketting";
				
				Department department3 = new Department();
				department3.departmentID = 3;
				department3.departmentName = "Secretary";

				// Create position
				Position position1 = new Position();				
				position1.positionName = PositionName.Dev;
				position1.positionID = 1;

				Position position2 = new Position();				
				position2.positionName = PositionName.Test;
				position2.positionID = 2;
				
				Position position3 = new Position();
				position3.positionName = PositionName.Scrum_Master;
				position3.positionID = 3;
				// Create account
				Account account1 = new Account();
				account1.accountID = 1;
				account1.email = "account@gmail.com";
				account1.userName = "haidang";
				account1.fullName ="Nguyen Hai Dang";
				account1.position = position1;
				account1.department = department1;
				account1.createDate = new Date("2020/12/30");

				Account account2 = new Account();
				account2.accountID = 2;
				account2.email = "account1@gmail.com";
				account2.userName = "quanganh";
				account2.fullName ="Tong Quang Anh";
				account2.position = position1;
				account2.department = department1;
				account2.createDate = new Date("2020/12/30");

				Account account3 = new Account();
				account3.accountID = 3;
				account3.email = "account1@gmail.com";
				account3.userName = "quanganh";
				account3.fullName ="Tong Quang Anh";
				account3.position = position3;
				account3.department = department2;
				account3.createDate = new Date("2020/12/30");
				
				//// Create Group
				Group group1 = new Group();
				group1.groupID = 1;
				group1.groupName = "Testing System";
				group1.creatorID = account1;
				group1.createDate =new Date("2020/12/30");
				
				Group group2 = new Group();
				group2.groupID = 2;
				group2.groupName = "Developement";
				group2.creatorID = account3;
				group2.createDate = new Date("2020/12/30");
				
				Group group3 = new Group();
				group3.groupID = 3;
				group3.groupName = "Management";
				group3.creatorID = account2;
				group3.createDate = new Date("2020/12/30");
				
				//Create GroupAccount
				
				GroupAccount groupAccount1 = new GroupAccount();
				groupAccount1.group = group3;
				groupAccount1.account = account1;
				groupAccount1.joinDate=new Date("2020/12/30");
				
				GroupAccount groupAccount2 = new GroupAccount();
				groupAccount2.group = group1;
				groupAccount2.account = account2;
				groupAccount2.joinDate=new Date("2020/12/30");
				
				GroupAccount groupAccount3 = new GroupAccount();
				groupAccount3.group = group3;
				groupAccount3.account = account3;
				groupAccount3.joinDate=new Date("2020/12/30");
				
				//Create TypeQuestion
				
				TypeQuestion typeQuestion1 = new TypeQuestion();
				typeQuestion1.typeID = 1;
				typeQuestion1.typeName = TypeName.Essay;
				
				TypeQuestion typeQuestion2 = new TypeQuestion();
				typeQuestion2.typeID = 2;
				typeQuestion2.typeName = TypeName.Multiple_Choice;
				
				//Create CategoryQuestion
				
				CategoryQuestion categoryQuestion1 = new CategoryQuestion();
				categoryQuestion1.categoryID = 1;
				categoryQuestion1.categoryName = "Java";
				
				CategoryQuestion categoryQuestion2 = new CategoryQuestion();
				categoryQuestion2.categoryID = 2;
				categoryQuestion2.categoryName = "ASP.NET";
				
				CategoryQuestion categoryQuestion3 = new CategoryQuestion();
				categoryQuestion3.categoryID = 3;
				categoryQuestion3.categoryName = "SQL";
				
				// Create Question
				
				Question question1 = new Question();
				question1.questionID= 1;
				question1.content ="Câu hỏi về Java";
				question1.categoryQuestion = categoryQuestion1;
				question1.typeQuestion = typeQuestion1;
				question1.account = account1;
				question1.createDate = new Date("2020/12/30");
				
				Question question2 = new Question();
				question2.questionID= 2;
				question2.content ="Câu hỏi về SQL";
				question2.categoryQuestion = categoryQuestion1;
				question2.typeQuestion = typeQuestion2;
				question2.account = account3;
				question2.createDate = new Date("2020/12/30");
				
				Question question3 = new Question();
				question2.questionID= 3;
				question2.content ="Câu hỏi về SQL";
				question2.categoryQuestion = categoryQuestion3;
				question2.typeQuestion = typeQuestion1;
				question2.account = account2;
				question2.createDate = new Date("2020/12/30");
				
				//Create Answer
				
				Answer answer2 = new Answer();
				answer2.answerID = 2;
				answer2.content = "Trả lời 02";
				answer2.question = question1;
				answer2.isCorrect = true;
				
				Answer answer1 = new Answer();
				answer1.answerID = 1;
				answer1.content = "Trả lời 01";
				answer1.question = question2;
				answer1.isCorrect = false;
				
				Answer answer3 = new Answer();
				answer3.answerID = 3;
				answer3.content = "Trả lời 03";
				answer3.question = question3;
				answer3.isCorrect = true;
				
				//Create Exam
				
				Exam exam1 = new Exam();
				exam1.examID = 1;
				exam1.code = "VTIQ001";
				exam1.title ="Đề thi C#";
				exam1.categoryID="Java";
				exam1.duration= 60;
				exam1.createDate=new Date("2020/12/30");
				
				Exam exam2 = new Exam();
				exam2.examID = 2;
				exam2.code = "VTIQ003";
				exam2.title ="Đề thi PHP";
				exam2.categoryID="PHP";
				exam2.duration= 120;
				exam2.createDate=new Date("2020/12/30");
				
				Exam exam3 = new Exam();
				exam3.examID = 3;
				exam3.code = "VTIQ003";
				exam3.title ="Đề thi SQL";
				exam3.categoryID="SQL";
				exam3.duration= 60;
				exam3.createDate=new Date("2020/12/30");
				
				// Create ExamQuestion
				ExamQuestion examQuestion1 = new ExamQuestion();
				examQuestion1.exam = exam2;
				Question[] questionOfExam1 = {question1,question2,question3};
				examQuestion1.question = questionOfExam1;
				
				
				
				
				// print department
				System.out.println("Department 1 information: ");
				System.out.println("DepartmentName: " + department1.departmentName);
				System.out.println("DepartmentID: " + department1.departmentID);
				
				System.out.println("Position 1 information: ");
				System.out.println("PositionName: " + position1.positionName);
				System.out.println("PositionID: " + position1.positionName);
				
				// print account
				System.out.println("Account 1 information: ");
				System.out.println("AccountID: " + account1.accountID);
				System.out.println("Email: " + account1.email);
				System.out.println("UserName: " + account1.userName);
				System.out.println("FullName: " + account1.fullName);
				System.out.println("Department Name: " + account1.department.departmentName);
				System.out.println("Position Name: " + account1.position.positionName);
				System.out.println("Create Date: " + account1.createDate);
				
				//print group
				
				System.out.println("Group 1 information: ");
				System.out.println("Group ID: " + group1.groupID);
				System.out.println("Group Name: " + group1.groupName);
				System.out.println("Creator ID: " + group1.creatorID.accountID);
				System.out.println("CreateDate: " + group1.createDate);
				
				//print ExamQuestion 
				System.out.println("ExamQuestionID: " + examQuestion1.exam.examID);
				for(int i=0 ;i< questionOfExam1.length;i++){
				System.out.println("QuestionOfExam: " + questionOfExam1[i].questionID);
				}
	}

}
