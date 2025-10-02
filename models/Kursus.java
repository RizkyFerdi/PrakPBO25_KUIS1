package models;

import konten.Konten;
import java.util.ArrayList;
import java.util.List;

public class Kursus {
 private String idKursus;
 private String namaKursus;
 private String deskripsi;
 private int harga;
 private Instruktur instruktur;
 private List<Konten> daftarKonten = new ArrayList<>();

 public Kursus(String idKursus, String namaKursus, String deskripsi, int harga, Instruktur instruktur) {
  this.idKursus = idKursus;
  this.namaKursus = namaKursus;
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

 public String getDeskripsi() {
  return deskripsi;
 }

 public Instruktur getInstruktur() {
  return instruktur;
 }

 public List<Konten> getDaftarKonten() {
  return daftarKonten;
 }

 public int getHarga() {
  return harga;
 }

 public void tambahKonten(Konten konten) {
  daftarKonten.add(konten);
  System.out.println("Konten ditambahkan: " + konten.getJudul());
 }

 @Override
 public String toString() {
  return idKursus + " - " + namaKursus + " (Rp" + harga + ")";
 }
}
