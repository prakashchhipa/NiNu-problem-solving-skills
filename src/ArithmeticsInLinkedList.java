import java.util.*;

class Node {
    int data;
    Node next;
    public Node(int d, Node n) {
        this.data =d;
        this.next = n;                                                                
    }
}

public class ArithmeticsInLinkedList
{  
    Node firstNode, secondNode, result, head;
    
    public void sum(Node n1, Node n2) {
        int carry = 0;
        while(n1!=null || n2!=null) {
            int add = carry;
            if(n1!= null) {
                add +=n1.data;
                n1 = n1.next;
            }
            if(n2!= null) {
                add +=n2.data;
                n2 =n2.next;
            }
            Node node = new Node(add%10, null);
            if(result == null) {
                result = node;
                head = node;
            } else {
                result.next = node;
                result = result.next;
            }
            carry = add/10;
        }
    }
    
    
    public void sumRecursion(Node n1, Node n2, int carry) {
        if(n1 == null && n2 == null) {
            return;
        }
        if(n1 != null && n2 != null) {
            int car = (n1.data + n2.data + carry) / 10;
            int val = (n1.data + n2.data + carry) % 10;
            Node node = new Node(val,null);
            if(this.result != null) {
                this.result.next = node;
                this.result = this.result.next;
            } else {
                this.head = node;
                this.result = node;
            }
            this.sumRecursion(n1.next, n2.next, car);
        }
         if(n1 == null) {
            int car = (n2.data + carry) / 10;
            int val = (n2.data + carry) % 10;
            Node node = new Node(val,null); 
           if(this.result != null) {
                this.result.next = node;
                this.result = this.result.next;
            } else {
                this.head = node;
                this.result = node;
            }
            this.sumRecursion(null, n2.next, car);
         }
         if(n2 == null) {
            int car = (n1.data + carry) / 10;
            int val = (n1.data + carry) % 10;
            Node node = new Node(val,null); 
            if(this.result != null) {
                this.result.next = node;
                this.result = this.result.next;
            } else {
                this.head = node;
                this.result = node;
            }
            this.sumRecursion(n1.next, null, car);
         }
    }
    
    
    
    public void addNodeFirstList(int data) {
        if(this.firstNode == null) {
            this.firstNode = new Node(data, null);
        } else {
            Node newNode = new Node(data, null);
            Node temp = this.firstNode;
            while(temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }
     public void addNodeSecondList(int data) {
        if(this.secondNode == null) {
            this.secondNode = new Node(data, null);
        } else {
            Node newNode = new Node(data, null);
            Node temp = this.secondNode;
            while(temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }    
    public void traversList(Node n1) {
        Node n = n1;
        while(n!= null) {
            System.out.print(n.data);
            System.out.print(' ');
            n = n.next;
        }
         System.out.println();
    }
    
    //Main program
    public static void main(String args[]) {
       ArithmeticsInLinkedList link = new ArithmeticsInLinkedList();
       link.addNodeFirstList(1);
       link.addNodeFirstList(2);
       link.addNodeFirstList(3);
       
       //link.addNode(4);
       link.addNodeSecondList(9);
       link.addNodeSecondList(2);
       link.addNodeSecondList(1);
       link.addNodeSecondList(4);
       System.out.println("First Number(reverse order): ");
       link.traversList(link.firstNode);
       System.out.println("Second Number(reverse order): ");
       link.traversList(link.secondNode);
       System.out.println("Addiiton(reverse order): ");
       //link.sumRecursion(link.firstNode, link.secondNode,0);
       link.sum(link.firstNode, link.secondNode);
       link.traversList(link.head);
    }
}

