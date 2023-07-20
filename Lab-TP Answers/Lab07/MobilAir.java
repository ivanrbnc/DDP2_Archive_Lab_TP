public class MobilAir extends Mobil { //TODO: impelementasikan sesuai UML diagram
  
    public MobilAir(String nama, EngineBehaviour engineBehaviour, String bahanBakar){
        // TODO: Lengkapi constructor berikut
        super(nama, engineBehaviour, bahanBakar, "Air");
    }

    // TODO: Lengkapi method ini
    @Override
    public String isiBahanBakar(){

        // Pengecekan mesin menyala saat mengisi bahan bakar
        if (this.getIsOn() == true) {
            return "Mobil masih menyala, matikan terlebih dahulu agar tidak tenggelam.";
        } else {
            this.setPersenFuel(100);
            return String.format("%s sekarang sudah penuh, mobil dapat digunakan kembali!", 
                                    this.getBahanBakar());
        }
    }

    // TODO: Lengkapi method ini
    @Override
    public String[] simulasi(){

        // Pembuatan array dan mengisinya sesuai simulasi yang diinginkan
        String[] temp = new String[8];
        temp[0] = this.start();

        for (int i = 1; i < 6; i++) {
            temp[i] = this.gas();
        }

        temp[6] = this.stop();
        temp[7] = this.isiBahanBakar();
        
        return temp;
    }   
}