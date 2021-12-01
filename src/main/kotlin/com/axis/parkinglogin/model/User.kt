package com.axis.parkinglogin.model

import com.fasterxml.jackson.annotation.JsonIgnore
import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank

@Document(collection = "user")
class User {

    @Id
    var _id: ObjectId? = null
//    var _id:Int=0
    @NotBlank(message = "Name is mandatory")
    var name=""
    @NotBlank(message = "MobileNo is mandatory")
    var mobileNo=""
    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email is Not valid")
    var email=""
    @NotBlank(message = "Email is mandatory")
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