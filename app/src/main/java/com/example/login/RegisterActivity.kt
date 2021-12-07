package com.example.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : AppCompatActivity() {

    private lateinit var registerUsername: EditText
    private lateinit var registerPassword: EditText
    private lateinit var emailRegister: EditText
    private lateinit var accountCreationButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        registerUsername = findViewById(R.id.registerUsername)
        registerPassword = findViewById(R.id.registerPassword)
        emailRegister = findViewById(R.id.emailRegister)
        accountCreationButton = findViewById(R.id.accountCreationButton)

        var rUsernameText = registerUsername.text.toString()
        var rPassText = registerPassword.text.toString()
        var Etext = emailRegister.text.toString()
        accountCreationButton.setOnClickListener {
            if (rUsernameText.isNotEmpty() && rPassText.isNotEmpty() && Etext.isNotEmpty()) {
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(Etext, rPassText)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            val intent = Intent(this, MainActivity::class.java)
                            startActivity(intent)
                            Toast.makeText(
                                this,
                                "You've created account seccessfully",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
            }

        }
    }
}