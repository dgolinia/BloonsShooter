import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class EndingScreen {
    ImageIcon logo = new ImageIcon("img/logo.png");
    JFrame endingFrame;
    Font pixelMplus;
    JLabel gameOver,result;
    JButton submit;
    JTextField setNickName;
    Border border = BorderFactory.createLineBorder(Color.BLACK,7);

    EndingScreen(){

        try{
            pixelMplus = Font.createFont(Font.TRUETYPE_FONT, new File("PixelMplus10-Regular.ttf")).deriveFont(50f);
            GraphicsEnvironment ge2 = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge2.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("PixelMplus10-Regular.ttf")));
        }catch (IOException | FontFormatException e){
            System.out.println("zła czcionka");
        }
        endingFrame = new JFrame();

        gameOver = new JLabel(new ImageIcon("img/gameOver.png"));
        gameOver.setBounds(150,50,700,200);
        gameOver.setBackground(new Color(94, 37, 156));
        gameOver.setOpaque(true);

        result = new JLabel(new ImageIcon("img/endingText.png"));
        result.setForeground(Color.yellow);
        result.setText("");
        result.setFont(pixelMplus);
        result.setHorizontalTextPosition(JLabel.CENTER);
        result.setVerticalTextPosition(JLabel.CENTER);
        result.setBounds(150,250,700,250);

        setNickName = new JTextField();
        setNickName.setBounds(350,550,300,70);
        setNickName.setHorizontalAlignment(JTextField.CENTER);
        setNickName.setFont(pixelMplus);
        setNickName.setOpaque(true);

        submit = new JButton(new ImageIcon("img/submit.png"));
        submit.setBounds(300,650,400,100);
        submit.setVisible(true);
        submit.setBorder(border);
        submit.addActionListener(e -> {
            endingFrame.dispose();
            new Menu();
        });

        endingFrame.add(gameOver);
        endingFrame.add(result);
        endingFrame.add(setNickName);
        endingFrame.add(submit);
        endingFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        endingFrame.setIconImage(logo.getImage());
        endingFrame.getContentPane().setBackground(new Color(94, 37, 156));
        endingFrame.setResizable(false);
        endingFrame.setTitle("Bloon Shooter");
        endingFrame.setLayout(null);
        endingFrame.setSize(1000,800);
        endingFrame.setLocationRelativeTo(null);
        endingFrame.setVisible(true);
    }
}
