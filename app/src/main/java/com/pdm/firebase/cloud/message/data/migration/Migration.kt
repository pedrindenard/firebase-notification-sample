package com.pdm.firebase.cloud.message.data.migration

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

@Suppress(names = ["UNUSED"])
internal object Migration {

    val VERSION_1_2 = object : Migration(1, 2) {
        override fun migrate(database: SupportSQLiteDatabase) {

        }
    }
}