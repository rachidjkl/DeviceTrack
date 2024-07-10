package com.example.devicetrack.ui.listaDispositivos

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.devicetrack.data.network.Service

class ListaDispositivoViewModelFactory(private val service: Service) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ListaDispositivoViewModel::class.java)) {
            return ListaDispositivoViewModel(service) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
