package org.example

import org.example.global.ExceptionHandler
import org.example.global.Parser
import org.example.global.exception.CommandErrorCode
import org.example.global.exception.CommandException
import org.example.wiseSaying.controller.WiseSayingController

/**
 * ${NAME}
 * <p></p>
 * @author 100mi
 */
fun main() {

    val wiseSayingController = WiseSayingController()
    val exceptionHandler = ExceptionHandler()
    val parser = Parser()
    var appRunning = true

    while(appRunning) {

        exceptionHandler.handleGlobalException {
            println("== 명언 앱 ==")
            print("명령) ")
            val command = readln()

            when {
                command == "종료" -> appRunning = false
                command == "등록" -> wiseSayingController.save()
                command.startsWith("목록") -> wiseSayingController.getAll()
                command.startsWith("삭제") -> wiseSayingController.delete(parser.parse(command))
                command.startsWith("수정") -> wiseSayingController.modify(parser.parse(command))
                else -> throw CommandException(CommandErrorCode.INVALID_COMMAND)
            }
        }

    }
}
