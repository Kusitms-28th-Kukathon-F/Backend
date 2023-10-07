package kusitms.server.domain.tumbler.history.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import kusitms.server.domain.common.dto.SuccessResponse;
import kusitms.server.domain.common.dto.code.SuccessCode;
import kusitms.server.domain.tumbler.current.dto.response.MainResponseDto;
import kusitms.server.domain.tumbler.history.dto.response.HistoryBoardGraphResponseDto;
import kusitms.server.domain.tumbler.history.dto.response.HistoryMonthDetailResponseDto;
import kusitms.server.domain.tumbler.history.dto.response.HistoryQuarterDetailResponseDto;
import kusitms.server.domain.tumbler.history.dto.response.HistoryRankResponseDto;
import kusitms.server.domain.tumbler.history.service.TumblerHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "부서 텀블러 랭킹 API", description = "부서 텀블러 랭킹 내역 상세 조회 API")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/tumblers/history")
public class TumblerHistoryController {

    private final TumblerHistoryService tumblerHistoryService;

    // ex. 202310 이정도로 달까지만 주세요
    @Operation(summary = "부서 텀블러 랭킹 내역 월별 상세 조회 API", description = "부서 텀블러 랭킹 내역 월별 상세 조회하기")
    @ApiResponse(responseCode = "200", description = "OK",
            content = @Content(schema = @Schema(implementation = HistoryMonthDetailResponseDto.class)))
    @GetMapping("/month/{userId}")
    public ResponseEntity<SuccessResponse<List<HistoryMonthDetailResponseDto>>> findDetailByMonth(@RequestParam String period, @PathVariable Long userId) {
        List<HistoryMonthDetailResponseDto> request = tumblerHistoryService.findDetailByMonth(period, userId);
        return SuccessResponse.of(SuccessCode.OK, request);
    }

    @Operation(summary = "부서 텀블러 랭킹 내역 분기별 상세 조회 API", description = "부서 텀블러 랭킹 내역 분기별 상세 조회하기")
    @ApiResponse(responseCode = "200", description = "OK",
            content = @Content(schema = @Schema(implementation = HistoryQuarterDetailResponseDto.class)))
    @GetMapping("/quarter/{userId}")
    public ResponseEntity<SuccessResponse<List<HistoryQuarterDetailResponseDto>>> findDetailByQuarter(@RequestParam String startPeriod, @RequestParam String endPeriod, @PathVariable Long userId) {
        List<HistoryQuarterDetailResponseDto> request = tumblerHistoryService.findDetailByQuarter(startPeriod, endPeriod, userId);
        return SuccessResponse.of(SuccessCode.OK, request);
    }

    @Operation(summary = "부서 대시보드 랭킹 조회 API", description = "부서 대시보드 랭킹 조회하기")
    @ApiResponse(responseCode = "200", description = "OK",
            content = @Content(schema = @Schema(implementation = HistoryRankResponseDto.class)))
    @GetMapping("/rank/{userId}")
    public ResponseEntity<SuccessResponse<List<HistoryRankResponseDto>>> findHistoryRank(@RequestParam String period, @PathVariable Long userId) {
        List<HistoryRankResponseDto> request = tumblerHistoryService.findHistoryRank(period, userId);
        return SuccessResponse.of(SuccessCode.OK, request);
    }

    @Operation(summary = "부서 대시보드 월별 그래프 조회 API", description = "부서 대시보드 월별 그래프 조회하기")
    @ApiResponse(responseCode = "200", description = "OK",
            content = @Content(schema = @Schema(implementation = HistoryBoardGraphResponseDto.class)))
    @GetMapping("/graph/{userId}")
    public ResponseEntity<SuccessResponse<List<HistoryBoardGraphResponseDto>>> findHistoryGraph(@RequestParam String period, @PathVariable Long userId) {
        List<HistoryBoardGraphResponseDto> request = tumblerHistoryService.findHistoryGraph(period, userId);
        return SuccessResponse.of(SuccessCode.OK, request);
    }
}
