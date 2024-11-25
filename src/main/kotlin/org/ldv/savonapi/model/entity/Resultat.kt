package org.ldv.savonapi.model.entity

import jakarta.persistence.*

@Entity
@Table(name = "resultat")
class Resultat(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var resultatId: Long,
    var score: Long,
) {
}