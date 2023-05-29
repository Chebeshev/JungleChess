package view;

import controller.ClickController;
import controller.GameController;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 这个类表示游戏过程中的整个游戏界面，是一切的载体
 */
public class ChessGameFrame extends JFrame implements ActionListener {
    //    public final Dimension FRAME_SIZE ;
    private final int WIDTH;
    private final int HEIGTH;
    public final int CHESSBOARD_SIZE;
    private GameController gameController;
    Chessboard chessboard;

    public ChessGameFrame(int width, int height) {
        setTitle("2022 CS102A Project Demo"); //设置标题
        this.WIDTH = width;
        this.HEIGTH = height;
        this.CHESSBOARD_SIZE = HEIGTH * 4 / 5;

        setSize(WIDTH, HEIGTH);
        setLocationRelativeTo(null); // Center the window.
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //设置程序关闭按键，如果点击右上方的叉就游戏全部关闭了
        setLayout(null);


        addChessboard();
        addLabel();
        addHelloButton();
        addSaveButton();
        addLoadButton();
    }


    /**
     * 在游戏面板中添加棋盘
     */
    private void addChessboard() {
        chessboard = new Chessboard(CHESSBOARD_SIZE, CHESSBOARD_SIZE);
        gameController = new GameController(chessboard);
        chessboard.setLocation(HEIGTH / 10, HEIGTH / 10);
        add(chessboard);
    }

    /**
     * 在游戏面板中添加标签
     */
    private void addLabel() {
        JLabel statusLabel = new JLabel("Sample label");
        statusLabel.setLocation(HEIGTH, HEIGTH / 10);
        statusLabel.setSize(200, 60);
        statusLabel.setFont(new Font("Rockwell", Font.BOLD, 20));
        add(statusLabel);
    }

    /**
     * 在游戏面板中增加一个按钮，如果按下的话就会显示Hello, world!
     */

    private void addHelloButton() {
        JButton button = new JButton("Show Hello Here");
        button.addActionListener((e) -> JOptionPane.showMessageDialog(this, "Hello, world!"));
        button.setLocation(HEIGTH, HEIGTH / 10 + 120);
        button.setSize(200, 60);
        button.setFont(new Font("Rockwell", Font.BOLD, 20));
        add(button);
    }

    private void addSaveButton() {
        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(this);
        saveButton.setLocation(760, 400);
        saveButton.setSize(200, 60);
        saveButton.setActionCommand("save");
        saveButton.setFont(new Font("Rockwell", Font.BOLD, 20));
        add(saveButton);
    }

    private void addLoadButton() {
        JButton button = new JButton("Load");
        button.setLocation(HEIGTH, HEIGTH / 10 + 240);
        button.setSize(200, 60);
        button.setFont(new Font("Rockwell", Font.BOLD, 20));
        add(button);

        button.addActionListener(e -> {
            System.out.println("Click load");
            String path = JOptionPane.showInputDialog(this, "Input Path here");
            gameController.loadGameFromFile(path);
        });
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        String cmd = event.getActionCommand();
        if (cmd.equals("withdraw")) {

        } else if (cmd.equals("restart")) {

        } else if (cmd.equals("initialize")) {

        } else if (cmd.equals("save")) {
            JFileChooser fileChooser=new JFileChooser();
            FileNameExtensionFilter filter=new FileNameExtensionFilter("text","txt");
            fileChooser.setFileFilter(filter);
            int returnVal= fileChooser.showOpenDialog(getParent());
            String file="";
            if(returnVal==JFileChooser.APPROVE_OPTION){
                file=fileChooser.getSelectedFile().getName();
                SaveAndLoad.Save(chessboard,file);
            }
        } else if (cmd.equals("load")) {

        }
    }
}
