package entity.Exception;

public class Department {
	private int id;
	private String name;

	public Department() {
		
	}

	public Department(int id, String name) {
		this.id = id;
		this.name = name;
	}
	@Override
	public String toString() {
		return "Department{" + "id=" + id + ", name='" + name + '\'' + '}';
	}

}
