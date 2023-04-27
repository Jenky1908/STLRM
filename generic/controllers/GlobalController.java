package dwn.slrm.generic.controllers;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import dwn.slrm.generic.Constants;

@Controller
@ControllerAdvice // Indique des traitements (@ModelAttribute, @ExceptionHandler...) à exécuter par tous les Controller
@RequestMapping
public class GlobalController {

	@GetMapping
	public String index() {
		return "index";
	}
	
	 // -> Controller.paths
    @ModelAttribute(name = "paths")
    public List<String> getPaths() {
    	
//    	Field[] declaredFields = Constants.class.getDeclaredFields(); // Récupère les noms des champs présents dans la classe Constants
//    	List<String> paths = new ArrayList<>();
//    	for(Field field : declaredFields) {
//    		try {
//        		paths.add((String) field.get(null)); // Avec un objet instancié, ceci va me récupérer les valeurs en cours de l'objet / avec null ceci va récupérer les valeurs de champs "static"
//			} catch (Exception ignored) {
//				throw new RuntimeException();
//			}
//    	}
    	
    	return Arrays.stream(Constants.class.getDeclaredFields()).map(field -> {
    		try {
    			return (String) field.get(null);
			} catch (Exception e) {
				return null;
			}
    	}).filter(Objects::nonNull).toList();
    }
}
