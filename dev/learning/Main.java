package dev.learning;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {

//        LinkedList<String> placesToVisit = new LinkedList<>();
        var placesToVisit = new LinkedList<String>();

        placesToVisit.add("Sydney");
        placesToVisit.add(0, "Canberra");
        System.out.println(placesToVisit);

        //        Add elements
        addMoreElement(placesToVisit);
        System.out.println(placesToVisit);

        //        Remove elements
        //        removeElements(placesToVisit);
        //        System.out.println(placesToVisit);

        //        Retrieve element
//    gettingElement(placesToVisit);
//    System.out.println(placesToVisit);

////     printItinerary
//        printItinerary(placesToVisit);
//        System.out.println(placesToVisit);

//        //     printItinerary2
//        printItinerary2(placesToVisit);
//        System.out.println(placesToVisit);

        //     printItinerary3
//        printItinerary3(placesToVisit);
//        System.out.println(placesToVisit);

        testIterator(placesToVisit);
//        System.out.println(placesToVisit);
    }

    private static void addMoreElement(LinkedList<String> list) {
        list.addFirst("Darwin");
        list.addLast("Hobart");
        // Queue method
        list.offer("Melbourne"); // it addes to the end of the list
        list.offerFirst("Brisbane");
        list.offerLast("Toowoomba");
        // Stack Method
        list.push("Alice Springs");
    }

    private static void removeElements(LinkedList<String> list) {
        list.remove(4);
        list.remove("Brisbane");

        //        Remove elements using linked list
        //        No argument remove method
//    System.out.println("-".repeat(20));
        System.out.println(list);
        //        using remove method
        String s1 = list.remove(); // removes first elements
        System.out.println(s1 + " was removed");

        //        using remove first method
        String s2 = list.removeFirst(); // removes first elements
        System.out.println(s2 + " was removed");

        //        using remove last method
        String s3 = list.removeLast(); // removes last elements
        System.out.println(s3 + " was removed");

        //        Queue/Deque poll methods

        String p1 = list.poll();
        System.out.println(p1 + " was removed"); // remove first element

        //        Using pollFirst() method
        String p2 = list.pollFirst();
        System.out.println(p2 + " was removed"); // remove first element

        //        Using pollLast() method
        String p3 = list.pollLast();
        System.out.println(p3 + " was removed"); // remove last element

        //putting it back to the list using push method - using stack : LIFO (last in first out)
        list.push("Sydney");
        list.push("Brisbane");
        list.push("Canberra");
        System.out.println(list);

        String p4 = list.pop(); // remove first element
        System.out.println(p4 + " was removed");
    }

    //    Different ways to retrieve elements from linked list

    private static void gettingElement(LinkedList<String> list) {
        System.out.println("Retrieved Element = " + list.get(4));

        //        retrieve first element using getFirst()
        System.out.println("First Element = " + list.getFirst());

        //        Retrieve last element using getLast()
        System.out.println("Last Element = " + list.getLast());

        //        finding the index/position in the list
        System.out.println("Darwin is at position: " + list.indexOf("Darwin"));
        //        using lastIndexOf() method
        System.out.println(
                "Melbourne is at position: " + list.lastIndexOf("Melbourne")
        );

        /************************************
         *       Queue retrieval method
         *       (FIFO) - First In First Out
         * ************************************/
        System.out.println("_".repeat(50));

        System.out.println("Elements from element() = " + list.element()); // this method takes no arguments
        /************************************
         *       Stack retrieval method
         *       (LIFO) - Last In First Out
         * ************************************/

        System.out.println("*".repeat(50));

        System.out.println("Elements from peek() = " + list.peek());
        System.out.println("Elements from peekFirst() = " + list.peekFirst());
        System.out.println("Elements from peekLast() = " + list.peekLast());
    }

    //  Triversing and manupalating element in a list
    public static void printItinerary(LinkedList<String> list) {
        System.out.println("Trip starts at " + list.getFirst());
        for (int i=1; i < list.size(); i++){
            System.out.println("--> From: " + list.get(i - 1) + " to " + list.get(i));
        }
        System.out.println("Trip ends at " + list.getLast());
    }

    public static void printItinerary2(LinkedList<String> list) {
        System.out.println("Trip starts at " + list.getFirst());
        String previousTown = list.getFirst();
        for(String town : list){
            System.out.println("--> From: " + previousTown + " to " + town);
            previousTown = town;
        }
        System.out.println("Trip ends at " + list.getLast());
    }

    public static void printItinerary3(LinkedList<String> list) {
        System.out.println("Trip starts at " + list.getFirst());
        String previousTown = list.getFirst();
        ListIterator<String> iterator = list.listIterator(1);
        while(iterator.hasNext()){
            var town = iterator.next();
            System.out.println("--> From: " + previousTown + " to " + town);
            previousTown = town;
        }
        System.out.println("Trip ends at " + list.getLast());
    }

    private static void testIterator(LinkedList<String> list){
//        var iterator = list.iterator();
        var iterator = list.listIterator();
        while (iterator.hasNext()){
//            System.out.println(iterator.next());
            if (iterator.next().equals("Brisbane")){
                iterator.add("Lake Wivenhoe");
//                iterator.remove(); // iterator to move forward to the element
            }
        }
//        moving backward
        while (iterator.hasPrevious()){
            System.out.println(iterator.previous());
        }
        System.out.println(list);

        var iterator2 = list.listIterator(3);
//        System.out.println(iterator2.next());
        System.out.println(iterator2.previous());
    }
}
