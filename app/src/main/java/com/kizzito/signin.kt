package com.kizzito

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class signin : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

        auth = Firebase.auth

        val signin = findViewById<Button>(R.id.btnsign)
        signin.setOnClickListener {

            val email:EditText = findViewById<EditText>(R.id.txtmail)
            val password:EditText = findViewById<EditText>(R.id.txtpass)

            val emailString = email.text.toString().trim()
            val passwordString = password.text.toString().trim()

            auth.createUserWithEmailAndPassword(emailString,passwordString).addOnCompleteListener {
                if (it.isSuccessful){
                    val intent = Intent(this, comewel::class.java)
                    startActivity(intent)
                    finish()
                    Toast.makeText(this, "Signup successfull" , Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this, "Signup failed" , Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    fun signclick(view: View) {
        val i = Intent(this,comewel::class.java)
        startActivity(i)
        finish()
    }
}