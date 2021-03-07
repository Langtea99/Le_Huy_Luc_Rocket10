package fontend.Exception;

public class Question3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			int[] numbers = { 1, 2, 3 };
			System.out.println(numbers[10]);

		} catch (Exception e) {
			System.err.println(e);
		}

	}

}
