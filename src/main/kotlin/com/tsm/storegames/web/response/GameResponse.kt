package com.tsm.storegames.web.response

import java.math.BigDecimal

data class GameResponse (
    val id: Long,
    val name: String,
    val genre: String,
    val releaseDate: String,
    val price: BigDecimal
)