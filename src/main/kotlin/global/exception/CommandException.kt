package org.example.global.exception

/**
 * CommandException
 * <p></p>
 * @author 100mi
 */
class CommandException(private val errorCode: CommandErrorCode): Exception() {
    override val message: String
        get() = errorCode.message
}