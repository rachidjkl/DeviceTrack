package com.example.devicetrack.data.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import java.time.format.DateTimeFormatter

data class Mantenimiento(
    @SerializedName("Id_mantenimiento") var mantenimiento: Int,
    @SerializedName("nombre") var  nombre: String,
    @SerializedName("fecha") var fecha:DateTimeFormatter,
    @SerializedName("descripcion") var descripcion: String,
    @SerializedName("dispositivo") var dispositivo:Int
):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt() ?:0,
        parcel.readString() ?:"",
        TODO("fecha"),
        parcel.readString() ?:"",
        parcel.readInt() ?:0,
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(mantenimiento)
        parcel.writeString(nombre)
        parcel.writeString(descripcion)
        parcel.writeInt(dispositivo)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Mantenimiento> {
        override fun createFromParcel(parcel: Parcel): Mantenimiento {
            return Mantenimiento(parcel)
        }

        override fun newArray(size: Int): Array<Mantenimiento?> {
            return arrayOfNulls(size)
        }
    }
}