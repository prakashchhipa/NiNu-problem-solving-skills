import java.util.*;

class TreeNode {
    public int id;
    public TreeNode left, right, parent;
    public TreeNode(int id) {
        this.id = id;
    }
}
public class TreePathSum {
    
    /*brute force*/
    public int totalPathfromRoot(TreeNode root, int target) {
        if(root == null) return 0;
        
        int paths = countPaths(root, target, 0);
        
        int pathsLeft = totalPathfromRoot(root.left, target);
        int pathsRight = totalPathfromRoot(root.right, target);
        
        return paths + pathsLeft + pathsRight;
    }
    
    public int countPaths(TreeNode node, int target, int currentSum) {
        if(node == null) return 0;
        
        currentSum = currentSum + node.id;
        int totalPath = 0;
        if(currentSum == target)
            totalPath++;
            
        totalPath += countPaths(node.left, target, currentSum);
        totalPath += countPaths(node.right, target, currentSum);
        
        return totalPath;
    }
    
    /*Optimized Solution O(N)*/
    public int countPathsOptimized(TreeNode node, int target, int running, HashMap<Integer, Integer> pathcount) {
        if(node == null) return 0;
        
        int current = node.id + running;
        int path = pathcount.getOrDefault(current - target, 0);
        if(current == target)
            path++;
            
        int oldVal = pathcount.getOrDefault(current,0);
        pathcount.put(current, oldVal + 1);
        path += countPathsOptimized(node.left, target, current, pathcount);
        path += countPathsOptimized(node.right, target, current, pathcount);
        oldVal = pathcount.getOrDefault(current,0);
        pathcount.put(current, oldVal - 1);
        return path;
    }
    public static void main (String[] args) {
     
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
        root.right.right = new TreeNode(1);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(-10);
        root.left.right = new TreeNode(2);
        root.left.right.right = new TreeNode(1);
        
        TreePathSum nonBSTTree = new TreePathSum();
        
        System.out.println("#Paths By Brute Force - O(NlogN) (Target:8): " + nonBSTTree.totalPathfromRoot(root, 8));
        
        System.out.println("#Paths By Optimized Method - O(N) (Target:8): " + nonBSTTree.countPathsOptimized(root, 8, 0, new HashMap<Integer, Integer>()));
        
        
    }
}