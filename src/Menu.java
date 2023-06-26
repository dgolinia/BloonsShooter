import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame implements ActionListener {
    JButton bNewGame = new JButton();
    JButton bHighScores = new JButton();
    JButton bEnd = new JButton();
    ImageIcon logo = new ImageIcon("img/logo.png");
    Border border = BorderFactory.createLineBorder(Color.BLACK,7);

    Menu(){

        bNewGame.setBounds(250,100,500,150);
        bNewGame.setIcon(new ImageIcon("img/NewGame.png"));
        bNewGame.addActionListener(this);
        bNewGame.setBorder(border);

        bHighScores.setBounds(250,300,500,150);
        bHighScores.setIcon(new ImageIcon("img/HighScores.png"));
        bHighScores.addActionListener(this);
        bHighScores.setBorder(border);

        bEnd.setBounds(250,500,500,150);
        bEnd.setIcon(new ImageIcon("img/End.png"));
        bEnd.addActionListener(this);
        bEnd.setBorder(border);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setIconImage(logo.getImage());
        this.getContentPane().setBackground(new Color(94, 37, 156));
        this.setResizable(false);
        this.setTitle("Bloon Shooter");
        this.setLayout(null);
        this.setSize(1000,800);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.add(bNewGame);
        this.add(bHighScores);
        this.add(bEnd);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == bNewGame){
            this.dispose();
            new ChoiceOfDifficulty();
        }else if (e.getSource() == bHighScores){
            this.dispose();
            new HighScores();
        } else if(e.getSource() == bEnd){
            System.exit(0);
        }
    }
}
