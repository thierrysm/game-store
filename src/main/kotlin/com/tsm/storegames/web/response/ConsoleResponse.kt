package com.tsm.storegames.web.response

import java.math.BigDecimal

data class ConsoleResponse (
    val id: Long,
    val name: String,
    val releaseDate: String,
    val price: BigDecimal
)