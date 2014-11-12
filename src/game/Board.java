package game;

import java.util.ArrayList;

public class Board {
	public int sizex = 8;
	public int sizey = 8;
	public static int board [][];
	static ArrayList<Integer> 	moves = new ArrayList<Integer>();
	public static int player = 1;
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
		int xnew, ynew;
		int sel = 0;
		if(player == 2){
			System.out.println("Player2");
			System.out.println(x + " " + y);
			if (board[x][y] == 2){
				System.out.println("valid selection");
				if(x >= 2 && y < 7){
					xnew = x - 2;
					ynew = y + 1;
					if (board[xnew][ynew] != 2){
						moves.add(xnew);
						moves.add(ynew);
					}

				}
				if(x >= 1 && y < 6){
					xnew = x - 1;
					ynew = y + 2;
					if (board[xnew][ynew] != 2){
						moves.add(xnew);
						moves.add(ynew);
					}

				}
				if(x <= 5 && y < 7){
					xnew = x + 2;
					ynew = y + 1;
					if (board[xnew][ynew] != 2){
						moves.add(xnew);
						moves.add(ynew);
					}

				}
				if(x <=6  && y < 6){
					xnew = x + 1;
					ynew = y + 2;
					if (board[xnew][ynew] != 2){
						moves.add(xnew);
						moves.add(ynew);
					}

				}

			}

		} else{ //player == 1
			if (board[x][y] == 1){
				System.out.println("Valid selection player 1");
				if(x >= 2 && y >= 1){
					xnew = x - 2;
					ynew = y - 1;
					if (board[xnew][ynew] != 1){
						moves.add(xnew);
						moves.add(ynew);
					}
				}
				if(x >= 1 && y >=2){
					xnew = x - 1;
					ynew = y - 2;
					if (board[xnew][ynew] != 1){
						moves.add(xnew);
						moves.add(ynew);
					}
				}
				if(x < 6 && y >= 1){
					xnew = x + 2;
					ynew = y - 1;
					if (board[xnew][ynew] != 1){
						moves.add(xnew);
						moves.add(ynew);
					}
				}
				if(x <7  && y >= 2){
					xnew = x + 1;
					ynew = y - 2;
					if (board[xnew][ynew] != 1){
						moves.add(xnew);
						moves.add(ynew);
					}
				}


			}

		}for (Integer i : moves){
			System.out.println(i);
		}

	}

	public static void Moving(int x, int y, int newx, int newy){
		board[newx][newy] = board[x][y];
		board[x][y] = 0;
		
	}
	//if ()


}
