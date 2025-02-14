package org.example.wiseSaying.exception

/**
 * WiseSayingException
 * <p></p>
 * @author 100minha
 */
class WiseSayingException(
    private val errorCode: WiseSayingErrorCode,
    private val id: Int? = null) : Exception()
{

    override val message: String
        get() = "${id ?: ""}${errorCode.message}"
}