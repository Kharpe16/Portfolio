/*
 * Kaylyn Harper
 * ITSC 2214-003
 * 4/3/19
 */

import java.util.Random;
public class Driver {

    /**
     * @param Kaylyn the command line arguments
     */
    public static void main(String[] Kaylyn) {
    
        PriorityQueue heap = new PriorityQueue();
        
        //Used to calculate the number of customers in in line
        int currentCustomers = 0;
        //Used to calculate the number of customer's serviced
        int totalServiced = 0;
        //Used to determine the max number of customers in line during the 60 minutes
        int maxCustomers = 0;
        
        //Simulates 60 miuntes
        for (int i = 0; i < 60; i++) {
            //Randomly chooses a number from 1-4 (25% Chance)
            int chance = new Random().nextInt(4) + 1;

            //if chance == 1 create a new customer
            if (chance == 1) {
                //increase the number of customers in the line
                currentCustomers++;
              
                //Add the customer
                heap.add(new PriorityCustomer());
                
                System.out.println("New customer added!  Queue length is now " + currentCustomers);
                
                //Check to see if the max number is less than current custmers
                if(currentCustomers > maxCustomers){
                    maxCustomers = currentCustomers;
                }
            }
            
            //Checks to see if the first customer in the linkedList is null
            //If the first is not null, then it will check the service time of the first
            if (heap.getFirst() != null) {
                
                //If the first customer's service time is equal to 0
                //then remove the first customer from the queue
                if (heap.getFirst().getServiceTime() == 0) {
                    heap.remove();
                    
                    //Increases the number of customers serviced and decreases the number
                    //of customers in line
                    totalServiced++;
                    currentCustomers--;
                    //outputs that the first customer has been serviced and
                    //gives the current number of people in line
                    System.out.println("Customer serviced and removed from the queue.  Queue length is now " + currentCustomers);
                } else {
                    //If the first customer's service time is not zero then
                    //decrease their service time
                    heap.getFirst().decServiceTime();
                }
            } else {
                //If the first is null, then output that no one is in line
                System.out.println("There is no customers in line");
            }
            //Print out during  each iteration to represent a minute
            System.out.println("---------------------------------------------------");
        }
        //Outputs the number of customers serviced 
        //and the max number of customers at a given point
        System.out.println("Total Customers Serviced: " + totalServiced);
        System.out.println("Maximum Customers in Line: " + maxCustomers);
    }
}
