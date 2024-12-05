package org.ldv.savonapi.service

import org.ldv.savonapi.model.dao.*
import org.springframework.stereotype.Service

@Service
class SimulateurService (
    val caracteristiqueDAO: CaracteristiqueDAO,
    val recetteDAO: RecetteDAO,
    val ingredientDAO: IngredientDAO,
    val ligneDAO: LigneDAO,
    val mentionDAO: MentionDAO,
    val resultatDAO: ResultatDAO
){
}