import com.adt.ds.Queue;

public class QueuesTest {
    public static void main(String args[]) {
        Queue q = new Queue(5);
        q.insert(1);
        q.insert(6);
        q.insert(10);
        q.insert(5);
        q.insert(2);
        q.insert(2);
        q.insert(2);
        q.insert(2);
        q.remove();
        q.view();
        q.remove();
        q.remove();
        q.remove();
        q.remove();
        q.remove();
        q.remove();
        q.remove();
        q.remove();

        q.view();
    }
}
