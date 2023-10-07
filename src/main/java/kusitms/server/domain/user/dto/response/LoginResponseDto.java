package kusitms.server.domain.user.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Schema(description = "유저 로그인 응답 객체")
public class LoginResponseDto {

    @Schema(description = "유저 ID", example = "1")
    private Long userId; // 확인하기**

    @Schema(description = "유저 소속", example = "DEPARTMENT")
    private String userRole; // COMPANY, DEPARTMENT, CAFE

    @Builder
    public LoginResponseDto(Long userId, String userRole) {
        this.userId = userId;
        this.userRole = userRole;
    }
}
