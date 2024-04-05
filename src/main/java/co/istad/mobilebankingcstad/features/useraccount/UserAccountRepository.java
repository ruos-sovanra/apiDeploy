package co.istad.mobilebankingcstad.features.useraccount;
import co.istad.mobilebankingcstad.domain.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UserAccountRepository extends JpaRepository<UserAccount,String> {
}
