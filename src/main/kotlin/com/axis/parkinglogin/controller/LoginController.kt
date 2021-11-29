package com.axis.parkinglogin.controller

import com.axis.parkinglogin.dto.LoginDTO
import com.axis.parkinglogin.dto.Message
import com.axis.parkinglogin.dto.SignUpDTO
import com.axis.parkinglogin.model.User
import com.axis.parkinglogin.service.ILoginService
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.lang.Exception
import java.util.*
import javax.servlet.http.Cookie
import javax.servlet.http.HttpServletResponse


@RestController
@RequestMapping("/parking")
class LoginController {
    @Autowired
    private lateinit var iLoginService: ILoginService
    @PostMapping("/signup")
    fun signUp(@RequestBody body:  SignUpDTO):ResponseEntity<User?>{
        val user = User()
        user._id = body._id.toInt()
        user.name = body.name
        user.email = body.email
        user.mobileNo = body.mobileNo
        user.password = body.password

        var signup =iLoginService.signUp(user)
        return ResponseEntity(signup, HttpStatus.OK)
    }
    @PostMapping("/login")
    fun login(@RequestBody body: LoginDTO, response: HttpServletResponse): ResponseEntity<Any> {
        val user = iLoginService.findByEmail(body.email)
                ?: return ResponseEntity.badRequest().body(Message("User not found!"))

        if (!user.comparePassword(body.password)) {
            return ResponseEntity.badRequest().body(Message("Invalid password!"))
        }
        val issuer = user._id.toString()
        val jwt = Jwts.builder()
                .setIssuer(issuer)
                .setExpiration(Date(System.currentTimeMillis() + 60 * 24 * 1000)) // 1 day
                .signWith(SignatureAlgorithm.HS512, "secret").compact()

        //Cookie code commented START
//        val cookie = Cookie("jwt", jwt)
//        cookie.isHttpOnly = true
//        response.addCookie(cookie)
        //Cookie code commented END

        //Build array START(HASHMAP)
        val resp = HashMap<String, String>()
        resp["_id"] = user._id.toString()
        resp["name"] = user.name
        resp["email"] = user.email
        resp["mobileNo"] = user.mobileNo
        resp["token"] =  jwt
        //Build array END(HASHMAP)

        return ResponseEntity(resp, HttpStatus.OK)
//        return ResponseEntity.ok(Message("success"))
    }

    @GetMapping("/user")
    fun user(@RequestHeader("Authorization")  jwt: String?): ResponseEntity<Any> {

        try {
            if (jwt == null) {
                return ResponseEntity.status(401).body(Message("unauthenticated"))
            }

            val body = Jwts.parser().setSigningKey("secret").parseClaimsJws(jwt).body
            return ResponseEntity.ok(Message("Authenticated url"))
//            return ResponseEntity.ok(iLoginService.getById(body.issuer.toInt()))
        } catch (e: Exception) {
            println(e)
            return ResponseEntity.status(401).body(Message("unauthenticated"))
        }
    }

    @PostMapping("logout")
    fun logout(response: HttpServletResponse): ResponseEntity<Any> {
        val cookie = Cookie("jwt", "")
        cookie.maxAge = 0

        response.addCookie(cookie)

        return ResponseEntity.ok(Message("success"))
    }
}