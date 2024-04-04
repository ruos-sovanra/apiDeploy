package co.istad.mobilebankingcstad.features.accounts;


import co.istad.mobilebankingcstad.features.accounts.dto.AccountRequest;
import co.istad.mobilebankingcstad.features.accounts.dto.AccountResponse;
import co.istad.mobilebankingcstad.features.accounttype.AccountTypeRepository;
import co.istad.mobilebankingcstad.features.user.UserRepository;
import co.istad.mobilebankingcstad.mapper.AccountMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService{
    private final AccountMapper accountMapper;
    private final AccountTypeRepository accountTypeRepository;
    private final AccountRepository accountRepository;
    private final UserRepository userRepository;
    @Override
    public List<AccountResponse> getAllAccounts() {
        return null;
    }

    @Override
    public AccountResponse createAccount(AccountRequest request) {
        return null;
    }

    @Override
    public AccountResponse findAccountById(String id) {
        return null;
    }

    @Override
    public AccountResponse findAccountByAccountNumber(String accountNumber) {
        return null;
    }

    @Override
    public List<AccountResponse> findAccountsByUserId(String userId) {
        return null;
    }
}
