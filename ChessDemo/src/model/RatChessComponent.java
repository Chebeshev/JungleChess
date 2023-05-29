package model;

import view.Chessboard;
import view.ChessboardPoint;
import controller.ClickController;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * 这个类表示国际象棋里面的车
 */
public class RatChessComponent extends ChessComponent {
    /**
     * 黑车和白车的图片，static使得其可以被所有车对象共享
     * <br>
     * FIXME: 需要特别注意此处加载的图片是没有背景底色的！！！
     */
    private static Image WHITE;
    private static Image BLACK;
    public int rank = 1;

    /**
     * 车棋子对象自身的图片，是上面两种中的一种
     */
    private Image Image;

    /**
     * 读取加载车棋子的图片
     *
     * @throws IOException
     */
    public void loadResource() throws IOException {
        if (WHITE == null) {
            WHITE = ImageIO.read(new File("./images/BRat.png"));
        }

        if (BLACK == null) {
            BLACK = ImageIO.read(new File("./images/RRat.png"));
        }
    }


    /**
     * 在构造棋子对象的时候，调用此方法以根据颜色确定rookImage的图片是哪一种
     *
     * @param color 棋子颜色
     */

    private void initiateRatImage(ChessColor color) {
        try {
            loadResource();
            if (color == ChessColor.BLUE) {
                Image = WHITE;
            } else if (color == ChessColor.RED) {
                Image = BLACK;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public RatChessComponent(ChessboardPoint chessboardPoint, Point location, ChessColor color, ClickController listener, int size) {
        super(chessboardPoint, location, color, listener, size);
        initiateRatImage(color);
    }

    /**
     * 车棋子的移动规则
     *
     * @param chessComponents 棋盘
     * @param destination     目标位置，如(0, 0), (0, 7)等等
     * @return 车棋子移动的合法性
     */

    @Override
    public boolean canMoveTo(ChessComponent[][] chessComponents, ChessboardPoint destination) {
        ChessboardPoint source = getChessboardPoint();
        if (chessComponents[destination.getX()][destination.getY()] instanceof RiverChessComponent)
            rank = 9;
        boolean flag = false;
        for (int i = 0; i < 12; i++) {
            if (source.getX() == Chessboard.riverRegionRow[i] && source.getY() == Chessboard.riverRegionCol[i]){
                flag = true;
                break;
            }
        }
        if (flag){

        }
        if (chessComponents[destination.getX()][destination.getY()].getRank() == 8)
            return true;
        if (chessComponents[destination.getX()][destination.getY()].getRank() > this.rank)
            return false;
        if (chessComponents[destination.getX()][destination.getY()] instanceof DenChessComponent){
            if ((chessComponents[destination.getX()][destination.getY()]).chessColor == this.chessColor)
                return false;
        }
        if (source.getX() == destination.getX()) {
            if (Math.abs(source.getY() - destination.getY()) == 1)
                return true;
        }
        if (source.getY() == destination.getY()) {
            if (Math.abs(source.getX() - destination.getX()) == 1)
                return true;
        }
        return false;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    /**
     * 注意这个方法，每当窗体受到了形状的变化，或者是通知要进行绘图的时候，就会调用这个方法进行画图。
     *
     * @param g 可以类比于画笔
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
//        g.drawImage(rookImage, 0, 0, getWidth() - 13, getHeight() - 20, this);
        g.drawImage(Image, 0, 0, getWidth() , getHeight(), this);
        g.setColor(Color.BLACK);
        if (isSelected()) { // Highlights the model if selected.
            g.setColor(Color.RED);
            g.drawOval(0, 0, getWidth() , getHeight());
        }
    }
}
