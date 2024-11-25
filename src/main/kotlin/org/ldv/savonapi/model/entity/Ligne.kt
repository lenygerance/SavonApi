package org.ldv.savonapi.model.entity

import jakarta.persistence.*


@Entity
@Table(name = "ligne")
class Ligne(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var ligneId: Long,
    var quantite: Float,
)  {
}