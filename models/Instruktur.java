package models;

public class Instruktur {
 private String idInstruktur;
 private String Name;
 private String pin;
 private String bidangKeahlian;

 public Instruktur(String idInstruktur, String Name, String pin, String bidangKeahlian) {
  this.idInstruktur = idInstruktur;
  this.Name = Name;
  this.pin = pin;
  this.bidangKeahlian = bidangKeahlian;
 }

 public String getIdInstruktur() {
  return idInstruktur;
 }

 public String getName() {
  return Name;
 }

 public String getPin() {
  return pin;
 }

 public String getBidangKeahlian() {
  return bidangKeahlian;
 }
}
