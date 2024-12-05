package org.ldv.savonapi.model.dto

import org.ldv.savonapi.model.dao.LigneDAO

class FormRecette(
    var id :Long? = null,
    var titre: String,
    var description: String,
    var surgraissage: Float,
    var avecSoude: Boolean,
    var concentrationAlcalin: Float,
    var ligneIngredients: MutableList<LigneDAO> = mutableListOf(),
) {
}