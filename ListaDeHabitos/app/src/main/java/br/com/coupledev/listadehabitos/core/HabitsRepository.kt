package br.com.coupledev.listadehabitos.core

import br.com.coupledev.listadehabitos.collections.HabitItem

interface HabitsRepository {
    fun fetchHabits(): List<HabitItem>

    fun addRandomNewHabit()

    fun toggleHabitCompletion(habitId: String)
}