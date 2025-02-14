package org.example.wiseSaying.entity

/**
 * wiseSaying
 * <p></p>
 * @author 100mi
 */
data class WiseSaying(var content: String, var author: String) {
    val id: Int = nextId()

    companion object {
        private var lastId = 0
        fun nextId(): Int {
            lastId++
            return lastId
        }
    }

    fun modify(content: String, author: String): WiseSaying {
        this.content = content
        this.author = author
        return this
    }
}