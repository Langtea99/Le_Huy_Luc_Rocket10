package com.vti.backend.Abstraction;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.vti.entity.Abstraction.ITuyenSinh;
import com.vti.entity.Abstraction.ThiSinh;

public class TuyenSinh implements ITuyenSinh{
	private List<ThiSinh> thiSinhs;
	public TuyenSinh() {
		thiSinhs = new ArrayList<>();
	}

	@Override
	public void themThiSinh() {
		// TODO Auto-generated method stub
		ThiSinh thiSinh = new ThiSinh();
		thiSinh.nhap ();
		thiSinhs.add(thiSinh);
	}

	@Override
	public void hienThiSinh() {
		// TODO Auto-generated method stub
		for(ThiSinh thisinh : thiSinhs){
			System.out.println(thisinh);
		}
	}

	@Override
	public void timThiSinh() {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.print("Nhập số báo danh cần tìm: ");
		int sbd = scanner.nextInt();

		for (ThiSinh thisinh : thiSinhs) {
			if (thisinh.getSoBaoDanh()== sbd ) {
				System.out.println(thisinh);
			}
		}
	}

}
