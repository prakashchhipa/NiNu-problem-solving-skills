import java.util.*;


class Node {
    int data;
    Node next;
    public Node(int d, Node n) {
        this.data =d;
        this.next = n;
    }
}

public class PivotPartitioning
{  
    Node root;
    public Node pivot(Node node, int target) {
        Node beforeS = null, befeorE=null, afterS=null, afterE=null;
        while(node != null) {
            Node next = node.next;
            node.next = null;
            if(node.data < target) {
                if(beforeS == null) {
                    beforeS = node;
                    befeorE = beforeS;
                } else {
                    befeorE.next = node;
                    befeorE = node;
                }
            } else {
                if(afterS == null) {
                    afterS = node;
                    afterE = afterS;

                } else {
                    afterE.next = node;
                    afterE = node;
                }
            }
           node = next; 
        }
        
        if (beforeS == null) {
            return afterS;
        }
     
        befeorE.next = afterS;
        return beforeS;
    }
    
    
    public Node pivotHT(Node node, int target) {
        Node head = node, tail=node;
        while(node != null) {
            Node next = node.next;
            if(node.data < target) {
                node.next = head;
                head = node;
            } else {
                tail.next = node;
                tail = node;
            }
            node = next;
        }
        return head;
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
       PivotPartitioning link = new PivotPartitioning();
       link.addNode(3);
       link.addNode(5);
       link.addNode(8);
       link.addNode(5);
       link.addNode(10);
       link.addNode(2);
       link.addNode(1);
       System.out.print("Linkedist before pivot partitioning: ");
       Node n1 = link.root;
       link.traversList(n1);
       System.out.print("Linkedist after pivot partitioning: ");
       Node n2 = link.root;
       Node node1 = link.pivot(n2, 5);
       link.traversList(node1);
       System.out.print("Linkedist after pivot partitioning(Head/Tail approach): ");
       node1 = link.pivot(link.root, 5);
       link.traversList(node1);
       
    }
}

