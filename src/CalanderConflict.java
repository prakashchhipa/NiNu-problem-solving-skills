import java.util.ArrayList;
import java.util.List;

public class CalanderConflict
{ 
	
    public List<String> findConflict(int [][]schedule, String[] events) {
        List<String> conflicts = new ArrayList<String>();
        List<String> temp_conflicts = new ArrayList<String>();
        temp_conflicts.add(events[0]);
        int end = schedule[0][1];
        for (int i=1;i<schedule.length ;i++ )  {
            /*No Conflicts*/
            if(schedule[i][0] > end) {
                if(temp_conflicts.size() > 1) {
                    conflicts.addAll(temp_conflicts);
                }
                temp_conflicts = new ArrayList<String>();
            }
            /*Max operations*/
            if(end > schedule[i][1] ) {
                end=end;
            } else {
                end = schedule[i][1];
            }
            temp_conflicts.add(events[i]);
        }
        if(temp_conflicts.size() > 1) {
                    conflicts.addAll(temp_conflicts);
        }
        return conflicts;
    }
    	
	// Driver program to test above function 
	public static void main(String[] args) 
	{ 
		int schedule[][] = { {1,2},{3,5},{4,6},{7,10},{8,11},{10,12},{13,14}, {13,14}};
		String events[] = {"a", "b", "c", "d", "e", "f", "g", "h"};
		CalanderConflict cc = new CalanderConflict();
		List<String> conflictList = cc.findConflict(schedule, events);
		System.out.println("No. of events has conflicts: " + conflictList.size()); 
	} 
} 
