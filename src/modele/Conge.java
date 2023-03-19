package modele;
import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Conge {
    private long id;
    private String demandeur;
    private Integer nombre_jours;
    private LocalDate date_debut;
    private  LocalDate date_fin;
    private String type_conge;

    @Override
    public String toString(){
        var congeStr="=======================================================================";
        congeStr="=>Congé n°                  : "+getId()+"                           \n";
        congeStr="=>Nom du demandeur de congé : "+getDemandeur()+"                    \n";
        congeStr="-----------------------------------------------------------------------";
        congeStr="=>Nombre de jours demandés          : " +getNombre_jours()   +"  \n";
        congeStr="=>Date début du congé               : " +getDate_debut()+"          \n";
        congeStr="=>Date fin du congé               : " +getDate_fin()+"           \n";
        congeStr="=>Type de congé               : " +getType_conge()+"          \n";
        congeStr="=======================================================================";
        return congeStr;
    }
}


