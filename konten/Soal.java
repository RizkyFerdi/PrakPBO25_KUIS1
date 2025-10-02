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

 public String getPertanyaan() {
  return pertanyaan;
 }

 public List<String> getOpsi() {
  return opsi;
 }

 public int getJawabanBenar() {
  return jawabanBenar;
 }
 
}
