package presentation;

import metier.CongeException;
import metier.ICongeMetier;
import lombok.*;
import org.springframework.beans.factory.annotation.Qualifier;

@Data
@AllArgsConstructor
@NoArgsConstructor

//@Autowired
@Qualifier("metier")
public class CongeController implements ICongeController{
    ICongeMetier service;
    @Override
    public void afficher_detailsCongé(Long idConge) throws CongeException {
        var congé = service.calculer_nbrJrsCongé(idConge);
        System.out.println(congé);
    }
}
