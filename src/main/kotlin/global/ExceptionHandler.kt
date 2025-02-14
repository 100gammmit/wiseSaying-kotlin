package org.example.global

import org.example.global.exception.CommandException
import org.example.wiseSaying.exception.WiseSayingException

/**
 * ExceptionHandler
 * <p></p>
 * @author 100mi
 */
class ExceptionHandler {
    fun handleGlobalException(block: () -> Unit) {
        try {
            block()
        } catch (e: CommandException) {
            println(e.message)
        } catch (e: WiseSayingException) {
            println(e.message)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}