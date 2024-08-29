package com.tsm.storegames.repository

import com.tsm.storegames.entity.ConsoleEntity
import org.springframework.data.jpa.repository.JpaRepository

interface ConsoleRepository : JpaRepository<ConsoleEntity, Long>