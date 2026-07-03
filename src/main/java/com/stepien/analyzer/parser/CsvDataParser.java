package com.stepien.analyzer.parser;

import com.stepien.analyzer.model.Transaction;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CsvDataParser implements DataParser {

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("M/d/yyyy HH:mm");

    @Override
    public List<Transaction> parse(String filePath) {
        List<Transaction> transactions = new ArrayList<>();
        
        try {
            List<String> lines = Files.readAllLines(Path.of(filePath));
            
            for (int i = 1; i < lines.size(); i++) {
                String line = lines.get(i);
                if (line.isBlank()) continue;
                
                String[] parts = line.split(",");
                
                Transaction transaction = new Transaction(
                    parts[0], 
                    parts[1], 
                    Double.parseDouble(parts[2]), 
                    LocalDateTime.parse(parts[3], DATE_FORMATTER), 
                    parts[4], 
                    parts[5], 
                    parts[6], 
                    parts[7], 
                    parts[8], 
                    parts[9]  
                );
                
                transactions.add(transaction);
            }
        } catch (IOException e) {
            System.err.println("Błąd odczytu pliku: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Błąd parsowania danych: " + e.getMessage());
        }
        
        return transactions;
    }
}