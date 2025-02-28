import java.util.PriorityQueue;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        // Min heap with size k
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Add elements to the heap
        for (int num : nums) {
            minHeap.add(num);
            if (minHeap.size() > k) {
                minHeap.poll(); // Remove the smallest element to maintain size k
            }
        }

        // The top element is the kth largest
        return minHeap.peek();
    }
}
