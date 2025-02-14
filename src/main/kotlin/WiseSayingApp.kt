package org.example

import org.example.global.Parser
import org.example.global.exception.CommandErrorCode
import org.example.global.exception.CommandException
import org.example.wiseSaying.controller.WiseSayingController
import org.example.wiseSaying.exception.WiseSayingException

/**
 * ${NAME}
 * <p></p>
 * @author 100mi
 */
fun main() {

    val wiseSayingController = WiseSayingController()
    val parser = Parser()

    while(true) {

        println("== 명언 앱 ==")
        print("명령) ")
        val command = readln()

        try{
            when {
                command == "종료" -> break;
                command == "등록" -> wiseSayingController.save()
                command.startsWith("목록") -> wiseSayingController.getAll()
                command.startsWith("삭제") -> wiseSayingController.delete(parser.parse(command))
                command.startsWith("수정") -> wiseSayingController.modify(parser.parse(command))
                else -> throw CommandException(CommandErrorCode.INVALID_COMMAND)
            }
        } catch (e: CommandException) {
            println(e.message)
        } catch (e: WiseSayingException) {
            println(e.message)
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }
}
