package org.ldv.savonapi.model.entity


import jakarta.persistence.*


@Entity
@Table(name = "mention")
class Mention (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var mentionId: Long,
    var label:String,
    var scoremin:Float?,
    var scoremax:Float?,


    @ManyToOne
    @JoinColumn(name ="caracteristiqueId")
    var caracteristique: Caracteristique? = null,

){
}