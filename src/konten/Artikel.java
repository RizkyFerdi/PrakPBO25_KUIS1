package konten;

public class Artikel extends Konten {
 private int panjangKata;

 public Artikel(String id, String judul, String deskripsi, int panjang) {
  super(id, judul, deskripsi);
  this.panjangKata = panjang;
 }

 @Override
 public void tampilkan() {
  System.out.println("[Artikel] " + getJudul() + " (" + panjangKata + " kata)");
 }
}
