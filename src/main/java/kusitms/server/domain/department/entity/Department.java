package kusitms.server.domain.department.entity;

import jakarta.persistence.*;
import kusitms.server.domain.company.entity.Company;
import kusitms.server.domain.tumbler.current.entity.TumblerCurrent;
import kusitms.server.domain.tumbler.history.entity.TumblerHistory;
import kusitms.server.domain.user.entity.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.FetchType.LAZY;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "DEPARTMENT")
@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dept_id")
    private Long id; // 부서 id

    @OneToOne(fetch = LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user; // 유저 id

    @ManyToOne(fetch = LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "company_id")
    private Company company; // 회사 id

    @Column(name = "dept_name", nullable = false)
    private String deptName; // 부서 이름

    @Column(name = "member_count", nullable = false)
    private Integer memberCount; // 부서 사원 수

    @OneToOne(mappedBy = "department", cascade = CascadeType.ALL, orphanRemoval = true)
    private TumblerCurrent tumblerCurrent;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TumblerHistory> tumblerHistories = new ArrayList<>();
}
