/*
    TC: O(n * budget^2)
    SC: O(n * budget)
*/

import java.util.*;

class Solution {
    int n;
    List<List<Integer>> graph;
    int[][][] dp;
    int[] present, future;

    public void dfs(int i, int budget) {  
        List<int[][]> childrendp = new ArrayList<>();

        for (int j : graph.get(i)) {
            dfs(j, budget);
            childrendp.add(new int[][]{dp[j][0], dp[j][1]});
        }

        for (int parentBought = 0; parentBought <= 1; parentBought++) {

            int price = (parentBought == 1) ? present[i] / 2 : present[i];
            int profit = future[i] - price;

            int[] best = new int[budget + 1];

            int[] childrenProfitIfUNotBought = new int[budget + 1];

            for (int[][] child : childrendp) {
                int[] childNoBuy = child[0];
                int[] temp = new int[budget + 1];

                for (int used = 0; used <= budget; used++) {
                    for (int take = 0; used + take <= budget; take++) {
                        temp[used + take] = Math.max(temp[used + take], childrenProfitIfUNotBought[used] + childNoBuy[take]
                        );
                    }
                }
                childrenProfitIfUNotBought = temp;
            }

            for (int b = 0; b <= budget; b++) {
                best[b] = Math.max(best[b], childrenProfitIfUNotBought[b]);
            }

            if (price <= budget) {
                int[] childrenProfitIfUBought = new int[budget + 1];

                for (int[][] child : childrendp) {
                    int[] childBuy = child[1];
                    int[] temp = new int[budget + 1];

                    for (int used = 0; used <= budget; used++) {
                        for (int take = 0; used + take <= budget; take++) {
                            temp[used + take] = Math.max(temp[used + take], childrenProfitIfUBought[used] + childBuy[take]);
                        }
                    }
                    childrenProfitIfUBought = temp;
                }

                for (int b = price; b <= budget; b++) {
                    best[b] = Math.max(best[b], childrenProfitIfUBought[b - price] + profit);
                }
            }

            dp[i][parentBought] = best;
        }
    }

    public int maxProfit(int n, int[] present, int[] future, int[][] hierarchy, int budget) {
        this.n = n;
        dp = new int[n][2][budget+1];
        this.future = future;
        this.present = present;
        graph = new ArrayList<>();

        for(int i = 0; i < n; i++) graph.add(new ArrayList<>());

        for(int[] h: hierarchy) {
            int u = h[0] - 1;
            int v = h[1] - 1;
            graph.get(u).add(v);
        }

        dfs(0, budget);

        int max = 0;
        for (int b = 0; b <= budget; b++) {
            max = Math.max(max, dp[0][0][b]);
        }
        return max;
    }
}