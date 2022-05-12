package uber;

public class UberEasy1 {
    static class UberEasy1Solution {
        /**
         * Easy:
         * Given an array A return an output array B of size [A.length - 2] where B[i] = 1 if sides A[i],A[i+1] and A[i+2] form a triangle. Otherwise, set B[i] = 0.
         * ex. A = [1, 2, 2, 5, 5, 4] should return B = [1,0,0,1]
         */
        public int[] solution(int[] A) {
            if(A.length < 3) return new int[]{0};
            int[] B = new int[A.length - 2];
            int indxB = 0;
            for(int i = 1; i < A.length - 1; i++) {
                int edge1 = A[i-1];
                int edge2 = A[i];
                int edge3 = A[i+1];
                if(edge1 < edge2 + edge3 && edge3 < edge1 + edge2 && edge2 < edge1 + edge3) {
                    B[indxB++] = 1;
                }else {
                    B[indxB++] = 0;
                }
            }
            return B;
        }
    }

    public static void main(String[] args) {
        UberEasy1Solution solution = new UberEasy1Solution();

        System.out.println(solution.solution(new int[] {1, 2, 2, 5, 5, 4}));
    }
}

