package org.ldv.savonapi.model.entity

import jakarta.persistence.*
import org.ldv.savonapi.model.id.LigneId


@Entity
@Table(name = "ligne")
class Ligne(
    @EmbeddedId
    var ligneId: LigneId? = null,
    var quantite: Float,
    var pourcentage: Float,

    @MapsId("ingredientId")
    @ManyToOne
    @JoinColumn(name ="ingredientId")
    var ingredient: Ingredient? = null,

    @MapsId("recetteId")
    @ManyToOne
    @JoinColumn(name ="recetteId")
    var recette: Recette? = null,
)  {
}