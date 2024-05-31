package com.example.devicetrack.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.devicetrack.data.model.Dispositivo
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    val dispositivoModel = MutableLiveData<List<Dispositivo>?>()
    val dispositivoFavModel = MutableLiveData<List<Dispositivo>?>()
    val isLoading = MutableLiveData<Boolean>()

    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            var result = emptyList<Dispositivo>()
            result = listOf(
                Dispositivo(1, "123456", "Dispositivo 1", "imagen1.jpg", 1, 0),
                Dispositivo(2, "789012", "Dispositivo 2", "imagen2.jpg", 0,1),
                Dispositivo(3, "345678", "Dispositivo 3", "imagen3.jpg", 1, 1))

            if(!result.isNullOrEmpty()){
                dispositivoModel.postValue(result)
                isLoading.postValue(false)
            }

            var result2 = emptyList<Dispositivo>()
            result2 = listOf(
                Dispositivo(1, "123456", "Favorito 1", "imagen1.jpg",0,0),
                Dispositivo(2, "789012", "Favorito 2", "imagen2.jpg",1,0),
                Dispositivo(3, "345678", "Favorito 3", "imagen3.jpg",1,1))

                dispositivoFavModel.postValue(result2)
        }
    }
}