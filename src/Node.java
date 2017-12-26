
public class Node {
	
	int frequency;
	char c;
	Node left;
	Node right;
	
	public Node(int frequency, char c, Node left, Node right) {
		this.frequency = frequency;
		this.c = c;
		this.left = left;
		this.right = right;
	}
	
	public Node(int frequency, char c) {
		this.frequency = frequency;
		this.c = c;
		this.left = null;
		this.right = null;
	}
}
