public class Pembayaran {
 private String id;
 private Peserta peserta;
 private Kursus kursus;
 private double jumlah;
 private String metode;
 private String status; // Pending, Sukses, Gagal

 public Pembayaran(String id, Peserta peserta, Kursus kursus, double jumlah, String metode) {
  this.id = id;
  this.peserta = peserta;
  this.kursus = kursus;
  this.jumlah = jumlah;
  this.metode = metode;
  this.status = "Pending";
 }

 public void konfirmasi() {
  this.status = "Sukses";
 }

 public String getStatus() {
  return status;
 }

 public Peserta getPeserta() {
  return peserta;
 }

 public Kursus getKursus() {
  return kursus;
 }
}
