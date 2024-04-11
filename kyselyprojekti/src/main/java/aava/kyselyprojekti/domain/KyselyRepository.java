package aava.kyselyprojekti.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface KyselyRepository extends CrudRepository<Kysely, Long> {


     List<Kysely> findByKyselynTekija(KyselynTekija kyselynTekija); 

 

}
