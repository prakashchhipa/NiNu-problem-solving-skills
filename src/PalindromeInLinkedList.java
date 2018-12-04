import java.util.*;


class Node {
    int data;
    Node next;
    public Node(int d, Node n) {
        this.data =d;
        this.next = n;
    }
}

public class PalindromeInLinkedList
{  
    Node root;
    
    public boolean validPalindrome(Node root) {
        Node slow = root, fast = root;
        Stack<Integer> stack = new Stack<Integer>(); 
        while (fast.next != null && fast.next.next != null) {
            stack.push(slow.data);
            slow = slow.next;
            fast = fast.next.next;
        }
        //even number of nodes needs to be checked
        if(fast.next != null) {
            stack.push(slow.data);
            slow = slow.next;
        } else {
            slow = slow.next;
        }       
        
        while(slow != null) {
            if(slow.data != stack.pop())
               return false;
            slow = slow.next;
        }
       return true;
   } 
    
    
    
    
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
       PalindromeInLinkedList link = new PalindromeInLinkedList();
       link.addNode(1);
       link.addNode(2);
       link.addNode(3);
       //link.addNode(4);
       link.addNode(3);
       link.addNode(2);
       link.addNode(1);
       
       link.traversList(link.root);
       System.out.print("Linkedist is palindrome: ");
       System.out.println(link.validPalindrome(link.root));
    }
}

