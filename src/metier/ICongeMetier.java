package metier;

import modele.Conge;

public interface ICongeMetier {
       Conge calculer_nbrJrsCongé(Long idConge) throws CongeException;
}
