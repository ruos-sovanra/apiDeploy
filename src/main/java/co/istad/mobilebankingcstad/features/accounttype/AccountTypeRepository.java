package co.istad.mobilebankingcstad.features.accounttype;

import co.istad.mobilebankingcstad.domain.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountTypeRepository extends JpaRepository<AccountType,String> {
}
