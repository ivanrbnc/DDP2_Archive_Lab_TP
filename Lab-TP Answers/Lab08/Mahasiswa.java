public class Mahasiswa {
    private static int MINIMUM_TINGKAT_KESEHATAN = 70;
    private String nama;
    private int tingkatKesehatan;

    public Mahasiswa(String nama, int tingkatKesehatan) {
        this.nama = nama;
        this.tingkatKesehatan = tingkatKesehatan;
    }

    public String getStatus() {
        // TODO: Implementasi method untuk mencetak status tingkat kesehatan mahasiswa

        // Melakukan pengecekan minimum tingkat kesehatan tiap mahasiswa
        if (tingkatKesehatan < MINIMUM_TINGKAT_KESEHATAN) {
            return "Tidak layak mengikuti program";
        } else {
            return "Layak mengikuti program";
        }
    }

    public int getTingkatKesehatan() {
        return this.tingkatKesehatan;
    }

    public String getNama() {
        return this.nama;
    }

    // Untuk mencetak sebagai output di file
    @Override
    public String toString() {
        return String.format("%-24s| %s\n", this.nama, this.getStatus());
    }
}
