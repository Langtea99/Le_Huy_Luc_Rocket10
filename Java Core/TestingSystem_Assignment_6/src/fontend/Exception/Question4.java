package fontend.Exception;


import entity.Exception.Department;

public class Question4 {
	
	private static Department[] departments = new Department[3];


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Department department1 = new Department(1, "Sale");
		Department department2 = new Department(2, "Marketing");
		Department department3 = new Department(3, "BOSS");

		departments[1] = department1;
		departments[2] = department2;
		departments[3] = department3;
		
		Department[] department = {department1,department2,department3};
		
		getIndex(5);


	}


	private static void getIndex(int index) {
		// TODO Auto-generated method stub
		try {
			System.out.println(departments[index]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Cannot find department !");
		}

	}

}
