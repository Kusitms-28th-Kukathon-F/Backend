package kusitms.server.domain.tumbler.current.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Schema(description = "부서 메인 조회 요청 객체")
public class MainRequestDto {

    @Schema(description = "유저 ID", example = "1")
    private Long userId;

//    @Schema(description = "유저 소속", example = "DEPARTMENT")
//    private String userRole; // COMPANY, DEPARTMENT, CAFE
}
