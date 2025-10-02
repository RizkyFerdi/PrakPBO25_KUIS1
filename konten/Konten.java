package konten;

public abstract class Konten {
 protected String id;
 protected String judul;
 protected String deskripsi;

 public Konten(String id, String judul, String deskripsi) {
  this.id = id;
  this.judul = judul;
  this.deskripsi = deskripsi;
 }

 public String getId() {
  return id;
 }

 public String getJudul() {
  return judul;
 }

 public String getDeskripsi() {
  return deskripsi;
 }

 public abstract void tampilkanKonten();

}
