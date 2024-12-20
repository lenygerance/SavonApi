package org.ldv.savonapi.model.entity

import jakarta.persistence.*

@Entity
@Table(name = "utilisateur")
class Utilisateur(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var utilisateurId: Long,
    var nom : String,
    var prenom : String,
    var pseudo : String,

    @OneToMany(mappedBy = "utilisateur")
    var recette: MutableList<Recette>? = null,

    @OneToMany(mappedBy = "utilisateur")
    var role: MutableList<Role>? = null,

    ) {
    fun login():Boolean{
        return true
    }
}