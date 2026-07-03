# Bank Transaction Analyzer 🏦

A lightweight, high-performance Java console application built to process and analyze raw bank transaction data. Developed using modern Java (JDK 17) and built with Maven, it serves as an interactive CLI tool for financial data analysis and basic fraud detection.

## 🚀 Features
* **Interactive CLI Menu:** A user-friendly console interface allowing dynamic queries.
* **Custom Data Parsing:** Efficiently reads and parses large datasets of CSV transactions into Java Objects without relying on heavy external libraries.
* **Fraud Detection (Thresholds):** Filters and flags suspicious transactions exceeding user-defined amounts.
* **Top Transactions:** Retrieves the highest value transactions instantly using sorting algorithms.
* **Aggregated Reporting:** Uses the Java Streams API to group, sum, and analyze financial data by transaction channels (ATM, Branch, Online).
* **Decoupled Architecture:** Built with SOLID principles in mind, utilizing interfaces (`DataParser` and `ReportExporter`) to ensure scalability and separation of concerns.

## 🛠️ Tech Stack
* **Language:** Java 17 (utilizing modern features like `record`, `Stream API`, and `Lambdas`).
* **Build Tool:** Apache Maven.
* **Paradigm:** Object-Oriented Programming (OOP).

## 💡 Future Improvements
This project serves as a core logic foundation for a larger architectural transition. The next planned steps include:
* Migrating the core logic into a **Spring Boot** application to expose analysis results via RESTful API endpoints.
* Replacing the CSV parser with a relational database integration (SQL / Hibernate / Spring Data JPA).
* Adding JUnit 5 tests for robust logic validation.

## 👨‍💻 How to Run

Ensure you have **Java 17** and **Maven** installed on your machine.

1. Clone the repository:
   ```bash
   git clone [https://github.com/reavz7/bank-analyzer.git](https://github.com/reavz7/bank-analyzer.git)
