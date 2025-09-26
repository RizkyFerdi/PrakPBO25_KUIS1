package konten;

import java.util.List;

public class Soal {
 private String pertanyaan;
 private List<String> opsi;
 private int jawabanBenar;

 public Soal(String pertanyaan, List<String> opsi, int jawabanBenar) {
  this.pertanyaan = pertanyaan;
  this.opsi = opsi;
  this.jawabanBenar = jawabanBenar;
 }

 public void tampilkanSoal() {
  System.out.println(pertanyaan);
  for (int i = 0; i < opsi.size(); i++) {
   System.out.println(i + ". " + opsi.get(i));
  }
 }

 public boolean periksaJawaban(int idx) {
  return idx == jawabanBenar;
 }
}
