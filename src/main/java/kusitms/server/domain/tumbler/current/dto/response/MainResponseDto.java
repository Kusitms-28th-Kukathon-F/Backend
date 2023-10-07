package kusitms.server.domain.tumbler.current.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import kusitms.server.domain.tumbler.history.dto.response.HistoryMonthDetailResponseDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Schema(description = "부서 메인 조회 응답 객체")
public class MainResponseDto {

    @Schema(description = "이번달 부서별 텀블러 등급", example = "1")
    private Integer tumblerGrade;

    @Schema(description = "이번달 부서별 텀블러 명", example = "AA건전지")
    private String tumblerName;

    @Schema(description = "부서명", example = "A")
    private String deptName;

    @Schema(description = "이번달 부서별 텀블러 퍼센트", example = "50.0")
    private Double tumblerPercent;

    @Schema(description = "이번달 목표 수 - 현재 적립 수", example = "288")
    private Integer toGoalCount;

    @Schema(description = "이번달 랭킹 TOP3")
    private List<HistoryMonthDetailResponseDto> rankList = new ArrayList<>();

    @Builder
    public MainResponseDto(Integer tumblerGrade, String tumblerName, String deptName, Double tumblerPercent, Integer toGoalCount, List<HistoryMonthDetailResponseDto> rankList) {
        this.tumblerGrade = tumblerGrade;
        this.tumblerName = tumblerName;
        this.deptName = deptName;
        this.tumblerPercent = tumblerPercent;
        this.toGoalCount = toGoalCount;
        this.rankList = rankList;
    }
}
