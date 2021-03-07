package com.vti.backend.Abstraction;

import com.vti.entity.Abstraction.Employee;
import com.vti.entity.Abstraction.Manager;
import com.vti.entity.Abstraction.Phone;
import com.vti.entity.Abstraction.VietnamesePhone;
import com.vti.entity.Abstraction.Waiter;

public class Abstraction {
	public void question1(){
		Phone phone = new VietnamesePhone();
		phone.insertContact("Shadow", "0342744550");
		phone.removeContact("Shadow");
		phone.updateContact("Shadow", "0342744550");
		phone.searchContact("Shadow");	
	}
	public void question2_3(){
		Employee employee = new Employee("Đăng Black", 6.9);
		employee.displayInfo();

		Manager manager = new Manager("Quang Anh", 9.6);
		manager.displayInfo();

		Waiter waiter = new Waiter("Chiến Panda", 2.6);
		waiter.displayInfo();
	}
}
