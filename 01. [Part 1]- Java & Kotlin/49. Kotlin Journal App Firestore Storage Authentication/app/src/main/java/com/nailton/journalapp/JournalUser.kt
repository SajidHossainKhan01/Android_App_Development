package com.nailton.journalapp

import android.app.Application

/**
 * criando singleton de conexao do usuario, quando o usuario tentar entrar no app,
 * o singleton rodara em segundo plano uma unica vez verificando se o usuario é nulo
 */
class JournalUser: Application() {

    var username: String? = null
    var userId: String? = null

    companion object {
        // criadno instancia de usuario
        var instance: JournalUser? = null
            get() {
                if (field == null) {
                    // criando instancia de usuario
                    field = JournalUser()

                }
                return field
            }
        private set
    }
}