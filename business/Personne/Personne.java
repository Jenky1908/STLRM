package dwn.slrm.business.Personne;

import dwn.slrm.generic.models.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Personne extends BaseEntity {
	
	@NotBlank(message = "Le nom ne peut être vide.")
    private String nom;
	
	@NotBlank(message = "Le prenom ne peut être vide.")
    private String prenom;
}
