import java.util.Scanner;

public class Pacilnomo {
	private static Aset[] portofolio;
	private static double earnings;

	private static void printSeparator() {
		System.out.println("=".repeat(64));
	}
	
	private static void daftarAset() {
		printSeparator();
		System.out.printf("Kamu memiliki %d total aset:\n", portofolio.length);
		for(Aset a : portofolio) {
			System.out.println("- " + a);
		}
		printSeparator();
	}

	private static void infoPortofolio() {
		int jumlahSaham = 0, jumlahObligasi = 0;
		double netWorth = 0;
	
		// TODO implementasikan perhitungan total valuasi aset, yaitu nilai semua aset dan pendapatan dari dividen dan bunga

		// Categorize each asset and update current networth
		for (Aset aset : portofolio) {
			if (aset instanceof Saham) {
				jumlahSaham += 1;
			} else {
				jumlahObligasi += 1;
			}
			
			// Main source of income
			netWorth += (aset.getPrice() * aset.getAmount());
		}

		// Add it's additional earning to the networth
		netWorth += earnings;

		printSeparator();
		System.out.printf("""
		Info Portofolio
		Jumlah Jenis Saham: %d
		Jumlah Jenis Obligasi: %d
		Total Nilai Portofolio: %.2f
		""", jumlahSaham, jumlahObligasi, netWorth);
		printSeparator();
	}

	private static void nextYear() {
		// TODO implementasikan pemanggilan nextYear untuk setiap aset pada portofolio
		
		// Update each asset year count
		for (Aset aset : portofolio) {
			aset.nextYear();
		}
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Silakan masukkan banyak aset yang tersedia: ");
		int banyakAset = Integer.parseInt(in.nextLine());
		
		portofolio = new Aset[banyakAset];
		
		for(int i = 0; i < banyakAset; i++) {
			System.out.printf("Aset %d: ", i + 1);
			String inp[] = in.nextLine().split("\\s+");
			String namaAset = inp[0], jenisAset = inp[1]; 
			int jumlah = Integer.valueOf(inp[2]); 
			double harga = Double.valueOf(inp[3]);
			
			if(jenisAset.equals("SAHAM")) {
				// TODO tambahkan aset saham ke portofolio berdasarkan input user

				// Catch user input
				double pertumbuhan = Double.valueOf(inp[4]);
				double dividen = Double.valueOf(inp[5]);

				// Create "share" object
				Saham newShare = new Saham(namaAset, jumlah, harga, pertumbuhan, dividen);

				// Add particular element to portofolio
				for (int j = 0; j < portofolio.length; j++) {
					if (portofolio[j] == null) {
						portofolio[j] = newShare;
						break;
					}
				}
				
			} else if(jenisAset.equals("OBLIGASI")) {
				// TODO tambahkan aset obligasi ke portofolio berdasarkan input user

				// Catch user input
				double bunga = Double.valueOf(inp[4]);
				int maturitas = Integer.valueOf(inp[5]);

				// Create "bond" object
				Obligasi newBond = new Obligasi(namaAset, jumlah, harga, bunga, maturitas);
				
				// Add particular element to portofolio
				for (int j = 0; j < portofolio.length; j++) {
					if (portofolio[j] == null) {
						portofolio[j] = newBond;
						break;
					}
				}
			} 
		}

		System.out.print("Selamat datang di...");
		System.out.print(""" 


							 /$$$$$$$                     /$$ /$$                                            
							| $$__  $$                   |__/| $$                                            
							| $$  \\ $$ /$$$$$$   /$$$$$$$ /$$| $$ /$$$$$$$   /$$$$$$  /$$$$$$/$$$$   /$$$$$$ 
							| $$$$$$$/|____  $$ /$$_____/| $$| $$| $$__  $$ /$$__  $$| $$_  $$_  $$ /$$__  $$
							| $$____/  /$$$$$$$| $$      | $$| $$| $$  \\ $$| $$  \\ $$| $$ \\ $$ \\ $$| $$  \\ $$
							| $$      /$$__  $$| $$      | $$| $$| $$  | $$| $$  | $$| $$ | $$ | $$| $$  | $$
							| $$     |  $$$$$$$|  $$$$$$$| $$| $$| $$  | $$|  $$$$$$/| $$ | $$ | $$|  $$$$$$/
							|__/      \\_______/ \\_______/|__/|__/|__/  |__/ \\______/ |__/ |__/ |__/ \\______/ 
																											
                                                                                 
                                                                                 """);
		
		while(true) {
			System.out.printf("""
				Silakan pilih salah satu opsi berikut:
				[1] Daftar aset
				[2] Info portofolio
				[3] Lanjut ke tahun berikutnya
				[*] Keluar\n""", earnings);
			printSeparator();
			System.out.print("Input: ");
			String pilihan = in.nextLine();
			if(pilihan.equals("1")) {
				daftarAset();
			} else if(pilihan.equals("2")) {
				infoPortofolio();
			} else if(pilihan.equals("3")) {
				nextYear();
				System.out.println("Setahun telah berlalu...");
				printSeparator();
			} else {
				System.out.println("Terima kasih telah menggunakan layanan Pacilnomo ~ !");
				break;
			}
		}
		
		in.close();
	}
	
	public static void addToEarnings(double jumlah) {
		earnings += jumlah;
	}
}
