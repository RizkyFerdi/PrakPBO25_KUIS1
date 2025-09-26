package services;

import model.Kursus;
import model.Peserta;

import java.util.ArrayList;
import java.util.List;

public class CourseService {
 private List<Kursus> kursusList = new ArrayList<>();

 public void tambahKursus(Kursus k) {
  kursusList.add(k);
 }

 public List<Kursus> getSemuaKursus() {
  return kursusList;
 }

 public Kursus cariKursusById(String id) {
  for (Kursus k : kursusList) {
   if (k.getIdKursus().equals(id))
    return k;
  }
  return null;
 }

 public void pesertaSelesaiKonten(Peserta peserta, Kursus kursus) {
  peserta.tambahProgress(kursus);
  System.out.println("Progress peserta diperbarui.");
 }
}
