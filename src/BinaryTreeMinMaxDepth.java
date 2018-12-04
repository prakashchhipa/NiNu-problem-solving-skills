//Queue based Binary tree min/max methods - Min will optimze in time complexcity compared to recusion based solution but required extra queue.

import java.lang.*;
class Node 
{ 
    public char data;
    //extra
    public int level;
    public Node left, right; 
    public Node(char item) 
    { 
        data = item;
        left = right = null; 
    } 
} 

class MyQueue 
{ 
    int front, rear, size; 
    int  capacity; 
    Node array[]; 
    public MyQueue(int capacity) { 
         this.capacity = capacity; 
         front = this.size = 0;  
         rear = capacity - 1; 
         array = new Node[this.capacity]; 
    } 
 
    boolean isFull() 
    {  return (this.size == this.capacity); 
    } 
    boolean isEmpty() 
    {  return (this.size == 0); } 
       
    void enqueue(Node item) 
    { 
        if (isFull()) 
            return; 
        this.rear = (this.rear + 1)%this.capacity; 
        this.array[this.rear] = item; 
        this.size = this.size + 1; 
    } 
    Node dequeue() 
    { 
        if (isEmpty()) 
            return null; 
           
        Node item = this.array[this.front]; 
        this.front = (this.front + 1)%this.capacity; 
        this.size = this.size - 1; 
        return item; 
    } 
    Node front() 
    { 
        if (isEmpty()) 
            return null; 
        return this.array[this.front]; 
    } 
    Node rear() 
    { 
        if (isEmpty()) 
            return null; 
        return this.array[this.rear]; 
    } 
}


public class BinaryTreeMinMaxDepth {
    public Node root = null;
    public MyQueue queue = null;
    public BinaryTreeMinMaxDepth(int qLen) {
        this.queue = new MyQueue(qLen);
    }
    
    public int findMinDepth() {
        
        //level 0 and level 1 conditions
        if(this.root == null) {
            return 0;
        }
        else if (this.root.left == null && this.root.right == null) {
            return 1;
        }
        
        this.root.level = 0;
        this.queue.enqueue(root);
        
        while(!this.queue.isEmpty()) {
            Node n= this.queue.dequeue();
            if(n.left == null && n.right == null) {
                return n.level;
            } else {
                if(n.left != null) {
                    n.left.level = n.level + 1;
                    this.queue.enqueue(n.left);
                }
                if(n.right != null) {
                    n.right.level = n.level + 1;
                    this.queue.enqueue(n.right);
                }
            }
        }
        return 0;
    }
    
   public int findMinDepthWithoutQueue(Node node) {
        
        //level 0 and level 1 conditions
        if(node == null) {
            return 0;
        }
        else if (node.left == null && node.right == null) {
            return 1;
        }
        
        return findMinDepthRecur(node);
    }
    
    public int findMinDepthRecur(Node node) {
        
        if(node.left ==null && node.right ==null) {
            return 0;
        }
        
        if(node.left !=null || node.right !=null) { 
            if(node.right ==null) {
                return findMinDepthRecur(node.left) + 1;
            }
            if(node.left ==null) {
                return findMinDepthRecur(node.right) + 1;
            }
            if(node.left !=null && node.right !=null) {
                return 1+ Math.min(findMinDepthRecur(node.left), findMinDepthRecur(node.right));             
            }
        }
        return 0;
    }
    public int findMaxDepth() {
        
        //level 0 and level 1 conditions
        if(this.root == null) {
            return 0;
        }
        else if (this.root.left == null && this.root.right == null) {
            return 1;
        }
        
        this.root.level = 0;
        this.queue.enqueue(root);
        int level =1;
        while(!this.queue.isEmpty()) {
            Node n= this.queue.dequeue();
            if(n.left != null || n.right != null) {
                if(n.left != null) {
                    n.left.level = n.level + 1;
                    this.queue.enqueue(n.left);
                    level = n.left.level;
                }
                if(n.right != null) {
                    n.right.level = n.level + 1;
                    this.queue.enqueue(n.right);
                    level = n.right.level;
                }
                
            }
        }
        return level;
    }
    
    public int findMaxDepthWithoutQueue(Node node) {
        
        //level 0 and level 1 conditions
        if(node == null) {
            return 0;
        }
        else if (node.left == null && node.right == null) {
            return 1;
        }
        
        return findMaxDepthRecur(node);
    }
    
    public int findMaxDepthRecur(Node node) {
        
        if(node.left ==null && node.right ==null) {
            return 0;
        }
        
        if(node.left !=null || node.right !=null) { 
            if(node.right ==null) {
                return findMaxDepthRecur(node.left) + 1;
            }
            if(node.left ==null) {
                return findMaxDepthRecur(node.right) + 1;
            }
            if(node.left !=null && node.right !=null) {
                return 1+ Math.max(findMaxDepthRecur(node.left), findMaxDepthRecur(node.right));             
            }
        }
        return 0;
    }
    
    public void createTree(BinaryTreeMinMaxDepth tree) {
        //making of tree
        tree.root = new Node('A');
        tree.root.left = new Node('B');
        tree.root.right = new Node('C');
        tree.root.left.left = new Node('D');
        tree.root.left.right = new Node('E');
        tree.root.right.left = new Node('F');
        tree.root.right.right = new Node('G');
        tree.root.left.left.left = new Node('H');
        tree.root.left.left.right = new Node('I');
        //tree.root.left.right.left = new Node('Z');
        tree.root.right.left.left = new Node('J');
        tree.root.right.left.right = new Node('K');
        tree.root.right.right.left = new Node('L');
        tree.root.right.right.right = new Node('M');
        tree.root.right.right.left.left = new Node('O');
        tree.root.right.right.left.right = new Node('P');
        tree.root.right.right.left.left.left = new Node('X');
        tree.root.right.right.left.left.right = new Node('Y');
    }
    //Main program
    public static void main(String args[]) {
        BinaryTreeMinMaxDepth tree = new BinaryTreeMinMaxDepth(20);
        tree.createTree(tree);
        System.out.println("Binary Tree's min Depth: " + tree.findMinDepth());
        tree = new BinaryTreeMinMaxDepth(20);
        tree.createTree(tree);
        System.out.println("Binary Tree's max Depth: " + tree.findMaxDepth());
        
        tree.createTree(tree);
        System.out.println("Binary Tree's min Depth(recusion): " + tree.findMinDepthWithoutQueue(tree.root));
        
        tree.createTree(tree);
        System.out.println("Binary Tree's max Depth(recusion): " + tree.findMaxDepthWithoutQueue(tree.root));
        
        
    }
}