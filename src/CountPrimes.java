public class CountPrimes {
    public int countPrimes(int n) {
        if(n <= 1) return 0;
        int count = 0;
        boolean[] notPrime = new boolean[n];
        for(int i = 2; i < n; i++ ) {
            if(!notPrime[i]) {
                for(int j = i; j * i < n; j++) {
                    notPrime[j * i] = true;
                }
                count++;
            }
        }
        return count;
    }
}
