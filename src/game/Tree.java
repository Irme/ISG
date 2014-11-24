package game;

import java.util.ArrayList;
import java.util.List;

public class Tree<T> {
    private Node<T> root;

    private ValMove vm = new ValMove();
    
    public Tree(ValMove rootData) {
        root = new Node<T>();
        root.setChildren(new ArrayList<Node<T>>());
    }

    public static class Node<T> {
        private ArrayList<Integer> moves = new ArrayList<Integer>();
        private int [][] state;
        private int score = -10;
        private ValMove valmov = new ValMove();
        private ArrayList<Node<T>> children = new ArrayList<Node<T>>();
        
        public Node(){
        	
        }
        
        public Node(int [][] state){
        	this.state = state;
        	//this.moves = Board.getAllMoves(state);
        	valmov.setScore(score);
        }
		public List<Node<T>> getChildren() {
			return children;
		}
		public void setChildren(ArrayList<Node<T>> children) {
			this.children = children;
		}
		public void addChild(Node<T> nod){
			this.children.add(nod);
		}
		public ArrayList<Integer> getMoves() {
			return moves;
		}
		public void setMoves(ArrayList<Integer> moves) {
			this.moves = moves;
		}

		public int [][] getState() {
			return state;
		}

		public void setState(int [][] state) {
			this.state = state;
		}

		public int getScore() {
			return valmov.getScore();
		}

		public void setScore(int score) {
			valmov.setScore(score);
		}

		public ValMove getValmov() {
			return valmov;
		}

		public void setValmov(ValMove valmov) {
			this.valmov = valmov;
		}
    }
}