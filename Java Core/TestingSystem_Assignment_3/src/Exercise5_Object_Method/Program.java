package Exercise5_Object_Method;

public class Program {

	public static void main(String[] args) {
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
				
				Department department4 = new Department();
				department4.departmentID = 4;
				department4.departmentName = "Marketing";

				Department department5 = new Department();
				department5.departmentID = 5;
				department5.departmentName = "Sale";
				
				Department[] departments = {department1,department2,department3,department4,department5};
		//Question 1:In ra thông tin của phòng ban thứ 1 (sử dụng toString())
				question1(department1);
				
		//Question 2:In ra thông tin của tất cả phòng ban (sử dụng toString())
				question2(departments);
				
//			Question 3:In ra địa chỉ của phòng ban thứ 1
				question3(department1);
				
		//Question 4: Kiểm tra xem phòng ban thứ 1 có tên là "Phòng A" không?
				queston4(department1);
				
		//Question 5: So sánh 2 phòng ban thứ 1 và phòng ban thứ 2 xem có bằng nhau không (bằng nhau khi tên của 2 phòng ban đó bằng nhau)
				question5(department1, department2);
				
		//Question 6: Khởi tạo 1 array phòng ban gồm 5 phòng ban, sau đó in ra danh sách phòng ban theo thứ tự tăng dần theo tên (sắp xếp theo vần ABCD)
				question6(departments);
				
		//Question 7: Khởi tạo 1 array học sinh gồm 5 Phòng ban, sau đó in ra danh sách phòng ban được sắp xếp theo tên
				question7(departments);

			}

			public static void question7(Department[] departments) {
				// doi chuoi
				for (int i = 0; i < departments.length-1; i++) {
					String reverseNameDepartment = reverseWords(departments[i].departmentName);
					for (int j = i+1; j < departments.length ; j++) {
						String reverseNameComparingDepartment = reverseWords(departments[j].departmentName);
						if (reverseNameDepartment.compareToIgnoreCase(reverseNameComparingDepartment) < 0) {
							Department temp = departments[i];
							departments[i] = departments[j];
							departments[j] = temp;
						}
					}
				}
				for (Department department : departments) {
					System.out.println(department);
				}
			}
			// Dao chuoi
			private static String reverseWords(String str) {
				str = str.trim();
				str = str.replaceAll("\\s+", " ");
				String[] words = str.split(" ");
				str = "";
				for (int i = words.length - 1; i >= 0; i--) {
					str += words[i] + " ";
				}
				return str.substring(0, str.length() - 2);		
			}

			public static void question6(Department[] departments) {
				for (int i = 0; i < departments.length-1; i++) {
					for (int j = i+1; j < departments.length; j++) {
						if (departments[i].departmentName.compareToIgnoreCase(departments[j].departmentName) < 0) {
							Department temp = departments[i];
							departments[i] = departments[j];
							departments[j] = temp;
						}
					}
				}
				for (Department department : departments) {
					System.out.println(department);
				}
				
			}

			public static void question5(Department department1, Department department2) {
				if (department1.departmentName.equals(department2.departmentName)) {
					System.out.println("Hai phong ban bang nhau !");
				} else {
					System.out.println("Hai phong ban khong bang nhau !");
				}		
			}
			public static void queston4(Department department) {
				if (department.departmentName.equals("Phòng A")) {
					System.out.println("Có tên là phòng A");
				} else {
					System.out.println("Không tên là phòng A");		
					}
			}
			public static void question3(Department department) {
				System.out.println(department.hashCode());	
			}

			public static void question2(Department[] departments) {
				for (Department department : departments) {
					System.out.println(department);
				}
			}
			public static void question1(Department department) {
				System.out.println(department);
	}

}
