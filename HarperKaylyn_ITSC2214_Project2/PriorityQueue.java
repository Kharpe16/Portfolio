/*
 * Kaylyn Harper
 * ITSC 2214
 * Date: 4/3/19
*/
public class PriorityQueue{
   private PriorityCustomer[] heap;
   private int size;
   /**
      Constructor
   **/
   public PriorityQueue(){
      heap = new PriorityCustomer[50];
      size = 0;
   }
   /**
      Adds a new customer
   **/
   public void add(PriorityCustomer pc){
      //Increment the size
      size++;
      //Set the heap at the size value to the new customer
      heap[size] = pc;
      
      //Set the index to the size
      int index = size;
      
      
       while (index > 1) {
    
         int parent = index / 2;
      
         //Check to see if the child's priority is greater than the parent's
         if (heap[index].getPriority() > heap[parent].getPriority()) {
         
            //If so swap the child and the parent
            //Then set the child's index to the parent's
            PriorityCustomer temp = heap[index];
            heap[index] = heap[parent];
            heap[parent] = temp;
            index = parent;
            
         } else {
            //If the parent is larger break the loop
            break;
         }
      }   
   }
   /**
      Removes a customer
   */ 
   public PriorityCustomer remove(){ 
      //Set the heap at 0 to the first Customer
      heap[0] = heap[1];
         
      //Move the last object to the root
      heap [1] = heap [size];
      heap [size] = null;
      size--;
      
      //Stores the index of the object moved to the root
      int index = 1;
      
      //continue to compare index to its children as long as there are children
      while (index <= size / 2) {
      
         //store index and values of children
         int leftCustomer = index * 2;
         int rightCustomer = leftCustomer + 1;
         
         int leftValue = heap [leftCustomer].getPriority();
         int rightValue = 0;
         
         //Checks to see if there is a right child
         if (rightCustomer <= size) {
            rightValue = heap [rightCustomer].getPriority();
         }
         
         //Checks to see which child is the larger child
         //Then switches them
         int largerValue;
         int largerIndex;
         
         if (leftValue > rightValue) {
            largerValue = leftValue;
            largerIndex = leftCustomer;
                } else {
            largerValue = rightValue;
            largerIndex = rightCustomer;
          }   
           
            //Determine if the larger child is bigger than the parent
            //if so, switch them
            if (heap[index].getPriority() < largerValue) {
         
            //swap
            PriorityCustomer temp = heap [index];
            heap [index] = heap [largerIndex];
            heap [largerIndex] = temp;
            
            //update the index since we moved it to a child position
            index = largerIndex;
         } else {
            //If the parent is larger break the loop
            break;
         }     
   }
      //Returns the removed customer
      return heap[0];
   }
   
   /**
   * Gets and returns the 1st priority customer
   **/
   public PriorityCustomer getFirst(){
      return heap[1];
   }
}