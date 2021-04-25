package pepega.service

import pepega.model.User
import pepega.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class Authorizer @Autowired constructor(val userRepository: UserRepository) {

    fun register(user: User): User {
        return userRepository.save(user)
    }

    fun login(nickname: String, password: String): User? {
        return userRepository.findByNicknameAndPassword(nickname, password)
    }

    fun logout(nickname: String): User? {
        return userRepository.findByNickname(nickname)
    }
}