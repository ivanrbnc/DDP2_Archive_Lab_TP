public class Pasien extends Warga {
	// TODO: Ubah modifier atribut pada class Pasien agar code menjadi lebih aman
	private int happiness;
	private String penyakit;
	private boolean pasienSembuh;

	// TODO: Lengkapi constructor
	public Pasien(String nama, String penyakit) {
		super(nama);
		this.penyakit = penyakit;
	}

	// TODO: Lengkapi method berinteraksi untuk pasien
	@Override
	public void berinteraksi(Warga X) {

		// Membedakan ketika pasien berinteraksi dengan dokter dan pasien
		if (X instanceof Dokter) {

			// Melakukan downcasting agar dapat menggunakan method khusus dokter
			Dokter xSebagaiDokter = (Dokter) X;

			// Penyembuhan pasien
			if (this.getPenyakit().equalsIgnoreCase(xSebagaiDokter.getPenyakitKeahlian()) 
					&& this.pasienSembuh == false) {
				this.pasienSembuh = true;
				this.happiness += 20;
				this.maxMinHappiness();
			} 
			
			// Dokter yang ditemui ramah atau tidak
			if (xSebagaiDokter.getDokterRamah() == true) {
				this.happiness += 10;
				this.maxMinHappiness();
			} else {
				this.happiness -= 5;
				this.maxMinHappiness();
			}
		} else if (X instanceof Pasien) {
			this.happiness += 5;
			this.maxMinHappiness();
		}

		// Penambahan log interaksi
		this.addLogInteraksi(X);
	}

	// Method yang memastikan happiness memiliki range 0 - 100
	public void maxMinHappiness() {
		if (this.happiness > 100) {
			this.happiness = 100;
		} else if (this.happiness < 0) {
			this.happiness = 0;
		}
	}

	// TODO: Lengkapi toString dengan memanggil method toString milik superclass
	@Override
	public String toString() {
		return super.toString();
	}

	public int getHappiness() {
		return this.happiness;
	}

	public boolean getStatusSembuh() {
		return this.pasienSembuh;
	}

	public String getPenyakit() {
		return this.penyakit;
	}

	public void setStatusSembuh(boolean statusBaru) {
		this.pasienSembuh = statusBaru;
	}

	public void setHappiness(int happinessBaru) {
		this.happiness = happinessBaru;
	}
}
