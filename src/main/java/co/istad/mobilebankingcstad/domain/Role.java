package co.istad.mobilebankingcstad.domain;


import jakarta.persistence.*;

@Entity
@Table(name = "roles_tbl")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    // stuff , admin , ...
    @Column(nullable = false, length = 25)
    private String name;
}
