/**
 * Project 3 ITSC 2214
 * 
 * @author Kaylyn Harper
 *
 */

public class BinarySearchTree {
	// Holds the root of the BST
	Node root;

	/**
	 * Constructor
	 */
	public BinarySearchTree() {
		root = null;
	}

	/**
	 * Inserts the new word into the Binary Search Tree or increases the frequency
	 * of a current node
	 * 
	 * @param newWord The new word being add
	 */
	public void insert(String newWord) {
		// if the root is null, set root to a new Node object with the new word
		if (root == null) {
			root = new Node(newWord);
		} else {
			// Temporary Node used to see if there is an object with the newWord
			Node temp;
			// Set Temp to the node found
			temp = search(root, newWord);
			// if the the temp Node is null then create a new one
			// otherwise, increase the frequency of the newWord
			if (temp == null) {
				temp = new Node(newWord);
				this.insert(root, temp);
			} else {
				temp.increaseFrequency();
			}

		}
	}

	/**
	 * Adds the new node to the tree
	 * 
	 * @param subroot The root or subroot of the tree
	 * @param newNode The new node being add
	 */
	public void insert(Node subroot, Node newNode) {
		// If the new word comes before the root alphabetically, then look at the left
		// child
		if (newNode.getWord().compareTo(subroot.getWord()) < 0) {
			// If the left child is null, set the newNode to the left child
			if (subroot.getLeftChild() == null) {
				subroot.setLeftChild(newNode);
				// If the left child is not null repeat the insert method with the leftChild and
				// the newNode
			} else {
				insert(subroot.getLeftChild(), newNode);
			}
			// If the new word comes after the root alphabetically, then look at the right
			// child
		} else {
			// If the right child is null, set the newNode to the right child
			if (subroot.getRightChild() == null) {
				subroot.setRightChild(newNode);
			} else { // If the right child is not null repeat the insert method with the rightChild
						// and the newNode
				insert(subroot.getRightChild(), newNode);
			}
		}

	}

	/**
	 * Searches for a particular word and outputs the information about the word
	 * 
	 * @param word The word being searched for
	 */
	public void search(String word) {
		// Checks to see if the root is null
		if (root == null) {
			return;
		}
		// Start the search and set the node found to temp
		Node temp = search(root, word);
		// If temp is not null print out the information for the node
		if (temp != null) {
			System.out.println(temp.getWord() + ": " + temp.getFrequency());
		} else { // if temp is null the node was not found
			System.out.println(word + " was not found");
		}

	}

	/**
	 * 
	 * @param subroot The root or subroot of the BST
	 * @param word The word being looked for
	 * @return The node reference for the word that is being looked for
	 */
	public Node search(Node subroot, String word) {
		// If the word is = to the the word of the subroot then return the subroot
		if (subroot.getWord().compareTo(word) == 0) {
			return subroot;
			// If the word comes before the subroot alphabetically, then look at the left
			// child
		} else if (word.compareTo(subroot.getWord()) < 0) {
			// If the left child is null then return null
			if (subroot.getLeftChild() == null) {
				return null;
			} else {
				// Search through the left side recursively
				return search(subroot.getLeftChild(), word);
			}

		} else {
			if (subroot.getRightChild() == null) {
				return null;
			} else {
				// Search through the right side recursively
				return search(subroot.getRightChild(), word);
			}
		}

	}
	/**
	 * Starts the Output of the preOrder Traversal
	 */
	public void printPreOrder() {
		System.out.println("PreOrder:");
		// Starts the output of the preorder
		printPreOrder(root);
		System.out.println("\n");
	}
	/**
	 * Prints out the Preorder
	 * @param subroot The root or subroot of the BST
	 */
	public void printPreOrder(Node subroot) {
		// Checks to see if the subroot is null
		if (subroot == null)
			return;

		// Print subroot
		System.out.println(subroot.getWord() + ": " + subroot.getFrequency());
		// Left subtree
		printPreOrder(subroot.getLeftChild());
		// Right subtree
		printPreOrder(subroot.getRightChild());
	}
	/**
	 * Starts the Output of the InOrder traversal
	 */
	public void printInOrder() {
		System.out.println("InOrder:");
		printInOrder(root);
		System.out.println("\n");
	}
	/**
	 * Prints out the Nodes In order
	 * @param subroot The root or subroot of the BST
	 */
	public void printInOrder(Node subroot) {
		// Checks to see if the subroot is null
		if (subroot == null)
			return;

		// Left subtree
		printInOrder(subroot.getLeftChild());
		// Print subroot
		System.out.println(subroot.getWord() + ": " + subroot.getFrequency());
		// Right subtree
		printInOrder(subroot.getRightChild());
	}
	/**
	 * Starts the Output of the PostOrder traversal
	 */
	public void printPostOrder() {
		System.out.println("Post Order:");
		printPostOrder(root);
		System.out.println("\n");
	}
	/**
	 * Prints out the Nodes In Post Order
	 * @param subroot The root or subroot of the BST
	 */
	public void printPostOrder(Node subroot) {
		// Checks to see if the subroot is null
		if (subroot == null)
			return;

		// Left child
		printPostOrder(subroot.getLeftChild());
		// Right child
		printPostOrder(subroot.getRightChild());
		// Print subroot
		System.out.println(subroot.getWord() + ": " + subroot.getFrequency());
	}

}
