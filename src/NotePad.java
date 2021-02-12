import javax.swing.*;

public class NotePad {
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
