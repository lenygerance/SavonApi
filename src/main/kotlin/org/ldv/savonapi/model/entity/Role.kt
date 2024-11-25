package org.ldv.savonapi.model.entity

import jakarta.persistence.*

@Entity
@Table (name="role")
class Role(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var roleId: Long,
    var description: String
) {
}