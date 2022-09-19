package dsa.stack;

public class StackChars {
    private int maxSize;
    private char[] stackArray;
    private int top;

    public StackChars(int size) {
        this.maxSize = size;
        this.stackArray = new char[maxSize];
        this.top = -1;
    }

    public void push(char j) {
        System.out.println("top : " + top + " : maxSize : " + maxSize);
        if (!isFull()) {
            top++;
            stackArray[top] = j;
        } else {
            System.out.println("OOPS max limit reached");
        }
    }

    public char pop() {
        if (!isEmpty()) {
            int oldTop = top;
            top--;
            return stackArray[oldTop];
        } else {
            System.out.println("The Stack is already Empty");
            return '0';
        }
    }

    public long peek() {
        return stackArray[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return maxSize - 1 == top;
    }
}
