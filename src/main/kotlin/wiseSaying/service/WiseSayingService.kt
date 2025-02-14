package org.example.wiseSaying.service

import org.example.wiseSaying.entity.WiseSaying
import org.example.wiseSaying.exception.WiseSayingErrorCode
import org.example.wiseSaying.exception.WiseSayingException
import org.example.wiseSaying.repository.WiseSayingRepository

/**
 * WiseSayingService
 * <p></p>
 * @author 100mi
 */
class WiseSayingService {
    private val wiseSayingRepository = WiseSayingRepository()

    fun save(content: String, author: String): WiseSaying {
        return wiseSayingRepository.save(WiseSaying(content, author))
    }

    fun findAll(): MutableMap<Int, WiseSaying> {
        return wiseSayingRepository.findAll()
    }

    fun existsById(id: Int) : Boolean {
        return wiseSayingRepository.existsById(id)
    }

    fun deleteById(id: Int) {
        wiseSayingRepository.deleteById(id)
    }

    fun findById(id: Int) : WiseSaying {
        return wiseSayingRepository.findById(id) ?: throw WiseSayingException(
            WiseSayingErrorCode.NOT_FOUND, id
        )
    }

    fun modify(wiseSaying: WiseSaying, content: String, author: String) {
        wiseSayingRepository.save(wiseSaying.modify(content, author))
    }
}