package kusitms.server.domain.sample.service;


import kusitms.server.domain.common.error.DuplicateException;
import kusitms.server.domain.sample.dto.response.CreateSampleResponseDto;
import kusitms.server.domain.sample.entity.Sample;
import kusitms.server.domain.sample.repository.SampleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static kusitms.server.domain.common.error.ApplicationError.DUPLICATE_SAMPLE_TEXT;


@RequiredArgsConstructor
@Service
@Transactional
public class SampleService {

    private final SampleRepository sampleRepository;

    public CreateSampleResponseDto createSample(String text) {
        validateDuplicateText(text);
        Sample sample = saveText(text);
        return CreateSampleResponseDto.of(sample);
    }

    private void validateDuplicateText(String text) {
        if(sampleRepository.existsByText(text)) {
            throw new DuplicateException(DUPLICATE_SAMPLE_TEXT);
        }
    }
    private Sample saveText(String text) {
        Sample sample = Sample.createSample(text);
        sampleRepository.save(sample);
        return sample;
    }
}
