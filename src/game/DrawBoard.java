package game;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class DrawBoard {
	Board b;
	int FX = 121;
	int FY = 71;
	int coor [] = new int [2];;

	/**
	 * @param args
	 */
	public  void drawB(Graphics g, BufferedImage bk, BufferedImage wk) {

		// TODO Auto-generated method stub
		for (int i = 0; i < 8; i++){
			for(int j = 0; j< 8; j++){
				if (Board.board[j][i] == 1){
					g.drawImage(wk, j*26+FX, i*26+FY, null);
				}else if(Board.board[j][i] == 2){
					g.drawImage(bk, j*26+FX, i*26+FY, null);

				}

			}
		}

	}
	public int[] highlight(int x, int y){
		coor[0] = -10;
		coor[1] = -10;
		x = x - FX;
		y = y - FY;
		for (int i = 0; i < 8; i++){
			if ( x <= ((i+1)*26) &&  x >= i*26){
				coor[0] =i;
			}
			if ( y <= ((i+1)*26) &&  y >= i*26){
				coor[1] =i;
			}
		}
		System.out.println("Coordinates : " +coor[0] + " " + coor[1]);

		return coor;



	}


}
