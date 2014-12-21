package game;

import java.util.Arrays;
public class State extends Object {
	
	private int [][] board;
	private String st;
	private int depth;
	
	
	/**
	 * @param args
	 */

	public State(int [][] b){
		setBoard(b);
	}
	public boolean equals(Object s){
		int [][] temp = ((State) s).getBoard();
		String t = toString(temp);
		String t2 = toString(board);
		return t.equals(t2);
	}
	@Override
	public int hashCode(){
		
		return st.hashCode();
	}
	
	public String toString(int b [][]){
		String s = new String();
		for(int i = 0; i < b.length; i++){
			for(int j = 0; j < b.length; j++){
				int t= b[i][j];
				String temp = Integer.toString(t);
				s = s + temp;
			}
		}
		return s;
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
	public int[][] getBoard() {
		return board;
	}
	public void setBoard(int[][] board) {
		this.board = board;
	}
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
}
