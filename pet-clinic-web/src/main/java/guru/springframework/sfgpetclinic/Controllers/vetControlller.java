package guru.springframework.sfgpetclinic.Controllers;

import guru.springframework.sfgpetclinic.services.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class vetControlller {
    private final VetService vetService;

    public vetControlller(VetService vetService) {
        this.vetService = vetService;
    }

    @RequestMapping({"/vets","/vets/index","/vets/index.html", "vets.html"})
    public String vetList(Model model){

        model.addAttribute("vets",vetService.findAll());
        return "/vets/index";
    }
}
