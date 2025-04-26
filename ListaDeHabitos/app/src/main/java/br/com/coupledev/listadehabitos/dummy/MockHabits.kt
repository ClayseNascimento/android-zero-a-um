package br.com.coupledev.listadehabitos.dummy

import br.com.coupledev.listadehabitos.collections.HabitItem
import br.com.coupledev.listadehabitos.core.HabitsRepository
import java.util.UUID


object MockHabits : HabitsRepository {

    private val randomHabitList = listOf(
        HabitItem(
            id = UUID.randomUUID().toString(),
            title = "Walk the dog",
            isCompleted = false,
            description = "Take the dog for a walk"
        ),
        HabitItem(
            id = UUID.randomUUID().toString(),
            title = "Do the dishes",
            isCompleted = false,
            description = "Clean the dishes",
        ),
        HabitItem(
            id = UUID.randomUUID().toString(),
            title = "Go to the gym",
            isCompleted = false,
            description = "Hit the gym"
        ),
        HabitItem(
            id = UUID.randomUUID().toString(),
            title = "Code every day",
            isCompleted = false,
            description = "Write some code",
        ),
        HabitItem(
            id = UUID.randomUUID().toString(),
            title = "Make a cup of tea",
            isCompleted = false,
            description = "Make a cup of tea",
        ),
        HabitItem(
            id = UUID.randomUUID().toString(),
            title = "Make a cup of coffee",
            isCompleted = false,
            description = "Make a cup of coffee",
        )
    )

    private val habitItemList: MutableList<HabitItem> = mutableListOf(
        HabitItem(
            id = UUID.randomUUID().toString(),
            title = "Read the book",
            isCompleted = false,
            description = "Read the book",
        )
    )

    override fun fetchHabits() = habitItemList.map { it.copy() }

    override fun addRandomNewHabit() {
        habitItemList.add(0, randomHabit())
    }

    override fun toggleHabitCompletion(habitId: String) {
        val habitIndex = findHabitIndexById(habitId)
        val habit = habitItemList[habitIndex]
        habitItemList[habitIndex] = habit.copy(isCompleted = !habit.isCompleted)
        sortHabitListByCompletion()
    }

    private fun randomHabit() = randomHabitList.random().copy(
        id = UUID.randomUUID().toString()
    )

    private fun findHabitIndexById(id: String) = habitItemList.indexOfFirst { habitItem ->
        habitItem.id == id
    }

    private fun sortHabitListByCompletion() = habitItemList.sortBy { it.isCompleted }
}