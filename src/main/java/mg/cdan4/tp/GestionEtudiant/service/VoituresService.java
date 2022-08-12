package mg.cdan4.tp.GestionEtudiant.service;

import mg.cdan4.tp.GestionEtudiant.entity.Voitures;
import mg.cdan4.tp.GestionEtudiant.repository.VoituresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoituresService {
    @Autowired
    private VoituresRepository voituresRepository;

    public List<Voitures> getAll(){
        return voituresRepository.findAll();
    }


    public List<Voitures> findByMarque(String marque){
        return voituresRepository.findByMarque(marque);
    }

    public void saveVoiture(Voitures voiture){
        voituresRepository.save(voiture);
    }


    public void deleteVoiture(Integer idMarque) {
        Voitures voiture = voituresRepository.findById(idMarque).orElseThrow();
        voituresRepository.delete(voiture);
    }

    public Voitures detailVoiture(Integer idMarque){
        return voituresRepository.findById(idMarque).orElseThrow();

    }


}
