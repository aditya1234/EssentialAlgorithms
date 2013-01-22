package binarysearchtree;

public class Node {
	private Node left;
	private Node right;
	private int value;
	
	public Node(int value) {
		this.value = value;
		left = null;
		right = null;
	}
	
	public Node getLeft() {
		return left;
	}
	
	public Node getRight() {
		return right;
	}
	
	public int getValue() {
		return value;
	}
	
	@Override
	public boolean equals(Object other) {
		assert(other instanceof Node);
		return (this.value == ((Node)other).getValue());
	}
	
	public void setLeft(Node node) {
		left = node;
	}
	
	public void setRight(Node node) {
		right = node;
	}
	
	public Node getSmallest() {
		if (left == null) {
			return this;
		} else {
			return left;
		}
	}
	
	public void setValue(int value) {
		this.value = value;
	}
}
