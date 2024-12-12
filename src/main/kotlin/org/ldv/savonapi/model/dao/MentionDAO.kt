package org.ldv.savonapi.model.dao

import org.ldv.savonapi.model.entity.Caracteristique
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import org.ldv.savonapi.model.entity.Mention
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

@Repository
interface MentionDAO: JpaRepository<Mention, Long> {

    @Query("SELECT m FROM Mention m WHERE m.caracteristique = :caracteristique AND " +
            ":score between m.scoremin and m.scoremax")
    fun findMentionByScoreAndCaracteristique(
        @Param("score") score: Float,
        @Param("caracteristique") caracteristique: Caracteristique
    ): Mention?
}


