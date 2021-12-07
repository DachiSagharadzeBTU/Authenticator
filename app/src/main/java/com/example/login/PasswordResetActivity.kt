package com.example.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class PasswordResetActivity : AppCompatActivity() {

    private lateinit var passwordResetButton : Button
    private lateinit var resetEmail : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_password_reset)

        passwordResetButton = findViewById<Button>(R.id.passwordResetButton)
        resetEmail = findViewById(R.id.codesentEmail)
        var email = resetEmail.text.toString()
        passwordResetButton.setOnClickListener{
            if (email.isNotEmpty()){
                FirebaseAuth.getInstance().sendPasswordResetEmail(email)
                    .addOnCompleteListener { task ->
                        if (task.isComplete)
                            Toast.makeText(
                                this,
                                "Password has been sent!!",
                                Toast.LENGTH_SHORT
                            ).show()
                    }
            }
        }

    }

}