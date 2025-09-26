package konten;

public class Video extends Konten {
 private int durasiMenit;

 public Video(String id, String judul, String deskripsi, int durasi) {
  super(id, judul, deskripsi);
  this.durasiMenit = durasi;
 }

 @Override
 public void tampilkan() {
  System.out.println("[Video] " + getJudul() + " (" + durasiMenit + " menit)");
 }
}
