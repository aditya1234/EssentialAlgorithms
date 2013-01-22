package binarysearchtree;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
	Node root;
	
	public BinarySearchTree() {
		root = null;
	}
	
	public Node find(int value) {
		return find(root,value);
	}
	
	public Node findMin() {
		return findMin(root);
	}
	
	public void insert(int value) {
		root = insert (root, value);
	}
	
	public void remove(int value) {
		remove (root, value);
	}
	
	public int lowestCommonAncestor(int node1, int node2) {
		return lowestCommonAncestor(root, node1, node2).getValue();
	}
	
	public Node find ( Node root, int value ) {
	
		if (root == null) {
			return null;
		}
		
		if (root.getValue() == value) {
			return root;
		} else if (root.getValue() > value ) {
			return find(root.getLeft(), value);
		} else {
			return find(root.getRight(), value);
		}
	}
	
	public Node findMax( Node node ) {
		Node currNode = root;
		while (currNode.getRight() != null) {
			currNode = currNode.getRight();
		}
		
		return currNode;
	}
	
	public boolean isEmpty () {
		return (root == null);
	}
	
	public void makeEmpty () {
		root = null; //Garbage collector to work here.
	}
	
	public void printAllDepth() {
		orderPrint(root,"in");
	}
	
	public void printAllBreadth() {
		Queue<Node> q = new LinkedList<Node>();
		
		q.offer(root);
		
		while (!q.isEmpty()) {
			Node n = q.poll();
			
			System.out.println(n.getValue());
			
			if (n.getLeft() != null) {
				q.offer(n.getLeft());
			}
			
			if (n.getRight() != null) {
				q.offer(n.getRight());
			}
		}
		
		while (!q.isEmpty()) {
			System.out.println(q.poll());
		}
	}
	
	public void inOrder() {
		orderPrint(root,"in");
	}
	
	public void postOrder() {
		orderPrint(root,"post");
	}
	
	public void preOrder() {
		orderPrint(root,"pre");
	}
	
	public void printBetween(int v1, int v2) {
		printBetween(root, v1, v2);
	}
	
	public void printBetween(Node node, int v1, int v2) {
		
		if (node == null) 
			return;

		printBetween(node.getLeft(), v1, v2);
		if (node.getValue() >= v1 && node.getValue() <= v2) {
			System.out.println(node.getValue());
		}
		printBetween(node.getRight(),v1,v2);
	}
	
	public boolean isValid() {
		return validate(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	private Node lowestCommonAncestor(Node node, int node1, int node2) {
		Node left, right;
		
		if (node == null) { //Make sure we don't have an empty tree
			return null;
		}
		
		//Compare left nodes
		// -- Left node is not null AND is equivalent to one of the two sought nodes
		if (node.getLeft() != null && 
				(node.getLeft().getValue() == node1 || 
				 node.getLeft().getValue() == node2)) {
			return node;
		}
		
		//Compare right nodes
		if (node.getRight() != null && 
				(node.getRight().getValue() == node1 || 
				 node.getRight().getValue() == node2)) {
			return node;
		}
		
		//Neither left nor right == the child, recursive iteration on both sides
		left = lowestCommonAncestor(node.getLeft(), node1, node2);
		right = lowestCommonAncestor(node.getRight(), node1, node2);
		
		if (left != null && right != null) {
			return node;
		} else {
			return (( left != null ) ? left : right);
		}
		
		
	}
	
	private Node insert( Node node, int value ) {
		
		if (node == null) {
			return new Node(value);
		} else {
			if (node.getValue() < value) {
				node.setRight(insert(node.getRight(),value));
			} else {
				node.setLeft(insert(node.getLeft(),value));
			}
			return node;
		}
	}
	
	private Node remove( Node node, int value ) {
		if (node == null)
			return node;
		
		if (node.getValue() == value) {
			if (node.getLeft() == null) {
				return node.getRight();
			} else if (node.getRight() == null) {
				return node.getLeft();
			} else {
				node.setLeft(lift(node.getLeft(), node));
				return node;
			}
		} else {
			if (node.getValue() < value) {
				node.setRight(remove(node.getRight(),value));
			} else {
				node.setLeft(remove(node.getLeft(),value));
			}
			return node;
		}
	}
	
	private Node lift(Node node, Node remove) {
		if (node.getLeft() == null) {
			remove.setValue(node.getValue());
			return node.getLeft();
		} else {
			node.setRight(lift(node.getRight(), remove));
			return node;
		}
	}
	
	private void orderPrint(Node node, String orderType) {
		if (node == null) 
			return;
		
		if (orderType.equals("in")) {
			orderPrint(node.getLeft(), orderType);
			System.out.print(" " + node.getValue());
			orderPrint(node.getRight(), orderType);
		} else if (orderType.equals("post")) {
			orderPrint(node.getLeft(), orderType);
			orderPrint(node.getRight(), orderType);
			System.out.print(" " + node.getValue());
		} else {
			System.out.print(" " + node.getValue());
			orderPrint(node.getLeft(), orderType);
			orderPrint(node.getRight(), orderType);
		}
	}
	
	private Node findMin( Node node ) {
		Node currNode = node;
		while (currNode.getLeft() != null) {
			currNode = currNode.getLeft();
		}
		
		return currNode;
	}

	private boolean validate(Node current, int min, int max) {
		
		if (current.getLeft() != null) {
			if (current.getLeft().getValue() < min || !validate(current.getLeft(), min, current.getValue()))
				return false;
		} else if ( current.getRight() != null) {
			if (current.getRight().getValue() > max || !validate(current.getRight(),current.getValue(), max))
				return false;
		}
		
		return true;
	}
}
