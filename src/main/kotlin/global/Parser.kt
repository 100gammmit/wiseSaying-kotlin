package org.example.global

/**
 * Parser
 * <p></p>
 * @author 100minha
 */
class Parser {

    fun parse(command: String) : Map<String, String> {
        val paramList = command.substring(3).split("&")
        val mappedParam = mutableMapOf<String, String>()

        for(param in paramList) {
            val splitParam = param.split("=")
            mappedParam[splitParam.get(0)] = splitParam.get(1)
        }

        return mappedParam
    }
}