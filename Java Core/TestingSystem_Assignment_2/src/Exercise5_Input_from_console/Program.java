package Exercise5_Input_from_console;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

import Exercise.Account;
import Exercise.Department;
import Exercise.Group;
import Exercise.GroupAccount;
import Exercise.GroupofAccount;
import Exercise.Position;
import Exercise.PositionName;

public class Program {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
//		//Question 1: Viết lệnh cho phép người dùng nhập 3 số nguyên vào chương trình
			System.out.print("Moi ban nhap vao 3 so nguyen :");
			for (int i = 0; i < 3; i++) {
				int x = scanner.nextInt();
				System.out.print("Ban da nhap: " + x );
			}
			
//		//Question 2: Viết lệnh cho phép người dùng nhập 2 số thực vào chương trình
			System.out.println("Moi ban nhap vao 2 so thuc : ");
			for (int i = 0; i < 3; i++) {
				float f = scanner.nextFloat();
				System.out.println("Ban da nhap: " + f );
		}
//		//Question 3: Viết lệnh cho phép người dùng nhập họ và tên
				System.out.println("Moi ban nhap vao ho :");
				String s1 = scanner.nextLine();
				System.out.println("Moi ban nhap vao ten :");
				String s2 = scanner.nextLine();
				System.out.println("Ten ban da nhap: " + s1 + " " + s2 + "\n");	
			
		//Question 4: Viết lệnh cho phép người dùng nhập vào ngày sinh nhật của họ
				System.out.println("Moi nhap vao ngay sinh :");
				String dateInput = scanner.next();
				String pattern4 = "yyyy/MM/dd";
				SimpleDateFormat dateFormat = new SimpleDateFormat(pattern4);
				Date date = dateFormat.parse(dateInput);
				System.out.println("Birhday: " + date);
			
		//Question 5: Viết lệnh cho phép người dùng tạo account (viết thành method)
				//Đối với property Position, Người dùng nhập vào 1 2 3 4 5 và vào
				//chương trình sẽ chuyển thành Position.Dev, Position.Test,
				//Position.ScrumMaster, Position.PM
					createAccount();
					
		//			Question 6: Viết lệnh cho phép người dùng tạo department (viết thành method)
			 CreateDepartment();
			
		//Question 7: Nhập số chẵn từ console
			for(int i =0 ;i < 100 ;i++){
				System.out.print("Moi ban nhap vao 1 so :");
				int number = scanner.nextInt();
				if( number %2 == 0)
				{
					System.out.print("So "+ number + " ban vua nhap la so chan !");
				}
				else
				{
					System.out.print("Nhap sai!");
					break;
				}
				}				
		// Question 8: Viết chương trình thực hiện theo flow sau
		//Bước 1: Chương trình in ra text "mời bạn nhập vào chức năng muốn sử dụng"
		//Bước 2:
		//Nếu người dùng nhập vào 1 thì sẽ thực hiện tạo account
		//Nếu người dùng nhập vào 2 thì sẽ thực hiện chức năng tạo department
		//Nếu người dùng nhập vào số khác thì in ra text "Mời bạn nhập lại" và quay trở lại bước 1
			while (true) {
				System.out.print("Mời bạn nhập vào chức năng muốn sử dụng (1: Tao account or 2: Tao department) :");
				int luaChon = scanner.nextInt();
	
				switch (luaChon) {
				case 1:
					createAccount();
					break;
				case 2:
					CreateDepartment();
					break;
				default:
					System.out.println("Mời bạn nhập lại");
				}
			}
			
//			Question 9: Viết method cho phép người dùng thêm group vào account
//			Bước 1: In ra tên các usernames của user cho người dùng xem
//			Bước 2: Yêu cầu người dùng nhập vào username của account
//			Bước 3: In ra tên các group cho người dùng xem
//			Bước 4: Yêu cầu người dùng nhập vào tên của group
//			Bước 5: Dựa vào username và tên của group người dùng vừa chọn, hãy thêm	account vào group đó .	
					
			insertAccountToGroup();
//			Question 10: Tiếp tục Question 8 và Question 9
//			Bổ sung thêm vào bước 2 của Question 8 như sau:
//			Nếu người dùng nhập vào 3 thì sẽ thực hiện chức năng thêm group vào account
//			Bổ sung thêm Bước 3 của Question 8:
//			Sau khi người dùng thực hiện xong chức năng ở bước 2 thì in ra dòng text để hỏi người dùng "Bạn có muốn thực hiện chức năng khác không?". 
//			Nếu người dùng chọn "Có" thì quay lại bước 1, nếu người dùng chọn "Không" thì kết thúc chương trình (sử dụng lệnh return để kết thúc chương trình)
					while (true) {
						System.out.print("Mời bạn nhập vào chức năng muốn sử dụng (1: Tao account or 2: Tao department or 3:Them Account vao group):");
						int luaChon = scanner.nextInt();
			
						switch (luaChon) {
						case 1:
							createAccount();
							break;
						case 2:
							CreateDepartment();
							break;
						case 3:
							insertAccountToGroup();
						default:
							System.out.print("Ban co muon thuc hien chuc nang khac khong (1:Khong or 2:Co):");
							int chon = scanner.nextInt();
							switch(chon)
							{
							case 1:
								return;
							default:
							}					
						}
					}
			
//			Question 11: Tiếp tục Question 10
//			Bổ sung thêm vào bước 2 của Question 8 như sau:
//			Nếu người dùng nhập vào 4 thì sẽ thực hiện chức năng thêm account vào 1 nhóm ngẫu nhiên, chức năng sẽ được cài đặt như sau:
//			Bước 1: In ra tên các usernames của user cho người dùng xem
//			Bước 2: Yêu cầu người dùng nhập vào username của account
//			Bước 3: Sau đó chương trình sẽ chọn ngẫu nhiên 1 group
//			Bước 4: Thêm account vào group chương trình vừa chọn ngẫu nhiên
					while (true) {
						System.out.print("Mời bạn nhập vào chức năng muốn sử dụng (1: Tao account or 2: Tao department or 3:Them Account vao group or 4:Them Acount vao group ngau nhien):");
						int luaChon = scanner.nextInt();
			
						switch (luaChon) {
						case 1:
							createAccount();
							break;
						case 2:
							CreateDepartment();
							break;
						case 3:
							insertAccountToGroup();
						case 4:
							insertAccountToGroupRandom();
						default:
							System.out.print("Ban co muon thuc hien chuc nang khac khong (1:Khong or 2:Co):");
							int chon = scanner.nextInt();
							switch(chon)
							{
							case 1:
								return;
							default:
							}					
						}
					}
		}	
		
		public static void insertAccountToGroupRandom() {
			Scanner scanner = new Scanner(System.in);
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
		//// Create Group
			Group group1 = new Group();
			group1.groupID = 1;
			group1.groupName = "Testing System";
			group1.createDate =new Date("2020/07/24");
			
			Group group2 = new Group();
			group2.groupID = 2;
			group2.groupName = "Developement";
			group2.createDate = new Date("2020/07/24");
			
			Group group3 = new Group();
			group3.groupID = 3;
			group3.groupName = "Management";
			group3.createDate = new Date("2020/07/24");
			
			GroupAccount groupAcc = new GroupAccount();
			Account[] account = { account1, account2, account3 };
	//Bước 1: In ra tên các usernames của user cho người dùng xem				
			for (int i = 0; i < account.length; i++) 
			{
					System.out.println( i+1+"." +"UserName: " + account[i].userName);
					System.out.println("FullName: " + account[i].fullName);					
			}
	//Bước 2: Yêu cầu người dùng nhập vào username của account	
			System.out.print("Nhap vao username cua account :");
			String userName = scanner.nextLine();
			
			switch (userName) {
			case "haidang":
				groupAcc.account = account1;
				break;
			case "huyluc":
				groupAcc.account = account2;
				break;
			case "quanganh":
				groupAcc.account = account3;
				break;
			default:
				System.out.println("Mời bạn nhập lại tên username đã có!");
	            return;
			}
			
			Group[] groups = {group1,group2,group3};
			Group[] groupOfAccount = {};
			Random random = new Random();
			int groupRandom = random.nextInt(groups.length);
			System.out.println("1 group random bạn được thêm tự động là: " + groups[groupRandom].groupName);
			switch (groupRandom) {
			case 0:
				groupOfAccount = insert(groupOfAccount, group1);
				groupAcc.groups = groupOfAccount;
				break;
			case 1:
				groupOfAccount = insert(groupOfAccount, group2);
				groupAcc.groups = groupOfAccount;
				break;
			case 3:
				groupOfAccount = insert(groupOfAccount, group3);
				groupAcc.groups = groupOfAccount;
				break;
			default:
	            return;
			}
			groupAcc.joinDate = new Date();
			System.out.println("User được thêm vào group thành công!");
			System.out.println("Username: " + groupAcc.account.userName);
			System.out.println("Group: " + groupAcc.groups[0].groupName);
			System.out.println("Date join: " + groupAcc.joinDate);
		}
			private static  Group[] insert(Group[] groupOfAccount, Group group1) {
				int arrIndex = groupOfAccount.length - 1;
		        int tempIndex = groupOfAccount.length;
		        Group [] tempArr = new Group [tempIndex + 1];
		         
		        for (int i = tempIndex; i >= 0; i--) {
		            if (arrIndex > -1) {
		                tempArr[i] = groupOfAccount[arrIndex--];
		            } 
		            else {
		                tempArr[i] = group1;
		            }
		        }
		        return tempArr;
		}
		public static void insertAccountToGroup(){
			Scanner scanner = new Scanner(System.in);
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
		// Create Group
			Group group1 = new Group();
			group1.groupID = 1;
			group1.groupName = "Testing System";
			group1.createDate =new Date("2020/07/24");
			
			Group group2 = new Group();
			group2.groupID = 2;
			group2.groupName = "Developement";
			group2.createDate = new Date("2020/07/24");
			
			Group group3 = new Group();
			group3.groupID = 3;
			group3.groupName = "Management";
			group3.createDate = new Date("2020/07/24");
			Account[] account = { account1, account2, account3 };
			Group[] group = { group1, group2, group3 };
	//Bước 1: In ra tên các usernames của user cho người dùng xem				
			for (int i = 0; i < account.length; i++) 
			{
					System.out.println( i+1+"." +"UserName: " + account[i].userName);
					System.out.println("FullName: " + account[i].fullName);					
			}
	//Bước 2: Yêu cầu người dùng nhập vào username của account	
			System.out.print("Nhap vao username cua account :");
			String userName = scanner.nextLine();
			
	//Bước 3: In ra tên các group cho người dùng xem
			for (int i = 0; i < group.length; i++) 
			{
					System.out.println( i+1+"." +"GroupName: " + group[i].groupName);				
			}

	//Bước 4: Yêu cầu người dùng nhập vào tên của group
			System.out.print("Nhap vao ten group :");
			String groupName = scanner.nextLine();
			
	//Bước 5: Dựa vào username và tên của group người dùng vừa chọn, hãy thêm account vào group đó .
			GroupofAccount z = new GroupofAccount(userName,groupName);
			System.out.println("UserName: "+ userName + " vua duoc them vao group: " + groupName );	
		}
		public static void createAccount() {
			Scanner scanner = new Scanner(System.in);

			System.out.print("Nhap vao Account ID:");
			int id = scanner.nextInt();

			System.out.print("Nhap vao username:");
			String userName = scanner.nextLine();

			System.out.print("Nhap vao Department:");
			String department = scanner.nextLine();

			System.out.print("Nhap vao Position ID (tu 1 -> 5):");
			int position = scanner.nextInt(6);
			switch (position) {
			case 1:
				System.out.print("Dev");
				break;
			case 2:
				System.out.print("Test");
				break;
				case 3:
				System.out.print("ScrumMaster");
				break;
			case 4:
				System.out.print("PM");
				break;
			default:
				System.out.print("SA");
			}

			System.out.print("\nNhap vao group:");
			scanner.nextLine();
			String groups = scanner.nextLine();

			System.out.print("\nNhap vao ngay:");
			String date = scanner.nextLine();
			scanner.close();
		}
			public static void CreateDepartment() {
				Scanner scanner = new Scanner(System.in);
				System.out.print("Nhap vao Department ID:");
				int id = scanner.nextInt();
				System.out.println("Moi ban nhap ten department muon tao :");
				String department = scanner.nextLine();
				scanner.close();
	}

}
