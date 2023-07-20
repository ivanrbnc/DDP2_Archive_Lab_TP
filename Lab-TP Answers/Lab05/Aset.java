
public class Aset {
	// TODO lengkapi visibility modifier atribut dan methods berikut
	protected String nama;
	protected int jumlah;
	protected double harga;
	protected int tahun = 0;
	
	public Aset(String nama, int jumlah, double harga) {
		// TODO lengkapi constructor ini
		this.nama = nama;
		this.jumlah = jumlah;
		this.harga = harga;
	}
	
	// Increment tahun
	public void nextYear() {
		this.tahun += 1;
	}

	// TODO buat getter dan setter untuk fields pada class ini
	public String getName() {
		return this.nama;
	}

	public int getAmount() {
		return this.jumlah;
	}

	public double getPrice() {
		return this.harga;
	}

	public void setPrice(double newPrice) {
		this.harga = newPrice;
	}

	public int getYear() {
		return this.tahun;
	}
}
