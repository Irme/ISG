package game;

import java.util.ArrayList;
import java.util.List;

public class Tree<T> {
    private Node<T> root;

    public Tree(ArrayList<Integer> rootData) {
        root = new Node<T>();
        root.setMoves(rootData);
        root.setChildren(new ArrayList<Node<T>>());
    }

    public static class Node<T> {
        private ArrayList<Integer> moves = new ArrayList<Integer>();
        private int [][] state;
        private int score;
        private ArrayList<Node<T>> children = new ArrayList<Node<T>>();
        
        public Node(){
        	
        }
        
        public Node(int [][] state){
        	this.state = state;
        	this.moves = Board.getAllMoves(state);
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
    }
}