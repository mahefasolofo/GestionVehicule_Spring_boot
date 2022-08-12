package mg.cdan4.tp.GestionEtudiant.repository;


import mg.cdan4.tp.GestionEtudiant.entity.Voitures;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoituresRepository extends JpaRepository<Voitures,Integer> {

   List<Voitures> findAll();
   //voituresRepository.findAll()
   List<Voitures> findByMarque(@Param("marque") String marque);

   /*List<Voitures> deleteByIdMarque(Integer idMarque);*/

}
