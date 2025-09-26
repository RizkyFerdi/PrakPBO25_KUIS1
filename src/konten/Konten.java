package konten;

public abstract class Konten {
 private String idKonten;
 private String judul;
 private String deskripsi;

 public Konten(String idKonten, String judul, String deskripsi) {
  this.idKonten = idKonten;
  this.judul = judul;
  this.deskripsi = deskripsi;
 }

 public String getIdKonten() {
  return idKonten;
 }

 public String getJudul() {
  return judul;
 }

 public String getDeskripsi() {
  return deskripsi;
 }

 public abstract void tampilkan();
}
