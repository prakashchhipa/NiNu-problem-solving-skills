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
    
    public int peek() {
        if(isEmpty()) return -1;
        int val = top.val;
        return val;
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

public class SortedStack 
{ 
    
    int capacity;
    NodeStack inputSt, sortedSt, tempSt;
    
    public SortedStack(int cap) {
        this.capacity = cap;
        inputSt = new NodeStack(cap);
        sortedSt = new NodeStack(cap);
        tempSt = new NodeStack(cap);
    }
    
    public boolean push(int val) {
        if(sortedSt.isFull()) return false;
        if(sortedSt.isEmpty()) {
            sortedSt.push(val);
        } else {
            while(true) {
                if(sortedSt.peek() == -1 || sortedSt.peek() > val)
                    break;
                tempSt.push(sortedSt.pop());
            }
            sortedSt.push(val);
            while(!tempSt.isEmpty())
                sortedSt.push(tempSt.pop());
        }
        return true;
    }
    
    public int pop() {
       return sortedSt.pop();
    }
    
     public int peek() {
       return sortedSt.peek();
    }
    
    public void displaySortedStack() {
        sortedSt.display();
    }
	public static void main(String args[]) { 
	    
	    SortedStack stack = new SortedStack(5);
	    
	    stack.push(2);
	    stack.push(4);
	    stack.push(1);
	    stack.push(6);
	    stack.push(9);
	    
	    stack.displaySortedStack();
	    
	    while(stack.peek() != -1) {
	        System.out.print(stack.pop());
	        System.out.print(" "); 
	    }
	}
} 






















