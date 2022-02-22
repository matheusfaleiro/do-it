package dev.theuzfaleiro.doit.data.model

import androidx.compose.ui.graphics.Color
import dev.theuzfaleiro.doit.ui.theme.HighPriority
import dev.theuzfaleiro.doit.ui.theme.LowPriority
import dev.theuzfaleiro.doit.ui.theme.MediumPriority
import dev.theuzfaleiro.doit.ui.theme.UnknownPriority

enum class Priority(val color: Color) {
    LOW(LowPriority),
    MEDIUM(MediumPriority),
    HIGH(HighPriority),
    UNKNOWN(UnknownPriority);

    companion object {
        fun from(value: Int): Priority {
            return when (value) {
                1 -> LOW
                2 -> MEDIUM
                3 -> HIGH
                else -> UNKNOWN
            }
        }
    }
}