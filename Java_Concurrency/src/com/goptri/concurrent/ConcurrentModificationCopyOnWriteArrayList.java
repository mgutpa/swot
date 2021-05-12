package com.goptri.concurrent;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
 
public class ConcurrentModificationCopyOnWriteArrayList {
 
    public static void main(String[] args) {
       List<String> list = new CopyOnWriteArrayList<String>();
       list.add("a");
       list.add("b");
       list.add("c");
       
        Iterator<String> iterator = list.iterator();
       
        while(iterator.hasNext()){
  
         String str = iterator.next();
         System.out.print(str+" ");
         
         if(str.equals("b"))
           list.add("b2");   //No ConcurrentModificationException
         
        }
       
        System.out.println("\nAfter iteration list is : "+list);
       
    }
 
}
 
/*OUTPUT 
	a b c
	After iteration list is : [a, b, c, b2]
	
	During execution of program CopyOnWriteArrayList and Iterator returned by CopyOnWriteArrayList maintains following variables >
	Variables maintained by CopyOnWriteArrayList - 
	           > lock > because CopyOnWriteArrayList  is thread safe.
	Variables maintained by Iterator returned by CopyOnWriteArrayList -
	           >snapshot, it is copy of CopyOnWriteArrayList (not the original CopyOnWriteArrayList)
	>Initially, cursor=0   > index of next element to return 
	means it is pointing to 1st element in list, i.e. on 0th index [increments every time when iterator.next() is called]
	It’s important to know that cursor is maintained on snapshot, rather than on list as in case of ArrayList (When iterating on ArrayList, 
	cursor is maintained on ArrayList, because no snapshot kind of variable exists there).
	
	So why program did not throw ConcurrentModificationException?
	Because when list.iterator() is called, a variable called snapshot is created which is copy of list (not the original list). Hence, iteration 
	does not care about structural modifications made to list.
*/