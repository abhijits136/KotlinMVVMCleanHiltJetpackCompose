package com.example.kotlinmvvmcleanhiltjetpackcompose.data.storage

import android.content.Context
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys
import com.example.kotlinmvvmcleanhiltjetpackcompose.domain.repository.SecureStorage
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class SecureStorageImpl @Inject constructor(
    @ApplicationContext private val context: Context
) : SecureStorage {

    private val masterKeyAlias = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC)

    private val sharedPreferences = EncryptedSharedPreferences.create(
        "secret_shared_prefs",
        masterKeyAlias,
        context,
        EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
        EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
    )

    override fun putSecret(key: String, value: String) {
        with(sharedPreferences.edit()) {
            putString(key, value)
            apply()
        }
    }

    override fun getSecret(key: String): String? {
        return sharedPreferences.getString(key, null)
    }
}
