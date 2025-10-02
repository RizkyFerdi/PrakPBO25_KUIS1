package services;

import models.Kursus;

import java.util.ArrayList;
import java.util.List;

public class CourseService {
 private static CourseService instance;
 private List<Kursus> kursusList = new ArrayList<>();

 private CourseService() {
 }

 public static CourseService getInstance() {
  if (instance == null)
   instance = new CourseService();
  return instance;
 }

 public void tambahKursus(Kursus kursus) {
  kursusList.add(kursus);
  System.out.println("Kursus " + kursus.getNamaKursus() + " berhasil ditambahkan!");
 }

 public void tampilkanSemuaKursus() {
  for (Kursus k : kursusList) {
   System.out.println(k);
  }
 }

 public Kursus cariKursusById(String id) {
  return kursusList.stream().filter(k -> k.getIdKursus().equalsIgnoreCase(id)).findFirst().orElse(null);
 }
}
