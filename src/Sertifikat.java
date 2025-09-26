public class Sertifikat {
 private String idSertifikat;
 private Peserta peserta;
 private Kursus kursus;
 private int skor;

 public Sertifikat(String id, Peserta peserta, Kursus kursus, int skor) {
  this.idSertifikat = id;
  this.peserta = peserta;
  this.kursus = kursus;
  this.skor = skor;
 }

 public void tampilkanSertifikat() {
  System.out.println("=== Sertifikat Kursus ===");
  System.out.println("ID Sertifikat : " + idSertifikat);
  System.out.println("Peserta       : " + peserta.getNama());
  System.out.println("Kursus        : " + kursus.getNamaKursus());
  System.out.println("Skor Kuis     : " + skor);
  System.out.println("==========================");
 }
}
