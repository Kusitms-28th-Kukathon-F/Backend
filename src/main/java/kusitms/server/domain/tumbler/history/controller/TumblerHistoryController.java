package kusitms.server.domain.tumbler.history.controller;


import kusitms.server.domain.common.dto.SuccessResponse;
import kusitms.server.domain.common.dto.code.SuccessCode;
import kusitms.server.domain.tumbler.history.dto.response.HistoryMonthDetailResponseDto;
import kusitms.server.domain.tumbler.history.dto.response.HistoryQuarterDetailResponseDto;
import kusitms.server.domain.tumbler.history.service.TumblerHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/tumblers/history")
public class TumblerHistoryController {

    private final TumblerHistoryService tumblerHistoryService;

    // ex. 202310 이정도로 달까지만 주세요
    @GetMapping("/month")
    public ResponseEntity<SuccessResponse<List<HistoryMonthDetailResponseDto>>> findDetailByMonth(@RequestParam String period, @RequestParam Long userId) {
        List<HistoryMonthDetailResponseDto> request = tumblerHistoryService.findDetailByMonth(period, userId);
        return SuccessResponse.of(SuccessCode.OK, request);
    }

    @GetMapping("/quarter")
    public ResponseEntity<SuccessResponse<List<HistoryQuarterDetailResponseDto>>> findDetailByQuarter(@RequestParam String startPeriod, @RequestParam String endPeriod, @RequestParam Long userId) {
        List<HistoryQuarterDetailResponseDto> request = tumblerHistoryService.findDetailByQuarter(startPeriod, endPeriod, userId);
        return SuccessResponse.of(SuccessCode.OK, request);
    }
}
