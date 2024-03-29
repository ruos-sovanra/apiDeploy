package co.istad.mobilebankingcstad.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "users_tbl")
@Data
public class User {
    @Id
//    @GeneratedValue(generator = "UUID")
//    @GenericGenerator(
//            name = "UUID",
//            strategy = "org.hibernate.id.UUIDGenerator"
//    )
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(updatable = false, nullable = false)
    private UUID id;
    private String username;
    private String gender ;
    private int pin;
    private String email;
    private String password;
    private String profileImage;
    private String phoneNumber;
    private String cityOrProvince;
    private String khanOrDistrict;
    private String sangkatOrCommune;
    private String employeeType;
    private String companyName;
    private String mainSourceOfIncome;
    private BigDecimal monthlyIncomeRange;
    private String oneSignalId; // for notification
    private String studentIdCard;
    private Boolean isDeleted;  // for statistic usage!
    private Boolean isBlocked; // disable
    private LocalDateTime createdAt;

}
