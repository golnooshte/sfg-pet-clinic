package guru.springframework.sfgpetclinic.Controllers;

import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.model.visit;
import guru.springframework.sfgpetclinic.services.PetServices;
import guru.springframework.sfgpetclinic.services.VisitService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
@RequestMapping("/owners/{ownerId}/pets/{petId}")

@Controller
public class visitController {
    private VisitService visitService;
    private PetServices petServices;


    public visitController(VisitService visitService, PetServices petServices) {
        this.visitService = visitService;
        this.petServices = petServices;
    }


    @InitBinder()
    public void initOwnerBinder(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }
    @ModelAttribute("pet")
    public Pet petfinder(@PathVariable Long petId){
         Pet pet=petServices.findById(petId);
         return pet;
    }

    @GetMapping("/visits/new")
    public String newVisits( Pet pet, Model model){
        visit visit=new visit();
        pet.getVisits().add(visit);
        visit.setPet(pet);
        model.addAttribute("visit",visit);
        return "pets/createOrUpdateVisitForm";
    }
    @PostMapping("/visits/new")
    public String VisitProcess(@Valid visit visit,Pet pet , Model model,
                               BindingResult result,@PathVariable Long ownerId){

        if(result.hasErrors()){
            model.addAttribute("visit",visit);
            return "pets/createOrUpdateVisitForm";
        }
        pet.getVisits().add(visit);
        visit.setPet(pet);
        visitService.save(visit);
        return "redirect:/owners/" + ownerId;
    }

}
