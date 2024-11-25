package org.ldv.savonapi.model.entity

import jakarta.persistence.*
import org.springframework.context.annotation.Description

@Entity
@Table (name="recette")
class Recette (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var RecetteId: Long,
    var titreId: Long,
    var description: String,
    var surgraissage: Float,
    var qteEau: Float,
    var qteAcalin: Float,
    var concentrationAlcalin: Float,
    var typeAlcalin: String
){
}