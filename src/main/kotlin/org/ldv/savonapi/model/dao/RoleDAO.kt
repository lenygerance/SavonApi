package org.ldv.savonapi.model.dao

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import org.ldv.savonapi.model.entity.Role

@Repository
interface RoleDAO: JpaRepository<Role, Long> {
}