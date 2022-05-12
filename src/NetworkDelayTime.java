import data.Pair;

import java.util.*;

public class NetworkDelayTime {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<Pair<Integer, Integer>>> neighborMap = new HashMap<>();
        for(int[] time : times) {
            int start = time[0] - 1;
            int end = time[1] - 1;
            int timeSpend = time[2];
            List<Pair<Integer, Integer>> neighbors = neighborMap.getOrDefault(start, new ArrayList<>());
            neighbors.add(new Pair<>(timeSpend, end));
            neighborMap.put(start, neighbors);
        }
        int result = helper(neighborMap, n, k-1);
        return result == Integer.MAX_VALUE ? -1 : result;

    }

    private int helper(Map<Integer, List<Pair<Integer, Integer>>> neighborMap, int n, int souce) {
        boolean visited[] = new boolean[n];
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        int[] signalReceivedAt = new int[n];
        Arrays.fill(signalReceivedAt, Integer.MAX_VALUE);
        queue.offer(new Pair<>(0, souce));
        signalReceivedAt[souce] = 0;
        int result = 0;
        while(!queue.isEmpty()) {
            Pair<Integer, Integer> current = queue.poll();
            int start = current.getValue();
            int time = current.getKey();
            if(time > signalReceivedAt[start]) continue;

            if(visited[start]) continue;

            visited[start] = true;

            List<Pair<Integer, Integer>> neighbors = neighborMap.getOrDefault(start, new ArrayList<>());
            for(Pair<Integer, Integer> neighbor : neighbors) {
                int timeToNeighbor = neighbor.getKey();
                int dest = neighbor.getValue();
                int total = timeToNeighbor + time;
                if(total < signalReceivedAt[dest]) {
                    signalReceivedAt[dest] = total;
                    queue.offer(new Pair<>(total, dest));
                }
            }

        }

        for(int time : signalReceivedAt) {
            if(result < time) {
                result = time;
            }
        }
        return result;
    }
}
