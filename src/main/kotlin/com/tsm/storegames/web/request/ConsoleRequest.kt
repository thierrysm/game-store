package com.tsm.storegames.web.request

import java.math.BigDecimal

data class ConsoleRequest (
    val name: String,
    val releaseDate: String,
    val price: BigDecimal
)