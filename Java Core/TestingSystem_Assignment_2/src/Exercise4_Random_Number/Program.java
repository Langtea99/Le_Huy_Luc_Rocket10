package Exercise4_Random_Number;

import java.time.LocalDate;
import java.util.Random;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//Question 1:In ngẫu nhiên ra 1 số nguyên
		Random random = new Random();
		int x = random.nextInt();
		System.out.println(x);
	//Question 2:In ngẫu nhiên ra 1 số thực
		float y = random.nextFloat();
		System.out.println(y);
	//Question 3:Khai báo 1 array bao gồm các tên của các bạn trong lớp, sau đó in ngẫu nhiên ra tên của 1 bạn
		String[] names = { "Luc", "Huy", "Quang" };
		int i = random.nextInt(names.length);
		System.out.println(names[i]);
	//Question 4:Lấy ngẫu nhiên 1 ngày trong khoảng thời gian 24-07-1995 tới ngày 20-12-1995
		int minDay = (int) LocalDate.of(1995, 07, 24).toEpochDay();
		int maxDay = (int) LocalDate.of(1995, 12, 20).toEpochDay();
		long randomInt = minDay + random.nextInt(maxDay - minDay);
		LocalDate randomDay = LocalDate.ofEpochDay(randomInt);
		System.out.println(randomDay);
	//Question 5:Lấy ngẫu nhiên 1 ngày trong khoảng thời gian 1 năm trở lại đây
		int now = (int) LocalDate.now().toEpochDay();
		randomInt = now - random.nextInt(365);
		randomDay = LocalDate.ofEpochDay(randomInt);
		System.out.println(randomDay);
	//Question 6: Lấy ngẫu nhiên 1 ngày trong quá khứ
		int z = random.nextInt(31 - 1 +1  )+ 1;
		System.out.println(z);
	//Question 7: Lấy ngẫu nhiên 1 số có 3 chữ số
		int k = random.nextInt(999 - 100)+100;
		System.out.println(k);
	}
}
