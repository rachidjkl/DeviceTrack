package com.example.devicetrack.data.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class Usuario(
    @SerializedName("Id_usuario") var Id_usuario: Int,
    @SerializedName("nombre") var nombre: String,
    @SerializedName("telefono") var telefono: Int,
    @SerializedName("email") var email: String,
    @SerializedName("contrasenya") var contrasenya: String
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt() ?: 0,
        parcel.readString() ?: "",
        parcel.readInt() ?: 0,
        parcel.readString() ?: "",
        parcel.readString() ?:"",
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(Id_usuario)
        parcel.writeString(nombre)
        parcel.writeInt(telefono)
        parcel.writeString(email)
        parcel.writeString(contrasenya)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Usuario> {
        override fun createFromParcel(parcel: Parcel): Usuario {
            return Usuario(parcel)
        }

        override fun newArray(size: Int): Array<Usuario?> {
            return arrayOfNulls(size)
        }
    }
}