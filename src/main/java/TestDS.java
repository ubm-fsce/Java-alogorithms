import com.adt.ds.Stack;

public class TestDS {

    public static void main(String[] args) {
        Stack myStack = new Stack(10);
        System.out.println("isEmpty : " + myStack.isEmpty());
        System.out.println("isFull : " + myStack.isFull());
        myStack.push(3);
        myStack.push(5);
        myStack.push(5);
        myStack.push(15);
        myStack.push(20);
        System.out.println("Peek : " + myStack.peek());
        myStack.push(5);
        myStack.push(15);
        System.out.println("Pop : " + myStack.pop());
        myStack.push(3);
        myStack.push(5);
        myStack.push(5);
        System.out.println("Pop : " + myStack.pop());
        //System.out.println("Pop : "+myStack.pop());
        //System.out.println("Pop : "+myStack.pop());
        System.out.println("isEmpty : " + myStack.isEmpty());
        System.out.println("isFull : " + myStack.isFull());
        myStack.push(3);
        myStack.push(5);
        myStack.push(5);
        myStack.push(3);
        myStack.push(5);
        myStack.push(5);
        System.out.println("isFull : " + myStack.isFull());
        System.out.println("Pop : " + myStack.pop());
        System.out.println("Pop : " + myStack.pop());
        System.out.println("Pop : " + myStack.pop());
        System.out.println("Pop : " + myStack.pop());
        System.out.println("Pop : " + myStack.pop());
        System.out.println("Pop : " + myStack.pop());
        System.out.println("Pop : " + myStack.pop());
        System.out.println("Pop : " + myStack.pop());
        System.out.println("Pop : " + myStack.pop());
        System.out.println("Pop : " + myStack.pop());
        System.out.println("Pop : " + myStack.pop());
        System.out.println("Pop : " + myStack.pop());
        System.out.println("isEmpty : " + myStack.isEmpty());
    }

    public static String reverseString() {
        return "";
    }
}
