package dsa.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

class ArrayEntry {

    public Integer value;
    public Integer arrayld;

    public ArrayEntry(Integer value, Integer arrayld) {
        this.value = value;
        this.arrayld = arrayld;
    }

}

public class MergeSortedArrays {

    private static enum SubarrayType {
        INCREASING, DECREASING
    }

    // : 11.1 Merge Sorted Arrays
    public static List<Integer> mergeSortedArrays(
            List<List<Integer>> sortedArrays) {
        List<Iterator<Integer>> iters = new ArrayList<>(sortedArrays.size());
        for (List<Integer> array : sortedArrays) {
            iters.add(array.iterator());
        }
        PriorityQueue<ArrayEntry> minHeap = new PriorityQueue<>(
                sortedArrays.size(), (o1, o2) -> {
                    return Integer.compare(o1.value, o2.value);
                });
        for (int i = 0; i < iters.size(); ++i) {
            if (iters.get(i).hasNext()) {
                minHeap.add(new ArrayEntry(iters.get(i).next(), i));
            }
        }
        List<Integer> result = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            ArrayEntry headEntry = minHeap.poll();
            result.add(headEntry.value);
            if (iters.get(headEntry.arrayld).hasNext()) {
                minHeap.add(new ArrayEntry(iters.get(headEntry.arrayld).next(),
                        headEntry.arrayld));
            }
        }
        return result;
    }

    // : 11.2 SORT AN INCREASING-DECREASING ARRAY
    public static List<Integer> sortKIncreasingDecreasingArray(List<Integer> A) {
        // Decomposes A into a set of sorted arrays.
        List<List<Integer>> sortedSubarrays = new ArrayList<>();
        SubarrayType subarrayType = SubarrayType.INCREASING;
        int startldx = 0;
        for (int i = 1; i <= A.size(); ++i) {
            if (i == A.size() // A is ended. Adds the last subarray
                    || (A.get(i - 1) < A.get(i)
                            && subarrayType == SubarrayType.DECREASING)
                    || (A.get(i - 1) >= A.get(i)
                            && subarrayType == SubarrayType.INCREASING)) {
                List<Integer> subList = A.subList(startldx, i);
                if (subarrayType == SubarrayType.DECREASING) {
                    Collections.reverse(subList);
                }
                sortedSubarrays.add(subList);
                startldx = i;
                subarrayType = (subarrayType == SubarrayType.INCREASING
                        ? SubarrayType.DECREASING
                        : SubarrayType.INCREASING);
            }
        }
        return MergeSortedArrays.mergeSortedArrays(sortedSubarrays);
    }

    // : 11.3 SORT AN ALMOST-SORTED ARRAY
    public void sortApproximatelySortedData(Iterator<Integer> sequence,
            int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        // Adds the first k elements into minHeap. Stop if there are fewer than k
        // elements .
        for (int i = 0; i < k && sequence.hasNext(); ++i) {
            minHeap.add(sequence.next());
        }
        // For every new element, add it to minHeap and extract the smallest.
        while (sequence.hasNext()) {
            minHeap.add(sequence.next());
            Integer smallest = minHeap.remove();
            System.out.println(smallest);
            // sequence is exhausted, iteratively extracts the remaining elements.
            while (!minHeap.isEmpty()) {
                Integer small = minHeap.remove();
                System.out.println(small);
            }
        }
    }

}