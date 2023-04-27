package dwn.slrm.business.projets;

import dwn.slrm.business.Personne.PersonneService;
import dwn.slrm.business.competence.CompetenceService;
import dwn.slrm.generic.Constants;
import dwn.slrm.generic.controllers.AbstractController;
import jakarta.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(Constants.PROJET_PREFIX)
public class ProjetController extends AbstractController<Projet,ProjetDto,ProjetService> {
	
	private final PersonneService personneService;
	
	private final CompetenceService competenceService;
	
    protected ProjetController(ProjetService service, PersonneService personneService, CompetenceService competenceService) {
        super(service, Constants.PROJET_PREFIX);
        this.personneService = personneService;
        this.competenceService = competenceService;
    }

	@Override
	public String getById(Model model, @PathVariable Long id) {
		
		model.addAttribute("participants", personneService.all());
		model.addAttribute("competences", competenceService.all());
		return super.getById(model, id);
	}

	@Override
	public String save(@Valid @ModelAttribute(name = "element") ProjetDto element, BindingResult result, Model model) {
		
		model.addAttribute("participants", personneService.all());
		model.addAttribute("competences", competenceService.all());
		return super.save(element, result, model);
	}
}
