// Ikuti UML Diagram

public class Makanan extends Pesanan {
    // TODO: tambahkan attributes
    private int tingkatKepedasan;

    public Makanan(String nama, int harga, int prioritas, int tingkatKepedasan) {
        // TODO: Lengkapi Constructor berikut
        super(nama, harga, prioritas);
        this.tingkatKepedasan = tingkatKepedasan;
    }

    @Override
    public String toString() {
        // TODO: return deskripsi sesuai dengan ketentuan soal
        return this.getNama() + " level " + this.tingkatKepedasan;
    }

    // Tambahkan getter-setter apabila diperlukan
}
