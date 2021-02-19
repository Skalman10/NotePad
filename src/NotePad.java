import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;

public class NotePad {
    public static void main(String[] args) {
        JFrame frame = new JFrame("NotePad");
        frame.setContentPane(new NotePad().NotePanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        boolean newFile = true;
    }
    public NotePad() {
        MNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea1.setText("");
            } // Metod för att clear textarea
        });
        MOpen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent f) {
                JFileChooser fc = new JFileChooser();
                int result = fc.showOpenDialog(null);
                String filename;
                if (result == JFileChooser.APPROVE_OPTION) {
                    filename = fc.getSelectedFile().getAbsolutePath();
                } else {
                    filename = null;
                }

                FileReader fr = null;
                try {
                    fr = new FileReader(filename);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                BufferedReader inFile = new BufferedReader(fr);

                String line;
                try {
                    while ((line = inFile.readLine() ) != null) {
                        textArea1.append(line+"\n");
                    }
                    inFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }//Metod för att öppna fil
        });
        MSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String filename = JOptionPane.showInputDialog("Spara som");
                FileWriter fw = null;
                try {
                    fw = new FileWriter(filename);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter outFile = new PrintWriter(bw);
                Scanner in = new Scanner(textArea1.getText());
                    while (in.hasNextLine()) {
                        outFile.println(in.nextLine());
                    }
                    outFile.flush();
                    outFile.close();
            }
        });
    }

    private JPanel NotePanel;
    private JTextArea textArea1;
    private JMenuItem MNew;
    private JMenuItem MOpen;
    private JMenuItem MSave;
}
