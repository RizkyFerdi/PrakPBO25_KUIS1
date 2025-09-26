import java.util.*;
import app.services.CourseService;
import app.services.PaymentService;
import app.services.UserService;
import konten.*;

public class Peserta {
 private String idPeserta;
 private String nama;
 private String email;
 private Map<Kursus, Integer> progressKursus = new HashMap<>();
 private Map<Kursus, Integer> skorKuis = new HashMap<>();

 public Peserta(String id, String nama, String email) {
  this.idPeserta = id;
  this.nama = nama;
  this.email = email;
 }

 public String getIdPeserta() {
  return idPeserta;
 }

 public String getNama() {
  return nama;
 }

 public void daftarKursus(Kursus k) {
  progressKursus.put(k, 0);
  System.out.println(nama + " berhasil daftar kursus " + k.getNamaKursus());
 }

 public void tambahProgress(Kursus k) {
  if (progressKursus.containsKey(k)) {
   int now = progressKursus.get(k);
   progressKursus.put(k, Math.min(100, now + 20));
  }
 }

 public double getProgressPersen(Kursus k) {
  return progressKursus.getOrDefault(k, 0);
 }

 public void simpanSkorKuis(Kursus k, int skor) {
  skorKuis.put(k, skor);
 }

 public int getSkorKuis(Kursus k) {
  return skorKuis.getOrDefault(k, 0);
 }
}
