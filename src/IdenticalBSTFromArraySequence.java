import java.util.*;

class TreeNode {
    public int id;
    public TreeNode left, right, parent;
    public TreeNode(int id) {
        this.id = id;
    }
}

public class IdenticalBSTFromArraySequence {
    
    //If relative order of left sub tree and relative order of right subtree is remain intact then regardless ordering of insertion to left or right doesnt matter. it prodcues same BST.
    //Mixing up these types of element ordering is called weaving.
    
    public static TreeNode root = null;
    
    public ArrayList<LinkedList<Integer>> sequences(TreeNode node) {
        ArrayList<LinkedList<Integer>> result = new ArrayList<LinkedList<Integer>>();
        if(node == null) {
            result.add(new LinkedList<Integer>());
            return result;
        }
        LinkedList<Integer> prefix = new LinkedList<Integer>();
        prefix.add(node.id);
        
        ArrayList<LinkedList<Integer>> firstResult = sequences(node.left);
        ArrayList<LinkedList<Integer>> secondResult = sequences(node.right);
        
        for(LinkedList<Integer> first : firstResult) {
            for(LinkedList<Integer> second : secondResult) {
                ArrayList<LinkedList<Integer>> results = new ArrayList<LinkedList<Integer>>();
                weave(first, second, prefix, results);
                result.addAll(results);
            }
        }
        
        return result;
    }
    
    public void weave(LinkedList<Integer> first, LinkedList<Integer> second, LinkedList<Integer> prefix, ArrayList<LinkedList<Integer>> results) {
        
        if(first.size() == 0 || second.size() == 0){
            LinkedList<Integer> result = (LinkedList<Integer>) prefix.clone();
            result.addAll(first);
            result.addAll(second);
            results.add(result);
            return;
        }
        
        Integer firstElement = first.removeFirst();
        prefix.addLast(firstElement);
        weave(first, second, prefix, results);
        firstElement = prefix.removeLast();
        first.addFirst(firstElement);
        
        Integer secondElement = second.removeFirst();
        prefix.addLast(secondElement);
        weave(first, second, prefix, results);
        secondElement = prefix.removeLast();
        second.addFirst(secondElement);
    } 
    
    public void inorder(TreeNode root) {
        if(root == null) return;
        inorder(root.left);
        System.out.print(root.id);
        System.out.print(" ");
        inorder(root.right);
    }
    
    
    public static void main(String[] args) {
            
            root = new TreeNode(20);
            
            /*Left substree*/
            root.left = new TreeNode(10);
            root.left.parent = root;
            
            root.left.left = new TreeNode(5);
            root.left.left.parent = root.left;
            
            root.left.right = new TreeNode(15);
            root.left.right.parent = root.left;
            
            root.left.left.left = new TreeNode(3);
            root.left.left.left.parent =  root.left.left;
            
            root.left.left.right = new TreeNode(7);
            root.left.left.right.parent = root.left.left;
            
            root.left.right.right = new TreeNode(17);
            root.left.right.right.parent = root.left.right;
            
            /*Right subtree*/
            root.right = new TreeNode(30);
            root.right.parent = root;
            
            root.right.left = new TreeNode(28);
            root.right.left.parent = root.right;
            
            /*root.right.left.left = new TreeNode(26);
            root.right.left.left.parent = root.right.left;
            
            root.right.left.left.left = new TreeNode(22);
            root.right.left.left.left.parent = root.right.left.left;
            
            root.right.right = new TreeNode(40);
            root.right.right.parent = root.right;
            
            root.right.right.right = new TreeNode(50);
            root.right.right.right.parent = root.right.right;
            
       */     IdenticalBSTFromArraySequence bst = new IdenticalBSTFromArraySequence();
            
            bst.inorder(root);
            System.out.println("\nAll sequences to for BST: ");
            ArrayList<LinkedList<Integer>> results = bst.sequences(root);
            for(LinkedList<Integer> result : results) {
                for(Integer i : result) {
                    System.out.print(i);
                    System.out.print(" ");
                }
                System.out.println();
            }
    }
}