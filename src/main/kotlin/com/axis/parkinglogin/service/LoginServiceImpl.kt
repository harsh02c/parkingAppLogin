package com.axis.parkinglogin.service

import com.axis.parkinglogin.model.User
import com.axis.parkinglogin.dao.IUserDAO
import com.axis.parkinglogin.service.ILoginService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import java.util.*

@Service
class LoginServiceImpl : ILoginService {
    @Autowired
    private lateinit var iUserDAO: IUserDAO

    override fun signUp(user: User): User? {

        return iUserDAO.save(user)
    }

    override fun login(user: User): User? {

        return iUserDAO.save(user)
    }

    override fun findByEmail(email: String): User? {
        return iUserDAO.findByEmail(email)
    }

    override fun getById(id: Int): Optional<User?> {
        return iUserDAO.findById(id)
    }

}