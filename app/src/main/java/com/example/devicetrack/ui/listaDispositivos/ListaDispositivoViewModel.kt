package com.example.devicetrack.ui.listaDispositivos

import Dispositivo
import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.devicetrack.data.DispositivosRepository
import kotlinx.coroutines.launch

class ListaDispositivoViewModel : ViewModel() {
    val dispositivoModel = MutableLiveData<List<Dispositivo>?>()
    val dispositivoFavModel = MutableLiveData<List<Dispositivo>?>()
    val isLoading = MutableLiveData<Boolean>()
    val dispositivosRepo = DispositivosRepository()


    fun onCreate(context: Context) {
        viewModelScope.launch {
            //recuperamos idUsuario
            val sharedPreferences: SharedPreferences = context.getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
            val idUser = sharedPreferences.getString("idUser", null).toString()
            isLoading.postValue(true)
            var result = emptyList<Dispositivo>()
            result = dispositivosRepo.getAllDispositivos(idUser)

            if(!result.isNullOrEmpty()){
                dispositivoModel.postValue(result)
                isLoading.postValue(false)
            }

            var result2 = emptyList<Dispositivo>()
            //result2 = dispositivosRepo.getAllDispositivosFav()
            dispositivoFavModel.postValue(result2)
        }
    }
}