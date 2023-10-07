package kusitms.server.domain.user.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Schema(description = "유저 로그인 요청 객체")
public class LoginRequestDto {

    @Schema(description = "로그인 ID", example = "dept01")
    private String loginId;

    @Schema(description = "로그인 PW", example = "pw01")
    private String password;
}
