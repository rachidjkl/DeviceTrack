package com.example.devicetrack.data.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import java.time.format.DateTimeFormatter

data class Alerta(
    @SerializedName("Id_alerta") var Id_alerta: Int,
    @SerializedName("leido") var leido: Int,
    @SerializedName("fecha") var fecha: DateTimeFormatter,
    @SerializedName("descripcion") var descripcion: String,
    @SerializedName("tipo") var tipo: Int,
    @SerializedName("dispositivo") var dispositivo: Int
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt() ?:0,
        parcel.readInt() ?: 0,
        TODO("fecha"),
        parcel.readString() ?: "",
        parcel.readInt() ?: 0,
        parcel.readInt() ?:0,
    ) {

    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(Id_alerta)
        parcel.writeInt(leido)
        parcel.writeString(descripcion)
        parcel.writeInt(tipo)
        parcel.writeInt(dispositivo)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Alerta> {
        override fun createFromParcel(parcel: Parcel): Alerta {
            return Alerta(parcel)
        }

        override fun newArray(size: Int): Array<Alerta?> {
            return arrayOfNulls(size)
        }
    }
}