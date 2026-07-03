package com.stepien.analyzer.parser;

import com.stepien.analyzer.model.Transaction;
import java.util.List;

public interface DataParser {
    List<Transaction> parse(String filePath);
}