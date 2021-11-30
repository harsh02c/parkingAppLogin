package com.axis.parkinglogin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients
class ParkingloginApplication

fun main(args: Array<String>) {
	runApplication<ParkingloginApplication>(*args)
}
