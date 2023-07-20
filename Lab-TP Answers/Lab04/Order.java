public class Order {
    private Barang barang;
    private int banyakBarang;

    public Order(Barang barang, int banyakBarang) {
        this.barang = barang;
        this.banyakBarang = banyakBarang;
    }

    public Barang getBarang() {
        return this.barang;
    }

    public int getBanyakBarang(){
        return this.banyakBarang;
    }

    public void setBarang(Barang barang) {
        this.barang = barang;
    }

    public void setBanyakBarang(int banyakBarang){
        this.banyakBarang = banyakBarang;
    }
}