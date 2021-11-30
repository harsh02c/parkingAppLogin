package com.axis.parkinglogin.util

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping

@FeignClient(value="fiegnDemo",url="http://localhost:8080/parking/")
interface FiegnServiceUtil {
    @GetMapping("/getAllBooking")
    fun getAllBooking():Any?
}