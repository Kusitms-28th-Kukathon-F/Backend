package kusitms.server.domain.company.service;


import kusitms.server.domain.company.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Service
@Transactional
public class CompanyService {

    private final CompanyRepository companyRepository;

}
