package com.kizzito

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class comewel : AppCompatActivity() {
    private lateinit var auth:FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comewel)

        auth = Firebase.auth

        val login =findViewById<Button>(R.id.btnsign)
        login.setOnClickListener {

            val email:EditText= findViewById<EditText>(R.id.txtmail)
            val password:EditText= findViewById<EditText>(R.id.txtpass)

            val emailString = email.text.toString().trim()
            val passwordString = password.text.toString().trim()

            if (TextUtils.isEmpty(email.text.toString()) || TextUtils.isEmpty(password.text.toString())){
                Toast.makeText(this,"Please enter all fields", Toast.LENGTH_SHORT).show()

            }else{
                auth.signInWithEmailAndPassword(emailString,passwordString).addOnCompleteListener {
                if(it.isSuccessful){
                    val i =Intent(this,kizzidraw::class.java)
                    startActivity(i)
                    finish()

                }else{
                    Toast.makeText(this,"Please enter correct credentials", Toast.LENGTH_LONG).show()
                }
                }
            }


        }

    }

    fun logclick(view: View) {}

    fun logsignclick(view: View) {
        val i = Intent(this,signin::class.java)
        startActivity(i)
        finish()
    }
}