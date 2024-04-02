package doanthuvien;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ThuVien {
    public static class Sach {
        private String maSach;
        private String tenSach;
        private String tacGia;
        private String theLoai;
        private int soLuong;
        private float giaTien;

        public Sach(String maSach, String tenSach, String tacGia, String theLoai, int soLuong, float giaTien) {
            this.maSach = maSach;
            this.tenSach = tenSach;
            this.tacGia = tacGia;
            this.theLoai = theLoai;
            this.soLuong = soLuong;
            this.giaTien = giaTien;
        }

        @Override
        public String toString() {
            return String.format(
                    "Ma sach: %-11s | Ten sach: %-19s | Tac gia: %1s | The loai: %-11s | So luong: %-13d | Gia tien: %-11.1f",
                    maSach, tenSach, tacGia, theLoai, soLuong, giaTien
            );
        }
    }

    private static final int MAX_SACH = 100; // Số lượng sách tối đa
    private static Sach[] danhSachSach = new Sach[MAX_SACH];
    private static int soLuongSach = 0;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            hienThiMenu();
            System.out.print("Nhap lua chon cua ban: ");
            int luaChon = scanner.nextInt();
            System.out.println();

            switch (luaChon) {
                case 1:
                    nhapThongTinSach();
                    System.out.println("Ban da nhap thong tin sach!\n");
                    break;

                case 2:
                    themSach();
                    System.out.println("Sach da duoc them vao thu vien!\n");
                    break;

                case 3:
                    timKiemSachTheoMa();
                    break;

                case 4:
                    xoaSachTheoMa();
                    break;

                case 5:
                    inDanhSachSach();
                    break;

                case 6:
                    sapXepDanhSachTheoTenSach();
                    break;

                case 7:
                    sapXepDanhSachTheoGiaTien();
                    break;

                case 8:
                    xuatDuLieuRaFile();
                    break;

                case 9:
                    nhapDuLieuTuFile();
                    break;

                case 0:
                    System.out.println("Ban da thoat chuong trinh!");
                    System.exit(0);

                default:
                    System.out.println("Khong co chuc nang nay!\n");
            }
        }
    }

    private static void hienThiMenu() {
        System.out.println("\n=============================================");
        System.out.println("==       CHUONG TRINH QUAN LY THU VIEN     ==");
        System.out.println("==    1. Nhap thong tin sach               ==");
        System.out.println("==    2. Them sach vao thu vien            ==");
        System.out.println("==    3. Tim kiem sach (theo ma sach)      ==");
        System.out.println("==    4. Xoa sach (theo ma sach)           ==");
        System.out.println("==    5. In danh sach                      ==");
        System.out.println("==    6. Sap xep danh sach theo ten sach   ==");
        System.out.println("==    7. Sap xep danh sach theo gia tien   ==");
        System.out.println("==    8. Xuat du lieu ra file              ==");
        System.out.println("==    9. Nhap du lieu tu file              ==");
        System.out.println("==    0. Thoat                             ==");
        System.out.println("==============================================\n");
    }

    private static void nhapThongTinSach() {
        System.out.print("Nhap so luong sach: ");
        int soLuong = scanner.nextInt();
        scanner.nextLine(); // Đọc ký tự Enter

        for (int i = 0; i < soLuong; i++) {
            System.out.printf("\n--- Sach thu %d ---\n", (i + 1));

            System.out.print("Nhap Ma sach: ");
            String maSach = scanner.nextLine();

            System.out.print("Nhap Ten sach: ");
            String tenSach = scanner.nextLine();

            System.out.print("Nhap Tac gia: ");
            String tacGia = scanner.nextLine();

            System.out.print("Nhap The loai: ");
            String theLoai = scanner.nextLine();

            System.out.print("Nhap So luong: ");
            int soLuongNhap = scanner.nextInt();
            scanner.nextLine(); // Đọc ký tự Enter

            System.out.print("Nhap Gia tien: ");
            float giaTien = scanner.nextFloat();
            scanner.nextLine(); // Đọc ký tự Enter

            danhSachSach[soLuongSach++] = new Sach(maSach, tenSach, tacGia, theLoai, soLuongNhap, giaTien);
        }
    }

    private static void themSach() {
        if (soLuongSach < MAX_SACH) {
            System.out.println("\n======= THEM SACH =======");
            scanner.nextLine(); // Đọc ký tự Enter từ lần nhập trước
            System.out.print("Nhap Ma sach: ");
            String maSach = scanner.nextLine();

            System.out.print("Nhap Ten sach: ");
            String tenSach = scanner.nextLine();

            System.out.print("Nhap Tac gia: ");
            String tacGia = scanner.nextLine();

            System.out.print("Nhap The loai: ");
            String theLoai = scanner.nextLine();

            System.out.print("Nhap So luong: ");
            int soLuongNhap = scanner.nextInt();
            scanner.nextLine(); // Đọc ký tự Enter

            System.out.print("Nhap Gia tien: ");
            float giaTien = scanner.nextFloat();
            scanner.nextLine(); // Đọc ký tự Enter

            danhSachSach[soLuongSach++] = new Sach(maSach, tenSach, tacGia, theLoai, soLuongNhap, giaTien);
            System.out.println("Sach da duoc them vao thu vien!\n");
        } else {
            System.out.println("Thu vien da day, khong the them sach moi!");
        }
    }

    private static void timKiemSachTheoMa() {
        System.out.println("Tim kiem sach theo Ma sach");
        System.out.print("Nhap Ma sach can tim: ");
        String maSach = scanner.next();

        boolean timThay = false;
        for (int i = 0; i < soLuongSach; i++) {
            if (danhSachSach[i].maSach.equals(maSach)) {
                timThay = true;
                System.out.println("\n==========================================");
                System.out.println("==         SACH TIM THAY                 ==");
                System.out.println(danhSachSach[i]);
                System.out.println("============================================\n");
                break;
            }
        }

        if (!timThay) {
            System.out.printf("Khong tim thay sach voi Ma sach: %s\n", maSach);
        }
    }

    private static void xoaSachTheoMa() {
        System.out.println("Xoa sach theo Ma sach");
        System.out.print("Nhap Ma sach can xoa: ");
        String maSach = scanner.next();

        boolean timThay = false;
        for (int i = 0; i < soLuongSach; i++) {
            if (danhSachSach[i].maSach.equals(maSach)) {
                timThay = true;
                for (int j = i; j < soLuongSach - 1; j++) {
                    danhSachSach[j] = danhSachSach[j + 1];
                }
                danhSachSach[--soLuongSach] = null;
                System.out.printf("Da xoa sach co Ma sach: %s\n", maSach);
                break;
            }
        }

        if (!timThay) {
            System.out.printf("Khong tim thay sach voi Ma sach: %s\n", maSach);
        }
    }

    private static void sapXepDanhSachTheoTenSach() {
        boolean hoanDoi;
        do {
            hoanDoi = false;
            for (int i = 0; i < soLuongSach - 1; i++) {
                if (danhSachSach[i].tenSach.compareToIgnoreCase(danhSachSach[i + 1].tenSach) > 0) {
                    Sach temp = danhSachSach[i];
                    danhSachSach[i] = danhSachSach[i + 1];
                    danhSachSach[i + 1] = temp;
                    hoanDoi = true;
                }
            }
        } while (hoanDoi);

        System.out.println("\n=========================================================================================================================================================");
        System.out.println("==================================================================== DANH SACH SACH ======================================================================");
        System.out.println("=========================================================================================================================================================");
        System.out.println("==    Ma sach        |     Ten sach                 |    Tac gia     |      The loai           |       So luong           |        Gia tien             ==");

        for (int i = 0; i < soLuongSach; i++) {
            System.out.println(danhSachSach[i]);
        }

        System.out.println("=========================================================================================================================================================");
    }

    private static void inDanhSachSach() {
        System.out.println("\n=========================================================================================================================================================");
        System.out.println("===================================================================== DANH SACH SACH ====================================================================");
        System.out.println("=========================================================================================================================================================");
        System.out.println("==    Ma sach        |     Ten sach                |    Tac gia   |      The loai          |       So luong          |        Gia tien                 ==");

        for (int i = 0; i < soLuongSach; i++) {
            System.out.println(danhSachSach[i]);
        }

        System.out.println("=========================================================================================================================================================");
    }

    private static void sapXepDanhSachTheoGiaTien() {
        for (int i = 0; i < soLuongSach - 1; i++) {
            for (int j = i + 1; j < soLuongSach; j++) {
                if (danhSachSach[i].giaTien < danhSachSach[j].giaTien) {
                    Sach temp = danhSachSach[i];
                    danhSachSach[i] = danhSachSach[j];
                    danhSachSach[j] = temp;
                }
            }
        }

        System.out.println("\n=========================================================================================================================================================");
        System.out.println("============================================================== DANH SACH SACH (THEO GIA TIEN GIAM DAN) ===================================================");
        System.out.println("=========================================================================================================================================================");
        System.out.println("==    Ma sach        |     Ten sach                |    Tac gia   |      The loai          |       So luong          |        Gia tien                ==");

        for (int i = 0; i < soLuongSach; i++) {
            System.out.println(danhSachSach[i]);
        }

        System.out.println("=========================================================================================================================================================");
    }

    private static void xuatDuLieuRaFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("danh_sach_sach.txt"))) {
            for (int i = 0; i < soLuongSach; i++) {
                writer.write(String.format("%s,%s,%s,%s,%d,%.2f\n",
                        danhSachSach[i].maSach,
                        danhSachSach[i].tenSach,
                        danhSachSach[i].tacGia,
                        danhSachSach[i].theLoai,
                        danhSachSach[i].soLuong,
                        danhSachSach[i].giaTien));
            }
            System.out.println("Luu du lieu vao file thanh cong.");
        } catch (IOException e) {
            System.out.println("Loi khi luu file: " + e.getMessage());
        }
    }

    private static void nhapDuLieuTuFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("danh_sach_sach.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String maSach = parts[0];
                String tenSach = parts[1];
                String tacGia = parts[2];
                String theLoai = parts[3];
                int soLuong = Integer.parseInt(parts[4]);
                float giaTien = Float.parseFloat(parts[5]);

                Sach sach = new Sach(maSach, tenSach, tacGia, theLoai, soLuong, giaTien);
                themSachVaoDanhSach(sach);
            }
            System.out.println("Doc du lieu tu file thanh cong.");
        } catch (IOException e) {
            System.out.println("Loi khi doc file: " + e.getMessage());
        }
    }

    private static void themSachVaoDanhSach(Sach sach) {
        if (soLuongSach < MAX_SACH) {
            danhSachSach[soLuongSach++] = sach;
        } else {
            System.out.println("Thu vien da day, khong the them sach moi!");
        }
    }
}

