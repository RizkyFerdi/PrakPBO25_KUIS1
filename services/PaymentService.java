package services;

import models.Pembayaran;

import java.util.ArrayList;
import java.util.List;

public class PaymentService {
 private static PaymentService instance;
 private List<Pembayaran> pembayaranList = new ArrayList<>();

 private PaymentService() {
 }

 public static PaymentService getInstance() {
  if (instance == null)
   instance = new PaymentService();
  return instance;
 }

 public void tambahPembayaran(Pembayaran pembayaran) {
  pembayaranList.add(pembayaran);
 }
}
