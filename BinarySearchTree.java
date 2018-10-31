
class BinarySearchTree{
	
	// Default null
	private Node root;

	public static class Node{
		
		public Node leftNode;
		public Node rightNode;
		
		public int key;
		public String value;
		public int count;
		
		public Node(int key, String value, int count){
			this.key = key;
			this.value = value;
			this.count = count;
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
	private Node put(int key, String value, Node p){
		
		if(p == null){
			return new Node(key,value,1);
		}
		
		// Can search and insert but also do it this way
		// Go down and up the tree
		// p = search(key, p);
		
		if(p.key == key){
			p.value = value;
		}
		else if(key < p.key){
			p.leftNode = put(key,value,p.leftNode);
			
		}
		else if(key > p.key){
			p.rightNode = put(key,value,p.rightNode);
		}
		
		// Happens on the way up.
		int left = p.leftNode == null ? 0 : p.leftNode.count;
		int right = p.rightNode == null ? 0 : p.rightNode.count;
		p.count = left + right + 1; // Need to count the node itself to calculate total nodes in the subtree
		
		return p;

	}
	
	public Node search(int key){ return search(key,root);}

	
	public void put(int key, String value){
		root = put(key,value, root);
	}
	
	public void deleteNode(Node p){
		
	}
	
	// In BST this prints out in-order
	public void inOrderTraversal(Node p){
		
		if( p == null){
			return;
		}
		inOrderTraversal(p.leftNode);
		System.out.println(p.key + " " + p.value + " " + p.count);
		inOrderTraversal(p.rightNode);
		
	}
	
	public void postOrderTraversal(Node p){
		
		if(p == null){
			return;
		}
		postOrderTraversal(p.leftNode);
		postOrderTraversal(p.rightNode);
		System.out.println(p.key + " " + p.value);
	}
	
	public void inOrderTraversal(){ inOrderTraversal(root); }
	
	public static void main(String[] args){
	
		BinarySearchTree binarySearchTree = new BinarySearchTree();
		binarySearchTree.put(50, "Bill");
		binarySearchTree.put(22, "Lax");
		binarySearchTree.put(33, "Jill");
		binarySearchTree.put(5, "Ben");
		binarySearchTree.put(8, "Tom");
		binarySearchTree.put(33, "Jill");
		binarySearchTree.put(5, "Ben");
		binarySearchTree.put(8, "Tom");
		binarySearchTree.put(25, "Jill");
		binarySearchTree.put(51, "Ben");
		binarySearchTree.put(82, "Tom");
		binarySearchTree.inOrderTraversal();
		
	}
	

}