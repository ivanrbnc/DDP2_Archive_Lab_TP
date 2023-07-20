abstract class Mobil {
    private String nama;
    private int persenFuel;
    private String bahanBakar;
    private String jenis;
    private EngineBehaviour engineBehaviour;
    private boolean isOn;

    protected Mobil (String nama, EngineBehaviour engineBehaviour, String bahanBakar, String jenis){
        // TODO: Lengkapi constructor berikut
        this.nama = nama;
        this.engineBehaviour = engineBehaviour;
        this.bahanBakar = bahanBakar;
        this.jenis = jenis;
        this.persenFuel = 100;
    }

    // TODO: Lengkapi method ini
    public String start(){

        // Menyalakan mobil serta mengembalikan string sesuai Engine Behavior yang dimilikinya
        this.isOn = true;
        return engineBehaviour.start(this);
    }

    // TODO: Lengkapi method ini
    public String gas(){

        // Mengecek apakah mesin belum dinyalakan
        if (this.isOn == false) {
            return "Nyalakan mobil dulu!";
        // Memeriksa isi bensin
        } else if (persenFuel <= 0) {
            return "Bensin habis!";
        // Mesin sudah dinyalakan dan bensin sudah terisi, maka mobil dapat digas
        } else {
            this.persenFuel = engineBehaviour.gas(this.persenFuel); // Pengurangan fuel

            // Pemilihan tempat gas sesuai jenis mobil
            String tempatGas;
            if (this.jenis.equals("Air")) {
                tempatGas = "Laut";
            } else if (this.jenis.equals("Terbang")) {
                tempatGas = "Langit";
            } else {
                tempatGas = "Jalan Raya";
            }

            // Menyesuaikan keluaran sesuai kebutuhan
            return String.format("%s digas dengan cepat di %s! Bahan bakar mobil %s sekarang %d%%.", 
                                    this.nama, tempatGas, this.bahanBakar, this.persenFuel);
        }
    }
  
    // TODO: Lengkapi method ini
    public String stop(){

        // Mematikan mobil serta mengembalikan string sesuai Engine Behavior yang dimilikinya
        this.isOn = false;
        return engineBehaviour.stop(this);
    }
  
    public abstract String isiBahanBakar();
    public abstract String[] simulasi();

    // Getter & Setter
    public String getNama() {
        return nama; 
    }

    public int getPersenFuel() {
        return persenFuel; 
    }

    public void setPersenFuel(int persenFuel) {
        this.persenFuel = persenFuel;
    }

    public String getBahanBakar() {
        return bahanBakar; 
    }
  
    public boolean getIsOn() {
        return isOn; 
    }

}