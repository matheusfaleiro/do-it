package dev.theuzfaleiro.todo.data.model

import androidx.compose.ui.graphics.Color
import dev.theuzfaleiro.todo.ui.theme.CriticalPriority
import dev.theuzfaleiro.todo.ui.theme.HighPriority
import dev.theuzfaleiro.todo.ui.theme.ImportantPriority
import dev.theuzfaleiro.todo.ui.theme.LowPriority
import dev.theuzfaleiro.todo.ui.theme.MediumPriority
import dev.theuzfaleiro.todo.ui.theme.UnknownPriority
import dev.theuzfaleiro.todo.ui.theme.UrgentPriority

enum class Priority(val colors: Color) {
    LOW(LowPriority),
    MEDIUM(MediumPriority),
    HIGH(HighPriority),
    URGENT(UrgentPriority),
    IMPORTANT(ImportantPriority),
    CRITICAL(CriticalPriority),
    UNKNOWN(UnknownPriority);
}