package com.defibank.account_service.service;

import com.defibank.account_service.dto.AccountRequest;
import com.defibank.account_service.dto.AccountResponse;
import com.defibank.account_service.entity.Account;
import com.defibank.account_service.repository.AccountRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.security.auth.login.AccountNotFoundException;
import java.util.UUID;

public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Transactional
    public AccountResponse createAccount(AccountRequest request) {
        Account account = Account.builder()
                .balance(request.initialBalance())
                .currency(request.currency())
                .build();
        accountRepository.save(account);
        return new AccountResponse(account.getId(), account.getBalance(), account.getCurrency());
    }

    public AccountResponse getAccountById(UUID accountId) throws AccountNotFoundException {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new AccountNotFoundException("Account not found for id: " + accountId));
        return new AccountResponse(account.getId(), account.getBalance(), account.getCurrency());
    }

}
