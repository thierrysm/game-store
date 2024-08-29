package com.tsm.storegames.util

fun <T> T?.orThrow() = this ?: error("Value cannot be null")