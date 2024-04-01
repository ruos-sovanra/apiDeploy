package co.istad.mobilebankingcstad.features.user;

import co.istad.mobilebankingcstad.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
}
