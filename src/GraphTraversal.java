import java.util.*;

class Node {
    public int id;
    boolean visited;
    public List<Node> adjList;
    public Node(int nodeId) {
        this.id = nodeId;
        this.visited = false;
        this.adjList = new ArrayList<Node>();
    }
}

class Graph {
    Node[] nodes;
    int capacity=0;
    
    public Graph(int size) {
        nodes = new Node[size];
    }
    
    public boolean addNode(Node n) {
        for(int i =0; i<capacity; i++) {
            if(this.nodes[i].id == n.id) {
                return false;
            }
        }
        this.nodes[capacity] = n;
        capacity++;
        return true;
    }
    
    public boolean addNbr(Node node, Node nbr) {
        boolean status = false;
        for(int i =0; i<capacity; i++) {
            if(this.nodes[i].id == node.id) {
                node.adjList.add(nbr);
                break;
            }
        }
        for(int i =0; i<capacity; i++) {
            if(this.nodes[i].id == nbr.id) {
                nbr.adjList.add(node);
                status = true;
                break;
            }
        }
        return status == true;
    }
    
    public void display() {
        for(int i =0; i< capacity; i++) {
            Node n = nodes[i];
            System.out.print(n.id);
            System.out.print(" : ");
            for(Node nd : n.adjList) {
                System.out.print(nd.id);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}

public class GraphTraversal
{ 
    public boolean checkRouteBFS(Node start, Node end) {
        
        if(start.id == end.id) return true;
        
        //LinkedList as queue
        List<Node> queue = new ArrayList<Node>();
        queue.add(start);
        //start.visited = true;
        
        while(!queue.isEmpty()) {
            Node n = queue.remove(queue.size() -1);
            n.visited = true;
            System.out.print(n.id);
            System.out.print(" ");
            for(Node nbr : n.adjList) {
                if(!nbr.visited) {
                    queue.add(nbr);
                    if(nbr.id == end.id) {
                        System.out.print(nbr.id);
                        return true;
                    }
                }
            }
        }
        System.out.println();
        return false;
    }
    
    public boolean checkRouteDFS(Node start, Node end) {
         if(start.id == end.id) return true;
         
         start.visited = true;
         System.out.print(start.id);
         System.out.print(" ");
         for(Node n : start.adjList) {
             if(n.visited == false) {
                boolean rt = checkRouteDFS(n, end);
                if(rt) break;
             }
         }
         return false;
    }
  
    
  
	public static void main(String args[]) { 
	    Node n1 = new Node(1);
	    Node n2 = new Node(2);
	    Node n3 = new Node(3);
	    Node n4 = new Node(4);
	    Node n5 = new Node(5);
	    Node n6 = new Node(6);
	    Node n7 = new Node(7);
	    Node n8 = new Node(8);
	    
	    Graph G = new Graph(8);
	    G.addNode(n1);
	    G.addNode(n2);
	    G.addNode(n3);
	    G.addNode(n4);
	    G.addNode(n5);
	    G.addNode(n6);
	    G.addNode(n7);
	    G.addNode(n8);
	    
	    G.addNbr(n1,n2);G.addNbr(n1,n3);
	    G.addNbr(n2,n4);G.addNbr(n3,n4);
	    G.addNbr(n3,n5);G.addNbr(n3,n7);
	    G.addNbr(n6,n7);G.addNbr(n6,n5);
	    G.addNbr(n8,n4);G.addNbr(n8,n7);
	    
	    System.out.println("Graph:");
	    G.display();
	    
	    
	    GraphTraversal gt = new GraphTraversal();
	    //System.out.println("checkRouteBFS:");
	    //System.out.println(gt.checkRouteBFS(n1,n6));
	    System.out.println("checkRouteDFS:");
	    System.out.println(gt.checkRouteDFS(n1,n6));
	}
} 






















