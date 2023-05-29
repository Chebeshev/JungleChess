package view;


import model.*;
import controller.ClickController;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * 这个类表示面板上的棋盘组件对象
 */
public class Chessboard extends JComponent {
    /**
     * CHESSBOARD_SIZE： 棋盘是8 * 8的
     * <br>
     * BACKGROUND_COLORS: 棋盘的两种背景颜色
     * <br>
     * chessListener：棋盘监听棋子的行动
     * <br>
     * chessboard: 表示8 * 8的棋盘
     * <br>
     * currentColor: 当前行棋方
     */
    private static final int CHESSBOARD_ROW = 9;
    private static final int CHESSBOARD_COL = 7;

    private final ChessComponent[][] chessComponents = new ChessComponent[CHESSBOARD_ROW][CHESSBOARD_COL];
    private ChessColor currentColor = ChessColor.RED;
    //all chessComponents in this chessboard are shared only one model controller
    private final ClickController clickController = new ClickController(this);
    private final int CHESS_SIZE;


    public Chessboard(int width, int height) {
        setLayout(null); // Use absolute layout.
        setSize(width, height);
        CHESS_SIZE = width / 9;
        System.out.printf("chessboard size = %d, chess size = %d\n", width, CHESS_SIZE);

        initiateEmptyChessboard();

        // FIXME: Initialize chessboard for testing only.
        initElephantOnBoard(2, 6, ChessColor.RED);
        initElephantOnBoard(6, 0, ChessColor.BLUE);
        initLionOnBoard(0,0,ChessColor.RED);
        initLionOnBoard(8,6,ChessColor.BLUE);
        initTigerOnBoard(0,6,ChessColor.RED);
        initTigerOnBoard(8,0,ChessColor.BLUE);
        initLeopardOnBoard(2,2,ChessColor.RED);
        initLeopardOnBoard(6,4,ChessColor.BLUE);
        initWolfOnBoard(2,4,ChessColor.RED);
        initWolfOnBoard(6,2,ChessColor.BLUE);
        initDogOnBoard(1,1,ChessColor.RED);
        initDogOnBoard(7,5,ChessColor.BLUE);
        initCatOnBoard(1,5,ChessColor.RED);
        initCatOnBoard(7,1,ChessColor.BLUE);
        initRatOnBoard(2,0,ChessColor.RED);
        initRatOnBoard(6,6,ChessColor.BLUE);
        initRiverOnBoard(3,1);
        initRiverOnBoard(3,2);
        initRiverOnBoard(4,1);
        initRiverOnBoard(4,2);
        initRiverOnBoard(5,1);
        initRiverOnBoard(5,2);
        initRiverOnBoard(3,4);
        initRiverOnBoard(3,5);
        initRiverOnBoard(4,4);
        initRiverOnBoard(4,5);
        initRiverOnBoard(5,4);
        initRiverOnBoard(5,5);
    }

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }

    public ChessColor getCurrentColor() {
        return currentColor;
    }

    public void putChessOnBoard(ChessComponent chessComponent) {
        int row = chessComponent.getChessboardPoint().getX(), col = chessComponent.getChessboardPoint().getY();

        if (chessComponents[row][col] != null) {
            remove(chessComponents[row][col]);
        }
        add(chessComponents[row][col] = chessComponent);
    }

    public void swapChessComponents(ChessComponent chess1, ChessComponent chess2) {
        // Note that chess1 has higher priority, 'destroys' chess2 if exists.
        if (!(chess2 instanceof EmptySlotComponent)) {
            remove(chess2);
            add(chess2 = new EmptySlotComponent(chess2.getChessboardPoint(), chess2.getLocation(), clickController, CHESS_SIZE));
        }
        chess1.swapLocation(chess2);
        int row1 = chess1.getChessboardPoint().getX(), col1 = chess1.getChessboardPoint().getY();
        chessComponents[row1][col1] = chess1;
        int row2 = chess2.getChessboardPoint().getX(), col2 = chess2.getChessboardPoint().getY();
        chessComponents[row2][col2] = chess2;

        chess1.repaint();
        chess2.repaint();
    }

    public void initiateEmptyChessboard() {
        for (int i = 0; i < chessComponents.length; i++) {
            for (int j = 0; j < chessComponents[i].length; j++) {
                putChessOnBoard(new EmptySlotComponent(new ChessboardPoint(i, j), calculatePoint(i, j), clickController, CHESS_SIZE));
            }
        }
    }

    public void swapColor() {
        currentColor = currentColor == ChessColor.RED ? ChessColor.BLUE : ChessColor.RED;
    }

    private void initElephantOnBoard(int row, int col, ChessColor color) {
        ChessComponent chessComponent = new ElephantChessComponent(new ChessboardPoint(row, col), calculatePoint(row, col), color, clickController, CHESS_SIZE);
        chessComponent.setVisible(true);
        putChessOnBoard(chessComponent);
    }

    private void initLionOnBoard(int row, int col, ChessColor color) {
        ChessComponent chessComponent = new LionChessComponent(new ChessboardPoint(row, col), calculatePoint(row, col), color, clickController, CHESS_SIZE);
        chessComponent.setVisible(true);
        putChessOnBoard(chessComponent);
    }

    private void initTigerOnBoard(int row, int col, ChessColor color) {
        ChessComponent chessComponent = new TigerChessComponent(new ChessboardPoint(row, col), calculatePoint(row, col), color, clickController, CHESS_SIZE);
        chessComponent.setVisible(true);
        putChessOnBoard(chessComponent);
    }

    private void initLeopardOnBoard(int row, int col, ChessColor color) {
        ChessComponent chessComponent = new LeopardChessComponent(new ChessboardPoint(row, col), calculatePoint(row, col), color, clickController, CHESS_SIZE);
        chessComponent.setVisible(true);
        putChessOnBoard(chessComponent);
    }

    private void initWolfOnBoard(int row, int col, ChessColor color) {
        ChessComponent chessComponent = new WolfChessComponent(new ChessboardPoint(row, col), calculatePoint(row, col), color, clickController, CHESS_SIZE);
        chessComponent.setVisible(true);
        putChessOnBoard(chessComponent);
    }

    private void initDogOnBoard(int row, int col, ChessColor color) {
        ChessComponent chessComponent = new DogChessComponent(new ChessboardPoint(row, col), calculatePoint(row, col), color, clickController, CHESS_SIZE);
        chessComponent.setVisible(true);
        putChessOnBoard(chessComponent);
    }

    private void initCatOnBoard(int row, int col, ChessColor color) {
        ChessComponent chessComponent = new CatChessComponent(new ChessboardPoint(row, col), calculatePoint(row, col), color, clickController, CHESS_SIZE);
        chessComponent.setVisible(true);
        putChessOnBoard(chessComponent);
    }

    private void initRatOnBoard(int row, int col, ChessColor color) {
        ChessComponent chessComponent = new RatChessComponent(new ChessboardPoint(row, col), calculatePoint(row, col), color, clickController, CHESS_SIZE);
        chessComponent.setVisible(true);
        putChessOnBoard(chessComponent);
    }

    private void initRiverOnBoard(int row, int col) {
        ChessComponent chessComponent = new RiverChessComponent(new ChessboardPoint(row, col), calculatePoint(row, col), clickController, CHESS_SIZE);
        chessComponent.setVisible(true);
        putChessOnBoard(chessComponent);
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    }


    private Point calculatePoint(int row, int col) {
        return new Point(col * CHESS_SIZE, row * CHESS_SIZE);
    }

    public void loadGame(List<String> chessData) {
        chessData.forEach(System.out::println);
    }
}
