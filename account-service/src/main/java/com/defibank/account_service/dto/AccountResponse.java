package com.defibank.account_service.dto;

import java.math.BigDecimal;
import java.util.UUID;

public record AccountResponse(UUID id, BigDecimal balance, String currency) {

}
