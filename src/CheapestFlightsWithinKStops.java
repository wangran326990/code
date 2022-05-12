import java.util.*;

public class CheapestFlightsWithinKStops {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] prev = new int[n];
        int[] cur = new int[n];
        Arrays.fill(cur, Integer.MAX_VALUE);
        cur[src] = 0;
        Map<Integer, List<int[]>> neighbors = getNeighbors(flights);
        while(k >= 0) {
            prev = Arrays.copyOf(cur, n);
            for(int i = 0; i < n; i++) {
                if(prev[i] != Integer.MAX_VALUE) {
                    List<int[]> neighborList = neighbors.getOrDefault(i, new ArrayList<>());
                    for (int[] neighbor : neighborList) {
                        int start = neighbor[0];
                        int des = neighbor[1];
                        int cost = neighbor[2];
                        if (prev[start] != Integer.MAX_VALUE && cur[des] > prev[start] + cost) {
                            cur[des] = prev[start] + cost;
                        }
                    }
                }
            }
            k--;
        }
        return cur[dst] == Integer.MAX_VALUE ? -1 : cur[dst];
    }

    private Map<Integer, List<int[]>> getNeighbors(int[][] flights) {
        Map<Integer, List<int[]>> neighbors = new HashMap<>();
        for(int[] flight : flights) {
            int src = flight[0];
            List<int[]> neighborList = neighbors.getOrDefault(src, new ArrayList<>());
            neighborList.add(flight);
            neighbors.put(src, neighborList);
        }
        return neighbors;
    }
}
