package models;

public class Pembayaran {
 private Peserta peserta;
 private Kursus kursus;
 private boolean statusLunas;

 public Pembayaran(Peserta peserta, Kursus kursus) {
  this.peserta = peserta;
  this.kursus = kursus;
  this.statusLunas = false;
 }

 public void bayar() {
  this.statusLunas = true;
 }

 public boolean isLunas() {
  return statusLunas;
 }
}
