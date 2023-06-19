package com.example.firebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    lateinit var myemail: EditText
    lateinit var password: EditText
    lateinit var myconfpassword: EditText
    lateinit var signup: Button
    lateinit var mylogin: TextView
    private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myemail = findViewById(R.id.email)
        password = findViewById(R.id.password)
        myconfpassword = findViewById(R.id.confermpassword)
        signup = findViewById(R.id.button)
        mylogin = findViewById(R.id.text)
        auth = Firebase.auth




        mylogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

        signup.setOnClickListener {
            SignUpUser()
        }
    }


    private fun SignUpUser() {
        val email = myemail.text.toString()
        val pass = password.text.toString()
        val cornfermpass = myconfpassword.text.toString()
        if (email.isBlank() || pass.isBlank() || cornfermpass.isBlank()) {
            Toast.makeText(this, "Password do not match", Toast.LENGTH_LONG).show()
            return
        }

        auth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(this) {
            if (it.isSuccessful) {
                Toast.makeText(this, "Sign up Successfully", Toast.LENGTH_LONG).show()


            } else {
                Toast.makeText(this, "Please check your password or email", Toast.LENGTH_LONG).show()
            }
        }

    }
}