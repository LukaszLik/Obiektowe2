package pepega.repository

import pepega.model.User
import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.Nullable

interface UserRepository: CrudRepository<User, Int> {
    @Nullable
    fun findByNicknameAndPassword(username: String, password: String): User

    @Nullable
    fun findByNickname(username: String): User
}