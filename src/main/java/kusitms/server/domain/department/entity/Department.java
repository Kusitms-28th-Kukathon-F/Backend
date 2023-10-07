package kusitms.server.domain.department.entity;

import jakarta.persistence.*;
import kusitms.server.domain.company.entity.Company;
import kusitms.server.domain.user.entity.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static jakarta.persistence.FetchType.LAZY;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "Department")
@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dept_id")
    private Long id; // 부서 id

    @OneToOne(fetch = LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user; // 유저 id

    @OneToOne(fetch = LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "company_id")
    private Company company; // 회사 id

    @Column(name = "dept_name", nullable = false)
    private String deptName; // 부서 이름

    @Column(name = "member_count", nullable = false)
    private Integer memberCount; // 부서 사원 수

}
