package kusitms.server.domain.cafe.service;

import kusitms.server.domain.cafe.dto.request.UpdateTeamTumblerRequestDto;
import kusitms.server.domain.cafe.dto.response.UpdateTeamTumblerResponseDto;
import kusitms.server.domain.cafe.repository.CafeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Transactional
public class CafeService {

    private final CafeRepository cafeRepository;

//    public UpdateTeamTumblerResponseDto updateTeamTumbler(UpdateTeamTumblerRequestDto request) {
//
//        //todo 부서의 텀블러 수를 증가 시켜줍니다.
//
//    }
}
