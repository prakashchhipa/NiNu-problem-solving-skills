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

public class PlatesOfStack 
{ 
	 
	 int capacity;
	 ArrayList<NodeStack> stacks;
	 public PlatesOfStack(int cap) {
	     this.capacity = cap;
	     stacks = new ArrayList<NodeStack>();
	 }
	 
	 public boolean isEmpty() { if(stacks.size() == 0 || stacks.get(stacks.size() -1).isEmpty()) return true; return false;}
	 
	 public NodeStack lastStack() { if(stacks.size() == 0) return null; return stacks.get(stacks.size() -1);}
	 
	 public void push(int val) {
	    NodeStack stack = lastStack();
	    if(stack == null || stack.isFull()) {
	        NodeStack st = new NodeStack(capacity);
	        st.push(val);
	        stacks.add(st);
	    } else {
	        stack.push(val);
	    }
	 }
	 
	 public int pop() {
	     NodeStack stack = lastStack();
	     if(stack == null) {
	        return -1;
	     }
	     int val = stack.pop();
	     if(stack.isEmpty()){
	         stacks.remove(stacks.size() -1);
	     }
	     return val;
	 }
	 
	 public int popAt(int idx) {
	     return leftShift(idx, true);
	 }
	 
	 public int leftShift(int idx, boolean remove) {
	     if(stacks.size() > idx) {
	         int removeItem;
	         NodeStack st = stacks.get(idx);
	         if(remove) {
	             removeItem = st.pop();
	         } else {
	             removeItem = st.removeBottom();
	         }
	         if(st.isEmpty()) {
	             stacks.remove(idx);
	         } else if(stacks.size() > idx + 1) {
	            int val = leftShift(idx + 1, false);
	            st.push(val);
	         }
	         return removeItem;
	     } else {
	        return -1;
	     }
	 }
	 
	 public void display() {
	     for(NodeStack st : stacks) {
	         st.display();
	         System.out.println();
	     }
	 }
	public static void main(String args[]) { 
	    /*NodeStack st = new NodeStack(3);
	    st.push(2);
	  //  st.push(3);
	  //  st.push(4);
	    
	    st.display();
	    System.out.println(st.pop());
	    st.display();
	    st.push(4);
	    st.display();
	    System.out.println(st.removeBottom());
	    st.display();*/
	    PlatesOfStack plates = new PlatesOfStack(3);
	    
	    plates.push(1);
	    plates.push(2);
	    plates.push(3);
	    plates.push(4);
	    plates.push(5);
	    plates.push(6);
	    plates.push(7);
	    plates.push(8);
	    plates.push(9);
	    plates.display();
	    plates.popAt(0);
	   // plates.pop();
	   // plates.pop();
	   // plates.pop();
	   plates.push(3);
	    plates.display();
	} 
} 