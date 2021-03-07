package com.vti.backend.InnerClass;

import com.vti.entity.InnerClass.CPU;
import com.vti.entity.InnerClass.Car;
import com.vti.entity.InnerClass.Car.Engine;

public class InnerClass {
	public void question1() {

		CPU cpu = new CPU(100f);
		CPU.Processor processor = cpu.new Processor(4, "Dell");
		CPU.Ram ram = cpu.new Ram(8, "ASUS");

		// get cache
		System.out.println(processor.getCache());
		
		// getClockspeed
				System.out.println(ram.getClockSpeed());
	}
	public void question2() {
		Car car = new Car("Mazda", "8WD");
		Engine engine = car.new Engine();
		engine.setEngineType("Crysler"); 
		car.setEngine(engine);
		car.printInfor();

	}
}
