package co.istad.mobilebankingcstad.features.accounts;


import co.istad.mobilebankingcstad.features.accounts.dto.AccountRequest;
import co.istad.mobilebankingcstad.features.accounts.dto.AccountResponse;
import co.istad.mobilebankingcstad.features.accounttype.AccountTypeRepository;
import co.istad.mobilebankingcstad.features.user.UserRepository;
import co.istad.mobilebankingcstad.mapper.AccountMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
        // check account type
        var accountType = accountTypeRepository
                .findByName(request.accountType())
                .orElseThrow(
                        () -> new ResponseStatusException(
                        HttpStatus.BAD_REQUEST,
                        "Account Type : " + request.accountType() + " is not valid! "));
        var owner = userRepository.findById(request.userId())
                .orElseThrow(
                        ()-> new ResponseStatusException(
                                HttpStatus.BAD_REQUEST,
                                "User ID = "+request.userId()+" is not a valid user"
                        )
                );


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
