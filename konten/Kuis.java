package konten;

import java.util.ArrayList;
import java.util.List;
import helpers.InputHelper;

public class Kuis extends Konten {
 private List<Soal> daftarSoal = new ArrayList<>();

 public Kuis(String id, String judul, String deskripsi) {
  super(id, judul, deskripsi);
 }

 public void tambahSoal(Soal soal) {
  daftarSoal.add(soal);
 }

 public int jalankanKuis() {
  if (daftarSoal == null || daftarSoal.isEmpty()) {
   System.out.println("Belum ada soal pada kuis ini.");
   return 0;
  }

  int benar = 0;

  for (Soal soal : daftarSoal) {
   System.out.println("\n" + soal.getPertanyaan());
   List<String> opsi = soal.getOpsi();
   for (int i = 0; i < opsi.size(); i++) {
    System.out.println((i + 1) + ". " + opsi.get(i));
   }

   int jawaban = InputHelper.inputInt("Pilih jawaban (1-" + opsi.size() + "): ");
   if (jawaban >= 1 && jawaban <= opsi.size()) {
    if (jawaban - 1 == soal.getJawabanBenar()) {
     benar++;
    }
   } else {
    System.out.println("Pilihan tidak valid, soal dianggap salah.");
   }
  }

  int totalSoal = daftarSoal.size();
  int skor = (int) Math.round((double) benar * 100.0 / totalSoal);

  System.out.println("\nAnda menjawab benar: " + benar + " / " + totalSoal);
  System.out.println("Skor akhir: " + skor + " / 100");

  return skor;
 }

 public List<Soal> getSoalList() {
  return daftarSoal;
 }

 @Override
 public void tampilkanKonten() {
  System.out.println("[Kuis] " + getJudul() + " (" + daftarSoal.size() + " soal)");
 }

}
