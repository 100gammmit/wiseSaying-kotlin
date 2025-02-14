package org.example.wiseSaying.repository

import org.example.wiseSaying.entity.WiseSaying

/**
 * WiseSayingRepository
 * <p></p>
 * @author 100mi
 */
class WiseSayingRepository {
    private var db = mutableMapOf<Int, WiseSaying>()

    fun save(wiseSaying: WiseSaying) : WiseSaying {
        db[wiseSaying.id] = wiseSaying
        return wiseSaying
    }

    fun findAll() : MutableMap<Int, WiseSaying> {
        return db
    }

    fun existsById(id: Int) : Boolean {
        return db.containsKey(id)
    }

    fun deleteById(id: Int) {
        db.remove(id)
    }

    fun findById(id: Int): WiseSaying? {
        return db[id]
    }

}