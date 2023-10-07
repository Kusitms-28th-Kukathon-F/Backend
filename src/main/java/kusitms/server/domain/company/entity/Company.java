package kusitms.server.domain.company.entity;

import jakarta.persistence.*;
import kusitms.server.domain.department.entity.Department;
import kusitms.server.domain.cafe.entity.CafeCompany;
import kusitms.server.domain.user.entity.User;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Entity
public class Company {

    @Id
    @Column(name = "company_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="company_name")
    private String companyName;

    @Column(name="company_period")
    private Long companyPeriod;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Department> departments = new ArrayList<>();

    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY)
    private List<CafeCompany> cafeCompanies = new ArrayList<>();

}
