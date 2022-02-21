package dev.theuzfaleiro.doit.domain.entity

import androidx.compose.ui.graphics.Color
import dev.theuzfaleiro.doit.ui.theme.HighPriority
import dev.theuzfaleiro.doit.ui.theme.LowPriority
import dev.theuzfaleiro.doit.ui.theme.MediumPriority
import dev.theuzfaleiro.doit.ui.theme.UnknownPriority

enum class PriorityDto(val colors: Color) {
    LOW(LowPriority),
    MEDIUM(MediumPriority),
    HIGH(HighPriority),
    UNKNOWN(UnknownPriority);
}