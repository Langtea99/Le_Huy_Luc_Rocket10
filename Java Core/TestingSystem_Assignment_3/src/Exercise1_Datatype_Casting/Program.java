package Exercise1_Datatype_Casting;

import java.util.Random;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Question 1:
//			Khai báo 2 số lương có kiểu dữ liệu là float.
//			Khởi tạo Lương của Account 1 là 5240.5 $
//			Khởi tạo Lương của Account 2 là 10970.055$
//			Khai báo 1 số int để làm tròn Lương của Account 1 và in số int đó ra
//			Khai báo 1 số int để làm tròn Lương của Account 2 và in số int đó ra
		
		question1();
	////Question 2:	Lấy ngẫu nhiên 1 số có 5 chữ số (những số dưới 5 chữ số thì sẽ thêm	có số 0 ở đầu cho đủ 5 chữ số)
			question23();
			
	//Question 3:Lấy 2 số cuối của số ở Question 2 và in ra.
//				Gợi ý:
//				Cách 1: convert số có 5 chữ số ra String, sau đó lấy 2 số cuối
//				Cách 2: chia lấy dư số đó cho 100
			question23();
			
	//Question 4: Viết 1 method nhập vào 2 số nguyên a và b và trả về thương của chúng
			question4();
		}
		public static void question4() {
			Scanner scanner = new Scanner(System.in);
			System.out.print("Nhập a = ");
			int a =scanner.nextInt();
			int b;
			do {
				System.out.print("Nhập b = ");
				b = scanner.nextInt();
				if (b == 0) {
					System.out.println("Vui lòng nhập b khác 0 !");
				}
			} while (b == 0);
			scanner.close();
			System.out.println("Thương: " + (float) a / (float) b);
		}
		public static void question23() {
			Random random = new Random();
			int x = random.nextInt(99999);
			if( x < 10)
			{
			System.out.println("Số ngẫu nhiên: 0000" + x);
			}
			else if(x>=10 & x<100)
			{
			System.out.println("Số ngẫu nhiên: 000" + x);
			}
			else if(x>=100 & x<1000)
			{
			System.out.println("Số ngẫu nhiên: 00" + x);
			}
			else if(x>=1000 & x<10000)
			{
			System.out.println("Số ngẫu nhiên: 0" + x);
			}
			else 
			{System.out.println("Số ngẫu nhiên: " + x);}
			String y = String.valueOf(x);
			System.out.println("Hai số cuối: " + y.substring(3));
		}


	private static void question1() {
		float salary1 = 5240.5f ;
		float salary2 = 10970.055f;
		
		int roundingsalary1 = (int) salary1;
		int roundingsalary2 = (int) salary2;
		
		System.out.println("Lương của Account 1 ( Đã làm tròn): " + roundingsalary1);
		System.out.println("Lương của Account 2 ( Đã làm tròn): " + roundingsalary2);
	}

}
