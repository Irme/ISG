package game;

import java.util.ArrayList;

public class Board {
	public static int sizex = 8;
	public static int sizey = 8;
	public static int board [][];
	static ArrayList<Integer> 	moves = new ArrayList<Integer>();
	ArrayList<Integer> 	moves2 = new ArrayList<Integer>();
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
	public static int isFinished(int [][] board){
		if(board [0][0] == 1 || board [1][0] == 1|| board [2][0] == 1 || board [3][0] == 1|| board [4][0] == 1|| board [5][0] == 1|| board [6][0] == 1|| board [7][0] == 1 ){
			return 2;
		}else if ( board [0][7] == 2 || board [1][7] ==  2 || board [2][7] == 2 || board [3][7] == 2 || board [4][7] == 2 || board [5][7] == 2 || board [6][7] == 2 || board [7][7] == 2){
			return 1;
		} else {
			return 0;
		}

	}

	public static int isAlmostFinished(int [][] board){
		if(board [0][1] == 1 || board [1][1] == 1|| board [2][1] == 1 || board [3][1] == 1|| board [4][1] == 1|| board [5][1] == 1|| board [6][1] == 1|| board [7][1] == 1 ){
			return 2;
		}else if ( board [0][6] == 2 || board [1][6] ==  2 || board [2][6] == 2 || board [3][6] == 2 || board [4][6] == 2 || board [5][6] == 2 || board [6][6] == 2 || board [7][6] == 2){
			return 1;
		} else {
			return 0;
		}

	}


	public static void printBoard(int [][] b){
		for(int i = 0; i < sizey; i++){
			for(int j = 0; j < sizex; j++ ){
				System.out.print("[" + b[j][i] + "]");
			}
			System.out.println();
		}
	}

	public static void Move(int x, int y){
		System.out.println("Moving");
		moves.clear();
		if(player == 2){
			if (board[x][y] == 2){
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
				if(x >= 2 && y >= 1){
					int xnew5 = x - 2;
					int ynew5 = y - 1;
					if (board[xnew5][ynew5] != 1){
						moves.add(xnew5);
						moves.add(ynew5);

					}
				}
				if(x >= 1 && y >=2){
					int xnew6 = x - 1;
					int ynew6 = y - 2;
					if (board[xnew6][ynew6] != 1){
						moves.add(xnew6);
						moves.add(ynew6);
					}
				}
				if(x < 6 && y >= 1){
					int xnew7 = x + 2;
					int ynew7 = y - 1;
					if (board[xnew7][ynew7] != 1){
						moves.add(xnew7);
						moves.add(ynew7);
					}
				}
				if(x <7  && y >= 2){
					int xnew8 = x + 1;
					int ynew8 = y - 2;
					if (board[xnew8][ynew8] != 1){
						moves.add(xnew8);
						moves.add(ynew8);
					}
				}


			}

		}


	}

	public  ArrayList<Integer> Move2 (int b [][], int x, int y, int pl){
		moves2.clear();
		if(pl == 2){
			if (b[x][y] == 2){
				if(x >= 2 && y < 7){
					int xnew1 = x - 2;
					int ynew1 = y + 1;
					if (b[xnew1][ynew1] != 2){
						moves2.add(xnew1);
						moves2.add(ynew1);
					}

				}
				if(x >= 1 && y < 6){
					int xnew2 = x - 1;
					int ynew2 = y + 2;
					if (b[xnew2][ynew2] != 2){
						moves2.add(xnew2);
						moves2.add(ynew2);
					}

				}
				if(x <= 5 && y < 7){
					int xnew3 = x + 2;
					int ynew3 = y + 1;
					if (b[xnew3][ynew3] != 2){
						moves2.add(xnew3);
						moves2.add(ynew3);
					}

				}
				if(x <=6  && y < 6){
					int xnew4 = x + 1;
					int ynew4 = y + 2;
					if (b[xnew4][ynew4] != 2){
						moves2.add(xnew4);
						moves2.add(ynew4);
					}

				}

			}

		} else if (pl == 1){ //player == 1
			if (b[x][y] == 1){
				if(x >= 2 && y >= 1){
					int xnew5 = x - 2;
					int ynew5 = y - 1;
					if (b[xnew5][ynew5] != 1){
						moves2.add(xnew5);
						moves2.add(ynew5);

					}
				}
				if(x >= 1 && y >=2){
					int xnew6 = x - 1;
					int ynew6 = y - 2;
					if (b[xnew6][ynew6] != 1){
						moves2.add(xnew6);
						moves2.add(ynew6);
					}
				}
				if(x < 6 && y >= 1){
					int xnew7 = x + 2;
					int ynew7 = y - 1;
					if (b[xnew7][ynew7] != 1){
						moves2.add(xnew7);
						moves2.add(ynew7);
					}
				}
				if(x <7  && y >= 2){
					int xnew8 = x + 1;
					int ynew8 = y - 2;
					if (b[xnew8][ynew8] != 1){
						moves2.add(xnew8);
						moves2.add(ynew8);
					}
				}


			}

		}
		return moves2;

	}

	public static void Moving(int x, int y, int newx, int newy){
		board[newx][newy] = board[x][y];
		board[x][y] = 0;

	}

	public static int [][] Moving2(int [][] b,int x, int y, int newx, int newy){
		int [][] temp  = clone(b);
		temp[newx][newy] = temp[x][y];
		temp[x][y] = 0;
		return temp;

	}
	public ArrayList<Integer> getAllMoves(int b [][],int pl){
		ArrayList<Integer> allmoves = new ArrayList<Integer>();

		for (int i = 0; i < b.length; i ++ ){
			for (int j = 0; j < b.length; j ++){
				if(b[i][j] == pl){
					ArrayList<Integer> temp = new ArrayList<Integer>();
					temp = Move2(b,i, j, pl);
					for (int k = 0; k < temp.size();k = k+2 ){
						allmoves.add(i);
						allmoves.add(j);
						allmoves.add(temp.get(k));
						allmoves.add(temp.get(k+1));
					}
				}
			}
		}



		return allmoves;
	}

	public static int [][] clone(int [][] b){
		int [][] clone = new int[b.length][b.length];
		for(int i = 0; i < b.length; i++){
			for(int j = 0 ; j < b.length; j ++){
				clone [i][j] = b [i][j];
			}
		}
		return clone;
	}

	/*Orders the moves.
	 * Moves that lead to winning postions or caputres will be checked first.
	 * 
	 */
	public ArrayList<Integer> moveOrdering(int [][] board, int player, ArrayList<Integer> moves){
		ArrayList<Integer> sorted = new ArrayList<Integer>();
		ArrayList<Integer> dontcareabouthese = new ArrayList<Integer>();

		if(player == 1){
			for (int i = 0; i < moves.size(); i = i +4){
				if(moves.get(i+3) == 0){
					sorted.add(moves.get(i));
					sorted.add(moves.get(i+1));
					sorted.add(moves.get(i+2));
					sorted.add(moves.get(i+3));
			
				} else if(board[moves.get(i+2)][moves.get(i+3)] == 2){//Capture
					sorted.add(moves.get(i));
					sorted.add(moves.get(i+1));
					sorted.add(moves.get(i+2));
					sorted.add(moves.get(i+3));
				} else{
					dontcareabouthese.add(moves.get(i));
					dontcareabouthese.add(moves.get(i+1));
					dontcareabouthese.add(moves.get(i+2));
					dontcareabouthese.add(moves.get(i+3));
				}
			}
		} else {
			for (int i = 0; i < moves.size(); i = i +4){
				if(moves.get(i+3) == 7){
					sorted.add(moves.get(i));
					sorted.add(moves.get(i+1));
					sorted.add(moves.get(i+2));
					sorted.add(moves.get(i+3));
			
				} else if(board[moves.get(i+2)][moves.get(i+3)] == 1){//Capture
					sorted.add(moves.get(i));
					sorted.add(moves.get(i+1));
					sorted.add(moves.get(i+2));
					sorted.add(moves.get(i+3));
				} else{
					dontcareabouthese.add(moves.get(i));
					dontcareabouthese.add(moves.get(i+1));
					dontcareabouthese.add(moves.get(i+2));
					dontcareabouthese.add(moves.get(i+3));
				}
				
			}

		}
		sorted.addAll(dontcareabouthese);
		return sorted;

	}

}
