package kusitms.server.domain.tumbler.history.dto.response;

import kusitms.server.domain.department.entity.Department;
import kusitms.server.domain.tumbler.history.entity.TumblerHistory;
import kusitms.server.domain.tumbler.history.util.ListComparatorQuarter;
import kusitms.server.domain.tumbler.history.util.ListComparatorTumblerHistory;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class HistoryRankResponseDto {

    private Integer rank;

    private Integer tumblerCount;


    public static HistoryRankResponseDto of(List<TumblerHistory> tumblerHistories, String deptName) {
        tumblerHistories.sort(new ListComparatorTumblerHistory());
        Integer rank = 0;

        for (int i = 0; i < tumblerHistories.size(); i++) {
            if(deptName.equals(tumblerHistories.get(i).getDepartment().getDeptName())) {
                rank = i;
            }
        }

        return HistoryRankResponseDto.builder()
                .rank(rank + 1)
                .tumblerCount(tumblerHistories.get(rank).getTumblerCount())
                .build();
    }
}
