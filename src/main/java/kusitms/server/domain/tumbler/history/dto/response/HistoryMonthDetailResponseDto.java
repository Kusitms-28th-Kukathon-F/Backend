package kusitms.server.domain.tumbler.history.dto.response;

import kusitms.server.domain.tumbler.history.entity.TumblerHistory;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class HistoryMonthDetailResponseDto {

    private String tumblerName;

    private String departmentName;

    private Integer tumblerGrade;

    private Double tumblerPercent;

    private Integer tumblerCount;

    public static HistoryMonthDetailResponseDto of(TumblerHistory tumblerHistory) {
        return HistoryMonthDetailResponseDto.builder()
                .tumblerName(tumblerHistory.getTumblerName())
                .departmentName(tumblerHistory.getDepartment().getDeptName())
                .tumblerGrade(tumblerHistory.getTumblerGrade())
                .tumblerPercent(tumblerHistory.getTumblerPercent())
                .tumblerCount(builder().tumblerCount)
                .build();
    }
}
