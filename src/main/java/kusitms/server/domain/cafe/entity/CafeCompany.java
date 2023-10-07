package kusitms.server.domain.cafe.entity;


import jakarta.persistence.*;
import kusitms.server.domain.company.entity.Company;
import kusitms.server.domain.user.entity.User;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Entity
public class CafeCompany {
    @Id
    @Column(name = "cafe_company_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cafe_id")
    private Cafe cafe;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

}
