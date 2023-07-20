public class Dokter extends Warga {
	// TODO: Ubah modifier atribut pada class Dokter agar code menjadi lebih aman
	private int jumlahPasienDitemui;
	private String penyakitKeahlian;
	private boolean dokterRamah;
	
	// TODO: Lengkapi constructor
	public Dokter(String nama, String penyakitKeahlian, boolean ramah) {
		super(nama);
		this.penyakitKeahlian = penyakitKeahlian;
		this.dokterRamah = ramah;
	}

	// TODO: Lengkapi method berinteraksi untuk dokter
	@Override
	public void berinteraksi(Warga X){
		if (X instanceof Pasien) {
			// Pencatatan jumlah pasien yang telah ditemui
			this.jumlahPasienDitemui += 1;
		}

		// Penambahan log interaksi
		this.addLogInteraksi(X);
	}

	// TODO: Lengkapi toString dengan memanggil method toString milik superclass
	@Override
	public String toString() {
		return super.toString();
	}

	public int getJumlahPasienDitemui(){
		return this.jumlahPasienDitemui;
	}

	public String getPenyakitKeahlian(){
		return this.penyakitKeahlian;
	}

	public boolean getDokterRamah(){
		return this.dokterRamah;
	}

}
