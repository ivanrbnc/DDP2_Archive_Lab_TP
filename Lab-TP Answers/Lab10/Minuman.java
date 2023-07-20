// Ikuti UML diagram

public class Minuman extends Pesanan {
    // TODO: tambahkan attributes
    private boolean isPakeEs;

    public Minuman(String nama, int harga, int prioritas, boolean isPakeEs) {
        // TODO: Lengkapi Constructor berikut
        super(nama, harga, prioritas);
        this.isPakeEs = isPakeEs;
    }

    @Override
    public String toString() {
        // TODO: return deskripsi sesuai dengan ketentuan soal
        return (isPakeEs ? this.getNama() + " dingin" : this.getNama() + " hangat");
    }

    // Tambahkan getter-setter bila diperlukan
}
