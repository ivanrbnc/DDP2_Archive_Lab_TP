public class Barang {
  
    //TODO: Tambahkan modifier
    private String nama;
    private int harga;
    private int beratBarang;
    private int stock;

    //TODO: Buat Constructor
    public Barang(String nama, int harga, int beratBarang, int stock) {
        this.nama = nama;
        this.harga = harga;
        this.beratBarang = beratBarang;
        this.stock = stock;
    }
      
    //TODO: Silakan cek stock
    public boolean cekStock(int stock){
        // False jika stok permintaan melebihi stok barang. Begitu pun sebaliknya.
        if (this.stock < stock) {
            return false;
        } else {
            return true;
        }
    }
    
    public String getNama() {
        return this.nama;
    }
    
    public int getStock(){
        return this.stock;
    }
  
    public void setStock(int kuantitas){
        this.stock = kuantitas;
    }
    
    public int getBeratBarang(){
        return this.beratBarang;
    }

    public int getHarga(){
        return this.harga;
    }   
}