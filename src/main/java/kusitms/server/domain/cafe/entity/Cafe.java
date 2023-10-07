package kusitms.server.domain.cafe.entity;

import jakarta.persistence.*;
import kusitms.server.domain.user.entity.User;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Entity
public class Cafe {

    @Id
    @Column(name = "cafe_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="cafe_name")
    private String cafeName;

    @Column(name="latitude")
    private Long latitude;

    @Column(name="longitude")
    private Long longitude;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

}
