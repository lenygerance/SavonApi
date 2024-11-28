package org.ldv.savonapi.model.entity

import jakarta.persistence.*
import org.springframework.context.annotation.Description

@Entity
@Table (name="recette")
class Recette (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var recetteId: Long,
    var titreId: Long,
    var description: String,
    var surgraissage: Float,
    var qteEau: Float,
    var qteAcalin: Float,
    var concentrationAlcalin: Float,
    var typeAlcalin: String,

    @ManyToOne
    @JoinColumn(name ="utilisateurId")
    var utilisateur: Utilisateur? = null,

    @OneToMany(mappedBy = "recetteId")
    var resultat: MutableList<Resultat>? = null,

    @OneToMany(mappedBy = "recetteId")
    var ligne: MutableList<Ligne>? = null,

){
}