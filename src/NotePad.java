import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class NotePad {
    public NotePad() {
        MNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea1.setText("");
            }
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
                        textArea1.append(line);
                    }
                    inFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("NotePad");
        frame.setContentPane(new NotePad().NotePanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private JPanel NotePanel;
    private JTextArea textArea1;
    private JMenuItem MNew;
    private JMenuItem MOpen;
    private JMenuItem MSave;
}
