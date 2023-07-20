public class MobilTerbang extends Mobil{ //TODO: impelementasikan sesuai UML diagram
    
    public MobilTerbang(String nama, EngineBehaviour engineBehaviour, String bahanBakar) {
        // TODO: Lengkapi Constructor berikut
        super(nama, engineBehaviour, bahanBakar, "Terbang");
    }

    // TODO: Lengkapi method ini
    @Override
    public String isiBahanBakar(){

        // Pengecekan mesin menyala saat mengisi bahan bakar
        if (this.getIsOn() == true) {
            return "Mobil masih terbang, matikan terlebih dahulu agar tidak jatuh.";
        } else {
            this.setPersenFuel(100);
            return String.format("%s sekarang sudah penuh, mobil dapat terbang kembali!", 
                                    this.getBahanBakar());
        }
    }

    // TODO: Lengkapi method ini
    @Override
    public String[] simulasi(){

        // Pembuatan array dan mengisinya sesuai simulasi yang diinginkan
        String[] temp = new String[5];
        temp[0] = this.start();

        for (int i = 1; i < 3; i++) {
            temp[i] = this.gas();
        }
        
        temp[3] = this.stop();
        temp[4] = this.isiBahanBakar();
        
        return temp;
    }
  
}