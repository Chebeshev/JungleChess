package view;

import javax.swing.*;
import java.awt.*;

/**
 * 这个类表示游戏过程中的整个游戏界面，是一切的载体
 */
public class LoadErrorFrame extends JFrame{
    //        public final Dimension FRAME_SIZE ;
    private final int WIDTH;
    private final int HEIGHT;
    JLabel statusLabel = new JLabel("");

    public JLabel getStatusLabel() {
        return statusLabel;
    }

    public LoadErrorFrame(int width, int height) {
        setTitle("Load Error!"); //设置标题
        this.WIDTH = width;
        this.HEIGHT = height;

        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null); // Center the window.
        setLayout(null);

        addLabel();
        addCloseButton();
    }
    private void addLabel() {
        statusLabel.setLocation(5*WIDTH/16, HEIGHT / 13);
        statusLabel.setSize(360, 80);
        statusLabel.setFont(new Font("Rockwell", Font.BOLD, 25));
        add(statusLabel);
    }
    private void addCloseButton(){
        JButton closeButton = new JButton("OK,fine.");
        closeButton.addActionListener(e -> setVisible(false));
        closeButton.setLocation(3*WIDTH/10,HEIGHT/10+160);
        closeButton.setSize(200,60);
        closeButton.setFont(new Font("Rockwell",Font.BOLD,20));
        add(closeButton);
    }
}