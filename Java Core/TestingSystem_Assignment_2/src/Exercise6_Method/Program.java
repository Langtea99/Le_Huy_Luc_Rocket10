package Exercise6_Method;

import java.util.Date;

import Exercise.Account;
import Exercise.Department;
import Exercise.Position;
import Exercise.PositionName;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		//Question 1: Tạo method để in ra các số chẵn nguyên dương nhỏ hơn 10
   	question1();
	//Question 2: Tạo method để in thông tin các account
		
		
		question2() ;
//Question 3: Tạo method để in ra các số nguyên dương nhỏ hơn 10
		question3();
	}
		public static void question1()
	{
		for(int i =0 ;i<10 ;i++)
		{
			if(i%2==0)
				System.out.print(i);
		}
	}
	public static void question2() {
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
		account1.createDate = new Date("2020/07/24");

		Account account2 = new Account();
		account2.accountID = 2;
		account2.email = "account1@gmail.com";
		account2.userName = "quanganh";
		account2.fullName ="Tong Quang Anh";
		account2.position = position1;
		account2.department = department1;
		account2.createDate = new Date("2020/07/24");

		Account account3 = new Account();
		account3.accountID = 3;
		account3.email = "account1@gmail.com";
		account3.userName = "quanganh";
		account3.fullName ="Tong Quang Anh";
		account3.position = position3;
		account3.department = department2;
		account3.createDate = new Date("2020/07/24");
		Account[] account = { account1, account2, account3 };
		for (int i = 0; i < account.length; i++) 
		{
			if (i != 1) 
			{
				System.out.println("Thông tin account thứ " + (i + 1)
						+ " là :");
				System.out.println("ID: " + account[i].accountID);
				System.out.println("Email: " + account[i].email);
				System.out.println("UserName: " + account[i].userName);
				System.out.println("FullName: " + account[i].fullName);
				System.out.println("Departmaent: " + account[i].department.departmentName);
				System.out.println("Position: " + account[i].position.positionName);
				System.out.println("CreateDate: " + account[i].createDate);
			}
		}
		
	}
	public static void question3()
	{
		for(int i =0 ;i<10 ;i++)
		{
				System.out.print(i);
		}
	}

}
