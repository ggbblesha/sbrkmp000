import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

public class komp extends JFrame {

    private JLabel text1;
    private JLabel text2;
    private JPanel main;
    private JButton MSIGeForceRTX4060Button;
    private JButton gigabyteRadeonRX6600Button;
    private JButton geForceRTX4070TiButton;
    private JButton intelArcA750250€Button;
    private JButton AMDRyzen55600Button;
    private JButton intelCoreI512600KFButton;
    private JButton AMDRyzen95950XButton;
    private JButton intelCeleronG55023Button;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JLabel qwerty;
    private JButton pabeigtsButton;
    private JLabel konec;
    private JTextField textField1;
    private int cena = 0;

    public komp() {
        setContentPane(main);
        setTitle("Datora konstruktors!");
        setSize(1400, 450);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);

        MSIGeForceRTX4060Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cena += 340;
                updateCenaLabel();
                offgpu(MSIGeForceRTX4060Button);
            }
        });

        gigabyteRadeonRX6600Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cena += 230;
                updateCenaLabel();
                offgpu(gigabyteRadeonRX6600Button);
            }
        });

        geForceRTX4070TiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cena += 1100;
                updateCenaLabel();
                offgpu(geForceRTX4070TiButton);
            }
        });

        intelArcA750250€Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cena += 250;
                updateCenaLabel();
                offgpu(intelArcA750250€Button);
            }
        });

        // ActionListeners для CPU
        AMDRyzen55600Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cena += 123;
                updateCenaLabel();
                offcpu(AMDRyzen55600Button);
            }
        });

        intelCoreI512600KFButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cena += 183;
                updateCenaLabel();
                offcpu(intelCoreI512600KFButton);
            }
        });

        intelCeleronG55023Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cena += 23;
                updateCenaLabel();
                offcpu(intelCeleronG55023Button);
            }
        });

        AMDRyzen95950XButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cena += 403;
                updateCenaLabel();
                offcpu(AMDRyzen95950XButton);
            }
        });


        pabeigtsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Добавление цены памяти к общей сумме
                String memory = comboBox2.getSelectedItem().toString();
                if (memory.equals("128 GB (50 €)")) {
                    cena += 50;
                } else if (memory.equals("256 GB (100 €)")) {
                    cena += 100;
                } else if (memory.equals("512 GB (200 €)")) {
                    cena += 200;
                } else if (memory.equals("1 TB (300 €)")) {
                    cena += 300;
                }
                updateCenaLabel();
                pabeigtsButton.setEnabled(false);

                //filewriter
                String name = textField1.getText();
                String filePath = "D:\\java\\kompi 2\\kompi\\sborka.txt";
                try {
                    FileWriter writer = new FileWriter(filePath, true);
                    writer.write("Paldies par pirkumiem, " + name + " :)\n");
                    writer.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                konec.setText("Paldies par pirkumiem, " + name + " :)");
            }
        });
    }

    // Выключение кнопок выбора CPU
    private void offcpu(JButton selectedButton) {
        JButton[] buttonsToDisable = {AMDRyzen55600Button, intelCoreI512600KFButton, intelCeleronG55023Button, AMDRyzen95950XButton};
        for (JButton button : buttonsToDisable) {
            if (button != selectedButton) {
                button.setEnabled(false);
            }
        }
    }

    // Выключение кнопок выбора видеокарты
    private void offgpu(JButton selectedButton) {
        JButton[] buttonsToDisable = {MSIGeForceRTX4060Button, gigabyteRadeonRX6600Button, geForceRTX4070TiButton, intelArcA750250€Button};
        for (JButton button : buttonsToDisable) {
            if (button != selectedButton) {
                button.setEnabled(false);
            }
        }
    }

    //сумма
    private void updateCenaLabel() {
        qwerty.setText("Iepirkuma cena: " + cena + "€");
    }
    public static void main(String[] args) {
        komp frame = new komp();
    }

    private void createUIComponents() {
        comboBox1 = new JComboBox<>();
        comboBox1.addItem("Toshiba Canvio Gaming");
        comboBox1.addItem("Adata HV300");
        comboBox1.addItem("Verbatim Silver 53189");
        comboBox1.addItem("Intenso Memory Case");
        comboBox2 = new JComboBox<>();
        comboBox2.addItem("128 GB (50 €)");
        comboBox2.addItem("256 GB (100 €)");
        comboBox2.addItem("512 GB (200 €)");
        comboBox2.addItem("1 TB (300 €)");
    }
}