package com.nailton.journalapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.google.firebase.Timestamp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.nailton.journalapp.databinding.ActivityNewJournalBinding
import java.util.Date

class NewJournal : AppCompatActivity() {
    private lateinit var binding: ActivityNewJournalBinding

    // credenciais de usuario
    private var currentUserId: String = ""
    private var currentUsername: String = ""

    // autenticacao de usuario
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var firebaseUser: FirebaseUser

    // intancia do firestore
    private var db: FirebaseFirestore = FirebaseFirestore.getInstance()
    // iniciando referencia ao storage
    private lateinit var storageReference: StorageReference

    private var collectionReference: CollectionReference = db.collection("Journal")

    private lateinit var imageUri: Uri


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_new_journal)

        // usando o Storage para criar uma instancia de referencia ao storage
        storageReference = FirebaseStorage.getInstance().reference

        firebaseAuth = Firebase.auth

        binding.apply {
            postProgressBar.visibility = View.INVISIBLE
            if (JournalUser.instance != null) {
                currentUserId = firebaseAuth.currentUser?.uid.toString().trim()
                currentUsername = firebaseAuth.currentUser?.displayName.toString().trim()

                postUsernameTextview.text = currentUsername
            }

            postCameraButton.setOnClickListener {
                val intent = Intent(Intent.ACTION_GET_CONTENT)
                intent.type = "image/*"
                startActivityForResult(intent, 1)
            }

            postSaveJournalButton.setOnClickListener {
                saveJournal()
            }
        }
    }

    private fun saveJournal() {
        val title = binding.postTitleEt.text.toString().trim()
        val thoughts = binding.postDescriptionEt.text.toString().trim()

        binding.postProgressBar.visibility = View.VISIBLE

        if (title.isNotEmpty() && thoughts.isNotEmpty() && imageUri != null) {
            // criando past no storage, na seguinte pasta .../journal_images/my_image.png
            val filePath: StorageReference = storageReference.child("journal_images")
                .child("my_image_"+Timestamp.now().toDate())
            // fazendo upload de imagem no storage
            filePath.putFile(imageUri)
                .addOnSuccessListener {
                    filePath.downloadUrl.addOnSuccessListener {
                        val imageUrl = it
                        val timestamp = Timestamp(Date())
                        // creating journal object
                        val journal = Journal(
                            title,
                            thoughts,
                            imageUrl.toString(),
                            currentUserId,
                            timestamp.toDate().toString(),
                            currentUsername
                        )

                        collectionReference.add(journal)
                            .addOnSuccessListener {
                                binding.postProgressBar.visibility = View.INVISIBLE
                                val intent = Intent(
                                    this, JournalList::class.java)
                                startActivity(intent)
                                finish()
                            }.addOnFailureListener {
                                Toast.makeText(
                                    this,
                                    "Algo deu errado aqui",
                                    Toast.LENGTH_LONG
                                ).show()
                            }
                    }
                }.addOnFailureListener {
                    binding.postProgressBar.visibility = View.INVISIBLE
                }
        } else {
            binding.postProgressBar.visibility = View.INVISIBLE
            Toast.makeText(
                this@NewJournal,
                "Os campos sao obrigatorios por favor revise!",
                Toast.LENGTH_LONG
            ).show()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 1 && resultCode == RESULT_OK) {
            if (data != null) {
                // acessando a imagem da pasta que queremos
                imageUri = data.data!!
                // exibindo a imagem no component de imagem
                binding.postImageView.setImageURI(imageUri)
            }
        }
    }

    override fun onStart() {
        super.onStart()
        firebaseUser = firebaseAuth.currentUser!!
    }
}