package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Peserta {
 private String id;
 private String username;
 private String pin;
 private List<Kursus> kursusDiikuti = new ArrayList<>();
 private Map<Kursus, Integer> skorKuis = new HashMap<>();

 public Peserta(String id, String username, String pin) {
  this.id = id;
  this.username = username;
  this.pin = pin;
 }

 public String getId() {
  return id;
 }

 public String getUsername() {
  return username;
 }

 public String getPin() {
  return pin;
 }

 public List<Kursus> getKursusDiikuti() {
  return kursusDiikuti;
 }

 public void ikutiKursus(Kursus kursus) {
  kursusDiikuti.add(kursus);
 }

 public void simpanSkorKuis(Kursus kursus, int skor) {
  skorKuis.put(kursus, skor);
 }

 public Integer getSkorKuis(Kursus kursus) {
  return skorKuis.get(kursus);
 }

}
