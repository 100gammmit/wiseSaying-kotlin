package org.example.wiseSaying.exception

/**
 * WiseSayingErrorCode
 * <p></p>
 * @author 100mi
 */
enum class WiseSayingErrorCode(val message: String) {

    NOT_FOUND("번 명언은 존재하지 않습니다."),
    INVALID_ID_FORMAT("잘못된 id 형식입니다.")
}