package com.vti.backend.Inheritance;

import java.util.ArrayList;
import java.util.Scanner;

import com.vti.entity.Inheritance.Question4.Bao;
import com.vti.entity.Inheritance.Question4.Sach;
import com.vti.entity.Inheritance.Question4.TaiLieu;
import com.vti.entity.Inheritance.Question4.TapChi;

public class QLTV {
	private ArrayList<TaiLieu> taiLieus;

	public QLTV() {
		taiLieus = new ArrayList<>();
	}
	// a) Thêm mới tài liêu: Sách, tạp chí, báo.
	public void inputTaiLieu() {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Nhập số tài liệu mà bạn muốn nhập:  ");
		int n = scanner.nextInt();

		TaiLieu taiLieu = new TaiLieu();
		for (int i = 0; i < n; i++) {

			System.out.print("Bạn muốn nhập tài liệu nào? (1:Sách || 2: Tạp chí || 3: Báo) ");
			byte luaChon = scanner.nextByte();

			switch (luaChon) {
			case 1:
				taiLieu = new Sach();
				break;
			case 2:
				taiLieu = new TapChi();
				break;
			case 3:
				taiLieu = new Bao();
				break;
			default:
				System.out.println("Nhập sai !");
				i--;
				break;
			}
			taiLieu.input();
			taiLieus.add(taiLieu);
		}
	}
	// b) Xoá tài liệu theo mã tài liệu.
		public void deleteTaiLieu() {
			Scanner scanner = new Scanner(System.in);

			System.out.print("Nhập mã tài liệu cần xóa: ");
			int maTaiLieu = scanner.nextInt();

			for (TaiLieu taiLieu : taiLieus) {
				if (maTaiLieu == taiLieu.getMaTaiLieu()) {
					taiLieus.remove(taiLieu);
				}
			}
		}
	// c) Hiện thị thông tin về tài liệu.
		public void printTaiLieu() {
			for (TaiLieu taiLieu : taiLieus) {
				taiLieu.getInfor();
			}
		}
	// d) Tìm kiếm tài liệu theo loại: Sách, tạp chí, báo.
		public void findTaiLieu() {
			Scanner scanner = new Scanner(System.in);
			
			System.out.print("Bạn muốn tìm kiếm theo loại nào? (1:Sách || 2: Tạp chí || 3: Báo)");
			int luaChon = scanner.nextByte();

			switch (luaChon) {
			case 1:
				for (TaiLieu taiLieu : taiLieus) {
					if (taiLieu instanceof Sach) {
						taiLieu.getInfor();
					}
				}
				break;
			case 2:
				for (TaiLieu taiLieu : taiLieus) {
					if (taiLieu instanceof TapChi) {
						taiLieu.getInfor();
					}
				}
				break;
			case 3:
				for (TaiLieu taiLieu : taiLieus) {
					if (taiLieu instanceof Bao) {
						taiLieu.getInfor();
					}
				}
				break;
			default:
				System.out.println("Nhập sai !");
				break;
			}
		}
}
