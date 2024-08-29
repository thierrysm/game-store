package com.tsm.storegames.entity

import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table(name = "game_table")
data class GameEntity (
    val name: String,
    val genre: String,
    @Column(name = "release_date")
    val releaseDate: String,
    val price: BigDecimal
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
}