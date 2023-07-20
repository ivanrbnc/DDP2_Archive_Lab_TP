import java.util.Scanner;

public class Lab03 {
    static int pointer = 0;
    static int size = 1;
    static String[][] playlist = new String[size][4];
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Selamat Datang di Pacilfy!");
        // TODO:
        // sebelum loop, menginisialisasi playlist dengan minimal 1 lagu dimasukkan       
        addMusic();
        
        // Meminta input data lagu terus-menerus hingga user memilih berhenti
        while (true) {
            System.out.println("Lanjut menambahkan lagu?\n[1] Lanjut\n[0] Berhenti");
            System.out.print("Perintah: ");
            String initialInput = in.nextLine();
            
            if (initialInput.equals("1")) {
                // Membesarkan kapasitas playlist terlebih dahulu, baru mengisi index terakhirnya
                enlargePlaylist();
                addMusic();
            } else if (initialInput.equals("0")) {
                break;
            }
        }

        System.out.println("Pacilfy siap dimulai");
               
        System.out.println("\nSELAMAT DATANG DI\n");
        System.out.println(" /$$$$$$$                     /$$ /$$  /$$$$$$");
        System.out.println("| $$__  $$                   |__/| $$ /$$__  $$");
        System.out.println("| $$  \\ $$ /$$$$$$   /$$$$$$$ /$$| $$| $$  \\__//$$   /$$");
        System.out.println("| $$$$$$$/|____  $$ /$$_____/| $$| $$| $$$$   | $$  | $$");
        System.out.println("| $$____/  /$$$$$$$| $$      | $$| $$| $$_/   | $$  | $$");
        System.out.println("| $$      /$$__  $$| $$      | $$| $$| $$     | $$  | $$");
        System.out.println("| $$     |  $$$$$$$|  $$$$$$$| $$| $$| $$     |  $$$$$$$");
        System.out.println("|__/      \\_______/ \\_______/|__/|__/|__/      \\____  $$");
        System.out.println("                                               /$$  | $$");
        System.out.println("                                              |  $$$$$$/");
        System.out.println("                                               \\______/");

        int command = 1;
        while (true){
            display();
            System.out.print("Command (0 untuk exit) : ");
            command = Integer.parseInt(in.nextLine());
            if (command == 1){
                prevMusic();
            } else if (command == 2){
                enlargePlaylist();
                addMusic();
            } else if (command == 3){
                detailsMusic();
            } else if (command == 4){
                deleteMusic();
            } else if (command == 5){
                nextMusic();
            } else if (command == 0){
                break;
            } else {
                System.out.println("Maaf, command yang anda masukan salah");
            }
        }
        System.out.println("Terima kasih sudah menggunakan Pacilfy!");
    }

    private static void nextMusic() {
        //TODO:
        // Menangkap data lagu pertama dari playlist
        String[] tempFirst = playlist[0];

        // Menghilangkan elemen pertama serta mengecilkan ukurannya dari playlist
        String[][] deletedFirst = new String[size - 1][4];
        System.arraycopy(playlist, 1, deletedFirst, 0, size - 1);
        playlist = deletedFirst;

        // Membesarkan ukuran dan meletakkan tempFirst pada elemen terakhir dari playlist
        String[][] tempArray = new String[size][4];    
        System.arraycopy(playlist, 0, tempArray, 0, size - 1);
        tempArray[playlist.length] = tempFirst;
        playlist = tempArray;
    }

    private static void deleteMusic() {
        //TODO:
        // Mengecek banyaknya lagu terlebih dahulu
        if (size == 1) {
            System.out.println("Minimal ada satu musik dalam sistem");
        } else {
            // Menghilangkan elemen pertama dari playlist lalu mengecilkan ukurannya
            String[][] tempArray = new String[size - 1][4];    
            System.arraycopy(playlist, 1, tempArray, 0, size - 1);
            size -= 1;
            playlist = tempArray;
        }
    }

    private static void detailsMusic() {
        //TODO:
        // Meminta judul yang ingin dicari lalu dibuat menjadi huruf kecil agar insensitive
        System.out.print("Judul yang ingin dicari: ");
        String titleToSearch = in.nextLine();

        // Mengecek apakah terdapat judul yang sama di playlist
        int counter = 0;
        for (String[] songData : playlist) {

            // Ketika ada yang sama, tampilkan serta menambahkan variabel counter
            if (titleToSearch.equalsIgnoreCase(songData[0])) { // Case insensitive equals
                System.out.println("Data lagu:");
                System.out.println("Judul : " + songData[0]);
                System.out.println("Artist: " + songData[1]);
                System.out.println("Album : " + songData[2]);
                System.out.println("Tahun : " + songData[3]);
                counter += 1;
                break;
            }
        }

        // Ketika tidak ada judul yang sama, maka counter bernilai 0
        if (counter == 0) {
            System.out.println("Lagu tidak ditemukan");
        }
    }

    private static void prevMusic() {
        //TODO:
        // Menangkap data lagu terakhir dari playlist
        String[] tempLast = playlist[playlist.length - 1];

        // Menghilangkan elemen terakhir serta mengecilkan ukurannya dari playlist
        String[][] deletedLast = new String[size - 1][4];
        System.arraycopy(playlist, 0, deletedLast, 0, size - 1);
        playlist = deletedLast;

        // Membesarkan ukuran dan meletakkan tempLast pada elemen pertama dari playlist
        String[][] tempArray = new String[size][4];    
        System.arraycopy(playlist, 0, tempArray, 1, size - 1);
        tempArray[0] = tempLast;

        playlist = tempArray;
    }

    private static void addMusic() {
        //TODO:
        /* Menggunakan referensi : 
        https://www.educba.com/2d-arrays-in-java/
        Dengan asumsi ukuran playlist memiliki slot kosong di akhirnya, maka dapat dilakukan */
        System.out.println("Silahkan masukan lagu anda");

        // Meletakkan tiap komponen lagu pada nested array
        System.out.print("Judul : ");
        String title = in.nextLine();
        playlist[playlist.length - 1][0] = title;

        System.out.print("Artist: ");
        String artist = in.nextLine();
        playlist[playlist.length - 1][1] = artist;
        
        System.out.print("Album : ");
        String album = in.nextLine();
        playlist[playlist.length - 1][2] = album;

        System.out.print("Tahun : ");
        String year = in.nextLine();
        playlist[playlist.length - 1][3] = year;
    }

    private static void enlargePlaylist() { 
        // Method ini akan membesarkan ukuran playlist sebesar satu
        String[][] tempArray = new String[size + 1][4];    
        System.arraycopy(playlist, 0, tempArray, 0, size);
        playlist = tempArray;
        size += 1;
    }

    private static void display() {
        System.out.println();
        System.out.println("Currently Playing");

        String displayedMusic = " " + playlist[pointer][1] + " - " + playlist[pointer][0] + " ";
        String command = "|[1] prev |[2] add music |[3] details |[4] delete music |[5] next|";

        if (displayedMusic.length() < command.length()){
            int width = 62;
            String s = displayedMusic;

            int padSize = width - s.length();
            int padStart = s.length() + padSize / 2;

            s = String.format("%" + padStart + "s", s);
            s = String.format("%-" + width  + "s", s);


            System.out.println(new String(new char[66]).replace("\0", "="));
            System.out.println("= "+ s +" =");
            System.out.println(new String(new char[66]).replace("\0", "="));
            System.out.println(command);

            return;
        }

        System.out.println("=" + new String(new char[displayedMusic.length()]).replace("\0", "=") + "=");
        System.out.println("=" + displayedMusic + "=");
        System.out.println("=" + new String(new char[displayedMusic.length()]).replace("\0", "=") + "=");
        System.out.println(command);
    }
}