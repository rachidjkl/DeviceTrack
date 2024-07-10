package com.example.devicetrack.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.devicetrack.data.DispositivosRepository

class GruposViewModelFactory(private val repository: DispositivosRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(GruposViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return GruposViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
