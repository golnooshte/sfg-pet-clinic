package guru.springframework.sfgpetclinic.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class vetControlller {
    @RequestMapping({"/vets","/vets/index","/vets/index.html"})
    public String vetList(){
        return "/vets/index";
    }
}
