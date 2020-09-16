package guru.springframework.sfgpetclinic.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"","/","index","index.html"})
public class IndexController {
    public String index(){
        return "index";
    }
    
    @RequestMapping("/oups")
    public String find(){
        return "Notimplemented";
    }
}

