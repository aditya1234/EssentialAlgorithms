package binarysearchtree;

public class TestClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(17);
		bst.insert(6);
		bst.insert(46);
		bst.insert(3);
		bst.insert(12);
		bst.insert(56);
		bst.insert(1);
		bst.insert(9);
		bst.insert(15);
		bst.insert(48);
		
		System.out.println( (bst.isValid()) ? "Good" : "Bad" );
		bst.printBetween(3, 48);
	}

}
