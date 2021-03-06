package guru.springframework.sfgpetclinic.Controllers;

import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.model.owner;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetServices;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@Controller
@RequestMapping("/owners/{ownerId}")
public class PetController {
   private PetServices petServices;
   private PetTypeService petTypeService;
   private OwnerService ownerService;

    public PetController(PetServices petServices, PetTypeService petTypeService, OwnerService ownerService) {
        this.petServices = petServices;
        this.petTypeService = petTypeService;
        this.ownerService = ownerService;
    }


    @ModelAttribute("types")
    public Collection<PetType> populatePetTypes() {
        return petTypeService.findAll();
    }
// we need owner many times in this controller
    @ModelAttribute("owner")
    public owner findOwner(@PathVariable("ownerId") Long ownerId) {
        return ownerService.findById(ownerId);
    }


    @InitBinder("owner")
    public void initOwnerBinder(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }
    @GetMapping("/pets/new")
    public String Createnewpet(Model model,owner owner){
        Pet pet= new Pet();
        owner.getPets().add(pet);

        pet.setOwner(owner);
        model.addAttribute("pet",pet);

        return "pets/createOrUpdatePetForm";
    }
    @PostMapping ("/pets/new")
    public String newPetProcess(Model model, owner owner
            , @Valid Pet pet, BindingResult result){
        if (StringUtils.hasLength(pet.getName()) && pet.isNew() && owner.getPet(pet.getName(), true) != null){
            result.rejectValue("name", "duplicate", "already exists");
        }
        if (result.hasErrors()) {
            model.addAttribute("pet", pet);
            return "pets/createOrUpdatePetForm";
        } else {
            owner.getPets().add(pet);
pet.setOwner(owner);
            petServices.save(pet);

            return "redirect:/owners/" + owner.getId();
        }
    }
    @GetMapping("/pets/{petId}/edit")
    public String editPet(Model model,owner owner,@PathVariable Long petId){
      model.addAttribute("pet",petServices.findById(petId));
            return "pets/createOrUpdatePetForm";

    }@PostMapping ("/pets/{petId}/edit")
    public String editPetProcess(@Valid Pet pet, Model model,owner owner,
                                 BindingResult result){
        if (result.hasErrors()) {
            pet.setOwner(owner);
            model.addAttribute("pet", pet);
            return"pets/createOrUpdatePetForm";
        } else {pet.setOwner(owner);

            petServices.save(pet);
            return "redirect:/owners/" + owner.getId();
        }

    }
        }




