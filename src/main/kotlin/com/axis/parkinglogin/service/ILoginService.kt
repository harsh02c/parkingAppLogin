package com.axis.parkinglogin.service

import com.axis.parkinglogin.model.User
import java.util.*

interface ILoginService {
    fun signUp(user:User):User?
    fun login(user:User):User?
    fun findByEmail(email:String): User?
    fun getById(id: Int): Optional<User?>
}