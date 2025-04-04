package com.defibank.account_service.event;

import java.util.UUID;

public record AccountCreatedEvent(UUID accountId) {
}
