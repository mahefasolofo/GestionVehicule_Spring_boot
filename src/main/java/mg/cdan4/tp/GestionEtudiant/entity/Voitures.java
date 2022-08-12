package mg.cdan4.tp.GestionEtudiant.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class Voitures {

    @Id
    @Column(nullable = false)
    /*@GeneratedValue(strategy = GenerationType.AUTO)*/
    private Integer idMarque;

    @Column
    private String libele;

    @Column
    private String modele;

    @Column
    private String marque;
}
