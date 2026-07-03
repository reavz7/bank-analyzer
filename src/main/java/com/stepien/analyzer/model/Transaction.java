package com.stepien.analyzer.model;

import java.time.LocalDateTime;

public record Transaction(
    String transactionId,
    String accountId,
    double amount,
    LocalDateTime date,
    String type,
    String location,
    String deviceId,
    String ipAddress,
    String merchantId,
    String channel
) {}