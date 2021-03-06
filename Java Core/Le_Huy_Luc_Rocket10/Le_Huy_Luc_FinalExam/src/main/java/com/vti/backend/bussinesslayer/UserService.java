package com.vti.backend.bussinesslayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.Utils.ScannerUtils;
import com.vti.backend.datalayer.IUserRepository;
import com.vti.backend.datalayer.UserRepository;
import com.vti.entity.Project;
import com.vti.entity.User;

public class UserService implements IUserService {

	private IUserRepository userRepository;

	public UserService() throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		userRepository = new UserRepository();
	}

	public List<User> getListManagerOfUsers() throws Exception {
		return userRepository.getListManagerOfUsers();
	}

	public Project getUserByProjectId(int projectId) throws Exception {
		return userRepository.getUserByProjectId(projectId);
	}

	@Override
	public boolean isUserExists(String email, String password) throws Exception {
		String email1 = email;
		String pass1 = password;
		boolean check = false;
		
		while(!check) {
			if (chuanHoaEmail(email1)) {
				check = true;
			}
			else {
				System.out.println("Email nhập chưa đúng định dạng.Nhập lại!");
				email1 = ScannerUtils.inputString("Vui lòng nhập!");
			}
		}
		check = false;
		while(!check) {
			if (checkPassword(pass1)) {
				check = true;
			}
			else {
				System.out.println("Pass nhập từ 6 tới 12 ký tự, có ít nhất 1 ký tự viết hoa. Nhap lai!");
				pass1 = ScannerUtils.inputString("Vui lòng nhập!");
			}
		}
		
		return userRepository.isUserExists(email1, pass1);
	}
	private boolean chuanHoaEmail(String email) {
		String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		String email1 = email;
		Boolean check = email1.matches(EMAIL_REGEX);
		return check;
	}
	
	private boolean checkPassword(String pass) {
		boolean check = false;
		boolean check2 = false;
		
		for (int i =0; i<pass.length(); i++) {
			if(Character.isUpperCase(pass.charAt(i)))
				check = true;
		}
		
		if(pass.length()>5 && pass.length()<13 && check==true) {
			check2 = true;
		}
		
		return check2;
	}
}
