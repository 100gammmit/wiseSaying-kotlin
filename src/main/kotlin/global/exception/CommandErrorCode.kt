package org.example.global.exception

/**
 * CommandErrorCode
 * <p></p>
 * @author 100mi
 */
enum class CommandErrorCode(val message: String) {

    INVALID_COMMAND("잘못된 명령어입니다."),
    INVALID_PARAMETER("잘못된 파라미터입니다."),
    INVALID_ID_FORMAT("잘못된 id 형식입니다.");
}