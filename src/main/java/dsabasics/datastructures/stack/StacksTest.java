package dsabasics.datastructures.stack;

public class StacksTest {

    public static void main(String[] args) {
        /*
         * Stack myStack = new Stack(10);
         * System.out.println("isEmpty : " + myStack.isEmpty());
         * System.out.println("isFull : " + myStack.isFull());
         * myStack.push(3);
         * myStack.push(5);
         * myStack.push(5);
         * myStack.push(15);
         * myStack.push(20);
         * System.out.println("Peek : " + myStack.peek());
         * myStack.push(5);
         * myStack.push(15);
         * System.out.println("Pop : " + myStack.pop());
         * myStack.push(3);
         * myStack.push(5);
         * myStack.push(5);
         * System.out.println("Pop : " + myStack.pop());
         * //System.out.println("Pop : "+myStack.pop());
         * //System.out.println("Pop : "+myStack.pop());
         * System.out.println("isEmpty : " + myStack.isEmpty());
         * System.out.println("isFull : " + myStack.isFull());
         * myStack.push(3);
         * myStack.push(5);
         * myStack.push(5);
         * myStack.push(3);
         * myStack.push(5);
         * myStack.push(5);
         * System.out.println("isFull : " + myStack.isFull());
         * System.out.println("Pop : " + myStack.pop());
         * System.out.println("Pop : " + myStack.pop());
         * System.out.println("Pop : " + myStack.pop());
         * System.out.println("Pop : " + myStack.pop());
         * System.out.println("Pop : " + myStack.pop());
         * System.out.println("Pop : " + myStack.pop());
         * System.out.println("Pop : " + myStack.pop());
         * System.out.println("Pop : " + myStack.pop());
         * System.out.println("Pop : " + myStack.pop());
         * System.out.println("Pop : " + myStack.pop());
         * System.out.println("Pop : " + myStack.pop());
         * System.out.println("Pop : " + myStack.pop());
         * System.out.println("isEmpty : " + myStack.isEmpty());
         */

        System.out.println(revereseCharString("THIS IS UDAY"));

    }

    public static String revereseCharString(String str) {
        int stackSize = str.length();
        StackChars sc = new StackChars(stackSize);
        for (int i = 0; i < stackSize; i++) {
            char ch = str.charAt(i);
            sc.push(ch);
        }
        String reverseString = "";
        for (int i = 0; i < stackSize; i++) {
            char ch = sc.pop();
            reverseString += ch;
        }
        return reverseString;
    }

}
