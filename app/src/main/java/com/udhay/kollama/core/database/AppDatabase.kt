package com.udhay.kollama.core.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.udhay.kollama.feature.settings.data.local.UserSettingsEntity
import com.udhay.kollama.feature.settings.data.local.UserSettingsDao

@Database(
    entities = [
        UserSettingsEntity::class
    ],
    version = 1,
    exportSchema = true
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userSettingsDao(): UserSettingsDao

    companion object {
        fun create(context: Context): AppDatabase =
            Room.databaseBuilder(
                context,
                AppDatabase::class.java,
                "kollama.db"
            )
                .build()
    }
}