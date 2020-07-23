package com.github.roomtest

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface DataDAO {
    @Insert
    fun insert(workData11: WorkData11?)

    @Update
    fun update(workData11: WorkData11?)

    @Delete
    fun delete(workData11: WorkData11?)

    @Query("select * from datas limit 1")
    fun getlimituserList(): LiveData<List<WorkData11?>?>?
}