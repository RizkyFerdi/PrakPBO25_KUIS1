package konten;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kuis extends Konten {
 private List<Soal> daftarSoal = new ArrayList<>();

 public Kuis(String id, String judul, String deskripsi) {
  super(id, judul, deskripsi);
 }

 public void tambahSoal(Soal s) {
  daftarSoal.add(s);
 }

 @Override
 public void tampilkan() {
  System.out.println("[Kuis] " + getJudul() + " (" + daftarSoal.size() + " soal)");
 }

 public int jalankanKuis(Scanner sc) {
  int skor = 0;
  for (Soal s : daftarSoal) {
   s.tampilkanSoal();
   System.out.print("Jawaban (0-3): ");
   int jawaban = Integer.parseInt(sc.nextLine());
   if (s.periksaJawaban(jawaban))
    skor += 50;
  }
  System.out.println("Skor akhir: " + skor);
  return skor;
 }
}
