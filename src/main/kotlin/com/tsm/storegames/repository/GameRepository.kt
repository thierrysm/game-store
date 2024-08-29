package com.tsm.storegames.repository

import com.tsm.storegames.entity.GameEntity
import org.springframework.data.jpa.repository.JpaRepository

interface GameRepository : JpaRepository<GameEntity, Long>