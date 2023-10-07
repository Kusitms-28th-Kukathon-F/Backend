package kusitms.server.domain.user.entity;

import jakarta.persistence.*;
import kusitms.server.domain.cafe.entity.Cafe;
import kusitms.server.domain.company.entity.Company;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Table(name = "user")
@Entity
public class User {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="login_id")
    private String loginId;

    @Column(name="password")
    private String password;

    @Enumerated(value = EnumType.STRING)
    @Column(name="role")
    private UserRole role;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Cafe cafe;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Company company;
}
