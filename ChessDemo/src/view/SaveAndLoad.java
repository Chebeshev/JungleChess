package view;

import controller.ClickController;
import model.*;

import javax.swing.*;
import java.io.*;

public class SaveAndLoad {
    public static boolean valid=false;

    public static void Save(Chessboard chessboard,String filePath){
        ChessComponent[][] chessComponents = chessboard.getChessComponents();
        int[][] elements = new int[9][7];
        for (int i=0;i<9;i++){
            for (int j=0;j<7;j++){
                ChessComponent item = chessComponents[i][j];
                if (item instanceof EmptySlotComponent)
                    elements[i][j] = 0;
                else if (item instanceof ElephantChessComponent) {
                    if (item.getChessColor() == ChessColor.RED)
                        elements[i][j] = 1;
                    else
                        elements[i][j] = 2;
                }
                else if (item instanceof LionChessComponent){
                    if (item.getChessColor() == ChessColor.RED)
                        elements[i][j] = 3;
                    else
                        elements[i][j] = 4;
                }
                else if (item instanceof TigerChessComponent){
                    if (item.getChessColor() == ChessColor.RED)
                        elements[i][j] = 5;
                    else
                        elements[i][j] = 6;
                }
                else if (item instanceof LeopardChessComponent){
                    if (item.getChessColor() == ChessColor.RED)
                        elements[i][j] = 7;
                    else
                        elements[i][j] = 8;
                }
                else if (item instanceof WolfChessComponent){
                    if (item.getChessColor() == ChessColor.RED)
                        elements[i][j] = 9;
                    else
                        elements[i][j] = 10;
                }
                else if (item instanceof DogChessComponent){
                    if (item.getChessColor() == ChessColor.RED)
                        elements[i][j] = 11;
                    else
                        elements[i][j] = 12;
                }
                else if (item instanceof CatChessComponent){
                    if (item.getChessColor() == ChessColor.RED)
                        elements[i][j] = 13;
                    else
                        elements[i][j] = 14;
                }
                else if (item instanceof RatChessComponent){
                    if (item.getChessColor() == ChessColor.RED)
                        elements[i][j] = 15;
                    else
                        elements[i][j] = 16;
                }
            }
        }

        String textStr = "";
        for (int[] rows : elements) {
            for (int data : rows) {
                textStr = textStr + data + " ";
            }
            textStr += "\n";
        }
        textStr+=Chessboard.currentColor;
        textStr+="\n";
        textStr+=ClickController.Round;
        saveFile(textStr,filePath);
    }


    public static void load(String filePath){

    }




    public static String readFile(String filePath) throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            file.createNewFile();
        }
        InputStream inputStream = new FileInputStream(file);
        byte[] bs = new byte[1024];
        int len = inputStream.read(bs);
        inputStream.close();
        return new String(bs);
    }



    public static void saveFile(String content, String filePath) {
        File file = new File(filePath);
        OutputStream outputStream = null;
        if (!file.exists()) {
            try {
                // 如果文件找不到，就new一个
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            outputStream = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        byte[] bs = content.getBytes();
        try {
            outputStream.write(bs);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
