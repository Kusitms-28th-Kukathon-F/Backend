package kusitms.server.domain.user.service;


import kusitms.server.domain.user.dto.request.LoginRequestDto;
import kusitms.server.domain.user.dto.response.LoginResponseDto;
import kusitms.server.domain.user.entity.User;
import kusitms.server.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;

    public LoginResponseDto userLogin(LoginRequestDto loginRequestDto) {

        String loginId = loginRequestDto.getLoginId();
        String password = loginRequestDto.getPassword();

//        User user = userRepository.findByLoginIdAndPassword(loginId, password)
//                .orElseThrow(() -> new );

        User user = userRepository.findByLoginIdAndPassword(loginId, password);

        LoginResponseDto res = LoginResponseDto.builder()
                .userId(user.getId())
                .userRole(user.getRole().toString())
                .build();

        return res;
    }
}
