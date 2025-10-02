package menus;

import helpers.InputHelper;
import konten.Konten;
import konten.Kuis;
import models.Peserta;
import models.Sertifikat;
import models.Kursus;
import services.CourseService;
import services.UserService;

public class PesertaMenu {
  private final UserService userService = UserService.getInstance();
  private final CourseService courseService = CourseService.getInstance();

  public void register() {
    System.out.println("\n=== REGISTER PESERTA ===");
    String id = InputHelper.inputString("Masukkan ID: ");
    String username = InputHelper.inputString("Masukkan Username: ");
    String pin = InputHelper.inputString("Masukkan PIN: ");
    userService.registerPeserta(id, username, pin);
  }

  public void tampilkan() {
    String username = InputHelper.inputString("Masukkan Username: ");
    String pin = InputHelper.inputString("Masukkan PIN: ");

    Peserta peserta = userService.loginPeserta(username, pin);
    if (peserta == null) {
      System.out.println("Login gagal!");
      return;
    }

    boolean jalan = true;
    while (jalan) {
      System.out.println("\n=== MENU PESERTA ===");
      System.out.println("1. Daftar Kursus");
      System.out.println("2. Lihat Kursus Anda");
      System.out.println("0. Logout");

      String pilihan = InputHelper.inputString("Pilih: ");
      switch (pilihan) {
        case "1":
          courseService.tampilkanSemuaKursus();
          String idKursus = InputHelper.inputString("Masukkan id kursus: ");

          Kursus kursus = courseService.cariKursusById(idKursus);

          if (kursus != null && idKursus.equalsIgnoreCase(kursus.getIdKursus())) {
            // cek apakah peserta sudah mengikuti kursus ini
            if (peserta.getKursusDiikuti().contains(kursus)) {
              System.out.println(
                  "Anda sudah mengikuti kursus " + kursus.getNamaKursus() + ". Tidak bisa mendaftar dua kali.");
            } else {
              System.out.println("Lakukan pembayaran");
              int bayar = InputHelper.inputInt("Masukkan jumlah pembayaran: ");
              if (bayar == kursus.getHarga()) {
                peserta.ikutiKursus(kursus);
                System.out.println("Anda telah berhasil mengikuti kursus " + kursus.getNamaKursus());
              } else {
                System.out.println("Pembayaran gagal! Jumlah tidak sesuai.");
              }
            }
          } else {
            System.out.println("Kursus tidak ditemukan!");
          }

          break;

        case "2":
          if (peserta.getKursusDiikuti().isEmpty()) {
            System.out.println("Anda belum mengikuti kursus apapun.");
          } else {
            System.out.println("Kursus yang Anda ikuti:");
            for (int i = 0; i < peserta.getKursusDiikuti().size(); i++) {
              Kursus k = peserta.getKursusDiikuti().get(i);
              System.out.println((i + 1) + ". " + k.getNamaKursus() + " (ID: " + k.getIdKursus() + ")");
            }

            String idKursusPeserta = InputHelper.inputString("Masukkan ID kursus untuk melihat detail: ");
            Kursus kursusPeserta = courseService.cariKursusById(idKursusPeserta);

            if (kursusPeserta != null && peserta.getKursusDiikuti().contains(kursusPeserta)) {
              boolean detailKursus = true;
              while (detailKursus) {
                System.out.println("\nDetail Kursus: " + kursusPeserta.getNamaKursus());
                System.out.println("Deskripsi: " + kursusPeserta.getDeskripsi());
                System.out.println("Instruktur: " + kursusPeserta.getInstruktur().getName());
                System.out.println("Daftar Konten:");

                for (Konten konten : kursusPeserta.getDaftarKonten()) {
                  System.out.println("- " + konten.getJudul());
                  System.out.println("  Tipe: " + konten.getClass().getSimpleName());
                  System.out.println("  Deskripsi: " + konten.getDeskripsi());
                }

                System.out.println("\nOpsi:");
                System.out.println("1. Ikuti Kuis");
                System.out.println("2. Cetak Sertifikat");
                System.out.println("0. Kembali");
                String subPilihan = InputHelper.inputString("Pilih: ");

                switch (subPilihan) {
                  case "1":
                    // cari konten kuis di kursus
                    Kuis kuis = null;
                    for (Konten konten : kursusPeserta.getDaftarKonten()) {
                      if (konten instanceof Kuis) {
                        kuis = (Kuis) konten;
                        break;
                      }
                    }
                    if (kuis == null) {
                      System.out.println("Tidak ada kuis pada kursus ini.");
                    } else {
                      int skor = kuis.jalankanKuis();
                      peserta.simpanSkorKuis(kursusPeserta, skor);
                      System.out.println("Skor Anda: " + skor);
                    }
                    break;

                  case "2":
                    Integer skorKuis = peserta.getSkorKuis(kursusPeserta);
                    if (skorKuis != null && skorKuis >= 80) {
                      Sertifikat sertifikat = new Sertifikat(peserta, kursusPeserta);
                      System.out.println("Sertifikat berhasil dicetak!");
                      System.out.println(sertifikat.toString());
                    } else {
                      System.out.println(
                          "Sertifikat belum bisa dicetak. Anda harus mengerjakan kuis dan mendapatkan skor >= 80.");
                    }
                    break;

                  case "0":
                    System.out.println("Kembali ke menu peserta.");
                    detailKursus = false; 
                    break;

                  default:
                    System.out.println("Pilihan tidak valid.");
                }
              }

            } else {
              System.out.println("Kursus tidak ditemukan dalam daftar Anda.");
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
