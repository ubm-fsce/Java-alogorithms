package epi.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

// TODO : 11.4 COMPUTE THE k CLOSEST STARS
public class Star implements Comparable<Star> {

    private double x, y, z;

    public Star(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double distance() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    @Override
    public int compareTo(Star rhs) {
        return Double.compare(this.distance(), rhs.distance());
    }

    // TODO : 11.4 COMPUTE THE k CLOSEST STARS
    public static List<Star> findClosestKStars(int ks, Iterator<Star> stars) {
        //(int ks, Iterator<Star> star){
        // maxHeap to store the closest k stars seen so far.
        PriorityQueue<Star> maxHeap
                = new PriorityQueue<>(ks, Collections.reverseOrder());
        while (stars.hasNext()) {
            // Add each star to the max -heap. If the max-heap size exceeds k, remove
            // the maximum element from the max-heap.
            Star star = stars.next();
            maxHeap.add(star);
            if (maxHeap.size() == ks + 1) {
                maxHeap.remove();
            }
        }
        List<Star> orderedStars = new ArrayList<Star>(maxHeap);
        // The only guarantee PriorityQueue makes about ordering is that the
        // maximum element comes first, so we sort orderedStars.
        Collections.sort(orderedStars);
        return orderedStars;
    }

}
