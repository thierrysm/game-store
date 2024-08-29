package com.tsm.storegames.web.response

import java.math.BigDecimal

data class ConsoleResponse (
    val id: Long,
    val name: String,
    val year: Int,
    val price: BigDecimal
)