import java.util.*;



class Project {
    public enum State {complete, partial, blank};
    public State state;
    public int id;
    public int dependancy;
    boolean visited;
    public ArrayList<Project> adjList;
    public Project(int projectId) {
        this.id = projectId;
        this.visited = false;
        this.dependancy = 0;
        this.adjList = new ArrayList<Project>();
        this.state = State.blank;
    }
}

class ProjectGraph {
    ArrayList<Project> projects;
    public int capacity=0, size = 0;
    
    public ProjectGraph(int size) {
        projects = new ArrayList<Project>();
        this.size = size;
    }
    
    public boolean addNode(Project n) {
        for(Project p: projects) {
            if(p.id == n.id) {
                return false;
            }
        }
        this.projects.add(n);
        capacity++;
        return true;
    }
    
    public boolean addNbr(Project first, Project second) {
        boolean status = false;
        for(Project p : projects) {
            if(p.id == first.id) {
                first.adjList.add(second);
                second.dependancy++;
                break;
            }
        }
        return status == true;
    }
    
    public void display() {
        for(int i =0; i< capacity; i++) {
            Project n = projects.get(i);
            System.out.print(n.id);
            System.out.print(" : ");
            for(Project nd : n.adjList) {
                System.out.print(nd.id);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}

public class ProjectBuildOrder
{ 
    
    public Stack<Project> orderProjectsDFS(ArrayList<Project> projects) {
        Stack<Project> stack = new Stack<Project>();
        for(Project project: projects) {
            if(project.state == Project.State.blank) {
                if(!dfs(project, stack)) 
                    return null;
            }
        }
        return stack;
    }
    
    
    //DFS based solution
    public boolean dfs(Project project, Stack<Project> stack) {
        
        if(project.state == Project.State.partial) return false;
        
        if(project.state == Project.State.blank) {
            project.state = Project.State.partial;
            ArrayList<Project> children = project.adjList;
            for(Project child: children) {
                if(!dfs(child, stack)) 
                    return false;
            }
            project.state = Project.State.complete;
            stack.push(project);
        }
        return true;
    }
    
    
    
    //Topological sorting approach
    public Project[] prepareProjectBuildOrder(ProjectGraph graph) {
        Project[] order = new Project[graph.projects.size()];
        int eoDList = nonDependentProjects(graph.projects, order, 0);
        if(eoDList == 0 ) return null;
        int process =0;
        while(process < order.length) {
            Project currentProj = order[process];
            if(currentProj == null) return null;
            for(Project child : currentProj.adjList)
                child.dependancy--;
            eoDList = nonDependentProjects(currentProj.adjList, order, eoDList);
            process++;
        }
        return order;
    }
  
    public int nonDependentProjects(ArrayList<Project> projects, Project[] order, int offset) {
        System.out.print("Order ");
        System.out.println(offset);
        for(Project p : projects) {
            if(p.dependancy == 0) {
                order[offset] = p;
                offset++;
            }
        }
        return offset;
    }
  
	public static void main(String args[]) { 
	    
	    Project p1 = new Project(1);
	    Project p2 = new Project(2);
	    Project p3 = new Project(3);
	    Project p4 = new Project(4);
	    Project p5 = new Project(5);
	    Project p6 = new Project(6);
	    Project p7 = new Project(7);

	    ProjectGraph G = new ProjectGraph(7);
	    G.addNode(p1);
	    G.addNode(p2);
	    G.addNode(p3);
	    G.addNode(p4);
	    G.addNode(p5);
	    G.addNode(p6);
	    G.addNode(p7);
	    
	    //Dependancies: 3 > 1, 3 > 2, 1 > 4, 2 > 4, 4 > 5, 6 > 7
	    G.addNbr(p3,p1);G.addNbr(p3,p2);G.addNbr(p1,p4);G.addNbr(p2,p4);G.addNbr(p4,p5);G.addNbr(p6,p7);
	    
	    System.out.println("Graph:");
	    G.display();
	    ProjectBuildOrder build = new ProjectBuildOrder();
	    
	    //Project[] order = build.prepareProjectBuildOrder(G);
	    //for(Project o: order)
	      //  System.out.println(o.id);
	    
	    Stack<Project> stack = build.orderProjectsDFS(G.projects);
	    
	    while (!stack.isEmpty())
	       System.out.println(stack.pop().id);
	    
	}
} 






















