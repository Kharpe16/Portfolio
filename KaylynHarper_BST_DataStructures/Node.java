/**
 * Project 3 
 * ITSC 2214
 * @author Kaylyn Harper
 *
 */
public class Node {
   //Holds references to the left and right child
	private Node rightChild;
	private Node leftChild;
   //Holds the word and the frequency
	private String word;
	private int frequency;
   /**
    * Constructor
    * @param nodeWord The word for the Node
    */
	public Node(String nodeWord) {
      //Sets the left and right child to null
		rightChild= leftChild = null; 
		word = nodeWord;
      //Sets the initial frequency to 1
		frequency = 1;
	}
	/**
	 * Gets and returns the left child
	 * @return The left Child
	 */
   public Node getLeftChild() {
		return leftChild;
	}
   /**
    * Sets the left child
    * @param leftChild The reference for the leftChild
    * @return The left child
    */
	public Node setLeftChild(Node leftChild) {
		this.leftChild = leftChild;
		return leftChild;
	}
	/**
	 * Gets and returns the right child
	 * @return The right child
	 */
	public Node getRightChild() {
		return rightChild;
	}
	/**
	 * Sets the right child
	 * @param rightChild The reference to the right child
	 */
	public void setRightChild(Node rightChild) {
		this.rightChild = rightChild;
	}
	/**
	 * Gets and returns the word
	 * @return The word for this Node
	 */
	public String getWord() {
		return word;
	}
	/**
	 * Increases the frequency of the word associated with this Node
	 */
	public void increaseFrequency() {
		frequency++;
	}
	/**
	 * Gets and returns the frequency
	 * @return The frequency of the word associated with this Node
	 */
	public int getFrequency() {
		return frequency;
	}
	
}
