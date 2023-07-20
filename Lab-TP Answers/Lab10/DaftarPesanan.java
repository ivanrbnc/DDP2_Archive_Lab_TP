import java.util.ArrayList;
import java.util.Collections;

public class DaftarPesanan<T extends Pesanan> {
    // TODO: tambahkan attributes
    private ArrayList<T> pesanans;
    private int pointer; // Digunakan untuk menunjukan bahwa pesanan ini akan disajikan selanjutnya

    public DaftarPesanan() {
        // TODO: Lengkapi Constructor berikut
        pesanans = new ArrayList<T>();
    }

    public void tambahPesanan(T pesanan) {
        // TODO: proses tambah pesanan
        pesanans.add(pesanan);
        Collections.sort(pesanans); // Tiap kali terdapat penambahan pesanan, maka otomatis pesanans akan diurutkan
    }

    public T nextPesanan() {
        // TODO: return sesuai dengan urutan prioritas
        // Pengecekan apakah seluruh pesanan di daftarMakanan telah disajikan
        if (this.pointer == this.pesanans.size()) {
            return null;
        } else {
            // Ketika masih terdapat pesanan yang belum disajikan, maka pesanan setelahnya akan disajikan
            T tempHidangan = pesanans.get(pointer); // Menangkap pesanan sesuai pointer
            this.pointer += 1; // Menggerakkan pointer agar bersesuaian dengan program
            return tempHidangan;
        }
    }
}
