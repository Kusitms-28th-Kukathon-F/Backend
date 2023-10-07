package kusitms.server.domain.sample.controller;

import kusitms.server.domain.common.dto.SuccessResponse;
import kusitms.server.domain.common.dto.code.SuccessCode;
import kusitms.server.domain.sample.dto.request.CreateSampleRequestDto;
import kusitms.server.domain.sample.dto.response.CreateSampleResponseDto;
import kusitms.server.domain.sample.service.SampleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/samples")
public class SampleController {

    private final SampleService sampleService;

    @PostMapping
    public ResponseEntity<SuccessResponse<CreateSampleResponseDto>> createSample(@RequestBody CreateSampleRequestDto createSample) {
        CreateSampleResponseDto response = sampleService.createSample(createSample.getText());
        return SuccessResponse.of(SuccessCode.CREATED, response);
    }
}
