package com.ajijul.gmgtest.db

import androidx.room.TypeConverter
import com.ajijul.gmgtest.network.models.*

class Converters {


    @TypeConverter
    fun toTextFromDob(dob: Dob?): String? {
        return dob?.date
    }

    @TypeConverter
    fun fromTextToDob(textDob: String): Dob {
        return Dob("0", textDob)
    }

    @TypeConverter
    fun toTextFromLocation(location: Location?): String? {
        return "${location?.city ?: ""}, + ${location?.state ?: ""}, ${location?.country ?: ""}"
    }

    @TypeConverter
    fun fromTextToLocation(textLocation: String?): Location {
        val address = textLocation?.split(",")
        return Location(
            address?.get(0)?:"", Coordinates("", ""), address?.get(2)?:"", "0",
            address?.get(1)?:"", Street("", "0"), Timezone("", "")
        )
    }

    @TypeConverter
    fun toTextFromLogin(login: Login?): String? {
        return ""
    }

    @TypeConverter
    fun fromTextToLogin(textLogin: String?): Login {
        return Login("", "", "", "", "", "", "")

    }

    @TypeConverter
    fun toTextFromName(name: Name?): String? {
        return "${name?.title ?: ""} ${name?.first ?: ""} ${name?.last ?: ""}"
    }

    @TypeConverter
    fun fromTextToName(textName: String?): Name {
        val name = textName?.split(" ")

        return Name(name?.get(1)?:"", name?.get(2)?:"", name?.get(0)?:"")

    }

    @TypeConverter
    fun toTextFromPicture(picture: Picture?): String? {
        return picture?.medium ?: ""
    }

    @TypeConverter
    fun fromTextToPicture(textPicture: String?): Picture {

        return Picture("", textPicture?:"", "")

    }

    @TypeConverter
    fun toTextFromRegistered(reg: Registered?): String? {
        return reg?.date
    }

    @TypeConverter
    fun fromTextToReg(textReg: String?): Registered {

        return Registered("0", textReg?:"")

    }

    @TypeConverter
    fun toTextFromId(id: Id?): String? {
        return id?.value
    }

    @TypeConverter
    fun fromTextToId(textId: String?): Id {

        return Id("", textId?:"")

    }
}