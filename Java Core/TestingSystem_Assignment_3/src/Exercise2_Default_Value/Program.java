package Exercise2_Default_Value;

import java.time.LocalDate;

public class Program {

	public static void main(String[] args) {
		//Question 1:Không sử dụng data đã insert từ bài trước, tạo 1 array Account và khởi tạo 5 phần tử theo cú pháp (sử dụng vòng for để khởi tạo):
//		 Email: "Email 1"
//		 Username: "User name 1"
//		 FullName: "Full name 1"
//		 CreateDate: now
	question1();
}

	private static void question1() {
		Account[] accounts = new Account[5];
		for(int i = 0; i< accounts.length; i++)
		{
			accounts[i] = new Account();
			accounts[i].email = "Email " + i+1;
			accounts[i].userName = "Username " + i+1;
			accounts[i].fullName = "FullName " + i+1;
			accounts[i].createDate = LocalDate.now();
		}
		for (Account account : accounts) {
			System.out.println(account.email);
			System.out.println(account.userName);
			System.out.println(account.fullName);
			System.out.println(account.createDate);
		}
	}

}
