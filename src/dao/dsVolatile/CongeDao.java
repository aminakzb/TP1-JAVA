package dao.dsVolatile;
import dao.ICongeDao;
import modele.Conge;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CongeDao implements ICongeDao<Conge, Long> {

    public static Set<Conge> Bd_Conge() {
        return new HashSet<Conge>(Arrays.asList(
                new Conge(1L, "Ahmad", 0, LocalDate.of(2023,12,03),LocalDate.of(2023,12,07), ""),
                new Conge(2L, "Ali", 0, LocalDate.of(2023,03,10),LocalDate.of(2007,12,19), ""),
                new Conge(3L, "Amine", 0, LocalDate.of(2023,03,10),LocalDate.of(2007,12,19), ""),
                new Conge(4L, "Naima", 0, LocalDate.of(2023,03,10),LocalDate.of(2007,12,19), ""),
                new Conge(5L, "Khadija", 0, LocalDate.of(2023,03,10),LocalDate.of(2007,12,19), "")));
    }
        @Override
        public Conge trouverParId(Long idConge) {
            return  Bd_Conge()
                    .stream()
                    .filter(conge -> conge.getId()==idConge)
                    .findFirst()
                    .orElse(null);
        }
    }

