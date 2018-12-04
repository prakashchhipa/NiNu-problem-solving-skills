import java.util.*; 

class MultiStack 
{ 
    
    int arr[];
    int stSize;
    int stacks[];
    
    public MultiStack(int size) {
        stSize = size;
        arr = new int[3*size];
        stacks = new int[3];
    }
    public void push (int st, int val) {
        int stPos = stacks[st];
        if (stPos >= stSize)
            return;
        int arrPos = st*stSize + stPos;
        arr[arrPos] = val;
        stPos++;
        stacks[st] = stPos;
    }
    public int pop (int st) {
        int stPos = stacks[st];
        if (stPos <= 0)
            return -1;
        int arrPos = st*stSize + stPos - 1;
        int val = arr[arrPos];
        arr[arrPos] = 0;
        stPos--;
        stacks[st] = stPos;
        return val;
    }
    public void validateArr() {
        for (int i=0;i<3*stSize ; i++) {
            System.out.print(arr[i]);
            System.out.print(" ");
        }
            System.out.println();
    } 
    public static void main(String[] args) {
      MultiStack ms = new MultiStack(5);
      ms.push(0,1);
      ms.push(1,1);
      //ms.push(2,1);
      ms.push(0,2);
      ms.push(1,2);
      //ms.push(2,2);
      ms.push(0,3);
      ms.push(1,3);
     // ms.push(2,3);
      ms.push(0,4);
      ms.push(1,4);
     // ms.push(2,4);
      ms.push(0,5);
      ms.push(1,5);
    //  ms.push(2,5);
      //ms.push(0,6);
     // ms.push(1,6);
      //ms.push(2,6);
      ms.validateArr();
      //System.out.println(ms.pop(0));
      //System.out.println(ms.pop(1));
      System.out.println(ms.pop(2));
      ms.validateArr();
    } 
} 