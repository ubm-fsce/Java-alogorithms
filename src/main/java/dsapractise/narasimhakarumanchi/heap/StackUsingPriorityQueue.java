package dsapractise.narasimhakarumanchi.heap;

import java.util.PriorityQueue;

public class StackUsingPriorityQueue {

    PriorityQueue<StackElement> queue = new PriorityQueue<StackElement>(10, (o1, o2) -> {
        return o2.key - o1.key;
    });
    int order = 1;

    public void push(int val) {
        StackElement element = new StackElement(order++, val);
        queue.add(element);
    }

    public Integer pop() {
        if (queue.isEmpty()) {
            System.out.println(" Empty Stack");
            return null;
        }
        return queue.poll().value;
    }

    public static void main(String[] args) {
        StackUsingPriorityQueue q = new StackUsingPriorityQueue();
        q.push(1);
        q.push(2);
        q.push(3);
        System.out.print(q.pop() + " ");
        System.out.print(q.pop() + " ");
        System.out.print(q.pop() + " ");
    }

}

class StackElement {

    int key, value;

    public StackElement(int key, int value) {
        this.key = key;
        this.value = value;
    }

}