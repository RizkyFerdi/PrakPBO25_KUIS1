package helpers;

import java.util.Scanner;

public class InputHelper {
 private static final Scanner scanner = new Scanner(System.in);

 public static String inputString(String pesan) {
  System.out.print(pesan);
  return scanner.nextLine();
 }

 public static int inputInt(String pesan) {
  System.out.print(pesan);
  while (!scanner.hasNextInt()) {
   System.out.println("Harap masukkan angka.");
   scanner.next();
   System.out.print(pesan);
  }
  int nilai = scanner.nextInt();
  scanner.nextLine();
  return nilai;
 }
}
