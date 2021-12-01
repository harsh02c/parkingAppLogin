package com.axis.parkinglogin.dto

import com.fasterxml.jackson.annotation.JsonIgnore
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import javax.validation.constraints.NotBlank

class SignUpDTO {
    val _id= ""
    @NotBlank(message = "mobileNo is mandatory")
    val mobileNo= ""
    @NotBlank(message = "MobileNo is mandatory")
    val name=""
    val email =""
    val password = ""

}