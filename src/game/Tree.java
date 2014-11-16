package game;

import java.util.ArrayList;
import java.util.List;

public class Tree<T> {
    private Node<T> root;

    public Tree(int [][] rootData) {
        root = new Node<T>();
        root.setData(rootData);
        root.setChildren(new ArrayList<Node<T>>());
    }

    public static class Node<T> {
        private int [][] data;
        private ArrayList<Node<T>> children = new ArrayList<Node<T>>();
        
        public Node(){
        	
        }
        
        public Node(int [][] data){
        	this.data = data;
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
		public int[][] getData() {
			return data;
		}
		public void setData(int [][] data) {
			this.data = data;
		}
    }
}