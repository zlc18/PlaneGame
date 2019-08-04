package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author zengluchuan
 * @date 2019/7/16 - 17:26
 * 飞机游戏主窗口
 */
public class MyGameFrame extends JFrame {
    Image plane=GameUtil.getImage("image/plane.png");
    Image background=GameUtil.getImage("image/background.jpg");
    int planeX=250,planeY =250;

    @Override
    public void paint(Graphics g) {//自动被调用，g相当于一只画笔
        g.drawImage(background,0,0,null);
        g.drawImage(plane,planeX,planeY,null);
        planeX++;
    }
//    帮助我们反复重画窗口
    class PaintThread extends Thread{
        @Override
        public void run() {
            while (true){
                System.out.println("paint window once");
                repaint();//重画
                try {
                    Thread.sleep(40);//1s=1000ms
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    /**
     * 初始化窗口
     */


    public void lunchFrame(){
        this.setTitle("ncu_zengluchuan_project");
        this.setVisible(true);
        this.setSize(500,500);
        this.setLocation(300,300);

        this.addWindowFocusListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });
        new PaintThread().start();
    }

    public static void main(String[] args) {
        MyGameFrame f=new MyGameFrame();
        f.lunchFrame();
    }

}

