
class BinarySearchTree{
	
	// Default null
	private Node root;

	public static class Node{
		public Node leftNode;
		public Node rightNode;
		public int key;
		public String value;
		
		public Node(int key, String value){
			this.key = key;
			this.value = value;
		}
	}
	
	// Search for the node. if the node is not found, returns the external position node.
	public Node search(int key, Node p){
		
		// Empty tree
		if(p == null){
			return null;
		}
		
		if(key < p.key){
			if(p.leftNode == null) return p;
			return search(key, p.leftNode);
		}
		else if(key > p.key){
			if(p.rightNode == null) return p;
			return search(key, p.rightNode);
		}
		else
			return p;
	}
	
	// p starts at root
	private void put(Node newNode, Node p){
		
		if(p == null){
			root = newNode;
			return;
		}
		
		p = search(newNode.key, root);
		
		if(p.key == newNode.key){
			p.value = newNode.value;
		}
		else if(newNode.key < p.key){
			p.leftNode = newNode;
		}
		else if(newNode.key > p.key){
			p.rightNode = newNode;
		}
		
		
	}
	
	public Node search(int key){ return search(key,root);}

	
	public void put(Node newNode){
		put(newNode, root);
	}
	
	// In BST this prints out in-order
	public void inOrderTraversal(Node p){
		
		if( p == null){
			return;
		}
		inOrderTraversal(p.leftNode);
		System.out.println(p.key + " " + p.value);
		inOrderTraversal(p.rightNode);
		
	}
	
	public void inOrderTraversal(){ inOrderTraversal(root); }
	
	public static void main(String[] args){
	
		BinarySearchTree binarySearchTree = new BinarySearchTree();
		binarySearchTree.put(new Node(50, "Bill"));
		binarySearchTree.put(new Node(22, "Lax"));
		binarySearchTree.put(new Node(33, "Jill"));
		binarySearchTree.put(new Node(5, "Ben"));
		binarySearchTree.put(new Node(8, "Tom"));
		binarySearchTree.put(new Node(33, "Jill"));
		binarySearchTree.put(new Node(5, "Ben"));
		binarySearchTree.put(new Node(8, "Tom"));
		binarySearchTree.put(new Node(25, "Jill"));
		binarySearchTree.put(new Node(51, "Ben"));
		binarySearchTree.put(new Node(82, "Tom"));
		binarySearchTree.inOrderTraversal();
	}
	

}