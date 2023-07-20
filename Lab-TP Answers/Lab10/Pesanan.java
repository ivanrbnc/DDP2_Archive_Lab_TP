public class Pesanan implements Comparable<Pesanan> {
    // TODO: tambahkan attributes
    private String nama;
    private int harga;
    private int prioritas;
    
    public Pesanan(String nama, int harga, int prioritas) {
        // TODO: Lengkapi Constructor berikut
        this.nama = nama;
        this.harga = harga;
        this.prioritas = prioritas;        
    }

    @Override
    public int compareTo(Pesanan o) {
        // TODO: Lengkapi method ini
        return this.prioritas - o.prioritas;
    }

    // Tambahkan getter-setter bila diperlukan
    public String getNama() {
        return this.nama;
    }

    public int getHarga() {
        return this.harga;
    }

    public int getPrioritas() {
        return this.prioritas;
    }
}