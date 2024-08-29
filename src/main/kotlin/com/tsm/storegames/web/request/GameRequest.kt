package com.tsm.storegames.web.request

import java.math.BigDecimal

data class GameRequest(
    val name: String,
    val genre: String,
    val releaseDate: String,
    val price: BigDecimal
)