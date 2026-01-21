package com.nailton.journalapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import com.nailton.journalapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.apply {
            signup.setOnClickListener {
                val intent = Intent(this@MainActivity, SignUpActivity::class.java)
                startActivity(intent)
            }

            signin.setOnClickListener {
                val email = edtEmail.text.toString().trim()
                val password = edtPass.text.toString().trim()
                loginWithEmailAndPassword(email, password)
            }
        }

        // inicializando autenticador
        firebaseAuth = Firebase.auth
    }

    // depois de inicializar o autenticador basta chamarmos a funcao de signin e conectarmos o usuario
    private fun loginWithEmailAndPassword(email: String, password: String) {
        val valid = validationCamps(email, password)
        if (valid) {
            firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnSuccessListener {
                    // instaciando um usuario e definindo o id do usuario instanciado com o id
                    // do usuario do firebase, fazendo a mesma coisa com o name, dessa forma conseguimos
                    // acessar informacoes do usuario na tela de listagem
                    val journal = JournalUser.instance!!
                    journal.userId = firebaseAuth.currentUser?.uid
                    journal.username = firebaseAuth.currentUser?.displayName
                    goToJournalList()
                }.addOnFailureListener {
                    Toast.makeText(
                        this@MainActivity,
                        "Authentication failure",
                        Toast.LENGTH_LONG
                    ).show()
                }
        }
    }

    private fun validationCamps(email: String, password: String): Boolean {
        if (email.length < 11 || password.length < 8) {
            Toast.makeText(
                this@MainActivity,
                "Campos invalidos",
                Toast.LENGTH_LONG
            ).show()
            return false
        }
        return true
    }

    override fun onStart() {
        super.onStart()
        val currentUser = firebaseAuth.currentUser

        if (currentUser != null) {
            goToJournalList()
        }
    }

    private fun goToJournalList() {
        val intent = Intent(this, JournalList::class.java)
        startActivity(intent)
    }
}