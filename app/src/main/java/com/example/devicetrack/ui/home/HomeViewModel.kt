package com.example.devicetrack.ui

import Dispositivo
import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.devicetrack.data.DispositivosRepository
import com.example.devicetrack.data.network.Service
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    val dispositivoModel = MutableLiveData<List<Dispositivo>?>()
    val dispositivoFavModel = MutableLiveData<List<Dispositivo>?>()
    val isLoading = MutableLiveData<Boolean>()
    private val dispositivosRepo: DispositivosRepository

    init {
        dispositivosRepo = DispositivosRepository(Service())
    }

    fun onCreate(context: Context) {
        viewModelScope.launch {
            val sharedPreferences: SharedPreferences = context.getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
            val idUser = sharedPreferences.getString("idUser", null).toString()
            isLoading.value = true
            var result = emptyList<Dispositivo>()
            result = dispositivosRepo.getAllDispositivos(idUser)

            if (result.isNotEmpty()) {
                dispositivoModel.value = result
                isLoading.value = false
            }

            var result2 = emptyList<Dispositivo>()
            result2 = dispositivosRepo.getAllDispositivosFav(idUser)
            dispositivoFavModel.value = result2

            isLoading.value = false
        }
    }
}
