package models;

import java.time.LocalDate;

public class Sertifikat {
 private String id;
 private LocalDate tanggalCetak;
 private Peserta peserta;
 private Kursus kursus;

 public Sertifikat(Peserta peserta, Kursus kursus) {
  this.id = "CERT-" + System.currentTimeMillis();
  this.peserta = peserta;
  this.kursus = kursus;
  this.tanggalCetak = LocalDate.now();
 }

 @Override
 public String toString() {
  return "\n=====================================\n" +
    "            SERTIFIKAT\n" +
    "=====================================\n" +
    "Nama Peserta : " + peserta.getUsername() + "\n" +
    "Kursus       : " + kursus.getNamaKursus() + "\n" +
    "Skor Kuis    : " + peserta.getSkorKuis(kursus) + "\n" +
    "Tanggal Cetak: " + tanggalCetak + "\n" +
    "ID Sertifikat: " + id + "\n" +
    "=====================================\n" +
    "   Selamat! Anda telah menyelesaikan\n" +
    "        kursus dengan sukses.\n" +
    "=====================================\n";
 }
}
