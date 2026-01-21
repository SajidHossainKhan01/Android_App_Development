package com.nailton.journalapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.auth.ktx.userProfileChangeRequest
import com.google.firebase.ktx.Firebase
import com.nailton.journalapp.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sign_up)
        auth = Firebase.auth

        binding.apply {
            signup.setOnClickListener {
                createUser()
            }
        }
    }

    private fun validCamps(email: String, password: String): Boolean {
        if (email.isBlank() || password.isBlank()) {
            Toast.makeText(
                this@SignUpActivity,
                "Campos Invalidos",
                Toast.LENGTH_LONG
            ).show()
            return false
        } else if (email.length < 11 || password.length < 8 ) {
            Toast.makeText(
                this@SignUpActivity,
                "Campos Invalidos",
                Toast.LENGTH_LONG
            ).show()
            return false
        }
        return true
    }

    private fun createUser() {
        val email = binding.edtEmail.text.toString()
        val password = binding.edtPass.text.toString()
        val name = binding.edtName.text.toString()
        val intent = Intent(this@SignUpActivity, MainActivity::class.java)
        val result = validCamps(email, password)
        if (result) {
            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Toast.makeText(
                            this@SignUpActivity,
                            "User created",
                            Toast.LENGTH_LONG
                        ).show()
                        val user = auth.currentUser
                        user?.updateProfile( userProfileChangeRequest {
                            displayName = name
                        })
                        startActivity(intent)
                    } else {
                        // If sign in fails, display a message to the user.
                        Toast.makeText(
                            baseContext,
                            "Authentication failed.",
                            Toast.LENGTH_SHORT,
                        ).show()
                    }
                }
        }
    }

    public override fun onStart() {
        super.onStart()
        val currentUser = auth.currentUser
        if (currentUser != null) {
            reload()
        }
    }

    private fun reload() {}

}