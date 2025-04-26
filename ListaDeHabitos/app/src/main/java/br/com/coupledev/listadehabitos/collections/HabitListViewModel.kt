package br.com.coupledev.listadehabitos.collections

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

import br.com.coupledev.listadehabitos.core.HabitsRepository

class HabitListViewModel(private val repository: HabitsRepository) : ViewModel() {

    private val uiState: MutableLiveData<HabitListUiState> by lazy {
        MutableLiveData<HabitListUiState>(HabitListUiState(habitItemList = repository.fetchHabits()))
    }

    fun stateOnceAndStream(): LiveData<HabitListUiState> {
        return uiState
    }


    fun addRandomHabit() {
        repository.addRandomNewHabit()
        refreshHabitList()
    }

     fun toggleHabitCompletion(habitId: String) {
        repository.toggleHabitCompletion(habitId)
         refreshHabitList()
    }


    private fun refreshHabitList() {
        uiState.value?.let { currentUiState ->
            uiState.value = currentUiState.copy(
                habitItemList = repository.fetchHabits()
            )
        }
    }


    @Suppress("UNCHECKED_CAST")
    class Factory(private val repository: HabitsRepository) : ViewModelProvider.Factory {

        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return HabitListViewModel(repository) as T
        }
    }
}