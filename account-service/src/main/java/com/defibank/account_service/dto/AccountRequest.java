package com.defibank.account_service.dto;

import java.math.BigDecimal;

public record AccountRequest(BigDecimal initialBalance, String currency) {
}
