import java.awt.event.*;
import java.util.HashMap;
import javax.swing.*;

public class CurrencyConversionFrame extends JFrame {
    JLabel labelTitle, labelFrom, labelTo;
    JButton convertButton, exitButton;
	JComboBox<String> dropDownFrom, dropDownTo;
	JTextField textFieldFrom, textFieldResult;
    String[] currency = {"Rupiah", "Euro", "US Dollar"};
    HashMap<String, Integer> kurs = new HashMap<String, Integer>();

    public CurrencyConversionFrame() {
        kurs.put("Rupiah", 1);
        kurs.put("Euro", 15000);
        kurs.put("US Dollar", 14000);

        // https://stackoverflow.com/questions/68637758/get-keys-from-hashmap-and-store-in-string-array-using-java
        // Membuat array berdasarkan "key" dari HashMap yang dimiliki
        String[] keys = kurs.keySet().toArray(String[]::new);

        // TO DO: Menentukan layout dan size yang ingin digunakan 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        setTitle("Currency Converter");

        // Size frame akan sebesar 370 x 190
        setSize(370, 190);	

        // TO DO: Membuat Panel sesuai kebutuhan
        // Panel-panel untuk diletakkan pada frame
        JPanel panel = new JPanel();
        JPanel panelFrom = new JPanel();
        JPanel panelTo = new JPanel();
        JPanel panelConfirm = new JPanel();

        // Membuat layout pada masing-masing frame
		BoxLayout boxLayoutManager = new BoxLayout(panel, BoxLayout.Y_AXIS);
		panel.setLayout(boxLayoutManager);

        BoxLayout boxLayoutFrom = new BoxLayout(panelFrom, BoxLayout.X_AXIS);
		panelFrom.setLayout(boxLayoutFrom);

        BoxLayout boxLayoutTo = new BoxLayout(panelTo, BoxLayout.X_AXIS);
		panelTo.setLayout(boxLayoutTo);

        BoxLayout boxLayoutConfirm = new BoxLayout(panelConfirm, BoxLayout.X_AXIS);
		panelConfirm.setLayout(boxLayoutConfirm);
        
        // Membuat label untuk judul
        labelTitle = new JLabel();
        labelTitle.setText("Welcome to Currency Converter");
        
        // TO DO: Membuat dropdown menu
        // Membuat label serta dropdown sesuai kondisi soal
        labelFrom = new JLabel("From");
        labelTo = new JLabel("To");

        dropDownFrom = new JComboBox<>(keys);
        dropDownTo = new JComboBox<>(keys);

        // TO DO: Membuat textfield 
        // Membentuk textfield agar user dapat mengisi input kurs yang ingin dikonversi
        textFieldFrom = new JTextField();
        textFieldResult = new JTextField();
        textFieldResult.setEditable(false); // Khusus untuk hasil, textfield tidak dapat diedit

        // Pembuatan tombol konversi dan keluar
        convertButton = new JButton("Convert");
        exitButton = new JButton("Exit");
        
        // TO DO: Masukkan widget ke panel yang tepat
        // Peletakkan widget dan panel-panel sesuai bentuk yang diinginkan
        panel.add(labelTitle);

        panelFrom.add(labelFrom);
        panelFrom.add(dropDownFrom);
        panelFrom.add(textFieldFrom);
        panel.add(panelFrom);

        panelTo.add(labelTo);
        panelTo.add(dropDownTo);
        panelTo.add(textFieldResult);
        panel.add(panelTo);
        
        panelConfirm.add(convertButton);
        panelConfirm.add(exitButton);
        panel.add(panelConfirm);

        // TO DO: Masukkan panel ke dalam frame
        add(panel);
        setVisible(true);

        convertButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                // TO DO: implementasikan pemanggilan method ConvertCurrency
                // Memanggil method ConvertCurrency untuk mendapat hasil dari perubahanan kurs
                String result = ConvertCurrency(textFieldFrom.getText(), 
                                                dropDownFrom.getSelectedItem().toString(), 
                                                dropDownTo.getSelectedItem().toString());

                textFieldResult.setText(result);
            }
        });

        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                // TO DO: hentikan eksekusi program
                // https://stackoverflow.com/questions/25446660/how-to-use-exit-button-in-swing-application
                System.exit(0);
            }
        });
    }
    
    // Method converter
    public String ConvertCurrency(String originalValue, String tipeCurrencyFrom, String tipeCurrencyTo) {
        double value = Double.valueOf(originalValue);
        double fromValue = value * kurs.get(tipeCurrencyFrom);
        double convertedValue = fromValue / kurs.get(tipeCurrencyTo);
        return String.format("%.2f", convertedValue);
    }
}
