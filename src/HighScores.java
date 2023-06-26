import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class HighScores extends JFrame {
    ImageIcon logo = new ImageIcon("img/logo.png");
    Border border = BorderFactory.createLineBorder(new Color(94, 37, 156),7);
    Font pixelMplus;
    JLabel lHighScores;
    String[] Fruits = new String[35];
    HighScores() {
        Fruits[0] = "1. Johny       SCORES: 358";
        Fruits[1] = "2. Dawid       SCORES: 126";
        Fruits[2] = "3. user123     SCORES: 0";
        Fruits[3] = "4.";
        Fruits[4] = "5";
        Fruits[5] = "6";
        Fruits[6] = "7";
        Fruits[7] = "8";
        Fruits[8] = "9";
        Fruits[9] = "10.";

        try{
            pixelMplus = Font.createFont(Font.TRUETYPE_FONT, new File("PixelMplus10-Regular.ttf")).deriveFont(42f);
            GraphicsEnvironment ge2 = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge2.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("PixelMplus10-Regular.ttf")));
        }catch (IOException | FontFormatException e){
            System.out.println("zła czcionka");
        }


        JList ListFruits = new JList(Fruits);
        ListFruits.setBounds(200,200,600,500);
        ListFruits.setForeground(new Color(251,242,54));
        ListFruits.setFont(pixelMplus);
        ListFruits.setBackground(new Color(94, 37, 156));
        ListFruits.setSelectionBackground(new Color(94, 37, 156));
        ListFruits.setSelectionForeground(Color.white);

        ListFruits.setBorder(new EmptyBorder(4,4,4,4));
        ListFruits.setFocusable(false);

        JScrollPane scrollTabela = new JScrollPane(ListFruits);
        scrollTabela.setBounds(200,200,600,500);
        scrollTabela.setBorder(border);
        scrollTabela.setFocusable(false);


        lHighScores = new JLabel();
        lHighScores.setIcon(new ImageIcon("img/HighScoresLabel.png"));
        lHighScores.setBounds(150,50,700,150);

        this.add(scrollTabela);
        this.add(lHighScores);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setIconImage(logo.getImage());
        this.setLayout(null);
        this.getContentPane().setBackground(new Color(94, 37, 156));
        this.setResizable(false);
        this.setTitle("Bloon Shooter");
        this.setSize(1000,800);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
