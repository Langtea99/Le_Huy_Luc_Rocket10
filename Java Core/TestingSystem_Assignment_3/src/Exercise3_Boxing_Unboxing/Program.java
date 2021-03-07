package Exercise3_Boxing_Unboxing;

public class Program {

	public static void main(String[] args) {
//		Question 1:Khởi tạo lương có datatype là Integer có giá trị bằng 5000.
		//	Sau đó convert lương ra float và hiển thị lương lên màn hình (với số float có 2 số sau dấu thập phân)
			quetion1();
			
		//	Question 2:Khai báo 1 String có value = "1234567".Hãy convert String đó ra số int	
			quetion2();
			
		//	Question 3:Khởi tạo 1 số Integer có value là chữ "1234567" .Sau đó convert số trên thành datatype int
			quetion3();
		}
		public static void quetion3() {
			Integer x = 1234567;
			int y = x.intValue();
			System.out.println(y);
			
			
		}
		public static void quetion2() {
			String x = "1234567";
			Integer y = Integer.parseInt(x);
			System.out.println("\n");
			System.out.println(y);
			
		}
		public static void quetion1() {
			Integer salary = 5000;
			Float x = (float) salary;
			System.out.printf("%2.2f", x);	
	}

}
