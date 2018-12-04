import java.util.*;

class TreeNode {
    public int id;
    public TreeNode left, right, parent;
    public TreeNode(int id) {
        this.id = id;
    }
}

public class CommonAncestor {
    
    public static TreeNode root = null;
    
    //without using parent reference
     public TreeNode findCommonAncestorUsingWithoutParentReference (TreeNode first, TreeNode second) {
         if(first == second) return first;
         //check if nodes are part of Tree
         if(!covers(root, first) || !covers(root, second)) return null;
         //check covers each other
         if(covers(first, second)) return first;
         if(covers(second, first)) return second;
         
         return helperFindCommonAnscestor(root, first, second);
        
     }
    
     public TreeNode helperFindCommonAnscestor(TreeNode root, TreeNode first, TreeNode second) {
         if(root == null || root == first || root == second) return root;
         
         boolean leftside = covers(root.left, first);
         boolean rightside = covers(root.left, second);
         
         if(leftside != rightside) {
             return root;
         }
         
         TreeNode next = leftside? root.left:root.right;
         return helperFindCommonAnscestor(next, first, second);
     }
    
    
    //using parent & sibling
    public TreeNode findCommonAncestorUsingSibling (TreeNode first, TreeNode second) {
        if(first == second) return first;
        //check if nodes are part of Tree
        if(!covers(root, first) || !covers(root, second)) return null;
        //check covers each other
        if(covers(first, second)) return first;
        if(covers(second, first)) return second;
        
        TreeNode sibling = getSibling(first);
        TreeNode parent = first.parent;
        while(!covers(sibling, second)) {
            sibling = getSibling(parent);
            parent = parent.parent;
        }
        
        return parent;
    }
    
    public TreeNode getSibling(TreeNode node) {
        if(node == null || node.parent == null) return null;
        TreeNode parent = node.parent;
        return parent.left == node? parent.right: parent.left;
    }
    
    public boolean covers(TreeNode root, TreeNode child) {
        if(root == null) return false;
        if(root == child) return true;
        return (covers(root.left, child) || covers(root.right, child));
    }
    
    //using parent reference & depth of nodes
    public TreeNode findCommonAncestorUsingDepth(TreeNode first, TreeNode second) {
        
        int fDepth = nodeDepth(first);
        int sDepth = nodeDepth(second);
        int diff = fDepth - sDepth;
    
        TreeNode firstNode = null, secondNode = null;
        if(diff > 0) {
            firstNode = first;
            secondNode = second;
        }
        if(diff < 0) {
            firstNode = second;
            secondNode = first;
        }
        
        diff = Math.abs(diff);
        //make sure of having depth difference otherwise following operation not needed
        if(firstNode != null) {
            while(diff > 0 && firstNode != null) {
                firstNode = firstNode.parent;
                diff--;
            }
        }
        
        //Now go for checking coomon parent
        while(firstNode != secondNode && firstNode != null && secondNode != null) {
            firstNode = firstNode.parent;
            secondNode = secondNode.parent;
        }
        
        return firstNode != null ? firstNode : null;
    }
    
    
    public int nodeDepth(TreeNode node) {
        if(node == null) return 0;
        int depth =0;
        while(node != null) {
            node = node.parent;
            depth++;
        }
        return depth;
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
            
            root.right.left.left = new TreeNode(26);
            root.right.left.left.parent = root.right.left;
            
            root.right.left.left.left = new TreeNode(22);
            root.right.left.left.left.parent = root.right.left.left;
            
            root.right.right = new TreeNode(40);
            root.right.right.parent = root.right;
            
            root.right.right.right = new TreeNode(50);
            root.right.right.right.parent = root.right.right;
            
            CommonAncestor bst = new CommonAncestor();
            
            bst.inorder(root);
            System.out.println("\nCommonAncestor: ");
            //System.out.print(bst.findCommonAncestor(root.right.left.left.left, root.left.right).id);
            System.out.println(bst.findCommonAncestorUsingDepth(root.right.left.left.left, root.left.left.right).id);
            System.out.println(bst.findCommonAncestorUsingSibling(root.right.left.left.left, root.left.left.right).id);
            System.out.println(bst.findCommonAncestorUsingWithoutParentReference(root.right.left.left.left, root.left.left.right).id);
            
            
            
            
    }
}