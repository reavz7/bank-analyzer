package com.stepien.analyzer.exporter;

import com.stepien.analyzer.model.Transaction;
import java.util.List;
import java.util.Map;

public class ConsoleReportExporter implements ReportExporter {

    @Override
    public void exportSuspicious(List<Transaction> transactions, double threshold) {
        System.out.println("\n--- RAPORT: Transakcje powyżej " + threshold + " PLN ---");
        if (transactions.isEmpty()) {
            System.out.println("Brak transakcji powyżej tej kwoty.");
        } else {
            for (Transaction t : transactions) {
                System.out.println("ID: " + t.transactionId() + " | Kwota: " + t.amount() + " | Lokalizacja: " + t.location());
            }
            System.out.println("💡 Znaleziono łącznie: " + transactions.size() + " takich transakcji.");
        }
        System.out.println();
    }

    @Override
    public void exportChannelStats(Map<String, Double> channelStats) {
        System.out.println("\n--- RAPORT: Suma transakcji per kanał ---");
        channelStats.forEach((channel, total) -> 
            System.out.printf("Kanał: %s -> %.2f PLN\n", channel, total)
        );
        System.out.println();
    }

    @Override
    public void exportTopTransactions(List<Transaction> transactions) {
        System.out.println("\n--- RAPORT: Największe transakcje ---");
        for (int i = 0; i < transactions.size(); i++) {
            Transaction t = transactions.get(i);
            System.out.println((i + 1) + ". ID: " + t.transactionId() + " | Kwota: " + t.amount() + " PLN | Kanał: " + t.channel());
        }
        System.out.println();
    }
}