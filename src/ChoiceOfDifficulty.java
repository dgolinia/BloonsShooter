import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class ChoiceOfDifficulty extends JFrame implements ActionListener {
    JButton bEasy = new JButton();
    JButton bMedium = new JButton();
    JButton bHard = new JButton();
    JLabel lSelectDifficulty = new JLabel();
    ImageIcon logo = new ImageIcon("img/logo.png");
    Border border = BorderFactory.createLineBorder(Color.BLACK,7);
    ChoiceOfDifficulty(){
        lSelectDifficulty.setBounds(250,50,500,150);
        lSelectDifficulty.setBorder(border);
        lSelectDifficulty.setIcon(new ImageIcon("img/SelectDifficulty.png"));

        bEasy.setBounds(350,250,300,100);
        bEasy.setIcon(new ImageIcon("img/easy.png"));
        bEasy.addActionListener(this);
        bEasy.setBorder(border);

        bMedium.setBounds(350,400,300,100);
        bMedium.setIcon(new ImageIcon("img/medium.png"));
        bMedium.addActionListener(this);
        bMedium.setBorder(border);

        bHard.setBounds(350,550,300,100);
        bHard.setIcon(new ImageIcon("img/hard.png"));
        bHard.addActionListener(this);
        bHard.setBorder(border);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setIconImage(logo.getImage());
        this.getContentPane().setBackground(new Color(94, 37, 156));
        this.setResizable(false);
        this.setTitle("Bloon Shooter");
        this.setLayout(null);
        this.setSize(1000,800);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.add(lSelectDifficulty);
        this.add(bEasy);
        this.add(bMedium);
        this.add(bHard);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bEasy){
            this.dispose();
            EasyAnimations animations1 = new EasyAnimations();
            animations1.baseAnimations();
            animations1.bloonsAnimations();
        } else if (e.getSource() == bMedium){
            this.dispose();
            MediumAnimations animations2 = new MediumAnimations();
            animations2.baseAnimations();
            animations2.bloonsAnimations();
        } else if (e.getSource() == bHard){
            this.dispose();
            HardAnimations animations3 = new HardAnimations();
            animations3.baseAnimations();
            animations3.bloonsAnimations();
        }
    }
}
