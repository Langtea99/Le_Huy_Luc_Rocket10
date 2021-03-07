package com.vti.fontend;

import com.vti.backend.Transaction;
import com.vti.ultis.ScannerUtils;

public class TransactionProgram {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		question1();
	}

	public static void question1() throws Exception {
		System.out.println("Input department id: ");
		int id = ScannerUtils.inputId();

		new Transaction().deleteDepartmentUsingTransaction(id);
		System.out.println("delete success!");
	}

}
