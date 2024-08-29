package com.tsm.storegames.entity

import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table(name = "console_table")
data class ConsoleEntity (
    val name: String,
    @Column(name = "release_date")
    val releaseDate: String,
    val price: BigDecimal
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
}