package com.example.devicetrack.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.devicetrack.data.DispositivosRepository
import com.example.devicetrack.data.model.Dispositivo
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    val dispositivoModel = MutableLiveData<List<Dispositivo>?>()
    val dispositivoFavModel = MutableLiveData<List<Dispositivo>?>()
    val isLoading = MutableLiveData<Boolean>()
    val dispositivosRepo = DispositivosRepository()

    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            var result = emptyList<Dispositivo>()
            result = dispositivosRepo.getAllDispositivos()


            if(!result.isNullOrEmpty()){
                dispositivoModel.postValue(result)
                isLoading.postValue(false)
            }
            var result2 = emptyList<Dispositivo>()
            //result2 = dispositivosRepo.getAllDispositivosFav()
            dispositivoFavModel.postValue(result2)


                dispositivoFavModel.postValue(result2)

        }
    }
}