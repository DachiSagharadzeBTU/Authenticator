package com.example.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private lateinit var loginEmail : EditText
    private lateinit var loginPassword : EditText
    private lateinit var loginButton : Button
    private lateinit var loginRegisterButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        loginButton = findViewById(R.id.login)
        loginEmail = findViewById(R.id.loginUsername)
        loginPassword = findViewById(R.id.loginPassword)
        loginRegisterButton = findViewById(R.id.registerButton)
        var loginEmailText = loginEmail.text.toString()
        var loginPasswordText = loginPassword.text.toString()

        loginButton.setOnClickListener{

            if (loginEmailText.isNotEmpty() && loginPasswordText.isNotEmpty())
                FirebaseAuth.getInstance().signInWithEmailAndPassword(loginEmailText, loginPasswordText)
                    .addOnCompleteListener { task ->

                        if(task.isComplete){

                            val intent = Intent(this,UserActivity::class.java)
                            startActivity(intent)
                            finish()
                        }
                        if (task.isCanceled){
                            Toast.makeText(this, "Woops... You're password is incorrect or you are not registered!", Toast.LENGTH_SHORT).show()
                        }
                    }
        }

        loginRegisterButton.setOnClickListener {
            val intent = Intent(this@MainActivity,RegisterActivity::class.java)
            startActivity(intent)
            finish()
        }



    }
}