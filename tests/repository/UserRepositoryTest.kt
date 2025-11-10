package tests.repository

import data.local.dao.UserDao
import data.local.entity.UserEntity
import data.repository.UserRepository
import domain.models.Result
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.*

class UserRepositoryTest {
    private lateinit var userDao: UserDao
    private lateinit var repository: UserRepository

    @Before
    fun setup() {
        userDao = mock(UserDao::class.java)
        repository = UserRepository(userDao)
    }

    @Test
    fun testGetUserSuccess() = runBlocking {
        val user = UserEntity("1", "Test", "test@example.com")
        `when`(userDao.getUserById("1")).thenReturn(user)
        val result = repository.getUser("1")
        assertTrue(result is Result.Success)
        assertEquals(user, (result as Result.Success).value)
    }

    @Test
    fun testGetUserNotFound() = runBlocking {
        `when`(userDao.getUserById("2")).thenReturn(null)
        val result = repository.getUser("2")
        assertTrue(result is Result.Failure)
    }
}
