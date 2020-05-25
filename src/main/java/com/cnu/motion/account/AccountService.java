package com.cnu.motion.account;

import com.cnu.motion.common.exception.ResourceNotFoundException;
import com.cnu.motion.common.type.Exception;
import com.cnu.motion.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;

    public Account getAccountWithId(String id) {
        return accountRepository.findAccountById(id).orElseThrow(() -> new ResourceNotFoundException(Exception.ACCOUNT_NOT_FOUND));
    }
}
