package kusitms.server.domain.tumbler.history.dto.response;

import kusitms.server.domain.tumbler.history.entity.TumblerHistory;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class HistoryBoardGraphResponseDto {

    private String x;

    private Integer y;

    public static HistoryBoardGraphResponseDto of(TumblerHistory tumblerHistory) {
        String monthStr = String.valueOf(tumblerHistory.getCreatedAt().getMonthValue()) + "월";
        return HistoryBoardGraphResponseDto.builder()
                .x(monthStr)
                .y(tumblerHistory.getTumblerCount())
                .build();
    }
}
