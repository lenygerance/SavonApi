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



    ) {
    fun login():Boolean{
        return true
    }
}