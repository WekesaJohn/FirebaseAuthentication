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

class LoginActivity : AppCompatActivity() {
    lateinit var myemail1:EditText
    lateinit var mypassword1:EditText
    lateinit var login1:Button
    lateinit var signup:TextView
    private lateinit var auth:FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        myemail1=findViewById(R.id.email1)
        mypassword1=findViewById(R.id.password1)
        login1=findViewById(R.id.button1)
        signup=findViewById(R.id.text1)
        auth = Firebase.auth

        login1.setOnClickListener {
            login1()
        }
    }
    private fun login1(){
        val email=myemail1.text.toString()
        val pass=mypassword1.text.toString()

        auth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(this){
            if (it.isSuccessful){
                Toast.makeText(this,"Successfully loggedin",Toast.LENGTH_LONG).show()
                val intent= Intent(this,HomeActivity::class.java)
                startActivity(intent)
            }
            else{
                Toast.makeText(this,"Log in failed",Toast.LENGTH_LONG).show()
            }
        }
    }
}