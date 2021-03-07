package Exercise4_String;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		//Question 1:Nhập một xâu kí tự, đếm số lượng các từ trong xâu kí tự đó (các từ có thể cách nhau bằng nhiều khoảng trắng )
//		question1();
		
//Question 2: Nhập hai xâu kí tự s1, s2 nối xâu kí tự s2 vào sau xâu s1
//		question2();
		
//Question 3:Viết chương trình để người dùng nhập vào tên và kiểm tra, nếu tên chư .Viết hoa chữ cái đầu 
//		question3();

//Question 4: Viết chương trình để người dùng nhập vào tên in từng ký tự trong tên của người dùng ra
//		quetion4();

//Question 5:Viết chương trình để người dùng nhập vào họ, sau đó yêu cầu người dùng nhập vào tên và hệ thống sẽ in ra họ và tên đầy đủ
//		quetion5();
		
//Question 6:Viết chương trình yêu cầu người dùng nhập vào họ và tên đầy đủ và sau đó hệ thống sẽ tách ra họ, tên , tên đệm		
//		question6();

//Question 7:Viết chương trình yêu cầu người dùng nhập vào họ và tên đầy đủ và chuẩn hóa họ và tên của họ như sau:
//	a) Xóa dấu cách ở đầu và cuối và giữa của chuỗi người dùng nhập vào
//	VD: Nếu người dùng nhập vào " nguyễn văn nam " thì sẽ chuẩn hóa thành "nguyễn văn nam"
//	b) Viết hoa chữ cái mỗi từ của người dùng
//	VD: Nếu người dùng nhập vào " nguyễn văn nam " thì sẽ chuẩn hóa thành "Nguyễn Văn Nam"
//		question7();
		
//Question 8: In ra tất cả các group có chứa chữ "Java"
//		quetion8();
		
//Question 9: In ra tất cả các group "Java"	
//		question9();
		
//Question 10:Kiểm tra 2 chuỗi có là đảo ngược của nhau hay không.Nếu có xuất ra “OK” ngược lại “KO”. Ví dụ “word” và “drow” là 2 chuỗi đảo ngược nhau.
//		question10();
		
//Question 11: Count special Character .Tìm số lần xuất hiện ký tự "a" trong chuỗi	
//		question11();
		
//Question 12: Reverse String .Đảo ngược chuỗi sử dụng vòng lặp
//		question12();
		
//Question 13: Kiểm tra một chuỗi có chứa chữ số hay không, nếu có in ra false ngược lại true.
//		question13();
		
//Question 14: Cho một chuỗi str, chuyển các ký tự được chỉ định sang một ký tự khác cho trước. 
//		question14();
		
//Question 15: Đảo ngược các ký tự của chuỗi cách nhau bởi dấu cách mà không dùng thư viện.
//		question15();
		
//Question 16:Cho một chuỗi str và số nguyên n >= 0. Chia chuỗi str ra làm các phần bằng nhau với n ký tự. Nếu chuỗi không chia được thì xuất ra màn hình “KO”.
//		question16();
		
		String str = "  Le Huy Luc ";
		demSoTu(str);
	}

	public static void question16() {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Chuoi: ");
		String str = scanner.nextLine();
		System.out.print("Nhập n: ");
		int n = scanner.nextInt();
		
		scanner.close();
		
		if (str == null || str.length()<= 1 || str.length() % n != 0) {
			System.out.println("Ko");
			return;
		}

		for (int i = 0; i < str.length(); i =i+n) {
			System.out.println(str.substring(i, i + n));
		}
	}

	public static void question15() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Chuỗi: ");
		String str = scanner.nextLine();
		scanner.close();

		String[] words = str.split(" ");

		for (int i = words.length - 1; i >= 0; i--) {
			System.out.print(words[i] + " ");
		}
		
	}

	public static void question14() {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Nhập chuỗi: ");
		String str = scanner.nextLine();

		System.out.print("Nhập kí tự muốn chuyển: ");
		char mch = scanner.nextLine().toCharArray()[0];

		System.out.print("Nhập kí tự sẽ chuyển: ");
		char tch= scanner.nextLine().toCharArray()[0];

		scanner.close();

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == mch) {
				str = str.replace(mch, tch);
			}
		}

		System.out.println("Chuoi sau khi chuyen: " + str);
		
	}

	public static void question13() {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Nhập chuỗi :");
		String chuoi = scanner.nextLine();
		scanner.close();
		
		for(int i=0;i < chuoi.length(); i++)
		{
			if(chuoi.charAt(i)==0 || chuoi.charAt(i)==1 || chuoi.charAt(i)==2 || chuoi.charAt(i)==3 || chuoi.charAt(i)==4 || chuoi.charAt(i)==5 || chuoi.charAt(i)==6 || chuoi.charAt(i)==7 || chuoi.charAt(i)==8 || chuoi.charAt(i)==9 )
			{
				System.out.println("False");
				break;
			}
			else
			{
				System.out.println("True");
			break;
			}
		}	
	}

	public static void question12() {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Nhập chuỗi :");
		String s1 = scanner.nextLine();
		
		String chuoidao = "";
		for (int i = s1.length() - 1; i >= 0; i--) {
			chuoidao += s1.charAt(i);
		}
		System.out.println("Chuoi sau khi dao :"+chuoidao);
		scanner.close();	
	}

	public static void question11() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Nhap vao mot chuoi :");
		String  chuoi = scanner.nextLine();
		scanner.close();
		
		int dem = 0;
		for (int i = 0; i < chuoi.length(); i++) {
			if ('a' == chuoi.charAt(i)) {
				dem++;
			}
		}

		System.out.println("Số lần xuất hiện ký tự 'a' trong chuỗi :"+dem);
	}

public static void question10() {
		Scanner scanner = new Scanner(System.in);
		String  daos1 = "";

		System.out.print("Nhập chuỗi 1 :");
		String s1 = scanner.nextLine();

		System.out.print("Nhập chuỗi 2 :");
		String s2 = scanner.nextLine();

		scanner.close();

		for (int i = s1.length() - 1; i >= 0; i--) {
			daos1 += s1.substring(i, i + 1);
		}

		if (s2.equals(daos1)) {
			System.out.println("Đây là chuỗi đảo ngược !");
		}
		else
			System.out.println("Đây không là chuỗi đảo ngược !");	
	}

	public static void question9() {
		String[] groupNames = { "Java core", "C#", "C++","Java tool","Java" };

		for (String groupName : groupNames) {
			if (groupName.equals("Java")) {
				System.out.println(groupName);
			}
		}		
	}

	public static void quetion8() {
		String[] groupNames = { "Java core", "C#", "C++","Java tool" };

		for (String groupName : groupNames) {
			if (groupName.contains("Java")) {
				System.out.println(groupName);
			}
		}	
	}

	public static void question7() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Nhập họ tên đầy đủ :");
		String fullName = scanner.nextLine();

		scanner.close();
		String[] words = fullName.split(" ");
		String fullNameNew = "";
		for (String word : words) {
			String firstCharacter = word.substring(0,1).toUpperCase();
			String leftCharacter = word.substring(1);
			word = firstCharacter + leftCharacter;
			fullNameNew += word + " ";
		}

		System.out.println("Họ tên sau khi chuẩn hóa: " + fullNameNew);
		
	}

	public static void question6() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Nhập họ và tên đầy đủ: ");
		String fullName = scanner.nextLine();
		String[] x = fullName.split(" ");
		String lastName = x[0];
		String firstName = x[x.length - 1];
		String middleName ="";
		for (int i = 1; i <= x.length - 2; i++) {
			 middleName += x[i] + " ";
		}
		System.out.println("Họ là: " + lastName);
		System.out.println("Tên đệm là: " + middleName);
		System.out.println("Tên là: " + firstName);
		scanner.close();
	}

	public static void quetion5() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Nhập họ: ");
		String firtName = scanner.nextLine();
		
		System.out.print("Nhập tên: ");
		String lastName = scanner.nextLine();
		
		System.out.print("Ho ten : " + firtName+" "+(lastName));
		scanner.close();
	}

	public static void quetion4() {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Nhập tên: ");
		String name = scanner.nextLine();

		name = name.toUpperCase();

		for (int i = 0; i < name.length(); i++) {
			System.out.println("Ký tự thứ " + i + " là: " + name.charAt(i));
		}
		scanner.close();
		
	}

	public static void question3() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Nhập Tên: ");
		String name = scanner.nextLine();
		
		String firstCharacter = name.substring(0,1).toUpperCase();
		String leftCharacter = name.substring(1);

		System.out.println(firstCharacter+leftCharacter );
		scanner.close();	
	}

	public static void question2() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Nhập chuỗi 1: ");
		String s1 = scanner.nextLine();

		System.out.println("Nhập chuỗi 2: ");
		String s2 = scanner.nextLine();

		System.out.println("Sau khi nối chuỗi : " + s1.concat(s2));
		scanner.close();	
	}
	public static void demSoTu(String str)
	{
		int tongSoTu = 1;
		//Buoc1: Chuan hoa
		while(str.charAt(0) == ' ')
		{
			str = str.substring(1);
		}
		while(str.charAt(str.length()-1) == ' ')
		{
			str = str.substring(0,str.length()-1);
		}
		for(int i =0 ;i < str.length()-1 ;i++ )
		{
			if(str.charAt(i)==' '&& str.charAt(i+1)==' ')
			{
				str = str.substring(0,i).concat(str.substring(i+1));
				i =i-1;
			}
		}
		for(int i=0;i<str.length()-1;i++)
		{
			if(str.charAt(i)==' ')
				tongSoTu++;
		}	
		System.out.println(str);
		System.out.println(tongSoTu);
	}
	public static void question1() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Nhap vao mot chuoi : ");
		String q1 = scanner.nextLine();
		String[] words = q1.split(" ");
		System.out.println("So tu: " + words.length);
		scanner.close();
	}

}
