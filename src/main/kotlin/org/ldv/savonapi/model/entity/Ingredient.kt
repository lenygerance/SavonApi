package org.ldv.savonapi.model.entity

import jakarta.persistence.*


@Entity
@Table(name="ingrediant")

class Ingredient (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var ingredientId: Long,
    var nom: String,
    var douceur: Float,
    var lavant: Float,
    var volmousse: Float,
    var tenuemousse: Float,
    var durete: Float,
    var solubilite: Float,
    var sechage: Float,
    var ins: Float,
    var iode: Float,
    var sapo: Float,

    @OneToMany(mappedBy = "ingrediant")
    var ligne: MutableList<Ligne> = mutableListOf()
){
}