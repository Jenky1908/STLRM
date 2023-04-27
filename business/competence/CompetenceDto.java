package dwn.slrm.business.competence;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

import jakarta.validation.constraints.NotBlank;

/**
 * A DTO for the {@link Competence} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompetenceDto implements Serializable {
    private long id;
    private int version;
	@NotBlank(message = "Le nom ne peut pas être vide !")
    private String nom;
}
