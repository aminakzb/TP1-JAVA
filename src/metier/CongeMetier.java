package metier;

import dao.ICongeDao;
import modele.Conge;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import lombok.*;
import org.springframework.beans.factory.annotation.Qualifier;

@Data
@AllArgsConstructor
@NoArgsConstructor

//@Autowired
@Qualifier("dao")
public class CongeMetier implements ICongeMetier{
    ICongeDao<Conge, Long> dao;
    @Override
    public Conge calculer_nbrJrsCongé(Long idConge) throws CongeException {
        var congé = dao.trouverParId(idConge);
        if (congé == null)
            throw new CongeException("Congé non trouvé");
        else {
            LocalDate debut=congé.getDate_debut();
            LocalDate fin=congé.getDate_fin();
            Integer nbr_jours= Math.toIntExact(debut.until(fin, ChronoUnit.DAYS));

            congé.setNombre_jours(nbr_jours);
            return congé;
        }
    }
}
