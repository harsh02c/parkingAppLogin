package com.axis.parkinglogin.model

import com.fasterxml.jackson.annotation.JsonIgnore
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

@Document(collection = "user")
class User {
    @Id
//    var _id=""
    var _id:Int=0
    var name=""
    var mobileNo=""
    var email=""
    var password=""
        @JsonIgnore
        get()=field
        set(value) {
            val passwordEncoder = BCryptPasswordEncoder()
            field = passwordEncoder.encode(value)
        }

    fun comparePassword(password: String): Boolean {
        return BCryptPasswordEncoder().matches(password,this.password)
    }
}