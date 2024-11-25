package org.ldv.savonapi.model.dao

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import org.ldv.savonapi.model.entity.Caracteristique
import org.springframework.transaction.annotation.Transactional

@Repository
interface CaracteristiqueDAO: JpaRepository<Caracteristique, Long> {


}