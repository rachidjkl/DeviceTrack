package com.example.devicetrack.data.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class Usuario_dispositivo(
    @SerializedName("usuario") var usuario: Int,
    @SerializedName("dispositivo") var dispositivo: Int,
    @SerializedName("favorito") var favorito: Int,
    @SerializedName("conexion") var conexion: Int
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt() ?: 0,
        parcel.readInt() ?: 0,
        parcel.readInt() ?: 0,
        parcel.readInt() ?: 0
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(usuario)
        parcel.writeInt(dispositivo)
        parcel.writeInt(favorito)
        parcel.writeInt(conexion)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Usuario_dispositivo> {
        override fun createFromParcel(parcel: Parcel): Usuario_dispositivo {
            return Usuario_dispositivo(parcel)
        }

        override fun newArray(size: Int): Array<Usuario_dispositivo?> {
            return arrayOfNulls(size)
        }
    }
}
