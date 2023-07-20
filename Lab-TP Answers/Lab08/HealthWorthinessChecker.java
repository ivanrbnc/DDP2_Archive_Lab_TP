import java.io.*;
import java.util.*;

public class HealthWorthinessChecker {
    private static int MINIMUM_TINGKAT_KESEHATAN = 70;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Scanner inputFile = null;
        PrintWriter outputFile = null;
        int jumlahMahasiswa = 0;

        System.out.println("Selamat datang di program Health Worthiness Checker.");
        System.out.println("-------------------------------------------------------");

        System.out.print("Silakan masukkan nama file masukan: ");
        String inputFileName = in.next();
        System.out.print("Silakan masukkan nama file keluaran: ");
        String outputFileName = in.next();

        System.out.println("-------------------------------------------------------");

        in.close();

        try {
            inputFile = new Scanner(new File(inputFileName));
            System.out.println("Data sedang diproses, harap menunggu...");

            String line = inputFile.nextLine();

            jumlahMahasiswa = Integer.valueOf(line);
            // TODO: Implementasi inisiasi array penyimpanan data
            List<Mahasiswa> kumpulanMahasiswa = new ArrayList<Mahasiswa>();

            while (inputFile.hasNextLine()) {
                line = inputFile.nextLine();
                // TODO: Implementasi penyimpanan data mahasiswa ke array sesuai spesifikasi
                
                String tempNama = line; // tempNama untuk menangkap baris nama
                String tempNilai = inputFile.nextLine(); // tempNilai untuk menangkap baris derajat kesehatan
                
                tempNilai = tempNilai.replaceAll(" ", ""); // Menghilangkan spasi agar bisa dikalkulasikan

                int tingkatKesehatan = 0;

                // Melakukan loop dari tempNilai dan melakukan kalkulasi sesuai rumus
                for (int i = 0; i < tempNilai.length(); i++) {
                    tingkatKesehatan += Character.getNumericValue(tempNilai.charAt(i)) * 2;
                }

                // Mendata tiap mahasiswa, serta mengumpulkannya di dalam kumpulan mahasiswa
                Mahasiswa tempMahasiswa = new Mahasiswa(tempNama, tingkatKesehatan);
                kumpulanMahasiswa.add(tempMahasiswa);
            }

            // Proses data mahasiswa
            System.out.println("\nLOG:");
            for (int i = 0; i < jumlahMahasiswa; i++) {
                Mahasiswa tempMahasiswa = kumpulanMahasiswa.get(i);
                try {
                    // TODO: Implementasi pengecekan tingkat kesehatan mahasiswa
                    
                    // Melakukan pengecekan minimum tingkat kesehatan tiap mahasiswa
                    if (tempMahasiswa.getTingkatKesehatan() > MINIMUM_TINGKAT_KESEHATAN) {
                        System.out.printf("%s: %s\n", tempMahasiswa.getNama(), "LAYAK");
                    } else {
                        throw new HealthinessUnworthyException(); // Melempar error
                    }                  
                    
                } catch (HealthinessUnworthyException e) {
                    // TODO: Implementasi output ketika mahasiswa tidak memenuhi kelayakan
                    
                    System.out.printf("%s: %s\n", tempMahasiswa.getNama(), e.getMessage());
                }
            }

            // Output ke teks
            outputFile = new PrintWriter(new File(outputFileName));

            outputFile.write("Nama Mahasiswa          | Status\n");
            outputFile.write("-------------------------------------------------------\n");
            // TODO: Implementasi output data mahasiswa ke file output

            // Menuliskan toString tiap mahasiswa ke output
            for (Mahasiswa mahasiswa : kumpulanMahasiswa) {
                outputFile.write(mahasiswa.toString());
            }

            System.out.println("\nData mahasiswa berhasil diproses!");

        } catch (FileNotFoundException e) {
            // TODO: Implementasi output ketika file tidak ditemukan
            System.out.println("ERROR: File masukan tidak ditemukan.");
        } finally {
            if (inputFile != null) {
                inputFile.close();
            }
            if (outputFile != null) {
                outputFile.close();
            }
        }

        System.out.println("-------------------------------------------------------");
        System.out.println("Terima kasih telah menggunakan program Health Worthiness Checker.");
    }
}
