import java.util.LinkedList;


public class myQueue extends Citizen {
    private LinkedList q;//Declare the object of queue

    //using LinkedList
//i.Constructor without param
    public myQueue() {
        q = new LinkedList();
    }//end of constructor

    //ii.method to insert an object to a queue
    public void enqueue(Object item) {
        q.addLast(item);
    }

    public Citizen element(Object item) {
        q.element();
        return null;
    }

    //end of enqueue
    //iii.method to remove an object from a queue
    public Object dequeue() {
        if (!empty())
            return q.removeFirst();
        else
            System.out.println("Queue is empty!");
        return 0;
    }


    //end of dequeue
    //iv.method to test whether the queue is empty or not
    public boolean empty() {
        return (q.size() == 0);
    }


    public String toString() {
        System.out.println(q.element().toString());
        return null;
    }




    //end of empty
}//end of Queue
