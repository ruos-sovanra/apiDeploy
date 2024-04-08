package co.istad.mobilebankingcstad.features.useraccount;
import co.istad.mobilebankingcstad.domain.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserAccountRepository extends JpaRepository<UserAccount,String> {

    // method for counting the number of account by user id

    @Query("SELECT COUNT(ua) FROM user_accounts_tbl ua WHERE ua.user.id = ?1")
    int  countAccountsByUserId(@Param("userId") String userId);

}
