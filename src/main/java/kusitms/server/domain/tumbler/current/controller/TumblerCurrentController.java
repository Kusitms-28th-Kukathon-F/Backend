package kusitms.server.domain.tumbler.current.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import kusitms.server.domain.common.dto.SuccessResponse;
import kusitms.server.domain.common.dto.code.SuccessCode;
import kusitms.server.domain.tumbler.current.dto.response.MainResponseDto;
import kusitms.server.domain.tumbler.current.service.TumblerCurrentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "부서 메인 API", description = "부서 메인 조회 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/tumblers/current")
public class TumblerCurrentController {

    private final TumblerCurrentService tumblerCurrentService;

    @Operation(summary = "부서 메인 조회 API", description = "부서 메인 조회하기")
    @ApiResponse(responseCode = "200", description = "OK",
            content = @Content(schema = @Schema(implementation = MainResponseDto.class)))
    @GetMapping("/{userId}")
    public ResponseEntity<SuccessResponse<MainResponseDto>> getTumblerCurrent(@PathVariable Long userId) {
        MainResponseDto response = tumblerCurrentService.getTumblerCurrent(userId);
        return SuccessResponse.of(SuccessCode.OK, response);
    }


}
