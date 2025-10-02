package menus;

import helpers.InputHelper;
import models.Instruktur;
import models.Kursus;
import konten.*;
import services.CourseService;
import services.UserService;
import java.util.List;
import java.util.ArrayList;

public class InstrukturMenu {
  private final UserService userService = UserService.getInstance();
  private final CourseService courseService = CourseService.getInstance();

  public void tampilkan() {
    String username = InputHelper.inputString("Masukkan Username: ");
    String pin = InputHelper.inputString("Masukkan PIN: ");

    Instruktur instruktur = userService.loginInstruktur(username, pin);
    if (instruktur == null) {
      System.out.println("Login gagal!");
      return;
    }

    boolean jalan = true;
    while (jalan) {
      System.out.println("\n=== MENU INSTRUKTUR ===");
      System.out.println("1. Tambah Kursus");
      System.out.println("2. Tambah Konten ke Kursus");
      System.out.println("0. Logout");

      String pilihan = InputHelper.inputString("Pilih: ");
      switch (pilihan) {
        case "1":
          String idK = InputHelper.inputString("ID Kursus: ");
          String namaK = InputHelper.inputString("Nama Kursus: ");
          String deskripsi = InputHelper.inputString("Deskripsi: ");
          int harga = InputHelper.inputInt("Harga: ");
          Kursus kursus = new Kursus(idK, namaK, deskripsi, harga, instruktur);
          courseService.tambahKursus(kursus);

          // hardcode
          // Kursus kursus2 = new Kursus("I002", "WEB", "HAHAHA", 200000, instruktur);
          // Kursus kursus1 = new Kursus("I001", "PBO", "HAHAHA", 200000, instruktur);
          // courseService.tambahKursus(kursus1);
          // courseService.tambahKursus(kursus2);
          break;

        case "2":
          courseService.tampilkanSemuaKursus();
          String idKursus = InputHelper.inputString("Masukkan ID Kursus: ");
          Kursus kursusPilihan = courseService.cariKursusById(idKursus);

          if (kursusPilihan == null) {
            System.out.println("Kursus tidak ditemukan.");
            break;
          }

          boolean jalanKonten = true;
          while (jalanKonten) {
            System.out.println("\n=== MENU TAMBAH KONTEN ===");
            System.out.println("1. Tambah Video");
            System.out.println("2. Tambah Artikel");
            System.out.println("3. Tambah Kuis");
            System.out.println("0. Keluar");
            String pilihKonten = InputHelper.inputString("Pilih: ");

            switch (pilihKonten) {
              case "1":
                String idV = InputHelper.inputString("ID Video: ");
                String judulV = InputHelper.inputString("Judul: ");
                String deskV = InputHelper.inputString("Deskripsi: ");
                int durasi = InputHelper.inputInt("Durasi (menit): ");
                kursusPilihan.tambahKonten(new Video(idV, judulV, deskV, durasi));
                break;

              case "2":
                String idA = InputHelper.inputString("ID Artikel: ");
                String judulA = InputHelper.inputString("Judul: ");
                String deskA = InputHelper.inputString("Deskripsi: ");
                String penulis = InputHelper.inputString("Penulis: ");
                kursusPilihan.tambahKonten(new Artikel(idA, judulA, deskA, penulis));
                break;

              case "3":
                String idKuis = InputHelper.inputString("ID Kuis: ");
                String judulK = InputHelper.inputString("Judul: ");
                String deskK = InputHelper.inputString("Deskripsi: ");
                Kuis kuis = new Kuis(idKuis, judulK, deskK);

                // Hardcode soal untuk testing
                // List<String> opsi1 = Arrays.asList("2", "3", "4", "5");
                // kuis.tambahSoal(new Soal("Berapakah hasil 2 + 2?", opsi1, 2));
                // List<String> opsi2 = Arrays.asList("Jakarta", "Bandung", "Surabaya",
                // "Medan");
                // kuis.tambahSoal(new Soal("Ibu kota Indonesia adalah?", opsi2, 0));
                // List<String> opsi3 = Arrays.asList("Merkurius", "Venus", "Bumi", "Mars");
                // kuis.tambahSoal(new Soal("Planet ketiga dari matahari adalah?", opsi3, 2));

                int jumlahSoal = InputHelper.inputInt("Jumlah soal: ");
                for (int i = 0; i < jumlahSoal; i++) {
                  String pertanyaan = InputHelper.inputString("Soal " + (i + 1) + ": ");

                  List<String> opsi = new ArrayList<>();
                  // Batasi hanya 3 opsi
                  for (int j = 0; j < 3; j++) {
                    opsi.add(InputHelper.inputString("Opsi " + (j + 1) + ": "));
                  }

                  int jawaban;
                  while (true) {
                    jawaban = InputHelper.inputInt("Nomor jawaban benar (1-3): ");
                    if (jawaban >= 1 && jawaban <= 3) {
                      break;
                    }
                    System.out.println("Pilihan tidak valid. Masukkan angka 1 - 3.");
                  }

                  // simpan jawaban benar sebagai 0-based index
                  kuis.tambahSoal(new Soal(pertanyaan, opsi, jawaban - 1));
                }

                kursusPilihan.tambahKonten(kuis);
                System.out.println("Kuis berhasil ditambahkan ke kursus " + kursusPilihan.getNamaKursus());
                break;

              case "0":
                jalanKonten = false;
                break;
            }
          }
          break;

        case "0":
          jalan = false;
          break;
      }
    }
  }
}
