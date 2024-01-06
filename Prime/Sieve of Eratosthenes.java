
class Solution {
    public static long sumOfPowers(long a, long b) {
        List<Integer> spf = new ArrayList<>(Collections.nCopies((int) (b + 1), -1));
        if (b == 1)
            return 0;
        if (a == 1)
            a++;
        for (int i = 2; i <= b; i++) {
            if (spf.get(i) == -1) {
                for (int j = i; j <= b; j += i)
                    spf.set(j, i);
            }
        }
        long ans = 0;
        for (int i = (int) a; i <= b; i++) {
            int x = i;
            while (x != 1) {
                x /= spf.get(x);
                ans++;
            }
        }
        return ans;
    }
}
