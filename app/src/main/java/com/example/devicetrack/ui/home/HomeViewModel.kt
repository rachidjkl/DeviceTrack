package com.example.devicetrack.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.devicetrack.data.model.Dispositivos
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    val dispositivoModel = MutableLiveData<List<Dispositivos>?>()
    val dispositivoFavModel = MutableLiveData<List<Dispositivos>?>()
    val isLoading = MutableLiveData<Boolean>()

    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            var result = emptyList<Dispositivos>()
            result = listOf(
                Dispositivos(1, "123456", "Dispositivo 1", "imagen1.jpg"),
                Dispositivos(2, "789012", "Dispositivo 2", "imagen2.jpg"),
                Dispositivos(3, "345678", "Dispositivo 3", "imagen3.jpg"))

            if(!result.isNullOrEmpty()){
                dispositivoModel.postValue(result)
                isLoading.postValue(false)
            }

            var result2 = emptyList<Dispositivos>()
            result2 = listOf(
                Dispositivos(1, "123456", "Favorito 1", "imagen1.jpg"),
                Dispositivos(2, "789012", "Favorito 2", "imagen2.jpg"),
                Dispositivos(3, "345678", "Favorito 3", "imagen3.jpg"))

                dispositivoFavModel.postValue(result2)
        }
    }
}