package com.siyu.footwalk.data.session


import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.siyu.footwalk.model.AuthSession
import com.siyu.footwalk.model.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.sessionDataStore by preferencesDataStore(name = "session")

class DataStoreSessionStorage(private val context: Context) : SessionStorage {

    private object Keys {
        val TOKEN = stringPreferencesKey("token")
        val USER_ID = intPreferencesKey("user_id")
        val NAME = stringPreferencesKey("name")
        val EMAIL = stringPreferencesKey("email")
    }

    override val session: Flow<AuthSession?> = context.sessionDataStore.data.map { prefs ->
        val token = prefs[Keys.TOKEN] ?: return@map null
        AuthSession(
            token = token,
            user = User(
                id = prefs[Keys.USER_ID] ?: 0,
                name = prefs[Keys.NAME].orEmpty(),
                email = prefs[Keys.EMAIL].orEmpty(),
            ),
        )
    }

    override suspend fun save(session: AuthSession) {
        context.sessionDataStore.edit { prefs ->
            prefs[Keys.TOKEN] = session.token
            prefs[Keys.USER_ID] = session.user.id
            prefs[Keys.NAME] = session.user.name
            prefs[Keys.EMAIL] = session.user.email
        }
    }

    override suspend fun clear() {
        context.sessionDataStore.edit { it.clear() }
    }
}