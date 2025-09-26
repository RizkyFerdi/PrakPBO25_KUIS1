package services;

import .*;
import java.util.ArrayList;
import java.util.List;

public class PaymentService {
 private List<Pembayaran> daftarPembayaran = new ArrayList<>();

 public Pembayaran buatPembayaran(String id, Peserta peserta, Kursus kursus, double jumlah, String metode) {
  Pembayaran pb = new Pembayaran(id, peserta, kursus, jumlah, metode);
  daftarPembayaran.add(pb);
  return pb;
 }

 public void konfirmasiPembayaran(Pembayaran pb) {
  pb.konfirmasi();
  System.out.println("✅ Pembayaran sukses untuk kursus " + pb.getKursus().getNamaKursus());
 }

 // validasi akses
 public boolean sudahBayar(Peserta peserta, Kursus kursus) {
  for (Pembayaran pb : daftarPembayaran) {
   if (pb.getPeserta().equals(peserta) &&
     pb.getKursus().equals(kursus) &&
     "Sukses".equals(pb.getStatus())) {
    return true;
   }
  }
  return false;
 }
}
