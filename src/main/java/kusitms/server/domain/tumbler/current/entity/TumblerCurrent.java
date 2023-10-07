package kusitms.server.domain.tumbler.current.entity;

import jakarta.persistence.*;
import kusitms.server.domain.department.entity.Department;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static jakarta.persistence.FetchType.LAZY;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "TUMBLER_CURRENT")
@Entity
public class TumblerCurrent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tumbler_cur_id")
    private Long id; // 현재 부서별 텀블러 id

    @OneToOne(fetch = LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "dept_id")
    private Department department; // 부서 id

    @Column(name = "tumbler_name", nullable = false)
    private String tumblerName; // 이번달 부서별 텀블러 이름

    @Column(name = "tumbler_goal", nullable = false)
    private Integer tumblerGoal; // 이번달 부서별 텀블러 목표 수 (사원 수 * 하루 2잔 * 20일)

    @Column(name = "tumbler_count", nullable = false)
    private Integer tumblerCount; // 이번달 부서별 텀블러 적립 수

    @Column(name = "tumbler_percent", nullable = false)
    private Double tumblerPercent; // 이번달 부서별 텀블러 퍼센트 (적립 수 / 목표 수)

    @Column(name = "tumbler_grade", nullable = false)
    private Integer tumblerGrade; // 이번달 부서별 텀블러 등급

    @Builder
    public TumblerCurrent(Long id, Department department, String tumblerName, Integer tumblerGoal, Integer tumblerCount, Double tumblerPercent, Integer tumblerGrade) {
        this.id = id;
        this.department = department;
        this.tumblerName = tumblerName;
        this.tumblerGoal = tumblerGoal;
        this.tumblerCount = tumblerCount;
        this.tumblerPercent = tumblerPercent;
        this.tumblerGrade = tumblerGrade;
    }
}
