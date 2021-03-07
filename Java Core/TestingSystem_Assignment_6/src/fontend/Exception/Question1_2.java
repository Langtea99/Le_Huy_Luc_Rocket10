package fontend.Exception;

public class Question1_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{float result = divide(7,0);
		System.out.println(result);
		}catch(Exception e){
			System.err.println("Cannot divide 0");
		}finally{
			System.out.println("divide completed!");
		}
	}

	private static float divide(int a, int b) {
		// TODO Auto-generated method stub
		return a/b;
	}

}
