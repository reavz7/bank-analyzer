package com.stepien.analyzer;

import com.stepien.analyzer.exporter.ConsoleReportExporter;
import com.stepien.analyzer.exporter.ReportExporter;
import com.stepien.analyzer.model.Transaction;
import com.stepien.analyzer.parser.CsvDataParser;
import com.stepien.analyzer.parser.DataParser;
import com.stepien.analyzer.service.TransactionAnalyzer;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("Rozpoczynam inicjalizację systemu...\n");

        // UWAGA: Upewnij się, że ścieżka do pliku CSV jest poprawna!
        String filePath = "data\\bank_transactions_data_2_augmented_clean_2.csv"; 
        DataParser parser = new CsvDataParser();
        List<Transaction> transactions = parser.parse(filePath);

        if (transactions.isEmpty()) {
            System.out.println("Brak danych do analizy.");
            return;
        }

        TransactionAnalyzer analyzer = new TransactionAnalyzer(transactions);
        ReportExporter exporter = new ConsoleReportExporter();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("✅ Pomyślnie wczytano " + transactions.size() + " transakcji.");

        while (running) {
            System.out.println("=====================================");
            System.out.println(" 🏦 BANK FRAUD & ANALYSIS SYSTEM");
            System.out.println("=====================================");
            System.out.println("1. Pokaż transakcje powyżej podanej kwoty (Fraud Detection)");
            System.out.println("2. Pokaż największe transakcje (Top X)");
            System.out.println("3. Podsumuj obrót per Kanał (ATM / Online / Branch)");
            System.out.println("4. Wyjście z programu");
            System.out.print("👉 Wybierz opcję (1-4): ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Podaj kwotę odcięcia (np. 1500): ");
                    try {
                        double threshold = Double.parseDouble(scanner.nextLine());
                        List<Transaction> suspicious = analyzer.findTransactionsAboveAmount(threshold);
                        exporter.exportSuspicious(suspicious, threshold);
                    } catch (Exception e) {
                        System.out.println("❌ Błąd: Podaj poprawną liczbę!\n");
                    }
                    break;
                case "2":
                    System.out.print("Ile największych transakcji chcesz zobaczyć? (np. 5): ");
                    try {
                        int limit = Integer.parseInt(scanner.nextLine());
                        List<Transaction> top = analyzer.findTopHighestTransactions(limit);
                        exporter.exportTopTransactions(top);
                    } catch (Exception e) {
                        System.out.println("❌ Błąd: Podaj poprawną liczbę całkowitą!\n");
                    }
                    break;
                case "3":
                    Map<String, Double> byChannel = analyzer.calculateTotalAmountByChannel();
                    exporter.exportChannelStats(byChannel);
                    break;
                case "4":
                    System.out.println("👋 Zamykanie systemu. Miłego dnia!");
                    running = false;
                    break;
                default:
                    System.out.println("❌ Błąd: Nieznana opcja. Wybierz od 1 do 4.\n");
            }
        }
        scanner.close();
    }
}