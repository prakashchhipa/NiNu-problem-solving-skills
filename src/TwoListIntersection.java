import java.util.*;


class Node {
    int data;
    Node next;
    public Node(int d, Node n) {
        this.data =d;
        this.next = n;
    }
}

public class TwoListIntersection
{  
    Node root1, root2;
    public Node findIntersection(Node node1, Node node2) {
        int countF=0, countS=0;
        Node nf = node1, ns = node2;
        //length counting and reaching to end of lists
        while(nf.next != null){
            countF += 1;
            nf=nf.next;
        }
        countF++;
        while(ns.next != null){
            countS += 1;
            ns=ns.next;
        }
        countS++;
        //checking if no intersection then return
        if( nf != ns) {
            return null;
        }
        //which is smaller and which one is taller
        Node small = countF < countS ? node1 : node2;
        Node large = countF > countS ? node1 : node2;
        
        //taller one should step up by difference count
        int diff = countF - countS;
        if(diff < 0) diff = -diff;
        
        while(diff != 0) {
            large = large.next;
            diff--;
        }
        
        // now latest large node and small node are on same distance form common end
        // just iterate and keep checking for common next which will be intersection
        while(small != null) {
            if (small == large){
                return small;
            }
            small = small.next;
            large = large.next;
        }
        
        return null;
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
       TwoListIntersection link = new TwoListIntersection();
       link.root1 = new Node(3, null);
       link.root1.next = new Node(1, null);
       link.root1.next.next = new Node(5,null);
       link.root1.next.next.next = new Node(9,null);
       Node node7 = new Node(7, null);
       link.root1.next.next.next.next = node7;
       link.root1.next.next.next.next.next = new Node(2,null);
       link.root1.next.next.next.next.next.next = new Node(1,null);
       
       link.root2 = new Node(4, null);
       link.root2.next = new Node(6, null);
       link.root2.next.next = node7;//new Node(7, null);
       
     
       System.out.print("First List: ");
       Node n1 = link.root1;
       link.traversList(n1);
       System.out.print("Second List: ");
       Node n2 = link.root2;
       link.traversList(n2);
       Node resultNode = link.findIntersection(link.root1, link.root2);
       System.out.print("Intersection Node: ");
       System.out.print(resultNode != null ? resultNode.data : "Null");
    }
}

