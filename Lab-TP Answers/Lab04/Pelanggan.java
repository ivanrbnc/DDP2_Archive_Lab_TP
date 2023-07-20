public class Pelanggan {
    
    //TODO: Tambahkan modifier
    private String nama;
    private int uang;
    private Order[] keranjang;
    private int banyakOrder = 0;
    private int kapasitasKeranjang = 5000;

    //TODO: Buat Constructor
    public Pelanggan(String nama, int uang, int kapasitas) {
        this.nama = nama;
        this.uang = uang;
        this.keranjang = new Order[kapasitas];
    }
    
    // TODO: lengkapi method di bawah ini
    public String addBarang(Barang barang, int banyakBarang){

        String namaBarang = barang.getNama();

        // Mengecek stock barang
        if (barang.cekStock(banyakBarang) == false) {
            return String.format("Stock %s kurang\n", barang.getNama());
        } 

        // Mengecek kapasitas keranjang
        if (barang.getBeratBarang() * banyakBarang > this.kapasitasKeranjang) {
            int maksimumBanyakBarang = this.kapasitasKeranjang / barang.getBeratBarang();
  
            // Asumsi saat barang yang ingin dimasukkan adalah 0, berarti sama saja tidak dimasukkan ke keranjang
            if (maksimumBanyakBarang == 0) {
                return String.format("Maaf %d %s terlalu berat, tetapi %d %s berhasil ditambahkan.\n", banyakBarang, namaBarang, maksimumBanyakBarang, namaBarang);
            }

            // Membuat order yang banyaknya sudah dikecilkan
            Order orderSekarang = new Order(barang, maksimumBanyakBarang);

            // Memasukkan order ke dalam keranjang
            masukkanOrder(orderSekarang, maksimumBanyakBarang);

            return String.format("Maaf %d %s terlalu berat, tetapi %d %s berhasil ditambahkan.\n", banyakBarang, namaBarang, maksimumBanyakBarang, namaBarang);

        } else {
            // Membuat order yang banyaknya sesuai
            Order orderSekarang = new Order(barang, banyakBarang);

            // Memasukkan order ke dalam keranjang
            masukkanOrder(orderSekarang, banyakBarang);

            return String.format("%s berhasil menambahkan %d %s\n", this.nama, banyakBarang, namaBarang);
        }
    }

    // Method baru dimana akan memasukkan order ke dalam keranjang
    // banyakBarang digunakan untuk barang lama yang sudah ada
    private void masukkanOrder(Order orderSekarang, int banyakBarang) { 

        // Counter untuk pengecekan apakah barang sudah ada di dalam keranjang
        int pointer = 0;
        int counterOrderBaru = 0;

        // Menurunkan kapasitas keranjang dan stok barang
        this.kapasitasKeranjang -= (orderSekarang.getBarang().getBeratBarang() * banyakBarang);
        orderSekarang.getBarang().setStock(orderSekarang.getBarang().getStock() - banyakBarang);

        // Mengecek apakah terdapat order yang sama di keranjang
        for (Order orderDiDalam : keranjang) {
            try {
                if ((orderDiDalam.getBarang().getNama()).equals(orderSekarang.getBarang().getNama())) {
                    orderSekarang.setBanyakBarang(orderSekarang.getBanyakBarang() + banyakBarang);
                }
            } catch (NullPointerException e) {
                counterOrderBaru += 1;
                break;
            }
        }

        // Karena sudah dipastikan order baru, bisa langsung memasukkan pada keranjang
        if (counterOrderBaru == 1) {
            for (Order orderDiDalam : keranjang) {
                if (orderDiDalam == null) {
                    keranjang[pointer] = orderSekarang;
                    banyakOrder += 1;
                    break;
                }
                pointer += 1;
            } 
        }               
    }

    // TODO: lengkapi method di bawah ini
    public int totalHargaBarang(){
        // Menetapkan total harga default = 0
        int totalHarga = 0;

        // Ketika order minimal 1, maka akan mengecek keranjang
        if (banyakOrder != 0) {

            // Mengalkulasikan total. Saat bertemu elemen null, akan dihentikan
            for (Order orderDiDalam : keranjang) {
                try {
                    int banyakOrder = orderDiDalam.getBanyakBarang();
                    int hargaPerBarang = orderDiDalam.getBarang().getHarga();
                    totalHarga += (banyakOrder * hargaPerBarang);
                } catch (NullPointerException e) {
                    break;
                }
            }
        } 
        return totalHarga;
    }
    
    // TODO: lengkapi method di bawah ini
    public String cekUang(){
        return String.format("Uang %s sekarang %d\n", this.nama, this.uang);
    }

    // Setter and Getter dan lengkapi modifier
    public String getNama() {
        return this.nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getUang() {
        return this.uang;
    }

    public void setUang(int uang) {
        this.uang = uang;
    }

    public Order[] getKeranjang() {
        return this.keranjang;
    }

    public void setKeranjang(Order[] keranjangBaru) {
        this.keranjang = keranjangBaru;
    }

    
    // Menambahkan method getter & setter untuk banyakOrder
    public int getBanyakOrder() {
        return this.banyakOrder;
    }

    public void setBanyakOrder(int orderBaru) {
        this.banyakOrder = orderBaru;
        if (orderBaru == 0) { // berguna untuk mereset keranjang
            this.kapasitasKeranjang = 5000;
        }
    }
}