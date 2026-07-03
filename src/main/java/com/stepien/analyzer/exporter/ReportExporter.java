package com.stepien.analyzer.exporter;

import com.stepien.analyzer.model.Transaction;
import java.util.List;
import java.util.Map;

public interface ReportExporter {
    void exportSuspicious(List<Transaction> transactions, double threshold);
    void exportChannelStats(Map<String, Double> channelStats);
    void exportTopTransactions(List<Transaction> transactions);
}