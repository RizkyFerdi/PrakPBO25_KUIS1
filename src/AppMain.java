import services.CourseService;
import services.PaymentService;
import services.UserService;
import konten.*;
import java.util.Arrays;
import java.util.Scanner;

public class AppMain {

    private static Peserta getPeserta(UserService userService, Scanner sc) {
        System.out.print("ID Peserta: ");
        String pid = sc.nextLine();
        Peserta peserta = userService.cariPesertaById(pid);
        if (peserta == null) {
            System.out.println("Peserta tidak ditemukan.");
        }
        return peserta;
    }

    private static Kursus getKursus(CourseService courseService, Scanner sc) {
        System.out.print("ID Kursus: ");
        String kid = sc.nextLine();
        Kursus kursus = courseService.cariKursusById(kid);
        if (kursus == null) {
            System.out.println("Kursus tidak ditemukan.");
        }
        return kursus;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UserService userService = new UserService();
        CourseService courseService = new CourseService();
        PaymentService paymentService = new PaymentService();

        // contoh data awal
        Instruktur ins1 = new Instruktur("I001", "Budi", "Java");
        userService.tambahInstruktur(ins1);

        Kursus kursus1 = new Kursus("K001", "Pemrograman OOP", "Belajar konsep OOP", 200000, ins1);
        courseService.tambahKursus(kursus1);

        // konten awal
        Video v = new Video("V001", "Intro OOP", "Pengenalan OOP", 12);
        Artikel art = new Artikel("A001", "Encapsulation", "Penjelasan enkapsulasi", 800);
        Kuis kuis = new Kuis("Q001", "Kuis Dasar OOP", "Uji pemahaman OOP");
        kuis.tambahSoal(new Soal("Apa itu enkapsulasi?",
                Arrays.asList("Menyembunyikan data", "Mewarisi kelas", "Polimorfisme", "Interface"), 0));
        kuis.tambahSoal(new Soal("Apa itu inheritance?",
                Arrays.asList("Pewarisan", "Polimorfisme", "Encapsulation", "Abstraction"), 0));

        kursus1.tambahKonten(v);
        kursus1.tambahKonten(art);
        kursus1.tambahKonten(kuis);

        System.out.println("=== EduTech App (Demo Dinamis) ===");

        boolean running = true;
        while (running) {
            System.out.println("\nMenu:");
            System.out.println("1. Daftar Peserta Baru");
            System.out.println("2. Tampilkan Semua Kursus");
            System.out.println("3. Daftar Kursus (Peserta)");
            System.out.println("4. Lakukan Pembayaran");
            System.out.println("5. Tampilkan Konten Kursus");
            System.out.println("6. Ikuti Konten");
            System.out.println("7. Ikuti Kuis");
            System.out.println("8. Terbitkan Sertifikat");
            System.out.println("9. Keluar");
            System.out.print("Pilih: ");
            String pilihan = sc.nextLine();

            switch (pilihan) {
                case "1":
                    System.out.print("ID Peserta: ");
                    String idP = sc.nextLine();
                    System.out.print("Nama: ");
                    String nama = sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.nextLine();
                    Peserta p = new Peserta(idP, nama, email);
                    userService.tambahPeserta(p);
                    System.out.println("Peserta dibuat: " + nama);
                    break;

                case "2":
                    for (Kursus k : courseService.getSemuaKursus()) {
                        System.out.println(k.getIdKursus() + " - " + k.getNamaKursus() + " | Rp" + k.getHarga()
                                + " | Instruktur: " + k.getInstruktur().getNama());
                    }
                    break;

                case "3":
                    Peserta peserta = getPeserta(userService, sc);
                    if (peserta == null)
                        break;
                    Kursus kurs = getKursus(courseService, sc);
                    if (kurs == null)
                        break;
                    peserta.daftarKursus(kurs);
                    break;

                case "4":
                    peserta = getPeserta(userService, sc);
                    if (peserta == null)
                        break;
                    kurs = getKursus(courseService, sc);
                    if (kurs == null)
                        break;
                    System.out.print("ID Pembayaran: ");
                    String pbid = sc.nextLine();
                    System.out.print("Metode (Transfer/COD): ");
                    String metode = sc.nextLine();
                    Pembayaran pb = paymentService.buatPembayaran(pbid, peserta, kurs, kurs.getHarga(), metode);
                    paymentService.konfirmasiPembayaran(pb);
                    break;

                case "5":
                    kurs = getKursus(courseService, sc);
                    if (kurs == null)
                        break;
                    kurs.tampilkanKonten();
                    break;

                case "6":
                    peserta = getPeserta(userService, sc);
                    if (peserta == null)
                        break;
                    kurs = getKursus(courseService, sc);
                    if (kurs == null)
                        break;
                    kurs.tampilkanKonten();
                    System.out.print("Pilih nomor konten yang sudah selesai: ");
                    int idx = Integer.parseInt(sc.nextLine()) - 1;
                    if (idx >= 0 && idx < kurs.getDaftarKonten().size()) {
                        courseService.pesertaSelesaiKonten(peserta, kurs);
                    } else {
                        System.out.println("Nomor konten tidak valid.");
                    }
                    break;

                case "7":
                    peserta = getPeserta(userService, sc);
                    if (peserta == null)
                        break;
                    kurs = getKursus(courseService, sc);
                    if (kurs == null)
                        break;
                    Kuis foundKuis = null;
                    for (Konten konten : kurs.getDaftarKonten()) {
                        if (konten instanceof Kuis) {
                            foundKuis = (Kuis) konten;
                            break;
                        }
                    }
                    if (foundKuis == null) {
                        System.out.println("Tidak ada kuis.");
                        break;
                    }
                    int skor = foundKuis.jalankanKuis(sc);
                    peserta.simpanSkorKuis(kurs, skor);
                    break;

                case "8":
                    peserta = getPeserta(userService, sc);
                    if (peserta == null)
                        break;
                    kurs = getKursus(courseService, sc);
                    if (kurs == null)
                        break;
                    double progress = peserta.getProgressPersen(kurs);
                    int skorKuis = peserta.getSkorKuis(kurs);
                    if (progress >= 80 && skorKuis >= 60) {
                        String sid = "S" + Math.round(Math.random() * 10000);
                        Sertifikat s = new Sertifikat(sid, peserta, kurs, skorKuis);
                        s.tampilkanSertifikat();
                    } else {
                        System.out.println(
                                "Belum memenuhi syarat sertifikat. Progress: " + progress + "%, Skor: " + skorKuis);
                    }
                    break;

                case "9":
                    running = false;
                    break;

                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
        sc.close();
        System.out.println("Terima kasih, program selesai.");
    }
}
