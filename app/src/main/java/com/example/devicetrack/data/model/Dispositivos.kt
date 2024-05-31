package com.example.devicetrack.data.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class Dispositivos(
    @SerializedName("Id_dispositivo") var Id_dispositivo: Int,
    @SerializedName("numero_serie") var numero_serie: String,
    @SerializedName("nombre") var nombre: String,
    @SerializedName("imagen") var imagen: String,
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt() ?: 0,
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(Id_dispositivo)
        parcel.writeString(numero_serie)
        parcel.writeString(nombre)
        parcel.writeString(imagen)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Dispositivos> {
        override fun createFromParcel(parcel: Parcel): Dispositivos {
            return Dispositivos(parcel)
        }

        override fun newArray(size: Int): Array<Dispositivos?> {
            return arrayOfNulls(size)
        }
    }
}
