package br.com.coupledev.listadehabitos.core

import br.com.coupledev.listadehabitos.collections.HabitItem
import java.util.UUID

class TestHabitRepository : HabitsRepository {

    val habitList = mutableListOf<HabitItem>()

    override fun fetchHabits() = habitList

    override fun addRandomNewHabit() {
        habitList.add(
            HabitItem(
                id = UUID.randomUUID().toString(),
                title = "Read the book",
                isCompleted = false,
                description = "Read the book"
            )
        )
    }

    override fun toggleHabitCompletion(habitId: String) {
        val index = habitList.indexOfFirst { it.id == habitId }
        habitList[index] = habitList[index].copy(isCompleted = !habitList[index].isCompleted)
    }
}