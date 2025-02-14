package org.example.wiseSaying.controller

import org.example.global.exception.CommandErrorCode
import org.example.global.exception.CommandException
import org.example.wiseSaying.service.WiseSayingService

/**
 * WiseSayingController
 * <p></p>
 * @author 100mi
 */
class WiseSayingController {

    private val wiseSayingService = WiseSayingService()

    fun save() {
        print("명언 : ")
        val content = readln()
        print("작가 : ")
        val author = readln()

        val wiseSaying = wiseSayingService.save(content, author)
        println("${wiseSaying.id}번 명언이 등록되었습니다.")
    }

    fun getAll() {
        println(
            """
                번호 / 작가 / 명언
                ----------------------
            """.trimIndent()
        )
        val wiseSayings = wiseSayingService.findAll()
        for ((id, wiseSaying) in wiseSayings.toList().reversed()) {
            println("$id / ${wiseSaying.author} / ${wiseSaying.content}")
        }
    }

    fun delete(param: Map<String, String>) {
        if (!param.containsKey("id")) {
            throw CommandException(
                CommandErrorCode.INVALID_PARAMETER)
        }

        val id = param["id"]?.toIntOrNull() ?: throw CommandException(
            CommandErrorCode.INVALID_ID_FORMAT)

        if (!wiseSayingService.existsById(id)) {
            println("${id}번 명언은 존재하지 않습니다.")
        } else {
            wiseSayingService.deleteById(id)
            println("${id}번 명언이 삭제되었습니다.")
        }
    }

    fun modify(param: Map<String, String>) {

        if (!param.containsKey("id")) {
            throw CommandException(CommandErrorCode.INVALID_PARAMETER)
        }

        val id = param["id"]?.toIntOrNull() ?: throw CommandException(CommandErrorCode.INVALID_ID_FORMAT)

        val wiseSaying = wiseSayingService.findById(id)

        print(
            """
                |명언(기존) : ${wiseSaying.content}
                |명언 : 
            """.trimMargin()
        )
        val content = readln()
        print(
            """
                |작가(기존) : ${wiseSaying.author}
                |작가 : 
            """.trimMargin()
        )
        val author = readln()

        wiseSayingService.modify(wiseSaying, content, author)
    }
}