package org.ldv.savonapi.model.entity

import jakarta.persistence.*

@Entity
@Table(name = "resultat")
class Resultat(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var resultatId: Long,
    var score: Long,

    @ManyToOne
    @JoinColumn(name ="recetteId")
    var recette: Recette? = null,

    @ManyToOne
    @JoinColumn(name ="caracteristiqueId")
    var caracteristique: Caracteristique? = null,
) {
}