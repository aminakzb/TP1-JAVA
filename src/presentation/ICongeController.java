package presentation;

import metier.CongeException;

public interface ICongeController {
    void afficher_detailsCongé(Long idConge) throws CongeException;
}
