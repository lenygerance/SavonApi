package org.ldv.savonapi.model.entity

import jakarta.persistence.*
import org.ldv.savonapi.model.id.ResultatId

@Entity
@Table(name = "resultat")
class Resultat(
  @EmbeddedId
    var resultatId: ResultatId? = null,
    var score: Float,

    @MapsId("recetteId")
    @ManyToOne
    @JoinColumn(name ="recetteId")
    var recette: Recette? = null,

    @MapsId("caracteristiqueId")
    @ManyToOne
    @JoinColumn(name ="caracteristiqueId")
    var caracteristique: Caracteristique? = null,
) {
}