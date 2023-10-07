package kusitms.server.domain.user.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Schema(description = "유저 로그인 응답 객체")
public class LoginResponseDto {

    @Schema(description = "유저 ID", example = "1")
    private Long id; // 유저 id

    @Schema(description = "Article ID", example = "TEAM")
    private String role; // COMPANY, DEPARTMENT, CAFE
}
