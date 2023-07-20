
public class Obligasi extends Aset {
	// TODO lengkapi visibility modifier atribut dan methods berikut
	private double bunga;
	private int maturitas;
	private boolean jatuhTempo = false;
	
	public Obligasi(String nama, int jumlah, double harga, double bunga, int maturitas) {
		// TODO lengkapi constructor ini
		super(nama, jumlah, harga);
		this.bunga = bunga;
		this.maturitas = maturitas;
	}
	
	@Override
	public void nextYear() {
		super.nextYear();
		
		// TODO validasi jatuh tempo
		// TODO tambahkan bunga ke total pendapatan Pacilnomo 

		if (this.jatuhTempo != true) {
			double amountOfEarningEachYear = this.bunga * this.getPrice() * this.getAmount();

			Pacilnomo.addToEarnings(amountOfEarningEachYear);	
		}

		// Matured
		if (super.getYear() > this.maturitas) {
			this.setDueDate(true);
		}
	}

	// TODO lengkapi method toString ini
	@Override
	public String toString() {
		return String.format("%s \nTipe: Obligasi\nHarga: %.2f\nJumlah: %d\nBunga: %.2f\nJatuh Tempo: %s", 
							this.getName(), this.getPrice(), this.getAmount(), this.bunga, this.jatuhTempo);
	}

	// TODO buat getter dan setter untuk fields pada class ini
	public double getInterest() {
		return this.bunga;
	}

	public int getMaturity() {
		return this.maturitas;
	}

	public boolean getDueDate() {
		return this.jatuhTempo;
	}

	public void setDueDate(boolean newDueDate) {
		this.jatuhTempo = newDueDate;
	}
}
