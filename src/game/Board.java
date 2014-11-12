package game;

import java.util.ArrayList;

public class Board {
	public int sizex = 8;
	public int sizey = 8;
	public static int board [][];
	static ArrayList<Integer> 	moves = new ArrayList<Integer>();
	public static int player = 2;
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
		if(board [0][0] == 1 || board [0][1] == 1|| board [0][2] == 1 || board [0][3] == 1|| board [0][4] == 1|| board [0][5] == 1|| board [0][6] == 1|| board [0][7] == 1 ){
			return 2;
		}else if ( board [7][0] == 2 || board [7][1] ==  2 || board [7][2] == 2 || board [7][3] == 2 || board [7][4] == 2 || board [7][5] == 2 || board [7][6] == 2 || board [7][7] == 2){
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
		if(player == 2){
			System.out.println("Player2");
			System.out.println(x + " " + y);
			if (board[y][x] == 2){
				System.out.println("valid selection");
				if(x >= 2 && y >= 1){
					xnew = x - 2;
					ynew = y - 1;
					if (board[ynew][xnew] != 2){
						moves.add(xnew);
						moves.add(ynew);
					}
					
				}
				if(x >= 1 && y >= 2){
					xnew = x - 1;
					ynew = y - 2;
					if (board[ynew][xnew] != 2){
						moves.add(xnew);
						moves.add(ynew);
					}
					
				}
				if(x <= 5 && y >= 1){
					xnew = x + 2;
					ynew = y - 1;
					if (board[ynew][xnew] != 2){
						moves.add(xnew);
						moves.add(ynew);
					}
					
				}
				if(x <=6  && y >= 2){
					xnew = x + 1;
					ynew = y - 2;
					if (board[ynew][xnew] != 2){
						moves.add(xnew);
						moves.add(ynew);
					}
					
				}
				
			}

		} else{ //player == 1
			if (board[y][x] == 1){
				System.out.println("Valid selection player 1");
				if(x >= 2 && y < 7){
					xnew = x - 2;
					ynew = y + 1;
					if (board[ynew][xnew] != 1){
						moves.add(xnew);
						moves.add(ynew);
					}
				}
				if(x >= 1 && y < 6){
					xnew = x - 1;
					ynew = y + 2;
					if (board[ynew][xnew] != 1){
						moves.add(xnew);
						moves.add(ynew);
					}
				}
				if(x < 6 && y < 7){
					xnew = x + 2;
					ynew = y + 1;
					if (board[ynew][xnew] != 1){
						moves.add(xnew);
						moves.add(ynew);
					}
				}
				if(x <7  && y < 6){
					xnew = x + 1;
					ynew = y + 2;
					if (board[ynew][xnew] != 1){
						moves.add(xnew);
						moves.add(ynew);
					}
				}
				
				
			}

		}for (Integer i : moves){
			System.out.println(i);
		}

	}
	
}
