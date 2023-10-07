package kusitms.server.domain.user.service;


import kusitms.server.domain.common.error.DuplicateException;
import kusitms.server.domain.sample.dto.response.CreateSampleResponseDto;
import kusitms.server.domain.sample.entity.Sample;
import kusitms.server.domain.sample.repository.SampleRepository;
import kusitms.server.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static kusitms.server.domain.common.error.ApplicationError.DUPLICATE_SAMPLE_TEXT;


@RequiredArgsConstructor
@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;

}
