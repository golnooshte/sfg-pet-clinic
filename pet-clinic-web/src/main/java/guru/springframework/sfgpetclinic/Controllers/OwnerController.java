package guru.springframework.sfgpetclinic.Controllers;

import guru.springframework.sfgpetclinic.model.owner;
import guru.springframework.sfgpetclinic.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/owners")
@Controller
public class OwnerController {
    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }


    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {

        dataBinder.setDisallowedFields("id");
    }


    @RequestMapping("/find")
    public String find( Model model){
model.addAttribute("owner",new owner()) ;
return "owners/findOwners";

    }
    @GetMapping
    public String processFindForm(owner owner, BindingResult result, Model model){
        // allow parameterless GET request for /owners to return all records
        if (owner.getLastName() == null) {
            owner.setLastName(""); // empty string signifies broadest possible search
        }

        // find owners by last name
        List<owner> results = ownerService.findAllByLastNameLike("%"+ owner.getLastName() + "%" );

        if (results.isEmpty()) {
            // no owners found
            result.rejectValue("lastName", "notFound", "not found");
            return "owners/findOwners";
        } else if (results.size() == 1) {
            // 1 owner found
            owner = results.get(0);
            return "redirect:/owners/" + owner.getId();
        } else {
            // multiple owners found
            model.addAttribute("selections", results);
            return "owners/ownersList";
        }
    }@RequestMapping("/{ownerId}")
    public ModelAndView showdetails(@PathVariable Long ownerId ){
        ModelAndView mav=new ModelAndView("owners/ownerDetails");
        mav.addObject(ownerService.findById(ownerId));
        return  mav;

    }
    @GetMapping("/new")
    public String createNewOwner(Model model){
        model.addAttribute("owner",new owner());
        return "owners/createOrUpdateOwnerForm";
    }
    @PostMapping("/new")
    public String createownerProcess(@Valid  owner owner, BindingResult result){
        if(result.hasErrors()){
return "owners/createOrUpdateOwnerForm";
        }
      owner savedowner=  ownerService.save(owner);
        return "redirect:/owners/"+savedowner.getId();
    }
    @GetMapping("/{ownerId}/edit")
    public String EditOwner( @PathVariable Long ownerId,Model model){
        model.addAttribute(ownerService.findById(ownerId));
        return "owners/createOrUpdateOwnerForm";
    }
    @PostMapping("/{ownerId}/edit")
    public String editOwner(@Valid owner owner,BindingResult result,@PathVariable Long ownerId){
        if(result.hasErrors()){
            return "owners/createOrUpdateOwnerForm";

        }
        owner.setId(ownerId);
        owner savedowner=ownerService.save(owner);

        return "redirect:/owners/"+savedowner.getId();
    }
    }
