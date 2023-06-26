import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class MediumMode extends JFrame implements KeyListener {
    ImageIcon logo = new ImageIcon("img/logo.png");
    ImageIcon upgrade2 = new ImageIcon("img/cost100.png");
    ImageIcon upgrade3 = new ImageIcon("img/cost150.png");
    ImageIcon maxUpgrades = new ImageIcon("img/maxUpgrades.png");
    ImageIcon woodenUpgrade = new ImageIcon("img/WoodenUpgrade.png");
    ImageIcon ironUpgrade = new ImageIcon("img/IronUpgrade.png");
    ImageIcon diamondUpgrade = new ImageIcon("img/DiamongUpgrade.png");
    ImageIcon finalUpgrade = new ImageIcon("img/finalUpgrade.png");
    JLayeredPane mainPanel = new JLayeredPane();
    JLabel cloud,cloud2,tree,tree2,floor,countingDown,lifes,scores,upgradesLabel,upgradesLabel2,stopwatch;
    JButton demageUpgrade,healUpgrade,redBloon,greenBloon,yellowBloon,pinkBloon,purpleBloon,leaveButton;
    Font pixelMplus,pixelMplus2;
    static Random rand = new Random();
    Border border = BorderFactory.createLineBorder(Color.BLACK,5);
    boolean ctrl,shift,q;
    int redLifes = 1;
    int greenLifes = 3;
    int yellowLifes = 6;
    int pinkLifes = 9;
    int purpleLifes = 12;
    int demagePerClic = 1;
    int hearths = 10;
    int gold = 0;
    int BloonsShooted = 0;
    int BloonSpeed = 1;
    int finalResult;
    MediumMode(){

        try{
            pixelMplus = Font.createFont(Font.TRUETYPE_FONT, new File("PixelMplus10-Bold.ttf")).deriveFont(400f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("PixelMplus10-Bold.ttf")));

            pixelMplus2 = Font.createFont(Font.TRUETYPE_FONT, new File("PixelMplus10-Regular.ttf")).deriveFont(50f);
            GraphicsEnvironment ge2 = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge2.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("PixelMplus10-Regular.ttf")));
        }catch (IOException | FontFormatException e){
            System.out.println("zła czcionka");
        }

        redBloon = new JButton(new ImageIcon("img/redBloon.png"));
        redBloon.setBounds(-100,rand.nextInt(50)+390,75,75);
        redBloon.setHorizontalTextPosition(JButton.CENTER);
        redBloon.setText(""+redLifes);
        redBloon.setFont(new Font("MV Boli",Font.BOLD,40));
        redBloon.setContentAreaFilled(false);
        redBloon.setBorder(new EmptyBorder(4,4,4,4));
        redBloon.setFocusable(false);
        redBloon.addActionListener((e) -> {
            redLifes = redLifes - demagePerClic;
            redBloon.setText(""+redLifes);
            if(redLifes <= 0) {
                redBloon.setVisible(false);
                redBloon.setText(""+redLifes);
                redLifes = 1;
                gold++;
                scores.setText(""+gold);
            }
        });

        greenBloon = new JButton(new ImageIcon("img/greenBloon.png"));
        greenBloon.setBounds(1400,rand.nextInt(50)+390,75,75);
        greenBloon.setHorizontalTextPosition(JButton.CENTER);
        greenBloon.setText(""+greenLifes);
        greenBloon.setFont(new Font("MV Boli",Font.BOLD,40));
        greenBloon.setContentAreaFilled(false);
        greenBloon.setBorder(new EmptyBorder(4,4,4,4));
        greenBloon.setFocusable(false);
        greenBloon.addActionListener(e -> {
            greenLifes = greenLifes - demagePerClic;
            greenBloon.setText(""+greenLifes);
            if(greenLifes <= 0){
                greenBloon.setVisible(false);
                greenBloon.setText(""+greenLifes);
                greenLifes = 3;
                gold = gold + 3;
                scores.setText(""+gold);
            }
        });

        yellowBloon = new JButton(new ImageIcon("img/yellowBloon.png"));
        yellowBloon.setBounds(-100,rand.nextInt(50)+390,75,75);
        yellowBloon.setHorizontalTextPosition(JButton.CENTER);
        yellowBloon.setText(""+yellowLifes);
        yellowBloon.setFont(new Font("MV Boli",Font.BOLD,40));
        yellowBloon.setContentAreaFilled(false);
        yellowBloon.setBorder(new EmptyBorder(4,4,4,4));
        yellowBloon.setFocusable(false);
        yellowBloon.addActionListener(e -> {
            yellowLifes = yellowLifes - demagePerClic;
            yellowBloon.setText(""+yellowLifes);
            if(yellowLifes <= 0){
                yellowBloon.setVisible(false);
                yellowBloon.setText(""+yellowLifes);
                yellowLifes = 6;
                gold = gold + 6;
                scores.setText(""+gold);
            }
        });

        pinkBloon = new JButton(new ImageIcon("img/pinkBloon.png"));
        pinkBloon.setBounds(-100,rand.nextInt(50)+390,75,75);
        pinkBloon.setHorizontalTextPosition(JButton.CENTER);
        pinkBloon.setText(""+pinkLifes);
        pinkBloon.setFont(new Font("MV Boli",Font.BOLD,40));
        pinkBloon.setContentAreaFilled(false);
        pinkBloon.setBorder(new EmptyBorder(4,4,4,4));
        pinkBloon.setFocusable(false);
        pinkBloon.addActionListener(e -> {
            pinkLifes = pinkLifes - demagePerClic;
            pinkBloon.setText(""+pinkLifes);
            if(pinkLifes <= 0){
                pinkBloon.setVisible(false);
                pinkBloon.setText(""+pinkLifes);
                pinkLifes = 9;
                gold = gold + 9;
                scores.setText(""+gold);
            }
        });

        purpleBloon = new JButton(new ImageIcon("img/purpleBloon.png"));
        purpleBloon.setBounds(1400,rand.nextInt(50)+390,75,75);
        purpleBloon.setHorizontalTextPosition(JButton.CENTER);
        purpleBloon.setText(""+purpleLifes);
        purpleBloon.setFont(new Font("MV Boli",Font.BOLD,40));
        purpleBloon.setContentAreaFilled(false);
        purpleBloon.setBorder(new EmptyBorder(4,4,4,4));
        purpleBloon.setFocusable(false);
        purpleBloon.addActionListener(e -> {
            purpleLifes = purpleLifes - demagePerClic;
            purpleBloon.setText(""+purpleLifes);
            if(purpleLifes <= 0){
                purpleBloon.setVisible(false);
                purpleBloon.setText(""+purpleLifes);
                purpleLifes = 12;
                gold = gold + 12;
                scores.setText(""+gold);
            }
        });

        demageUpgrade = new JButton();
        demageUpgrade.setIcon(woodenUpgrade);
        demageUpgrade.setBounds(620,650,150,100);
        demageUpgrade.setBorder(border);
        demageUpgrade.setEnabled(false);
        demageUpgrade.addActionListener(e -> {
            if(demageUpgrade.getIcon() == woodenUpgrade){
                gold = gold - 50;
                scores.setText(""+gold);
                demageUpgrade.setIcon(ironUpgrade);
                upgradesLabel.setIcon(upgrade2);
                demageUpgrade.setEnabled(false);
            }else if(demageUpgrade.getIcon() == ironUpgrade){
                gold = gold - 100;
                scores.setText(""+gold);
                demageUpgrade.setIcon(diamondUpgrade);
                upgradesLabel.setIcon(upgrade3);
                demageUpgrade.setEnabled(false);
            }else if(demageUpgrade.getIcon() == diamondUpgrade){
                gold = gold - 150;
                scores.setText(""+gold);
                demageUpgrade.setIcon(finalUpgrade);
                demageUpgrade.setBorder(new EmptyBorder(4,4,4,4));
                demageUpgrade.setFocusable(false);
                demageUpgrade.setContentAreaFilled(false);
                upgradesLabel.setIcon(maxUpgrades);
            }
            demagePerClic++;
        });

        healUpgrade = new JButton(new ImageIcon("img/HealthUpgrade.png"));
        healUpgrade.setBounds(780,650,150,100);
        healUpgrade.setBorder(border);
        healUpgrade.setEnabled(false);
        healUpgrade.addActionListener(e -> {
            gold = gold - 100;
            hearths++;
            lifes.setText(""+hearths);
            scores.setText(""+gold);
        });

        leaveButton = new JButton();
        leaveButton.addKeyListener(this);

        cloud = new JLabel(new ImageIcon("img/cloud.png"));
        cloud.setBounds(100,20,200,100);

        cloud2 = new JLabel(new ImageIcon("img/cloud.png"));
        cloud2.setBounds(600,150,200,100);

        tree = new JLabel(new ImageIcon("img/tree.png"));
        tree.setBounds(300,300,200,300);

        tree2 = new JLabel(new ImageIcon("img/tree.png"));
        tree2.setBounds(900,300,200,300);

        floor = new JLabel(new ImageIcon("img/floor.png"));
        floor.setBounds(0,600,1400,200);

        lifes = new JLabel(new ImageIcon("img/hearth.png"));
        lifes.setText(""+hearths);
        lifes.setForeground(Color.WHITE);
        lifes.setFont(pixelMplus2);
        lifes.setHorizontalAlignment(JLabel.LEFT);
        lifes.setBounds(0,650,210,100);

        scores = new JLabel(new ImageIcon("img/gold.png"));
        scores.setText(""+gold);
        scores.setForeground(new Color(251,242,54));
        scores.setHorizontalAlignment(JLabel.LEFT);
        scores.setIconTextGap(20);
        scores.setFont(pixelMplus2);
        scores.setBounds(210,650,230,100);

        stopwatch = new JLabel(new ImageIcon("img/stopwatch.png"));
        stopwatch.setForeground(Color.WHITE);
        stopwatch.setFont(pixelMplus2);
        stopwatch.setBounds(1150,650,290,100);
        stopwatch.setHorizontalAlignment(JLabel.LEFT);

        upgradesLabel = new JLabel(new ImageIcon("img/cost50.png"));
        upgradesLabel.setBounds(440,650,180,100);

        upgradesLabel2 = new JLabel(new ImageIcon("img/cost100_2.png"));
        upgradesLabel2.setBounds(930,650,180,100);

        countingDown = new JLabel();
        countingDown.setFont(pixelMplus);
        countingDown.setHorizontalAlignment(JLabel.CENTER);
        countingDown.setBounds(350,100,700,500);

        mainPanel.setBounds(0,0,1400,800);
        mainPanel.setOpaque(true);
        mainPanel.setBackground(new Color(51,173,255));
        mainPanel.add(cloud,Integer.valueOf(2));
        mainPanel.add(tree,Integer.valueOf(2));
        mainPanel.add(cloud2,Integer.valueOf(2));
        mainPanel.add(tree2,Integer.valueOf(2));
        mainPanel.add(floor,Integer.valueOf(0));
        mainPanel.add(lifes,Integer.valueOf(1));
        mainPanel.add(upgradesLabel,Integer.valueOf(1));
        mainPanel.add(upgradesLabel2,Integer.valueOf(1));
        mainPanel.add(scores,Integer.valueOf(1));
        mainPanel.add(stopwatch,Integer.valueOf(1));
        mainPanel.add(demageUpgrade,Integer.valueOf(1));
        mainPanel.add(healUpgrade,Integer.valueOf(1));
        mainPanel.add(countingDown,Integer.valueOf(10));
        mainPanel.add(redBloon,Integer.valueOf(1));
        mainPanel.add(greenBloon,Integer.valueOf(1));
        mainPanel.add(yellowBloon,Integer.valueOf(1));
        mainPanel.add(pinkBloon,Integer.valueOf(1));
        mainPanel.add(purpleBloon,Integer.valueOf(1));
        mainPanel.add(leaveButton,Integer.valueOf(2));

        this.add(mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Bloon Shooter - Easy");
        this.setIconImage(logo.getImage());
        this.setResizable(false);
        this.setSize(1400,800);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == 17) ctrl = true;
        if(e.getKeyCode() == 16) shift = true;
        if(e.getKeyCode() == 81) q = true;
        if(ctrl && shift && q){
            this.dispose();
            new Menu();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == 17) ctrl = false;
        if(e.getKeyCode() == 16) shift = false;
        if(e.getKeyCode() == 81) q = false;
    }
}