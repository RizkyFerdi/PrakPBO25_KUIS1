package konten;

public class Artikel extends Konten {

 private String penulis;

 public Artikel(String id, String judul, String deskripsi, String penulis) {
  super(id, judul, deskripsi);
  this.penulis = penulis;
 }

 @Override
 public void tampilkanKonten(){
  System.out.println("[Artikel] " + getJudul() + " (" + penulis + ")");
 }
}
