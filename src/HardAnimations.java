import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;
public class HardAnimations extends HardMode{
    Thread cloudAnimation = new Thread(() -> {
        int cloudX = cloud.getX();
        int cloudY = cloud.getY();
        boolean checked = true;
        while (hearths != 0){
            cloud.setLocation(cloudX, cloudY);
            if (checked) {
                cloudX ++;
            }else {
                cloudX --;
            }
            if(cloudX >= 1200){
                checked = false;
                cloudX = cloud.getX();
            }
            if(cloudX <= 0){
                checked = true;
            }
            try{
                Thread.sleep(20);
            }catch (Exception e){
                System.out.println("Exception 1");
            }
        }
    });
    Thread cloudAnimation2 = new Thread(() -> {
        int cloudX = cloud2.getX();
        int cloudY = cloud2.getY();
        boolean checked = true;
        while (hearths != 0){
            cloud2.setLocation(cloudX, cloudY);
            if (checked) {
                cloudX ++;
            }else {
                cloudX --;
            }
            if(cloudX >= 1200){
                checked = false;
                cloudX = cloud2.getX();
            }
            if(cloudX <= 0){
                checked = true;
            }
            try{
                Thread.sleep(20);
            }catch (Exception e){
                System.out.println("Exception 1");
            }
        }
    });
    Thread redBloonAnimation = new Thread(() -> {
        int BloonX = redBloon.getX();
        int BloonY = redBloon.getY();
        int BloonYBorderUP = BloonY - 30;
        int BloonYBorderDOWN = BloonY + 30;
        int direction = 1;
        while (hearths != 0) {
            redBloon.setLocation(BloonX, BloonY);
            BloonX = BloonX + BloonSpeed;
                if (direction == 1) {
                    BloonY--;
                    if (BloonY == BloonYBorderUP)
                        direction = -1;
                } else if (direction == -1) {
                    BloonY++;
                    if (BloonY == BloonYBorderDOWN)
                        direction = 1;
                }

            if (BloonX >= 1400) {
                BloonX = -100;
                BloonY = rand.nextInt(500);
                BloonYBorderUP = BloonY - 30;
                BloonYBorderDOWN = BloonY + 30;
                hearths--;
                lifes.setText("" + hearths);
            } else if (!redBloon.isVisible()) {
                BloonX = -100;
                BloonY = rand.nextInt(500);
                BloonYBorderUP = BloonY - 20;
                BloonYBorderDOWN = BloonY + 20;
                BloonsShooted++;
                redBloon.setVisible(true);
                redBloon.setText("1");
            }

            if (BloonX >= cloud.getX() && BloonX - 10 <= cloud.getX() + 190 && BloonY >= cloud.getY() - 50 && BloonY <= cloud.getY() + 90) {
                redBloon.setEnabled(false);
            } else if (BloonX >= cloud2.getX() + 10 && BloonX - 10 <= cloud2.getX() + 190 && BloonY >= cloud2.getY() - 50 && BloonY <= cloud2.getY() + 90) {
                redBloon.setEnabled(false);
            } else if (BloonX >= tree.getX()-20 && BloonX <= tree.getX()-20+190 && BloonY >= tree.getY()-20 && BloonY <= 600){
                redBloon.setEnabled(false);
            }else redBloon.setEnabled(BloonX < tree2.getX() - 20 || BloonX > tree2.getX() - 20 + 190 || BloonY < tree2.getY() - 20 || BloonY > 600);
            try {
                Thread.sleep(10);
            } catch (Exception e) {
                System.out.println("Exception 3");
            }

            healUpgrade.setEnabled(gold >= 100);
            if (gold >= 50 && demageUpgrade.getIcon() == woodenUpgrade) {
                demageUpgrade.setEnabled(true);
            } else if (gold >= 100 && demageUpgrade.getIcon() == ironUpgrade) {
                demageUpgrade.setEnabled(true);
            } else if (gold >= 150 && demageUpgrade.getIcon() == diamondUpgrade) {
                demageUpgrade.setEnabled(true);
            } else if (demageUpgrade.getIcon() == finalUpgrade) {
                demageUpgrade.setEnabled(true);
            }

            if (hearths < 1) {
                lifes.setText("0");
            }
        }
    });
    Thread greenBloonAnimation = new Thread(() -> {
        int BloonX = greenBloon.getX();
        int BloonY = greenBloon.getY();
        int BloonYBorderUP = BloonY-20;
        int BloonYBorderDOWN = BloonY+20;
        int direction = 1;
        while (hearths != 0) {
            greenBloon.setLocation(BloonX, BloonY);
            BloonX = BloonX - BloonSpeed;
            if (direction == 1) {
                BloonY--;
                if (BloonY == BloonYBorderUP)
                    direction = -1;
            } else if (direction == -1) {
                BloonY++;
                if (BloonY == BloonYBorderDOWN)
                    direction = 1;
            }

            if(BloonX <=- 70){
                BloonX = 1450;
                BloonY = rand.nextInt(500);
                BloonYBorderUP = BloonY - 30;
                BloonYBorderDOWN = BloonY + 30;
                greenBloon.setText(""+greenLifes);
                greenLifes=3;
                hearths--;
                lifes.setText(""+hearths);
                if(hearths < 1){
                    hearths = 0;
                    lifes.setText(""+hearths);
                }
            } else if(!greenBloon.isVisible()){
                BloonX = 1450;
                BloonY = rand.nextInt(500);
                BloonYBorderUP = BloonY - 30;
                BloonYBorderDOWN = BloonY + 30;
                BloonsShooted++;
                greenBloon.setVisible(true);
                greenBloon.setText(""+greenLifes);
            }

            if (BloonX >= cloud.getX() && BloonX - 10 <= cloud.getX() + 190 && BloonY >= cloud.getY() - 50 && BloonY <= cloud.getY() + 90) {
                greenBloon.setEnabled(false);
            } else if (BloonX >= cloud2.getX() + 10 && BloonX - 10 <= cloud2.getX() + 190 && BloonY >= cloud2.getY() - 50 && BloonY <= cloud2.getY() + 90) {
                greenBloon.setEnabled(false);
            } else if (BloonX >= tree.getX()-20 && BloonX <= tree.getX()-20+190 && BloonY >= tree.getY()-20 && BloonY <= 600){
                greenBloon.setEnabled(false);
            }else greenBloon.setEnabled(BloonX < tree2.getX() - 20 || BloonX > tree2.getX() - 20 + 190 || BloonY < tree2.getY() - 20 || BloonY > 600);
            try{
                Thread.sleep(40);
            }catch (Exception e){
                System.out.println("Exception 3");
            }
            if(hearths < 1){
                lifes.setText("0");
            }
        }
    });
    Thread yellowBloonAnimation = new Thread(() -> {
        int BloonX = yellowBloon.getX();
        int BloonY = yellowBloon.getY();
        int BloonYBorderUP = BloonY-20;
        int BloonYBorderDOWN = BloonY+20;
        int direction = 1;
        while( hearths != 0) {
            yellowBloon.setLocation(BloonX, BloonY);
            BloonX = BloonX + BloonSpeed;
            if (direction == 1) {
                BloonY--;
                if (BloonY == BloonYBorderUP)
                    direction = -1;
            } else if (direction == -1) {
                BloonY++;
                if (BloonY == BloonYBorderDOWN)
                    direction = 1;
            }

            if(BloonX >= 1400){
                BloonX = -100;
                BloonY = rand.nextInt(500);
                BloonYBorderUP = BloonY - 30;
                BloonYBorderDOWN = BloonY + 30;
                yellowBloon.setText(""+yellowLifes);
                yellowLifes=6;
                hearths--;
                lifes.setText(""+hearths);
                if(hearths < 1){
                    hearths=0;
                    lifes.setText(""+hearths);
                }
            } else if(!yellowBloon.isVisible()){
                BloonX = -100;
                BloonY = rand.nextInt(500);
                BloonYBorderUP = BloonY - 30;
                BloonYBorderDOWN = BloonY + 30;
                BloonsShooted++;
                yellowBloon.setVisible(true);
                yellowBloon.setText(""+yellowLifes);
            }

            if (BloonX >= cloud.getX() && BloonX - 10 <= cloud.getX() + 190 && BloonY >= cloud.getY() - 50 && BloonY <= cloud.getY() + 90) {
                yellowBloon.setEnabled(false);
            } else if (BloonX >= cloud2.getX() + 10 && BloonX - 10 <= cloud2.getX() + 190 && BloonY >= cloud2.getY() - 50 && BloonY <= cloud2.getY() + 90) {
                yellowBloon.setEnabled(false);
            } else if (BloonX >= tree.getX()-20 && BloonX <= tree.getX()-20+190 && BloonY >= tree.getY()-20 && BloonY <= 600){
                yellowBloon.setEnabled(false);
            }else yellowBloon.setEnabled(BloonX < tree2.getX() - 20 || BloonX > tree2.getX() - 20 + 190 || BloonY < tree2.getY() - 20 || BloonY > 600);
            try{
                Thread.sleep(30);
            }catch (Exception e){
                System.out.println("Exception 3");
            }
            if(hearths < 1){
                lifes.setText("0");
            }
        }
    });
    Thread pinkBloonAnimation = new Thread(() -> {
        int BloonX = pinkBloon.getX();
        int BloonY = pinkBloon.getY();
        int BloonYBorderUP = BloonY-20;
        int BloonYBorderDOWN = BloonY+20;
        int direction = 1;
        while (hearths != 0) {
            pinkBloon.setLocation(BloonX, BloonY);
            BloonX = BloonX + BloonSpeed;
            if (direction == 1) {
                BloonY--;
                if (BloonY == BloonYBorderUP)
                    direction = -1;
            } else if (direction == -1) {
                BloonY++;
                if (BloonY == BloonYBorderDOWN)
                    direction = 1;
            }

            if(BloonX >= 1400){
                BloonX = -100;
                BloonY = rand.nextInt(500);
                BloonYBorderUP = BloonY - 30;
                BloonYBorderDOWN = BloonY + 30;
                pinkBloon.setText(""+pinkLifes);
                pinkLifes=9;
                hearths--;
                lifes.setText(""+hearths);
                if(hearths < 1){
                    hearths = 0;
                    lifes.setText(""+hearths);
                }
            } else if(!pinkBloon.isVisible()){
                BloonX = -100;
                BloonY = rand.nextInt(500);
                BloonYBorderUP = BloonY - 30;
                BloonYBorderDOWN = BloonY + 30;
                BloonsShooted++;
                pinkBloon.setVisible(true);
                pinkBloon.setText(""+pinkLifes);
            }

            if (BloonX >= cloud.getX() && BloonX - 10 <= cloud.getX() + 190 && BloonY >= cloud.getY() - 50 && BloonY <= cloud.getY() + 90) {
                pinkBloon.setEnabled(false);
            } else if (BloonX >= cloud2.getX() + 10 && BloonX - 10 <= cloud2.getX() + 190 && BloonY >= cloud2.getY() - 50 && BloonY <= cloud2.getY() + 90) {
                pinkBloon.setEnabled(false);
            } else if (BloonX >= tree.getX()-20 && BloonX <= tree.getX()-20+190 && BloonY >= tree.getY()-20 && BloonY <= 600){
                pinkBloon.setEnabled(false);
            }else pinkBloon.setEnabled(BloonX < tree2.getX() - 20 || BloonX > tree2.getX() - 20 + 190 || BloonY < tree2.getY() - 20 || BloonY > 600);
            try{
                Thread.sleep(40);
            }catch (Exception e){
                System.out.println("Exception 3");
            }
            if(hearths < 1){
                lifes.setText("0");
            }
        }
    });
    Thread purpleBloonAnimation = new Thread(() -> {
        int BloonX = purpleBloon.getX();
        int BloonY = purpleBloon.getY();
        int BloonYBorderUP = BloonY-20;
        int BloonYBorderDOWN = BloonY+20;
        int direction = 1;
        while (hearths != 0) {
            purpleBloon.setLocation(BloonX, BloonY);
            BloonX = BloonX - BloonSpeed;
            if (direction == 1) {
                BloonY--;
                if (BloonY == BloonYBorderUP)
                    direction = -1;
            } else if (direction == -1) {
                BloonY++;
                if (BloonY == BloonYBorderDOWN)
                    direction = 1;
            }

            if(BloonX <=- 70){
                BloonX = 1450;
                BloonY = rand.nextInt(500);
                BloonYBorderUP = BloonY - 30;
                BloonYBorderDOWN = BloonY + 30;
                purpleBloon.setText(""+purpleLifes);
                purpleLifes=12;
                hearths--;
                lifes.setText(""+hearths);
                if(hearths < 1){
                    lifes.setText(""+hearths);
                    hearths = 0;
                }
            } else if(!purpleBloon.isVisible()){
                BloonX = 1450;
                BloonY = rand.nextInt(500);
                BloonYBorderUP = BloonY - 30;
                BloonYBorderDOWN = BloonY + 30;
                BloonsShooted++;
                purpleBloon.setVisible(true);
                purpleBloon.setText(""+purpleLifes);
            }

            if (BloonX >= cloud.getX() && BloonX - 10 <= cloud.getX() + 190 && BloonY >= cloud.getY() - 50 && BloonY <= cloud.getY() + 90) {
                purpleBloon.setEnabled(false);
            } else if (BloonX >= cloud2.getX() + 10 && BloonX - 10 <= cloud2.getX() + 190 && BloonY >= cloud2.getY() - 50 && BloonY <= cloud2.getY() + 90) {
                purpleBloon.setEnabled(false);
            } else if (BloonX >= tree.getX()-20 && BloonX <= tree.getX()-20+190 && BloonY >= tree.getY()-20 && BloonY <= 600){
                purpleBloon.setEnabled(false);
            }else purpleBloon.setEnabled(BloonX < tree2.getX() - 20 || BloonX > tree2.getX() - 20 + 190 || BloonY < tree2.getY() - 20 || BloonY > 600);
            try{
                Thread.sleep(40);
            }catch (Exception e){
                System.out.println("Exception 3");
            }
            if(hearths < 1){
                lifes.setText("0");
            }
        }
    });
    Thread startAnimation = new Thread(() -> {
        int counter = 3;
        while (counter != -1){
            countingDown.setText(""+counter);
            counter--;
            if(counter == -1)
                countingDown.setText("go");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        countingDown.setText("");
    });
    Thread stopwatchAnimation = new Thread(() ->{
        int min = 0;
        int sec = 0;
        while (hearths != 0){
            sec++;
            if(sec == 60){
                sec = 0;
                min++;
            }
            if(sec%10==0){
                BloonSpeed = BloonSpeed + 1;
            }
            String stringMin = String.format("%02d",min);
            String stringSec = String.format("%02d",sec);
            stopwatch.setText(stringMin+":"+stringSec);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        finalResult = (BloonsShooted*2000)/((min*60)+sec);
        System.out.println(finalResult);
        this.dispose();
        new EndingScreen();
    });
    public void baseAnimations() {
        cloudAnimation.start();
        cloudAnimation2.start();
    }
    public void bloonsAnimations() {
        startAnimation.start();
        new Timer().schedule(
                new TimerTask() {
                    @Override
                    public void run() {
                        try {
                            stopwatchAnimation.start();
                            redBloonAnimation.start();
                            Thread.sleep(5000);
                            greenBloonAnimation.start();
                            Thread.sleep(5000);
                            yellowBloonAnimation.start();
                            Thread.sleep(5000);
                            pinkBloonAnimation.start();
                            Thread.sleep(5000);
                            purpleBloonAnimation.start();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                },4000
        );
    }
}
