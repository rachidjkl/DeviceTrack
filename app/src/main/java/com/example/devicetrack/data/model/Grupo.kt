package com.example.devicetrack.data.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class Grupo(
    @SerializedName("grupo") var grupo: Int,
    @SerializedName("nombre") var nombre:String
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt() ?:0,
        parcel.readString() ?: ""
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(grupo)
        parcel.writeString(nombre)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Grupo> {
        override fun createFromParcel(parcel: Parcel): Grupo {
            return Grupo(parcel)
        }

        override fun newArray(size: Int): Array<Grupo?> {
            return arrayOfNulls(size)
        }
    }
}