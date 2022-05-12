package uber;

import java.util.*;

public class BusRoutes {
   static class Solution {
        public int numBusesToDestination(int[][] routes, int source, int target) {
            Map<Integer, List<Integer>> routeMap = new HashMap<>();
            getBusRoutes(routes, routeMap);
            boolean[] visited = new boolean[routes.length];
            Queue<Integer> queue = new LinkedList<>();
            List<Integer> startBuses = routeMap.getOrDefault(source, new ArrayList<>());
            for(Integer startBus : startBuses) {
                if(!visited[startBus]) {
                    visited[startBus] = true;
                    queue.offer(startBus);
                }

            }
            int result = 0;
            while(!queue.isEmpty()) {
                int busSize = queue.size();
                result++;
                for(int i = 0; i < busSize; i++) {
                    int curBus = queue.poll();
                    for(int busStop : routes[curBus]) {
                        if(busStop == target) return result;
                        List<Integer> startBusesCur = routeMap.getOrDefault(source, new ArrayList<>());
                        for(Integer startBus : startBusesCur) {
                            if(!visited[startBus]) {
                                visited[startBus] = true;
                                queue.offer(startBus);
                            }
                        }
                    }
                }
            }

            return -1;

        }
        private void getBusRoutes(int[][] routes, Map<Integer, List<Integer>> routeMap) {
            for(int i = 0; i < routes.length; i++) {
                for(int busStop : routes[i]) {
                    List<Integer> buses = routeMap.getOrDefault(busStop, new ArrayList<>());
                    buses.add(i);
                    routeMap.put(busStop, buses);
                }
            }
        }
    }

    public static void main(String[] args) {
        /**
         * [[1,2,7],[3,6,7]]
         * 1
         * 6
         */

        int[][] routes = {{1,2,7},{3,6,7}};
        Solution solution = new Solution();
        solution.numBusesToDestination(routes, 1, 6);
    }
}
