import java.util.*;

class Node {
    int data;
    Node next;
    public Node(int d, Node n) {
        this.data =d;
        this.next = n;
    }
}

public class RemoveDuplicateNodeinLinkedList
{  
    Node root;
    public void addNode(int data) {
        if(root == null) {
            root = new Node(data, null);
        } else {
            Node newNode = new Node(data, null);
            Node temp = root;
            while(temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }    
    //Approach - uses O(N) extra space but computes results in O(N) time
    public void deleteDuplicates(Node n) {
        HashSet<Integer> hset = new HashSet<Integer>();
        Node previous = root;
        while(n!=null) {
            if(hset.contains(n.data))
                previous.next = n.next;
            else {
                hset.add(n.data);
                previous = n;
            } 
            n = n.next;    
        }
    }
    
    public void deleteDuplicatesWithoutExtraSpace(Node n) {
        Node current = n;
        Node runner = current;
        while(current !=null) {
            runner = current;
            while(runner.next != null) {
                if(current.data == runner.next.data){
                    runner.next = runner.next.next;
                } else{
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }
    
    public void traversList(Node n) {
        while(n!= null) {
            System.out.print(n.data);
            System.out.print(' ');
            n = n.next;
        }
         System.out.println();
    }
    
    //Main program
    public static void main(String args[]) {
       RemoveDuplicateNodeinLinkedList link = new RemoveDuplicateNodeinLinkedList();
       link.addNode(2);
       link.addNode(3);
       link.addNode(4);
       link.addNode(2);
       link.addNode(3);
       link.addNode(5);
       
       link.traversList(link.root);
     //  link.deleteDuplicates(link.root); 
       link.deleteDuplicatesWithoutExtraSpace(link.root);
       link.traversList(link.root);
    }
}

