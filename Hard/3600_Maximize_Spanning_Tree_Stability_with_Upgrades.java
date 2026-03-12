/*
    TC: O(e * log e)
    SC: O(n)

*/

import java.util.*;

class DSU {
    int n;
    int[] size;
    int[] parent;

    DSU(int n) {
        this.n = n;
        size = new int[n];
        parent = new int[n];

        for(int i = 0; i < n; ++ i) {
            size[i] = 1;
            parent[i] = -1;
        }
    }

    int find(int u) {
        if(parent[u] == -1) return u;
        return parent[u] = find(parent[u]);
    }

    void union(int u, int v) {
        if(size[u] < size[v]) {
            parent[u] = v;
            size[v] += size[u];
        } else {
            parent[v] = u;
            size[u] += size[v];
        }
    }
}

class Solution {
    public boolean check(int n, int[][] edges, int k, int mid) {
        DSU dsu = new DSU(n);

        int cnt = 0;

        for(int[] e: edges) {
            int u = e[0], v = e[1];
            int s = e[2];
            int m = e[3];

            int paru = dsu.find(u);
            int parv = dsu.find(v);

            if(m == 1) {
                if(s < mid || paru == parv) return false;
                dsu.union(paru, parv);
                cnt++;
            } else {
                if(paru != parv) {
                    if(s >= mid) {
                        dsu.union(paru, parv);
                        cnt++;
                    } else if(k > 0 && 2 * s >= mid) {
                        dsu.union(paru, parv);
                        k--;
                        cnt++;
                    }
                }
            }
        }

        return cnt == n-1;
    }

    public int maxStability(int n, int[][] edges, int k) {
        Arrays.sort(edges, (a, b) -> {
            if(a[3] != b[3]) return Integer.compare(b[3], a[3]);
            return Integer.compare(b[2], a[2]);
        });

        int l = 0, r = 200000;

        while(l <= r) {
            int mid = (l + r) / 2;
            // System.out.println(l + " " + mid + " " + r);

            if(check(n, edges, k, mid)) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return r;
    }
}