package com.example.bankingapp

import androidx.compose.ui.graphics.vector.ImageVector

data class Currency(
    val name: String,
    val buy: String,
    val sell: String,
    val icon: ImageVector
)
