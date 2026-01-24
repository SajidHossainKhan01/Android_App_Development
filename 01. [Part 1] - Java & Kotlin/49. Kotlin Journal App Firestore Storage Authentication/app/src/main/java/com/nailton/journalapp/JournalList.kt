package com.nailton.journalapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import com.nailton.journalapp.databinding.ActivityJournalListBinding

class JournalList : AppCompatActivity() {
    private lateinit var binding: ActivityJournalListBinding
    private lateinit var journalList: MutableList<Journal>
    private lateinit var recyclerAdapter: JournalRecyclerAdapter

    // Firebase references
    // iniciando variavel de autenticacao
    private lateinit var firebaseAuth: FirebaseAuth
    // iniciando variavel de usuario
    private lateinit var firebaseUser: FirebaseUser
    // iniciando instancia para acessar banco de dados
    private val db = FirebaseFirestore.getInstance()

    // Criando collecao de referencia
    private val collectionReference = db.collection("Journal")

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_journal_list)

        // Autenticando usuario
        firebaseAuth = Firebase.auth
        firebaseUser = firebaseAuth.currentUser!!

        binding.apply {
            // RecyclerView
            // otimizando recycler view atraves do seu tamanho
            recyclerView.setHasFixedSize(true)
            recyclerView.layoutManager = LinearLayoutManager(this@JournalList)

            floatingCreate.setOnClickListener {
                val intent = Intent(this@JournalList, NewJournal::class.java)
                startActivity(intent)
            }

            floatingBtn.setOnClickListener {
                // encerrando secao do usuario
                firebaseAuth.signOut()
                val intent = Intent(this@JournalList, MainActivity::class.java)
                startActivity(intent)
            }

            // acessando todos os posts
            // verificando se o id do usuario é igual ao id da instancia, se sim cairemos
            // no sucesso se nao cai no erro
            collectionReference.whereEqualTo("userId",
                firebaseUser.uid)
                .get()
                .addOnSuccessListener {
                    Log.i("TAGY", "PASSOU AQUI")
                    if (!it.isEmpty) {
                        for (document in it) {
                            val journal = Journal(
                                document.data["title"].toString(),
                                document.data["thoughts"].toString(),
                                document.data["imageUrl"].toString(),
                                document.data["userId"].toString(),
                                document.data["timeAdded"].toString(),
                                document.data["username"].toString(),
                            )
                            journalList.add(journal)
                        }

                        // Enviando dados para a recycler view
                        recyclerAdapter = JournalRecyclerAdapter(this@JournalList, journalList)
                        recyclerView.adapter = recyclerAdapter
                        recyclerAdapter.notifyDataSetChanged()
                    } else {
                        textViewList.visibility = View.VISIBLE
                    }
                }.addOnFailureListener {
                    Toast.makeText(
                        this@JournalList,
                        "Server Erro",
                        Toast.LENGTH_LONG
                    ).show()
                }
        }
        // Post arrayList
        journalList = arrayListOf<Journal>()
    }

}