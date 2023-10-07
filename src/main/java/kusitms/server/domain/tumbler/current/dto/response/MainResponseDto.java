package kusitms.server.domain.tumbler.current.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Schema(description = "부서 메인 조회 응답 객체")
public class MainResponseDto {

    @Schema(description = "이번달 부서별 텀블러 등급", example = "1")
    private Integer tumblerGrade;

    @Schema(description = "이번달 부서별 텀블러 명", example = "")
    private String tumblerName;

    @Schema(description = "부서명", example = "")
    private String deptName;

    @Schema(description = "이번달 부서별 텀블러 퍼센트", example = "")
    private Double tumblerPercent;

    @Schema(description = "이번달 목표 수 - 현재 적립 수", example = "")
    private Integer toGoalCount;

    @Builder
    public MainResponseDto(Integer tumblerGrade, String tumblerName, String deptName, Double tumblerPercent, Integer toGoalCount) {
        this.tumblerGrade = tumblerGrade;
        this.tumblerName = tumblerName;
        this.deptName = deptName;
        this.tumblerPercent = tumblerPercent;
        this.toGoalCount = toGoalCount;
    }
}
