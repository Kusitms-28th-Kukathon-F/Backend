package kusitms.server.domain.tumbler.history.dto.response;

import kusitms.server.domain.tumbler.history.entity.TumblerHistory;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class HistoryQuarterDetailResponseDto {

    private String tumblerName;

    private String deptName;

    private Integer tumblerGrade;

    private Double tumblerPercent;

    private Double tumblerAverage;

    public static HistoryQuarterDetailResponseDto of(List<TumblerHistory> tumblerHistories) {
        Double average = (double) 0;
        for (TumblerHistory tumbler:tumblerHistories) {
            average += tumbler.getTumblerCount();
        }
        average /= tumblerHistories.size();
        return HistoryQuarterDetailResponseDto.builder()
                .tumblerName(tumblerHistories.get(0).getTumblerName())
                .deptName(tumblerHistories.get(0).getDepartment().getDeptName())
                .tumblerGrade(tumblerHistories.get(0).getTumblerGrade())
                .tumblerPercent(tumblerHistories.get(0).getTumblerPercent())
                .tumblerAverage(average)
                .build();
    }
}
