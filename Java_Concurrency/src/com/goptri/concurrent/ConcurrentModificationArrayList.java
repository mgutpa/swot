package com.goptri.concurrent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
 

public class ConcurrentModificationArrayList {
 
    public static void main(String[] args) {
       List<String> list = new ArrayList<String>();
       list.add("a");
        list.add("b");
        list.add("c");
        
        for (String str : list) {
        	if(str.equals("b")) {
                list.add("b2");   //will throw ConcurrentModificationException
              
             }       
             System.out.println("\nAfter iteration list is : "+list);       
         
		}
    
       
        /*Iterator<String> iterator = list.iterator();
       
        while(iterator.hasNext()){
         
         String str = iterator.next();
         System.out.print(str+" ");
         
         if(str.equals("b"))
           list.add("b2");   //will throw ConcurrentModificationException
         
        }       
        System.out.println("\nAfter iteration list is : "+list);       
    }
 */}
}

/*
 During execution of program ArrayList and Iterator returned by ArrayList maintains following variables >
 Variables maintained by ArrayList -
	           > modCount =3  
	           > size  =3 
 Variables maintained by Iterator returned by ArrayList -
	           >expectedModCount =3
 			   >Initially, cursor=0   > index of next element to return 
 means it is pointing to 1st element in list, i.e. on 0th index [increments every time when iterator.next() is called]
	 		   >Initially, lastRet= -1 > index of last element returned; -1 if no such
		[increments every time when iterator.next() is called]

 Every time iterator.next() is called it internally calls checkForComodification() to checks for any modification made to list.
 	public E next() {
            checkForComodification();
            try {
            int i = cursor;
            E next = get(i);
            lastRet = i;
            cursor = i + 1;
            return next;
        } catch (IndexOutOfBoundsException e) {
            checkForComodification();
            throw new NoSuchElementException();
        }
    }
   final void checkForComodification() {
     if (modCount != expectedModCount)
         throw new ConcurrentModificationException();
    }
    
    if modCount is not equal to expectedModCount ConcurrentModificationException is thrown.


	What is modCount? What is structural modifications in java?
	The number of times this list has been structurally modified. Any changes to size of list are called structural modifications in java.
	
	Which method cause structural modifications in java?
	add() and remove() method changes size of list. Hence, cause structural modifications.
	Every time any of these methods is called modCount is incremented by 1.
	
	Additionally, you may also be interested in knowing what will happen if add() and remove() methods are called subsequently in java?
	Subsequent calls made to add() and remove() methods won’t avoid ConcurrentModificationException. Because in this case modCount will be incremented twice by 1.
	
	Which method does not cause structural modifications in java?
	set() method does not changes size of list. Hence, does not cause any structural modifications.
	Every time set() is called modCount remains unchanged.
	
	How to use iterator.remove() in java?
	We can remove elements from ArrayList using iterator’s remove method.
	Every time iterator.remove() is called modCount remains unchanged.
	But, if iterator.remove() is called before calling iterator.next() than IllegalStateException is thrown.
 * 
 * 
 * for-each is an advanced looping construct. Internally it creates an Iterator and iterates over the Collection. 
 * Only possible advantage of using an actual Iterator object over the for-each construct is that you can modify 
 * your collection using Iterator's methods like .remove(). Modifying the collection without using Iterator's 
 * methods while iterating will produce a ConcurrentModificationException.
 */
