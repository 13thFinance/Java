//byte may be faster for two reasons
//1: since I am using an array and it pulls a page from memory into the cpu cache then it can access it faster
//from there than from system memory(RAM), If java was converting bytes into ints that means it would need it
//could not fit that much into it's cache and both would be equivalent. But since java uses a byte as a byte and
//not an int, then the computer has no trouble caching the byte array and so it goes fast, but the int array has
//trouble  since it is ints and it still does not fit into the cache.
//2: byte + computation is faster.

//what I learned: contrary to popular belief, java can be made to go fast

import java.time.LocalTime;
import java.util.Random;

public class HelloWorld{
    
    Random rand = new Random();
    
     public static void main(String []args)
     {
        //int addition tester
        ///////////////////////////////////////////////////////////////////////////////////
        System.out.println("Testing calculation times...");
        System.out.println("Addition of 8000 Ints: ");
        
        //define our array size
        int size = 8000;
        
        //fill up an array of 8000 ints
        int[] myIntArray = new int[size]; //this will have garbage in it which is fine
        
        //get a time stamp
        LocalTime now = LocalTime.now();
        //make a sum variable
        int sum = 0;
        System.out.println("Current Time: " + now);
        
        //do the addition
        for(int i = 0; i < size; i++)
        {
            sum += myIntArray[i]; //doesnt matter what the sum is
        }
        
        System.out.println("Int addition complete...");
        
        //get another timestamp
        LocalTime then = LocalTime.now();
        System.out.println("Current Time: " + then);
        
        //calculate difference and print it
        int difference = (then.getNano() - now.getNano());
        System.out.println("Total time taken in nanoseconds: " + difference);
        
        /////////////////////////////////////////////////////////////////////////////////////
        
        
        //byte addition tester
        /////////////////////////////////////////////////////////////////////////////////////
        System.out.println("Testing calculation times...");
        System.out.println("Addition of 8000 Bytes: ");
        
        //fill up an array of 8000 ints
        byte[] myByteArray = new byte[size]; //this will have garbage in it which is fine
        
        //get a time stamp
        now = LocalTime.now();
        //make a sum variable
        byte sumByte = 0; //make sure it is byte type to not do implicit casting
        System.out.println("Current Time: " + now);
        
        //do the addition
        for(int i = 0; i < size; i++)
        {
            sumByte += myByteArray[i]; //doesnt matter what the sum is
        }
        
        System.out.println("Byte addition complete...");
        
        //get another timestamp
        then = LocalTime.now();
        System.out.println("Current Time: " + then);
        
        //calculate difference and print it
        difference = (then.getNano() - now.getNano());
        System.out.println("Total time taken in nanoseconds: " + difference);
        /////////////////////////////////////////////////////////////////////////////////////
        
        //get sizes of the array
     }
}

//OUTPUT
/*
Testing calculation times...
Addition of 8000 Ints: 
Current Time: 20:50:21.639
Int addition complete...
Current Time: 20:50:21.644
Total time taken in nanoseconds: 5000000
Testing calculation times...
Addition of 8000 Bytes: 
Current Time: 20:50:21.644
Byte addition complete...
Current Time: 20:50:21.644
Total time taken in nanoseconds: 0
*/
