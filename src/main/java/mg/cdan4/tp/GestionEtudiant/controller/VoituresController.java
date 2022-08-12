package mg.cdan4.tp.GestionEtudiant.controller;


import mg.cdan4.tp.GestionEtudiant.entity.Voitures;
import mg.cdan4.tp.GestionEtudiant.service.VoituresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/voitures")
public class VoituresController {
    @Autowired
    private VoituresService voituresService;

    @GetMapping("/listeVoiture/")
    public List<Voitures> listeVoitures(){
        return voituresService.getAll();
    }

    @GetMapping("/listeVoitureMarque/{param1}")
    public List<Voitures> listeVoitures(@PathVariable("param1")String marque)
    {
        return voituresService.findByMarque(marque);
    }

    @PostMapping("/insertVoiture/{idMarque},{libele},{modele},{marque}")
    public void saveVoiture(@PathVariable("idMarque") Integer idMarque, @PathVariable("libele") String libele,@PathVariable("modele") String modele,@PathVariable("marque") String marque){
       Voitures voitures = new Voitures();
       voitures.setIdMarque(idMarque);
       voitures.setLibele(libele);
       voitures.setModele(modele);
       voitures.setMarque(marque);

        voituresService.saveVoiture(voitures);
    }

    @GetMapping(value ="/essai/")
    public String essai(Model model){
        List<Voitures> listeArticle = voituresService.getAll();
        model.addAttribute("voitures",listeArticle);
        return "essai";
    }

    @GetMapping("/delete/{idMarque}")
    public String deleteVoiture(@PathVariable("idMarque") Integer idMarque){
        voituresService.deleteVoiture(idMarque);
        return "redirect:../essai/";
    }

    @GetMapping("/afficherDetails/{idMarque}")
    public String detailVoiture(@PathVariable("idMarque") Integer idMarque,Model model){
        Voitures voiture = voituresService.detailVoiture(idMarque);
        model.addAttribute("voiture",voiture);
        return "afficherDetails";
    }

}
