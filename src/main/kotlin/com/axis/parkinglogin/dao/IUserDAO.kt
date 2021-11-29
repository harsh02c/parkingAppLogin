package com.axis.parkinglogin.dao

import com.axis.parkinglogin.model.User
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface IUserDAO :MongoRepository<User,Int>{
    fun findByEmail(email:String): User?
}
