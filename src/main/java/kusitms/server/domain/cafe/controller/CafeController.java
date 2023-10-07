package kusitms.server.domain.cafe.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import kusitms.server.domain.cafe.dto.request.UpdateTeamTumblerRequestDto;
import kusitms.server.domain.cafe.dto.response.UpdateTeamTumblerResponseDto;
import kusitms.server.domain.cafe.service.CafeService;
import kusitms.server.domain.common.dto.SuccessResponse;
import kusitms.server.domain.common.dto.code.SuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "카페 텀블러 API", description = "유저 로그인 API")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/cafes")
public class CafeController {

    private final CafeService cafeService;

    @Operation(summary = "부서 텀블러 적립 API", description = "부서 텀블러 적립하기")
    @ApiResponse(responseCode = "200", description = "OK")
    @GetMapping("/{userId}")
    public ResponseEntity<SuccessResponse<UpdateTeamTumblerResponseDto>> addTumblerCurrent(@PathVariable Long userId) {
        UpdateTeamTumblerResponseDto response = cafeService.addTumblerCurrent(userId);
        return SuccessResponse.of(SuccessCode.OK, response);
    }
}
