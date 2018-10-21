package master.springframework.springbootpetclinic.controllers;

import master.springframework.springbootpetclinic.model.Owner;
import master.springframework.springbootpetclinic.services.OwnerService;
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

    private static final String VIEWS_OWNER_CREATE_OR_UPDATE_FORM = "owners/createOrUpdateOwnerForm";

    private OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        //Security feature to stop hacker from using id to manipulate data
        dataBinder.setDisallowedFields("id");
    }

    @RequestMapping("/find")
    public String findOwners(Model model) {
        model.addAttribute("owner", new Owner());
        return "owners/findOwners";
    }

    @GetMapping
    public String processFindForm(Owner owner, BindingResult result, Model model) {

        // allow parameterless GET request for /owners to return all records
        if (owner.getLastName() == null) {
            owner.setLastName(""); // empty string signifies broadest possible search
        }

        // find owners by last name
        List<Owner> results = ownerService.findByLastNameLike(owner.getLastName());
        if (results.isEmpty()) {
            // no owners found
            result.rejectValue("lastName", "notFound", "not found");
            return "owners/findOwners";
        } else if (results.size() == 1) {
            // 1 owner found
            owner = results.iterator().next();
            return "redirect:/owners/" + owner.getId();
        } else {
            // multiple owners found
            model.addAttribute("selections", results);
            return "owners/ownersList";
        }

    }

    @GetMapping("/{ownerId}")
    public ModelAndView showOwner(@PathVariable("ownerId") Long ownerId) {
        ModelAndView mav = new ModelAndView("owners/ownerDetails");
        mav.addObject(this.ownerService.findById(ownerId));
        return mav;
    }

    @GetMapping("/new")
    public ModelAndView initCreateOwnerForm() {
        ModelAndView mav = new ModelAndView(VIEWS_OWNER_CREATE_OR_UPDATE_FORM);
        mav.addObject("owner", new Owner());
        return mav;
    }

    @PostMapping("/new")
    public ModelAndView processCreateOwnerForm(@Valid Owner owner, BindingResult result) {
        if(result.hasErrors()) {
            return new ModelAndView(VIEWS_OWNER_CREATE_OR_UPDATE_FORM);
        }
        Owner savedOwner = ownerService.save(owner);
        return new ModelAndView("redirect:/owners/" + savedOwner.getId());
    }

    @GetMapping("/{ownerId}/edit")
    public ModelAndView initUpdateOwnerForm(@PathVariable("ownerId") Long ownerId) {
        ModelAndView mav = new ModelAndView(VIEWS_OWNER_CREATE_OR_UPDATE_FORM);
        mav.addObject("owner", ownerService.findById(ownerId));
        return mav;
    }

    @PostMapping("/{ownerId}/edit")
    public ModelAndView processUpdateOwnerForm(@PathVariable("ownerId") Long ownerId, @Valid Owner owner, BindingResult result) {
        if(result.hasErrors()) {
            return new ModelAndView(VIEWS_OWNER_CREATE_OR_UPDATE_FORM);
        }
        owner.setId(ownerId);
        Owner savedOwner = ownerService.save(owner);
        return new ModelAndView("redirect:/owners/" + savedOwner.getId());
    }
}
