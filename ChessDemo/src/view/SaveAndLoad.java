package view;

import controller.ClickController;
import model.*;

import java.io.*;

public class SaveAndLoad {

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
                else if (item instanceof TrapChessComponent){
                    if (item.getChessColor() == ChessColor.RED)
                        elements[i][j] = 17;
                    else
                        elements[i][j] = 18;
                }
                else if (item instanceof DenChessComponent){
                    if (item.getChessColor() == ChessColor.RED)
                        elements[i][j] = 19;
                    else
                        elements[i][j] = 20;
                }
                else if (item instanceof RiverChessComponent){
                    elements[i][j] = 21;
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
        textStr+="\n";
        textStr+=Chessboard.NumberOfRed;
        textStr+="\n";
        textStr+=Chessboard.NumberOfBlue;

        saveFile(textStr,filePath);
    }


    public static void load(String filePath){
        Chessboard.NumberOfRed = 0;
        Chessboard.NumberOfBlue = 0;
        String rows;
        String[] row;
        try {String s = readFile(filePath);
            String[] split = s.split("\n");
                if(split[9].equals("RED")){Chessboard.currentColor=ChessColor.RED;}
                if(split[9].equals("BLUE")){Chessboard.currentColor=ChessColor.BLUE;}
                ClickController.Round = Float.parseFloat(split[10]);
                Chessboard.NumberOfRed = (int)(Float.parseFloat(split[11]));
            Chessboard.NumberOfBlue = (int)(Float.parseFloat(split[12]));
                ChessGameFrame.chessboard.initiateEmptyChessboard();
                for (int i=0;i<9;i++){
                    rows = split[i];
                    row = rows.split(" ");
                    for (int j=0;j<7;j++){
                        int data = Integer.parseInt(row[j]);
                        if (data==1)
                        {ChessGameFrame.chessboard.getChessComponents()[i][j].setVisible(false);
                        ChessGameFrame.chessboard.initElephantOnBoard(i,j,ChessColor.RED);
                        }
                        else if (data==2)
                        {ChessGameFrame.chessboard.getChessComponents()[i][j].setVisible(false);
                            ChessGameFrame.chessboard.initElephantOnBoard(i,j,ChessColor.BLUE);
                         }
                        else if (data==3)
                        {ChessGameFrame.chessboard.getChessComponents()[i][j].setVisible(false);
                            ChessGameFrame.chessboard.initLionOnBoard(i,j,ChessColor.RED);
                           }
                        else if (data==4)
                        {ChessGameFrame.chessboard.getChessComponents()[i][j].setVisible(false);
                            ChessGameFrame.chessboard.initLionOnBoard(i,j,ChessColor.BLUE);
                           ;
                        }
                        else if (data==5)
                        {ChessGameFrame.chessboard.getChessComponents()[i][j].setVisible(false);
                            ChessGameFrame.chessboard.initTigerOnBoard(i,j,ChessColor.RED);
                          }
                        else if (data==6)
                        {ChessGameFrame.chessboard.getChessComponents()[i][j].setVisible(false);
                            ChessGameFrame.chessboard.initTigerOnBoard(i,j,ChessColor.BLUE);
                        }
                        else if (data==7)
                        {ChessGameFrame.chessboard.getChessComponents()[i][j].setVisible(false);
                            ChessGameFrame.chessboard.initLeopardOnBoard(i,j,ChessColor.RED);
                          }
                        else if (data==8)
                        {ChessGameFrame.chessboard.getChessComponents()[i][j].setVisible(false);
                            ChessGameFrame.chessboard.initLeopardOnBoard(i,j,ChessColor.BLUE);
                          }
                        else if (data==9)
                        {ChessGameFrame.chessboard.getChessComponents()[i][j].setVisible(false);
                            ChessGameFrame.chessboard.initWolfOnBoard(i,j,ChessColor.RED);
                      }
                        else if (data==10)
                        {ChessGameFrame.chessboard.getChessComponents()[i][j].setVisible(false);
                            ChessGameFrame.chessboard.initWolfOnBoard(i,j,ChessColor.BLUE);
                           }
                        else if (data==11)
                        {ChessGameFrame.chessboard.getChessComponents()[i][j].setVisible(false);
                            ChessGameFrame.chessboard.initDogOnBoard(i,j,ChessColor.RED);
                        }
                        else if (data==12)
                        {ChessGameFrame.chessboard.getChessComponents()[i][j].setVisible(false);
                            ChessGameFrame.chessboard.initDogOnBoard(i,j,ChessColor.BLUE);
                         }
                        else if (data==13)
                        {ChessGameFrame.chessboard.getChessComponents()[i][j].setVisible(false);
                            ChessGameFrame.chessboard.initCatOnBoard(i,j,ChessColor.RED);
                          }
                        else if (data==14)
                        {ChessGameFrame.chessboard.getChessComponents()[i][j].setVisible(false);
                            ChessGameFrame.chessboard.initCatOnBoard(i,j,ChessColor.BLUE);
                        }
                        else if (data==15)
                        {ChessGameFrame.chessboard.getChessComponents()[i][j].setVisible(false);
                            ChessGameFrame.chessboard.initRatOnBoard(i,j,ChessColor.RED);
                         }
                        else if (data==16)
                        {ChessGameFrame.chessboard.getChessComponents()[i][j].setVisible(false);
                            ChessGameFrame.chessboard.initRatOnBoard(i,j,ChessColor.BLUE);
                         }
                        else if (data==17)
                        {ChessGameFrame.chessboard.getChessComponents()[i][j].setVisible(false);
                            ChessGameFrame.chessboard.initTrapOnBoard(i,j,ChessColor.RED);
                       }
                        else if (data==18)
                        {ChessGameFrame.chessboard.getChessComponents()[i][j].setVisible(false);
                            ChessGameFrame.chessboard.initTrapOnBoard(i,j,ChessColor.BLUE);
                         }
                        else if (data==19)
                        {ChessGameFrame.chessboard.getChessComponents()[i][j].setVisible(false);
                            ChessGameFrame.chessboard.initDenOnBoard(i,j,ChessColor.RED);
                         }
                        else if (data==20)
                        {ChessGameFrame.chessboard.getChessComponents()[i][j].setVisible(false);
                            ChessGameFrame.chessboard.initDenOnBoard(i,j,ChessColor.BLUE);
                         }
                        else if(data==21)
                        {ChessGameFrame.chessboard.getChessComponents()[i][j].setVisible(false);
                            ChessGameFrame.chessboard.initRiverOnBoard(i,j);}
                    }
                }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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
