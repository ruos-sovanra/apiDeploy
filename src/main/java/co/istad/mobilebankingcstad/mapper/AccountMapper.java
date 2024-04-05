package co.istad.mobilebankingcstad.mapper;


import co.istad.mobilebankingcstad.domain.Account;
import co.istad.mobilebankingcstad.domain.User;
import co.istad.mobilebankingcstad.features.accounts.dto.AccountRequest;
import co.istad.mobilebankingcstad.features.accounts.dto.AccountResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface AccountMapper
{
    @Mapping(target = "accountType",ignore = true)
    Account mapRequestToEntity(AccountRequest accountRequest);


    @Mapping(target = "user",ignore = true)
    @Mapping(target = "accountType", expression = "java(account.getAccountType().getName())")
    AccountResponse mapUserAccountToAccountResponse(Account account);


//    @Mapping(target = "user", source = "user")

    void setUserForAccountResponse(@MappingTarget AccountResponse accountResponse, User user);

}
