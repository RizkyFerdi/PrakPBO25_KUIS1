package services;

import model.Instruktur;
import model.Peserta;

import java.util.ArrayList;
import java.util.List;

public class UserService {
 private List<Peserta> pesertaList = new ArrayList<>();
 private List<Instruktur> instrukturList = new ArrayList<>();

 public void tambahPeserta(Peserta p) {
  pesertaList.add(p);
 }

 public void tambahInstruktur(Instruktur i) {
  instrukturList.add(i);
 }

 public Peserta cariPesertaById(String id) {
  for (Peserta p : pesertaList) {
   if (p.getIdPeserta().equals(id))
    return p;
  }
  return null;
 }

 public Instruktur cariInstrukturById(String id) {
  for (Instruktur i : instrukturList) {
   if (i.getIdInstruktur().equals(id))
    return i;
  }
  return null;
 }
}
