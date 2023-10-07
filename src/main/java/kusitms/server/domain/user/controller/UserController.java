package kusitms.server.domain.user.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import kusitms.server.domain.common.dto.SuccessResponse;
import kusitms.server.domain.common.dto.code.SuccessCode;
import kusitms.server.domain.user.dto.request.LoginRequestDto;
import kusitms.server.domain.user.dto.response.LoginResponseDto;
import kusitms.server.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "유저 API", description = "유저 로그인 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Operation(description = "유저 로그인", summary = "유저 로그인 하기")
    @ApiResponse(responseCode = "200", description = "OK",
            content = @Content(schema = @Schema(implementation = LoginResponseDto.class)))
    @PostMapping("")
    public ResponseEntity<SuccessResponse<LoginResponseDto>> userLogin(@RequestBody LoginRequestDto loginRequestDto) {
        LoginResponseDto response = userService.userLogin(loginRequestDto);
        return SuccessResponse.of(SuccessCode.OK, response);
    }

}
