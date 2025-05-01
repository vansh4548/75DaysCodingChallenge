import java.util.*;

class Solution {
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        Arrays.sort(tasks);
        Arrays.sort(workers);
        
        int low = 0, high = Math.min(tasks.length, workers.length), result = 0;
        
        while (low <= high) {
            int mid = (low + high) / 2;
            if (isFeasible(mid, tasks, workers, pills, strength)) {
                result = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        return result;
    }

    private boolean isFeasible(int k, int[] tasks, int[] workers, int pills, int strength) {
        Deque<Integer> taskList = new ArrayDeque<>();
        for (int i = k - 1; i >= 0; i--) {
            taskList.add(tasks[i]);
        }

        TreeMap<Integer, Integer> workerMap = new TreeMap<>();
        for (int i = workers.length - k; i < workers.length; i++) {
            workerMap.put(workers[i], workerMap.getOrDefault(workers[i], 0) + 1);
        }

        int remainingPills = pills;

        while (!taskList.isEmpty()) {
            int task = taskList.pollFirst();

            Integer normalWorker = workerMap.ceilingKey(task);
            if (normalWorker != null) {
                decrement(workerMap, normalWorker);
                continue;
            }

            if (remainingPills == 0) return false;

            Integer boostedWorker = workerMap.ceilingKey(task - strength);
            if (boostedWorker == null) return false;

            decrement(workerMap, boostedWorker);
            remainingPills--;
        }

        return true;
    }

    private void decrement(TreeMap<Integer, Integer> map, int key) {
        if (map.get(key) == 1) {
            map.remove(key);
        } else {
            map.put(key, map.get(key) - 1);
        }
    }
}
