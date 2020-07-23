package com.github.roomtest

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey


@Entity(tableName = "datas")
class WorkData11 {
    @PrimaryKey(autoGenerate = true)
    var id = 0
        private set

    @ColumnInfo(name = "data")
    var data: String
        private set

    constructor(id: Int, data: String) {
        this.id = id
        this.data = data
    }

    @Ignore
    constructor(data: String) {
        this.data = data
    }

}