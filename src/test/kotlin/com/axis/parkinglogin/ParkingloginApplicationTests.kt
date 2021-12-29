package com.axis.parkinglogin

import com.axis.parkinglogin.dao.IUserDAO
import com.axis.parkinglogin.model.User
import com.axis.parkinglogin.service.ILoginService
import junit.framework.TestCase.assertEquals
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Mockito.`when`
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean


@SpringBootTest
class ParkingloginApplicationTests {

//	@Test
//	fun contextLoads() {
//	}

//	@Autowired
//	private lateinit var iLoginService: ILoginService
//	@MockBean
//	private val repository: IUserDAO? = null
//
//	@Test
//	fun signUp() {
//
//		val user = User()
//		user.name = "Test"
//		user.email = "test@gmail.com"
//		user.mobileNo = "99999999"
//		user.password = "123"
//		`when`(repository!!.save(user)).thenReturn(user)
//		Assertions.assertEquals(user, iLoginService.signUp(user))
//	}
//
//	@Test
//	fun login() {
//
//		val user = User()
//		user.email = "test@gmail.com"
//		`when`(repository!!.findByEmail("test@gmail.com")).thenReturn(user)
//		Assertions.assertEquals(user, iLoginService.findByEmail("test@gmail.com"))
//	}
}
