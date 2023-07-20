public class MobilTruk extends Mobil{ //TODO: impelementasikan sesuai UML diagram

    public MobilTruk(String nama, EngineBehaviour engineBehaviour, String bahanBakar) {
        // TODO: Lengkapi Constructor berikut
        super(nama, engineBehaviour, bahanBakar, "Truk");
    }

    // TODO: Lengkapi method ini
    @Override
    public String isiBahanBakar(){

        // Pengecekan mesin menyala saat mengisi bahan bakar
        if (this.getIsOn() == true) {
            return "Mobil masih menyala, matikan terlebih dahulu agar tidak meledak.";
        } else {
            this.setPersenFuel(100);
            return String.format("%s sekarang sudah penuh, mobil dapat digaskeun kembali!", 
                                    this.getBahanBakar());
        }
    }

    // TODO: Lengkapi method ini
    @Override
    public String[] simulasi(){

        // Pembuatan array dan mengisinya sesuai simulasi yang diinginkan
        String[] temp = new String[7];
        temp[0] = this.start();

        for (int i = 1; i < 5; i++) {
            temp[i] = this.gas();
        }
        
        temp[5] = this.stop();
        temp[6] = this.isiBahanBakar();
        
        return temp;
    }


}