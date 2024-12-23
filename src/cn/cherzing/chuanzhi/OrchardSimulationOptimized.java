package cn.cherzing.chuanzhi;

/**
 * @author Cherzing
 * @date 2024/12/29 0029 16:48
 * @description OrchardSimulationOptimized
 */
import java.util.*;

public class OrchardSimulationOptimized {
    static class SegmentTree {
        private int[] tree;
        private int n;

        public SegmentTree(int n) {
            this.n = n;
            tree = new int[4 * n];
        }

        public void update(int idx, int val) {
            idx += n;
            tree[idx] = val;
            while (idx > 1) {
                idx >>= 1;
                tree[idx] = Math.min(tree[idx << 1], tree[idx << 1 | 1]);
            }
        }

        public int query(int l, int r) {
            l += n;
            r += n;
            int res = Integer.MAX_VALUE;
            while (l < r) {
                if ((l & 1) != 0) {
                    res = Math.min(res, tree[l]);
                    l++;
                }
                if ((r & 1) != 0) {
                    r--;
                    res = Math.min(res, tree[r]);
                }
                l >>= 1;
                r >>= 1;
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        while (T-- > 0) {
            int n = scanner.nextInt();
            int q = scanner.nextInt();
            int[] fruits = new int[n];
            Map<Integer, Integer> fruitCount = new HashMap<>();

            for (int i = 0; i < n; i++) {
                fruits[i] = scanner.nextInt();
                fruitCount.put(fruits[i], fruitCount.getOrDefault(fruits[i], 0) + 1);
            }

            SegmentTree st = new SegmentTree((int) 1e6 + 1);
            for (Map.Entry<Integer, Integer> entry : fruitCount.entrySet()) {
                int count = entry.getValue();
                st.update(count, st.query(0, count) - 1);
            }

            int[] queries = new int[q];
            for (int i = 0; i < q; i++) {
                queries[i] = scanner.nextInt();
            }

            for (int d : queries) {
                System.out.print(st.query(0, d + 1) + " ");
            }
            System.out.println();
        }
        scanner.close();
    }
}