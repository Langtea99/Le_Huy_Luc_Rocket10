package fontend.Exception;

import Utils.ScannerUtils;

public class Question7_8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Nhập id: ");
		int id = ScannerUtils.inputInt("id phải là 1 số, mời nhập lại: ");

		System.out.println("id của bạn: " + id);

		System.out.println("Nhập money: ");
		float money = ScannerUtils.inputFloat("money phải là 1 số thực, mời nhập lại: ");

		System.out.println("Money của bạn: " + money);

		System.out.println("Nhập tên: ");
		String name = ScannerUtils.inputString("Tên của bạn phải là 1 String khác rỗng, mời nhập lại: ");

		System.out.println("Money của bạn: " + name);

	}

}
