import konten.Konten;

import java.util.ArrayList;
import java.util.List;

public class Kursus {
 private String idKursus;
 private String namaKursus;
 private String deskripsi;
 private double harga;
 private Instruktur instruktur;
 private List<Konten> daftarKonten = new ArrayList<>();

 public Kursus(String id, String nama, String deskripsi, double harga, Instruktur instruktur) {
  this.idKursus = id;
  this.namaKursus = nama;
  this.deskripsi = deskripsi;
  this.harga = harga;
  this.instruktur = instruktur;
 }

 public String getIdKursus() {
  return idKursus;
 }

 public String getNamaKursus() {
  return namaKursus;
 }

 public double getHarga() {
  return harga;
 }

 public Instruktur getInstruktur() {
  return instruktur;
 }

 public void tambahKonten(Konten k) {
  daftarKonten.add(k);
 }

 public List<Konten> getDaftarKonten() {
  return daftarKonten;
 }

 public void tampilkanKonten() {
  int i = 1;
  for (Konten k : daftarKonten) {
   System.out.print(i++ + ". ");
   k.tampilkan();
  }
 }
}
