
public class Saham extends Aset {
	// TODO lengkapi visibility modifier atribut dan methods berikut
	private double dividen;
	private double pertumbuhan;
	
	public Saham(String nama, int jumlah, double harga, double pertumbuhan, double dividen) {
		super(nama, jumlah, harga);
		this.pertumbuhan = pertumbuhan;
		this.dividen = dividen;
	}

	@Override
	public void nextYear() {
		super.nextYear();
		grow();

		// TODO modifikasi harga sesuai dengan pertumbuhan sekarang dan tambahkan dividen ke earnings
		double priceChange = this.getPrice() * this.pertumbuhan;
		this.setPrice(this.getPrice() + priceChange);

		double amountOfEarningEachYear = dividen * this.getPrice() * this.getAmount();

		Pacilnomo.addToEarnings(amountOfEarningEachYear);		
	}

	// Linear congruential generator for subsequent growth
	private void grow() {
		int a = 0x4b;
		int c = 0x4a;
		int m = 2;
		pertumbuhan = ((a * pertumbuhan + c) % m) - 1;
		pertumbuhan = pertumbuhan < 0 ? pertumbuhan % -m : pertumbuhan;
	}

	// TODO lengkapi method toString ini
	@Override
	public String toString() {
		return String.format("%s \nTipe: Saham\nHarga: %.2f\nJumlah: %d\nDividen: %.2f\nPertumbuhan: %.2f", 
							this.getName(), this.getPrice(), this.getAmount(), this.dividen, this.pertumbuhan);
	}

	// TODO buat getter dan setter untuk fields pada class ini
	public double getDividend() {
		return this.dividen;
	}

	public double getGrowth() {
		return this.pertumbuhan;
	}
}