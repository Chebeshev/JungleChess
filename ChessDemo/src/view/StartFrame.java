package view;

import controller.GameController;
import model.ChessColor;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 这个类表示游戏过程中的整个游戏界面，是一切的载体
 */
public class StartFrame extends JFrame implements ActionListener {
    //    public final Dimension FRAME_SIZE ;
    private final int WIDTH;
    private final int HEIGTH;
    public final int CHESSBOARD_SIZE;

    public StartFrame(int width, int height) {
        setTitle("2022 CS102A Project Demo"); //设置标题
        this.WIDTH = width;
        this.HEIGTH = height;
        this.CHESSBOARD_SIZE = HEIGTH * 4 / 5;

        setSize(WIDTH, HEIGTH);
        setLocationRelativeTo(null); // Center the window.
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //设置程序关闭按键，如果点击右上方的叉就游戏全部关闭了
        setLayout(null);


        addLabel();
        addStartButton();
    }


    /**
     * 在游戏面板中添加标签
     */
    private void addLabel() {
        JLabel statusLabel = new JLabel("Enjoy yourself~");
        statusLabel.setLocation(100, 120);
        statusLabel.setSize(200, 60);
        statusLabel.setFont(new Font("Rockwell", Font.BOLD, 20));
        add(statusLabel);
    }

    /**
     * 在游戏面板中增加一个按钮，如果按下的话就会显示Hello, world!
     */

    private void addStartButton() {
        JButton button = new JButton("Start");
        button.addActionListener(this);
        button.setLocation(90, 240);
        button.setSize(200, 60);
        button.setActionCommand("start");
        button.setFont(new Font("Rockwell", Font.BOLD, 20));
        add(button);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        String cmd = event.getActionCommand();
        if (cmd.equals("start")) {
            SwingUtilities.invokeLater(() -> {
                ChessGameFrame mainFrame = new ChessGameFrame(1000, 760);
                mainFrame.setVisible(true);
            });
            this.setVisible(false);
        }
    }
}
