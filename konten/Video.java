package konten;

public class Video extends Konten {
 private int durasi;

 public Video(String id, String judul, String deskripsi, int durasi) {
  super(id, judul, deskripsi);
  this.durasi = durasi;
 }

 @Override
 public void tampilkanKonten() {
  System.out.println("[Video] " + getJudul() + " (" + durasi + " menit)");
 }
}
