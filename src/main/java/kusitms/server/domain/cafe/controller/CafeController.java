package kusitms.server.domain.cafe.controller;


import kusitms.server.domain.cafe.dto.request.UpdateTeamTumblerRequestDto;
import kusitms.server.domain.cafe.dto.response.UpdateTeamTumblerResponseDto;
import kusitms.server.domain.cafe.service.CafeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/cafes")
public class CafeController {

    private final CafeService cafeService;

//    @PostMapping
//    public UpdateTeamTumblerResponseDto updateTeamTumbler(@RequestBody UpdateTeamTumblerRequestDto request) {
//        cafeService.
//    }
}
