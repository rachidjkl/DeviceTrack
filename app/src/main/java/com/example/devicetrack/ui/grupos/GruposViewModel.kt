package com.example.devicetrack.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.devicetrack.data.model.Grupo
import com.example.devicetrack.data.DispositivosRepository
import kotlinx.coroutines.launch

class GruposViewModel(private val repository: DispositivosRepository) : ViewModel() {

    private val _grupos = MutableLiveData<List<Grupo>>()
    val grupos: LiveData<List<Grupo>> get() = _grupos

    fun fetchGrupos(idDispositivo: String) {
        viewModelScope.launch {
            val gruposList = repository.getAllGrupDispositivos(idDispositivo)
            _grupos.value = gruposList
        }
    }
}
