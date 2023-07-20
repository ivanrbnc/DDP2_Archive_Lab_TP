import java.util.Scanner; // Memberikan izin untuk scan/input user

public class KalkulatorBMI {

    // Method yang mengkalkulasikan BMI melalui metric
    public static double metricCalculating(double mass, double tall) {
        double metricValue = mass / Math.pow(tall * 0.01, 2); // Dikalikan 0.01 karena perubahan cm ke m
        return metricValue;
    }

    // Method yang mengkalkulasikan BMI melalui imperial
    public static double imperialCalculating(double mass, double tall) {
        double imperialValue = 703 * mass / Math.pow(tall, 2); 
        return imperialValue;
    }

    public static void main(String[] args) {
        Scanner object = new Scanner(System.in); // Object sebagai nama penangkap
        
        System.out.println("Selamat datang di program kalkulator BMI!");
        System.out.println("--------------------------------------------------------");

        System.out.print("Masukkan jumlah mahasiswa yang akan dihitung datanya: ");
        int loop = object.nextInt(); // Menangkap seberapa banyak mahasiswa yang akan diukur

        // Data kosong untuk diisi terkait pengukuran BMI
        int belowAverage = 0;
        int average = 0;
        int aboveAverage = 0;
        int obesity = 0;

        for (int i = 0; i < loop; i++) {
            // Mengosongkan scanner karena sebelumnya nextInt() dan setelahnya menggunakan nextLine()
            object.nextLine();

            // Mendapatkan data-data yang diperlukan tiap mahasiswa
            System.out.printf("--------------------DATA MAHASISWA %d--------------------%n", i+1);
            System.out.print("Standar pengukuran apakah yang digunakan? ");
            String evalType = object.nextLine();
            System.out.print("Masukkan massa tubuh mahasiswa (pon): ");
            float weight = object.nextFloat();
            System.out.print("Masukkan tinggi tubuh mahasiswa (inci): ");
            float height = object.nextFloat();
            
            // Asumsikan nilai bmi = 0 sebelum pengukuran tiap mahasiswa
            double bmi = 0;

            // Menyocokkan rumus yang digunakan dengan standar yang dipilih
            switch (evalType) {
                case "METRIK":
                    bmi = metricCalculating(weight, height); // Menarik method metric untuk perhitungan
                    break;
            
                case "IMPERIAL":
                    bmi = imperialCalculating(weight, height); // Menarik method imperial untuk perhitungan
                    break;
            }

            // Mengelompokkan mahasiswa sesuai kelas bmi yang diperolehnya
            if (bmi < 18.5){
                belowAverage += 1;
            } else if (bmi >= 18.5 && bmi < 25.0) {
                average += 1;
            } else if (bmi >= 25.0 && bmi < 30.0) {
                aboveAverage += 1;
            } else {
                obesity += 1;
            }

        }

        // Menunjukkan ringkasan penuh dari keseluruhan mahasiswa
        System.out.println("---------------------RINGKASAN DATA---------------------");
        System.out.printf("Berikut merupakan ringkasan hasil pengukuran BMI dari %d mahasiswa.%n", loop);
        System.out.printf("Jumlah mahasiswa dengan berat badan di bawah normal: %d%n", belowAverage);
        System.out.printf("Jumlah mahasiswa dengan berat badan normal: %d%n", average);
        System.out.printf("Jumlah mahasiswa dengan berat badan di atas normal: %d%n", aboveAverage);
        System.out.printf("Jumlah mahasiswa obesitas: %d%n", obesity);
        System.out.println("--------------------------------------------------------");
        System.out.println("Terima kasih telah menggunakan program kalkulator BMI!");

        // Menutup scanner agar tidak menyala terus menerus
        object.close();
    }
}