import java.util.*;
class Node {
    int val;
    Node above, below;
    public Node(int val) {
        this.val = val;
    }
}
class NodeStack {
    
    int capacity, size=0;
    Node top, bottom;
    
    public NodeStack(int cap) { this.capacity = cap;}
    public boolean isFull() {return this.capacity == this.size;}
    public boolean isEmpty() {return 0 == this.size;}
    
    public boolean push(int val) {
        if(isFull()) return false;
        size ++;
        Node n = new Node(val);
        if(top == null) {
            top = n;
            bottom = n;
        } else {
            n.below = top;
            top.above = n;
            top = n;
        }
        return true;
    }
    
    public int pop() {
        if(isEmpty()) return -1;
        int val = top.val;
        top = top.below;
        size--;
        return val;
    }
    
    public int removeBottom() {
        if(isEmpty()) return -1;
        int n = bottom.val;
        bottom = bottom.above;
        if(bottom != null)
            bottom.below = null;
        if(size == 1)
            top = null;
        size--;
        return n;
    }
    
    public void display() {
        Node n = top;
        while(n != null) {
            System.out.print(n.val);
            System.out.print(' ');
            n = n.below;
        }
        System.out.println();
    }
}

public class QueueUsingStacks 
{ 
    int capacity;
    NodeStack enqueueSt, dequeueSt;
    
	public QueueUsingStacks(int capacity) {
	    this.capacity = capacity;
	    enqueueSt = new NodeStack(capacity);
	    dequeueSt = new NodeStack(capacity);
	}
	public boolean enqueue(int val) {
	    if(enqueueSt.isFull()) return false;
	    enqueueSt.push(val);
	    return true;
	}
	
	public int dequeue() {
	    if(dequeueSt.isEmpty()) {
	        while(!enqueueSt.isEmpty())
	            dequeueSt.push(enqueueSt.pop());
	        if(dequeueSt.isEmpty())
	            return -1;
	    }
	    return dequeueSt.pop();
	}
	public static void main(String args[]) { 
	  QueueUsingStacks queue = new QueueUsingStacks(3);
	  queue.enqueue(1);
	  queue.enqueue(2);
	  queue.enqueue(3);
	  
	  for(int i=0;i<4;i++) {
	      System.out.print(queue.dequeue());
	      System.out.print(" ");
	  }
	  System.out.println();
	} 
} 






















