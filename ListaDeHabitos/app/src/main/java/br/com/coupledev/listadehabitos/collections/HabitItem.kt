package br.com.coupledev.listadehabitos.collections

data class HabitItem(
    val id: String,
    val title: String,
    val description: String,
    val isCompleted: Boolean
)
