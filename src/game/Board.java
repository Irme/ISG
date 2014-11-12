package game;

import java.util.ArrayList;

public class Board {
	public int sizex = 8;
	public int sizey = 8;
	public static int board [][];
	static ArrayList<Integer> 	moves = new ArrayList<Integer>();
	public static int player = 1;
	static int  coor [] = new int [2];
	public Board(){
		//TODO : constructor
		board = new int [sizey][sizex];
		for (int i = 0; i < sizey; i++){
			for (int j = 0; j < sizex ; j++){
				if(j == 0 || j == 1){
					board [i][j] = 2;
				}else if(j == 6 || j == 7){
					board [i][j] = 1;
				}else {
					board [i][j] = 0;
				}
			}
		}
		//board[0][0] = 5;
	}


	//Return who is finished, zero otherwise
	public int isFinished(){
		if(board [0][0] == 1 || board [1][0] == 1|| board [2][0] == 1 || board [3][0] == 1|| board [4][0] == 1|| board [5][0] == 1|| board [6][0] == 1|| board [7][0] == 1 ){
			return 2;
		}else if ( board [0][7] == 2 || board [1][7] ==  2 || board [2][7] == 2 || board [3][7] == 2 || board [4][7] == 2 || board [5][7] == 2 || board [6][7] == 2 || board [7][7] == 2){
			return 1;
		} else {
			return 0;
		}

	}

	public void printBoard(){
		for(int i = 0; i < sizey; i++){
			for(int j = 0; j < sizex; j++ ){
				System.out.print("[" + board[j][i] + "]");
			}
			System.out.println();
		}
	}

	public static void Move(int x, int y){
		moves.clear();
		if(player == 2){
			System.out.println("Player2");
			System.out.println(x + " " + y);
			if (board[x][y] == 2){
				System.out.println("valid selection");
				if(x >= 2 && y < 7){
					int xnew1 = x - 2;
					int ynew1 = y + 1;
					if (board[xnew1][ynew1] != 2){
						moves.add(xnew1);
						moves.add(ynew1);
					}

				}
				if(x >= 1 && y < 6){
					int xnew2 = x - 1;
					int ynew2 = y + 2;
					if (board[xnew2][ynew2] != 2){
						moves.add(xnew2);
						moves.add(ynew2);
					}

				}
				if(x <= 5 && y < 7){
					int xnew3 = x + 2;
					int ynew3 = y + 1;
					if (board[xnew3][ynew3] != 2){
						moves.add(xnew3);
						moves.add(ynew3);
					}

				}
				if(x <=6  && y < 6){
					int xnew4 = x + 1;
					int ynew4 = y + 2;
					if (board[xnew4][ynew4] != 2){
						moves.add(xnew4);
						moves.add(ynew4);
					}

				}

			}

		} else if (player == 1){ //player == 1
			if (board[x][y] == 1){
				System.out.println("Valid selection player 1 " + x + " " + y );
				if(x >= 2 && y >= 1){
					int xnew5 = x - 2;
					int ynew5 = y - 1;
					System.out.println(xnew5 + " " + ynew5);
					if (board[xnew5][ynew5] != 1){
						moves.add(xnew5);
						moves.add(ynew5);
						
					}
				}
				if(x >= 1 && y >=2){
					int xnew6 = x - 1;
					int ynew6 = y - 2;
					System.out.println(xnew6 + " " + ynew6);
					if (board[xnew6][ynew6] != 1){
						moves.add(xnew6);
						moves.add(ynew6);
					}
				}
				if(x < 6 && y >= 1){
					int xnew7 = x + 2;
					int ynew7 = y - 1;
					System.out.println(xnew7 + " " + ynew7);
					if (board[xnew7][ynew7] != 1){
						moves.add(xnew7);
						moves.add(ynew7);
					}
				}
				if(x <7  && y >= 2){
					int xnew8 = x + 1;
					int ynew8 = y - 2;
					System.out.println(xnew8 + " " + ynew8);
					if (board[xnew8][ynew8] != 1){
						moves.add(xnew8);
						moves.add(ynew8);
					}
				}


			}

		}
					for (Integer i : moves){
					System.out.println(i);
				}

	}

	public static void Moving(int x, int y, int newx, int newy){
		board[newx][newy] = board[x][y];
		board[x][y] = 0;

	}
	//if ()


}
