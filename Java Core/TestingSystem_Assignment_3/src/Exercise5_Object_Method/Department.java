package Exercise5_Object_Method;

public class Department {
	int departmentID;
	String departmentName;
	
@Override
public String toString(){
	String result ="";
	result += "DepartmentID :"+ departmentID+"\n";
	result += "DepartmentName :"+ departmentName+"\n";
	return result;
}
}
