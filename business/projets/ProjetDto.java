package dwn.slrm.business.projets;

import dwn.slrm.business.Personne.PersonneDto;
import dwn.slrm.business.competence.CompetenceDto;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProjetDto implements Serializable {
    Long id;
    Integer version;
    @NotBlank(message = "Le nom ne peut pas être vide !")
    String nom;
    List<String> contenus;
    List<CompetenceDto> competences;
    List<PersonneDto> participants;
}
