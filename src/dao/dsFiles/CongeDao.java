package dao.dsFiles;

import dao.ICongeDao;
import modele.Conge;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

@Component("dao1")
public class CongeDao implements ICongeDao<Conge, Long> {

    public List<Conge> findAll() {
        List<Conge> congés = new ArrayList<>();

        try {
            List<String> lines = Files.readAllLines(FileBasePath.CONGESFOLDER, StandardCharsets.UTF_8);
            lines.remove(0);

            if (!lines.isEmpty())
                congés = lines.stream().map(line -> {
                    Conge c = null;
                    StringTokenizer st = new StringTokenizer(line, "\t");

                    long id =Long.parseLong(st.nextToken());
                    String demandeur = st.nextToken();
                    Integer nbr_jours =Integer.parseInt(st.nextToken()) ;
                    LocalDate debut=LocalDate.parse(st.nextToken());
                    LocalDate fin=LocalDate.parse(st.nextToken());
                    String type_congé = st.nextToken();

                    c = new Conge(id,demandeur,nbr_jours,debut,fin,type_congé);
                    return c;
                }).collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }

        return congés;
    }
    @Override
    public Conge trouverParId(Long idCongé) {
        return  findAll()
                .stream()
                .filter(credit -> credit.getId()==idCongé )
                .findFirst()
                .orElse(null);
    }
}
