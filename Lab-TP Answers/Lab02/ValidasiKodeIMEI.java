import java.util.Scanner;

public class ValidasiKodeIMEI {
    public static void main(String[] args) {
        Scanner object = new Scanner(System.in);
        int looping = object.nextInt();

        object.nextLine(); // Scanner bug
        
        // Melakukan pendataan sebanyak variabel looping yang diberikan
        while (looping-- > 0) {
            String code = object.nextLine();
            // Memvalidasi panjang serta prefix yang dimiliki suatu kode lalu melakukan checking terhadap kode
            if (code.length() == 11 && (code.charAt(0) == '2' || (code.charAt(0) == '1' && code.charAt(1) == '8'))) {
                System.out.println(checking(1, code, 0, 0));
            } else {
                System.out.println("NO");
            }
        }
        object.close();
    }

    // Method yang akan membaca digit pertama dan mengolahnya secara terus-menerus
    public static Object checking(int i, String str, int sumOdd, int sumEven) {
        // Penangkapan digit pertama dari suatu kode
        int valueFirstDigit = Character.getNumericValue(str.charAt(0));

        // Memastikan rekursi bisa berhenti sekaligus memberikan output yang diinginkan
        if (i == 0 && str.equals("done")) {
            int sumTotal = sumOdd + sumEven;
            return (sumTotal % 10 == 0 ? "YES" : "NO");
        }

        // Pembagian kelompok antara ganjil dan genap sesuai nilai dari variabel i
        if (i % 2 == 1) { // Kelompok ganjil
            int multipliedValue = valueFirstDigit * 2;
            // Pengecekan banyaknya digit setelah dikalikan 2
            if (multipliedValue > 9){ // 2 digit
                // Melakukan pengubahan integer menjadi string agar bisa di-slice lalu jumlahkan keduanya
                String multipliedString = Integer.toString(multipliedValue);
                sumOdd += (Character.getNumericValue(multipliedString.charAt(0)) + Character.getNumericValue(multipliedString.charAt(1)));
            } else { // 1 digit
                sumOdd += multipliedValue;
            }

        } else { // Kelompok genap
            sumEven += valueFirstDigit;
        }

        /* Pemastian bahwa panjang parameter str masih lebih dari 1
        Jika belum <= 1, lakukan rekursi sembari memotong digit pertama dari kode */
        if (str.length() > 1) {
            return checking(i += 1, str.substring(1, str.length()), sumOdd, sumEven);
        } else {
            return checking(0, "done", sumOdd, sumEven);
        }
    }
}