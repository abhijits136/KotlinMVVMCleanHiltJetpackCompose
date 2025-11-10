package data.repository

import data.local.dao.UserDao
import data.local.entity.UserEntity
import domain.models.Result

class UserRepository(private val userDao: UserDao) {
    suspend fun getUser(id: String): Result<UserEntity, Throwable> = try {
        val user = userDao.getUserById(id)
        if (user != null) Result.Success(user) else Result.Failure(Exception("User not found"))
    } catch (e: Throwable) {
        Result.Failure(e)
    }

    suspend fun saveUser(user: UserEntity): Result<Unit, Throwable> = try {
        userDao.insertUser(user)
        Result.Success(Unit)
    } catch (e: Throwable) {
        Result.Failure(e)
    }

    suspend fun deleteUser(user: UserEntity): Result<Unit, Throwable> = try {
        userDao.deleteUser(user)
        Result.Success(Unit)
    } catch (e: Throwable) {
        Result.Failure(e)
    }
}
