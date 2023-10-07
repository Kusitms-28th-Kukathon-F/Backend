package kusitms.server.domain.cafe.dto.response;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UpdateTeamTumblerResponseDto {

    private Long teamId;

    private String teamName;

    private Long totalTumblerNumber;

    public static UpdateTeamTumblerResponseDto of(Long teamId, String teamName, Long totalTumblerNumber) {
        return UpdateTeamTumblerResponseDto.builder()
                .teamId(teamId)
                .teamName(teamName)
                .totalTumblerNumber(totalTumblerNumber)
                .build();
    }
}
