package kusitms.server.domain.company.controller;

import kusitms.server.domain.company.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/companies")
public class CompanyController {

    private final CompanyService companyService;

}
