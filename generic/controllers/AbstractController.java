package dwn.slrm.generic.controllers;

import dwn.slrm.generic.services.IAbstractCrudService;
import jakarta.validation.Valid;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

public abstract class AbstractController<Entity,Dto,Service extends IAbstractCrudService<Entity,Dto>> {

    protected final Service service;
    protected final String prefix;

    protected AbstractController(Service service, String prefix) {
        this.service = service;
        this.prefix = prefix;
    }

    @GetMapping
    public String all(Model model) {
        model.addAttribute("elements", service.all());
        return prefix + "/all";
    }

    @GetMapping("/{id}")
    public String getById(Model model, @PathVariable Long id) {
    	model.addAttribute("element", service.byId(id));
        return prefix + "/byId";
    }
    
    @PostMapping
    public String save(@Valid @ModelAttribute(name = "element") Dto element, BindingResult result, Model model) {
        if(result.hasErrors()){
            return prefix + "/byId";
        }
        service.save(element);
        return "redirect:/"+prefix;
    }

    // -> ResumeController
    // ResumeController.prefix -> resumes
    
    /// -> ProjetController
    // ProjetController.prefix -> projets
    
    @ModelAttribute(name = "prefix")
    public String getPrefix(){
        return prefix;
    }
    
}
