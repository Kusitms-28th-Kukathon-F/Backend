package kusitms.server.domain.tumbler.history.entity;

import jakarta.persistence.*;
import kusitms.server.domain.department.entity.Department;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import static jakarta.persistence.FetchType.LAZY;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "TUMBLER_HISTORY")
@Entity
public class TumblerHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tumbler_his_id")
    private Long id; // 부서별 텀블러 내역 id

    @ManyToOne(fetch = LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "dept_id")
    private Department department; // 부서 id

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt; // 생성 날짜 (월 구분)

    @Column(name = "tumbler_name", nullable = false)
    private String tumblerName; // 월별 부서 텀블러 이름

    @Column(name = "tumbler_percent", nullable = false)
    private Double tumblerPercent; // 월별 부서 텀블러 퍼센트

    @Column(name = "tumbler_grade", nullable = false)
    private Integer tumblerGrade; // 월별 부서 텀블러 등급

    @Column(name = "tumbler_count", nullable = false)
    private Integer tumblerCount; // 월별 부서 텀블러 적립 수

    @Builder
    public TumblerHistory(Long id, Department department, LocalDateTime createdAt, String tumblerName, Double tumblerPercent, Integer tumblerGrade, Integer tumblerCount) {
        this.id = id;
        this.department = department;
        this.createdAt = createdAt;
        this.tumblerName = tumblerName;
        this.tumblerPercent = tumblerPercent;
        this.tumblerGrade = tumblerGrade;
        this.tumblerCount = tumblerCount;
    }

    public void updateTumblerCount() {
        this.tumblerCount += 8;
        this.tumblerGrade = (tumblerCount / 64) + 1;
        this.tumblerPercent = (double) ((tumblerCount % 64) / 64.0) * 100;
    }
}
