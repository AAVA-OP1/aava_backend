package aava.kyselyprojekti.domain;

import org.springframework.data.repository.CrudRepository;
import java.util.List;
import java.util.Optional;


public interface KysymysRepository extends CrudRepository<Kysymys, Long>{
    
    List<Kysymys> findByKysely(Kysely kysely);
    Optional <Kysymys> findById(long kysymysid);


}
