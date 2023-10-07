package kusitms.server.domain.cafe.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class UpdateTeamTumblerResponseDto {

    private String deptName; // 부서 이름


    @Builder
    public UpdateTeamTumblerResponseDto(String deptName) {
        this.deptName = deptName;
    }
}
