package kusitms.server.domain.tumbler.history.dto.response;

import kusitms.server.domain.tumbler.history.entity.TumblerHistory;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class HistoryMonthDetailResponseDto {

    private String tumblerName;

    private String deptName;

    private Integer tumblerGrade;

    private Integer tumblerPercent;

    private Integer tumblerCount;

    public static HistoryMonthDetailResponseDto of(TumblerHistory tumblerHistory) {
        return HistoryMonthDetailResponseDto.builder()
                .tumblerName(tumblerHistory.getTumblerName())
                .deptName(tumblerHistory.getDepartment().getDeptName())
                .tumblerGrade(tumblerHistory.getTumblerGrade())
                .tumblerPercent((int) Math.floor(tumblerHistory.getTumblerPercent()))
                .tumblerCount(tumblerHistory.getTumblerCount())
                .build();
    }
}
