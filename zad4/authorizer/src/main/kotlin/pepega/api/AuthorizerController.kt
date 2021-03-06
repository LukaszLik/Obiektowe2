package pepega.api

import pepega.model.User
import pepega.model.UserNotFoundException
import pepega.service.Authorizer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/authorizer")
class AuthorizerController @Autowired constructor(val authorizer: Authorizer) {

    @PostMapping("/register")
    fun register(@RequestBody user: User): User {
        return authorizer.register(user)
    }

    @GetMapping("/login")
    fun login(@RequestParam("nickname") nickname: String, @RequestParam("password") password: String): User {
        return authorizer.login(nickname, password) ?: throw UserNotFoundException()
    }

    @GetMapping("/logout")
    fun logout(@RequestParam("nickname") nickname: String): User {
        return authorizer.logout(nickname) ?: throw UserNotFoundException()
    }
}