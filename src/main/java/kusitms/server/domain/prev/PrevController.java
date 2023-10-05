package kusitms.server.domain.prev;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrevController {

    @GetMapping("/prev")
    public String prevTest() {
        return "test:)";
    }
}
