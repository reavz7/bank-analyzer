package com.stepien.analyzer.service;

import com.stepien.analyzer.model.Transaction;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TransactionAnalyzer {

    private final List<Transaction> transactions;

    public TransactionAnalyzer(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public List<Transaction> findTransactionsAboveAmount(double amountThreshold) {
        return transactions.stream()
                .filter(t -> t.amount() > amountThreshold)
                .collect(Collectors.toList());
    }

    public Map<String, Double> calculateTotalAmountByChannel() {
        return transactions.stream()
                .collect(Collectors.groupingBy(
                        Transaction::channel,
                        Collectors.summingDouble(Transaction::amount)
                ));
    }

    public List<Transaction> findTopHighestTransactions(int limit) {
        return transactions.stream()
                .sorted((t1, t2) -> Double.compare(t2.amount(), t1.amount())) 
                .limit(limit)
                .collect(Collectors.toList());
    }
}