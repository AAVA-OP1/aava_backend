package aava.kyselyprojekti.domain;

import org.springframework.data.repository.CrudRepository;
import java.util.List;


public interface KysymysRepository extends CrudRepository<Kysymys, Long>{
    
    List<Kysymys> findByKysely(Kysely kysely);


}
