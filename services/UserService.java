package services;

import models.Instruktur;
import models.Peserta;

import java.util.HashMap;
import java.util.Map;

public class UserService {
  private static UserService instance;
  private Map<String, Instruktur> instrukturMap = new HashMap<>();
  private Map<String, Peserta> pesertaMap = new HashMap<>();

  private UserService() {
    instrukturMap.put("i1", new Instruktur("i1", "Budi", "1111", "pemrograman"));
    pesertaMap.put("p1", new Peserta("p1", "rizky", "4321"));//hardcose peserta
  }

  public static UserService getInstance() {
    if (instance == null)
      instance = new UserService();
    return instance;
  }

  public Instruktur loginInstruktur(String username, String pin) {
    return instrukturMap.values().stream()
        .filter(i -> i.getName().equalsIgnoreCase(username) && i.getPin().equalsIgnoreCase(pin))
        .findFirst()
        .orElse(null);
  }

  public Peserta loginPeserta(String username, String pin) {
    return pesertaMap.values().stream()
        .filter(p -> p.getUsername().equalsIgnoreCase(username) && p.getPin().equalsIgnoreCase(pin))
        .findFirst()
        .orElse(null);
  }

  public void registerPeserta(String id, String username, String pin) {
    if (pesertaMap.containsKey(id)) {
      System.out.println("ID peserta sudah terdaftar!");
      return;
    }
    Peserta peserta = new Peserta(id, username, pin);
    pesertaMap.put(id, peserta);
  }
}
