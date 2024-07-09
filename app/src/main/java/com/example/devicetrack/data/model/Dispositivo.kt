import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class Dispositivo(
    @SerializedName("id_dispositivo") var Id_dispositivo: Int,
    @SerializedName("numero_serie") var numero_serie: String,
    @SerializedName("nombre") var nombre: String,
    @SerializedName("imagen") var imagen: String?,
    @SerializedName("favorito") var favorito: Int,
    @SerializedName("conexion") var conexion: Int,
    @SerializedName("codigo_conexion") var codigo_conexion: Int

) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readNullableString(),
        parcel.readInt()?: 0,
        parcel.readInt()?: 0,
        parcel.readInt()?: 0
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(Id_dispositivo)
        parcel.writeString(numero_serie)
        parcel.writeString(nombre)
        parcel.writeString(imagen)
        parcel.writeInt(favorito)
        parcel.writeInt(conexion)
        parcel.writeInt(codigo_conexion)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Dispositivo> {
        override fun createFromParcel(parcel: Parcel): Dispositivo {
            return Dispositivo(parcel)
        }

        override fun newArray(size: Int): Array<Dispositivo?> {
            return arrayOfNulls(size)
        }
    }
}

// Extension functions to handle nullable types in Parcel
private fun Parcel.readNullableString(): String? {
    return if (readInt() != 0) readString() else null
}

private fun Parcel.readIntOrNull(): Int? {
    return if (readInt() != 0) readInt() else null
}
