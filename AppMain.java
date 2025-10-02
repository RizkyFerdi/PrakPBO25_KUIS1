import menus.InstrukturMenu;
import menus.PesertaMenu;
import helpers.InputHelper;

public class AppMain {
  public static void main(String[] args) {
    InstrukturMenu instrukturMenu = new InstrukturMenu();
    PesertaMenu pesertaMenu = new PesertaMenu();

    boolean jalan = true;
    while (jalan) {
      System.out.println("\n=== MENU UTAMA ===");
      System.out.println("1. Login Instruktur");
      System.out.println("2. Login Peserta");
      System.out.println("3. Register Peserta");
      System.out.println("0. Keluar");

      String pilihan = InputHelper.inputString("Pilih: ");

      switch (pilihan) {
        case "1":
          instrukturMenu.tampilkan();
          break;
        case "2":
          pesertaMenu.tampilkan();
          break;
        case "3":
          pesertaMenu.register();
          break;
        case "0":
          jalan = false;
          break;
        default:
          System.out.println("Pilihan tidak valid.");
      }
    }
  }
}
