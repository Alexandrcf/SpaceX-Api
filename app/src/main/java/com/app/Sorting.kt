package com.app

import com.app.model.DataClass

class Sorting {
    fun sortByDate(
        missions: List<DataClass>,
        isReversed: Boolean
    ) : List<DataClass> {
        return if (isReversed)
            missions.sortedByDescending { it.date_unix }
        else missions.sortedBy { it.date_unix }
    }
}