package com.example.devicetrack.ui.listaDispositivos.añadirDispositivos

import Dispositivo
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.devicetrack.data.DispositivosRepository
import com.example.devicetrack.data.model.Grupo
import com.example.devicetrack.data.network.Service
import kotlinx.coroutines.launch

class AñadirDispositivoViewModel : ViewModel() {

    private val repository = DispositivosRepository(Service())

    private val _listaGrupos = MutableLiveData<List<Grupo>>()
    val listaGrupos: LiveData<List<Grupo>> get() = _listaGrupos

    private val _guardarDispositivoResult = MutableLiveData<Boolean>()
    val guardarDispositivoResult: LiveData<Boolean> get() = _guardarDispositivoResult

    fun obtenerGrupos(idDispositivo: String) {
        viewModelScope.launch {
            try {
                val grupos = repository.getAllGrupDispositivos(idDispositivo)
                _listaGrupos.postValue(grupos)
            } catch (e: Exception) {
                // Manejar error
                _listaGrupos.postValue(emptyList())
            }
        }
    }

    fun guardarDispositivo(dispositivo: Dispositivo) {
        viewModelScope.launch {
            try {
                repository.postDispositivo(dispositivo)
                _guardarDispositivoResult.postValue(true)
            } catch (e: Exception) {
                // Manejar error
                _guardarDispositivoResult.postValue(false)
            }
        }
    }
}
