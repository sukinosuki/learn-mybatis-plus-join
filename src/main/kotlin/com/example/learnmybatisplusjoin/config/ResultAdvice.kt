package com.example.learnmybatisplusjoin.config

import com.example.learnmybatisplusjoin.common.R
import org.slf4j.LoggerFactory
import org.springframework.core.MethodParameter
import org.springframework.http.MediaType
import org.springframework.http.converter.HttpMessageConverter
import org.springframework.http.server.ServerHttpRequest
import org.springframework.http.server.ServerHttpResponse
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice


@RestControllerAdvice
class ResultAdvice : ResponseBodyAdvice<Any> {
    var logger = LoggerFactory.getLogger(ResultAdvice::class.java)

    override fun supports(returnType: MethodParameter, converterType: Class<out HttpMessageConverter<*>>): Boolean {
        return returnType.declaringClass.name.contains("com.example")
    }

    override fun beforeBodyWrite(
        body: Any?,
        returnType: MethodParameter,
        selectedContentType: MediaType,
        selectedConverterType: Class<out HttpMessageConverter<*>>,
        request: ServerHttpRequest,
        response: ServerHttpResponse
    ): Any? {
        logger.info("before body write $body")
        logger.info("return type $returnType")

        if (body is R<*>) {
            return body
        }
//        return body
        return R.ok(body)
    }
}