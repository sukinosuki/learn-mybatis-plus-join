package com.example.learnmybatisplusjoin.config

import com.example.learnmybatisplusjoin.common.R
import com.example.learnmybatisplusjoin.common.exception.RecordNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus
import java.lang.Exception

@ControllerAdvice
class ExceptionHandler {

    @ExceptionHandler(Exception::class)
    @ResponseBody
    fun handleException(e: Exception): R<Any?> {
        return R.error(msg = e.message ?: "server error", code = 500)
    }

    @ExceptionHandler(RecordNotFoundException::class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    fun handleRecordNotFoundException(e: RecordNotFoundException): R<Any?> {

        return R.error(msg = e.msg, code = 404)
    }
}