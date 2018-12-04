import java.util.*;


class Node {
    int data;
    Node next;
    public Node(int d, Node n) {
        this.data =d;
        this.next = n;
    }
}

public class FindLinkedListLoopEntry
{  
    Node root1;
    public Node findLoopEntry(Node node1) {
        Node slow = node1, fast = node1;
        //meeting point
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
                break;
        }
        slow = node1;
        while(slow != null && slow.next !=null) {
            slow = slow.next;
            fast = fast.next;
            if(slow == fast)
                return slow;
        }
        return null;
    }
    
    //Main program
    public static void main(String args[]) {
       FindLinkedListLoopEntry link = new FindLinkedListLoopEntry();
       link.root1 = new Node(1, null);
       link.root1.next = new Node(2, null);
       link.root1.next.next = new Node(3,null);
       Node node4 = new Node(4,null);
       link.root1.next.next.next = node4;
       link.root1.next.next.next.next = new Node(5,null);
       link.root1.next.next.next.next.next = new Node(6,null);
       link.root1.next.next.next.next.next.next = new Node(7,null);
       link.root1.next.next.next.next.next.next.next = new Node(8,null);
       //loop at node 4
       link.root1.next.next.next.next.next.next.next.next = node4;
       
       Node n1 = link.root1;
       Node loopEntryNode = link.findLoopEntry(n1);
       System.out.print("Loop Entry: ");
       System.out.println(loopEntryNode.data);
    }
}

