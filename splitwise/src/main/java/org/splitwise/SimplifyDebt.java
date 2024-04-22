package org.splitwise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimplifyDebt {
    public static void main(String[] args) {
        int[][] transactions = {{0, 1, 5}, {1, 2, 5}, {2, 0, 10}, {0, 2, 1}};
        System.out.println(minTransfers(transactions));
    }

    // TC: O(n!)
    public static int minTransfers(int[][] transactions) {
        Map<Integer, Integer> memberVsBalanceMap = new HashMap<>();

        for (int[] txn : transactions) {
            int from = txn[0];
            int to = txn[1];
            int amount = txn[2];

            memberVsBalanceMap.put(from, memberVsBalanceMap.getOrDefault(from, 0) - amount);
            memberVsBalanceMap.put(to, memberVsBalanceMap.getOrDefault(to, 0) + amount);
        }

        List<Integer> balances = new ArrayList<>();
        for (int amount : memberVsBalanceMap.values()) {
            if (amount != 0) balances.add(amount);
        }

        return dfs(balances, 0);
    }

    private static int dfs(List<Integer> balances, int idx) {
        if (idx >= balances.size()) return 0;

        int currentVal = balances.get(idx);

        if (balances.get(idx) == 0) return dfs(balances, idx + 1);

        int minTransactions = Integer.MAX_VALUE;

        for (int txnIdx = idx + 1; txnIdx < balances.size(); txnIdx++) {
            int nextVal = balances.get(txnIdx);

            if (currentVal * nextVal < 0) {
                balances.set(txnIdx, currentVal + nextVal);
                int nextResult = dfs(balances, idx + 1);
                if (nextResult == Integer.MAX_VALUE) continue;
                minTransactions = Math.min(minTransactions, 1 + nextResult);
                balances.set(txnIdx, nextVal);

                if (currentVal + nextVal == 0) break;
            }
        }

        return minTransactions;
    }
}
