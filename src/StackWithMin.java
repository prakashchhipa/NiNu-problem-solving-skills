import java.util.*; 

class arrayStack
{
    protected int arr[];
    protected int top, size, len;
    /*  Constructor for arrayStack */
    public arrayStack(int n)
    {
        size = n;
        len = 0;
        arr = new int[size];
        top = -1;
    }
    /*  Function to check if stack is empty */
    public boolean isEmpty()
    {
        return top == -1;
    }
    /*  Function to check if stack is full */
    public boolean isFull()
    {
        return top == size -1 ;        
    }
    /*  Function to get the size of the stack */
    public int getSize()
    {
        return len ;
    }
    /*  Function to check the top element of the stack */
    public int peek()
    {
        if( isEmpty() )
            return -1;
        return arr[top];
    }
    /*  Function to add an element to the stack */
    public boolean push(int i)
    {
        if(top + 1 >= size)
            return false;
        if(top + 1 < size )
            arr[++top] = i;
        len++ ;
        return true;
    }
    /*  Function to delete an element from the stack */
    public int pop()
    {
        if( isEmpty() )
            return -1;
        len-- ;
        return arr[top--]; 
    }    
    /*  Function to display the status of the stack */
    public void display()
    {
        System.out.print("\nStack = ");
        if (len == 0)
        {
            System.out.print("Empty\n");
            return ;
        }
        for (int i = top; i >= 0; i--)
            System.out.print(arr[i]+" ");
        System.out.println();
    }    
}

class Node {
    int value;
    int minVal;
}

class StackWithMin 
{ 
    arrayStack stVal;
    arrayStack stMin;
    
    public StackWithMin() {
        stVal = new arrayStack(10);
        stMin = new arrayStack(10);
    }
    
    public void push(int val) {
        int minStackVal = stMin.peek();
        if(minStackVal > 0) {
            if(minStackVal >= val) {
                 stVal.push(val);
                 stMin.push(val);
            } else {
                stVal.push(val);
                stMin.push(minStackVal); 
            }
        } else {
            stVal.push(val);
            stMin.push(val);
        }
        System.out.print(stVal.peek());
        System.out.print(" ");
        System.out.print(stMin.peek());
        System.out.println();
    }
    
    public Node pop() {
         int val = stVal.pop();
         int min = stMin.pop();
         Node n = new Node();
         n.value = val;
         n.minVal = min;
         return n;
    }
    
    public int min() {
        return stMin.peek();
    }
    public static void main(String[] args) {
        StackWithMin st = new StackWithMin();
        
        st.push(5);
        st.push(6);
        st.push(3);
        st.push(7);
        Node n1 = st.pop();
        System.out.print(n1.value);
        System.out.print(" ");
        System.out.print(st.min());
        System.out.println();
        Node n2 = st.pop();
        System.out.print(n2.value);
        System.out.print(" ");
        System.out.print(st.min());
    } 
} 

