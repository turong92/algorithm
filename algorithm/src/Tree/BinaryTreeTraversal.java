package Tree;

public class BinaryTreeTraversal {

	public static void main(String[] args) {
		Node node4 = new Node(null, null, 4);
		Node node5 = new Node(null, null, 5);
		Node node6 = new Node(null, null, 6);
		Node node7 = new Node(null, null, 7);
		Node node2 = new Node(node4, node5, 2);
		Node node3 = new Node(node6, node7, 3);
		Node root = new Node(node2, node3, 1);
		
		System.out.print("inorder : ");
		inorder(root);
		System.out.print("\npreorder : ");
		preorder(root);
		System.out.print("\npostorder : ");
		postorder(root);
	}
	
	public static Node makeNode(Node left, Node right, int data) {
		Node node = new Node(left, right, data);
		return node;
	}
	
	public static void inorder(Node node) {
		if(node != null) {
			inorder(node.getLeft());
			System.out.print(node.getData() + " ");
			inorder(node.getRight());
		}
	}
	
	public static void preorder(Node node) {
		if(node != null) {
			System.out.print(node.getData() + " ");
			preorder(node.getLeft());
			preorder(node.getRight());
		}
	}
	
	public static void postorder(Node node) {
		if(node != null) {
			postorder(node.getLeft());
			postorder(node.getRight());
			System.out.print(node.getData() + " ");
		}
	}
}

class Node {
	private Node left;
	private Node right;
	private int data;
	
	Node(Node left, Node right, int data){
		this.left = left;
		this.right = right;
		this.data = data;
	}
	
	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}
}
