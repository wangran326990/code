import java.util.*;

public class MinCostToConnectAllPoints {
    static class Solution {
        class Scope {
            int[] point1;
            int[] point2;
            int scope;
            public Scope(int[] point1, int[] point2) {
                this.point1 = point1;
                this.point2 = point2;
                this.scope = Math.abs(point1[0] - point2[0]) + Math.abs(point1[1] - point2[1]);
            }
            public boolean isEqual(Scope scope) {
                if(this.point1 == scope.point1 && this.point2 == scope.point2) return true;
                if(this.point2 == scope.point1 && this.point1 == scope.point2) return true;
                return false;
            }
        }
        public int minCostConnectPoints(int[][] points) {
            List<Scope> connectedEdges = new ArrayList<>();
            List<Scope> scopes = new ArrayList();
            for(int i = 0; i < points.length; i++) {
                for(int j = 0; j < points.length; j++ ) {
                    if(i != j) {
                        scopes.add(new Scope(points[i], points[j]));
                    }
                }
            }
            Collections.sort(scopes, (Scope scope1, Scope scope2)-> {
                return scope1.scope - scope2.scope;
            });
            int count = 0;
            int result = 0;
            for(Scope scope : scopes) {
                if(checkCircle(connectedEdges, scope)) {
                    continue;
                }else {
                    count++;
                    result += scope.scope;
                    if(points.length - 1 == count) {
                        return result;
                    }

                    connectedEdges.add(scope);
                }
            }
            return result;
        }

        private boolean checkCircle(List<Scope> edges, Scope newScope) {
            int edgesNumbers =edges.size();
            Set<int[]> differentPoints = new HashSet<>();
            differentPoints.add(newScope.point1);
            differentPoints.add(newScope.point2);
            for(Scope scope : edges) {
                if(newScope.isEqual(scope)) return true;
                differentPoints.add(scope.point1);
                differentPoints.add(scope.point2);
            }
            return differentPoints.size() <= edgesNumbers + 1;
        }
    }

        public static void main(String[] args) {
            Solution solution = new Solution();
            int[][] points = {{0,0},{2,2},{3,10},{5,2},{7,0}};
            solution.minCostConnectPoints(points);
        }



}
