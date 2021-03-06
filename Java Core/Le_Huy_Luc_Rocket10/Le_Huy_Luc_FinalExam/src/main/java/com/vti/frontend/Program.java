package com.vti.frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import com.vti.Utils.ScannerUtils;
import com.vti.backend.presentation.UserController;
import com.vti.entity.Position;
import com.vti.entity.User;

public class Program {
	private static UserController userController;
	public static void main(String[] args)
			throws Exception {
		menuLogin();
	}

	private static void menuLogin() throws Exception {
		Function function = new Function();
		userController = new UserController();
		
		int chon;
		do {
			System.out.println("\n*******************************************");
			System.out.println("**             Users system              **");
			System.out.println("*******************************************");
			System.out.println("**                                       **");
			System.out.println("**        1. Đăng nhập                   **");
			System.out.println("**        2. Manager của các project     **");
			System.out.println("**        3. In ra tất cả các employee & Manager trong project**");
			System.out.println("**                                       **");
			System.out.println("*******************************************");
			System.out.println("**     Nhập lựa chọn của bạn             **");
			chon = ScannerUtils.inputInt("Vui lòng nhập vào một số. Nhập lại!");
			switch(chon) {
			case 1:
				login();
				break;
			case 2:
				function.getListManagerOfUsers();
				break;
			case 3:
				function.getUserByProjectId();
				break;
			case 0:
				System.out.println("Đã thoát chương trình thành công!");
				break;
			default:
				System.err.println("Không có lựa chọn này. Nhập lại !");
				break;
			}
		} while(chon != 0);
	}

	private static void login() throws Exception {
		System.out.println("Nhap Email:");
		String email = ScannerUtils.inputString("Nhap lai!");
		System.out.println("Nhap pass word:");
		String password = ScannerUtils.inputString("Nhap lai!");
		if(userController.isUserExists(email, password))
			System.out.println("Đăng nhập thành công!");
		else
			System.out.println("Email hoặc password không đúng. Kiểm tra lại!");
	}
}


