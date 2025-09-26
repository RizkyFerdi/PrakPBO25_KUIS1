
public class Instruktur {
 private String idInstruktur;
 private String nama;
 private String keahlian;

 public Instruktur(String id, String nama, String keahlian) {
  this.idInstruktur = id;
  this.nama = nama;
  this.keahlian = keahlian;
 }

 public String getIdInstruktur() {
  return idInstruktur;
 }

 public String getNama() {
  return nama;
 }
}
