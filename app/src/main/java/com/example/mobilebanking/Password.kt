package com.example.mobilebanking

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.text.Editable
import android.text.TextWatcher
import android.view.inputmethod.InputMethodManager
import android.widget.EditText


class Password : AppCompatActivity() {
    var strikes: Int = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.password)
        var editTextNumber = findViewById<EditText>(R.id.editTextNumber)
        editTextNumber.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if (s.toString().length == 4) {
                    if (s.toString().equals("0451")) {
                        println("przeszlo")
                    }
                    else {
                        editTextNumber.text.clear();
                        ++strikes;
                        if (strikes >= 3) {
                            println("mockup blokowania logowania")
                        }
                    }
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })
        editTextNumber.requestFocus()
        val inputMethodManager = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.showSoftInput(editTextNumber, InputMethodManager.SHOW_IMPLICIT)
    }

    override fun onBackPressed() {
        intent = Intent(this, Login::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NO_ANIMATION
        startActivity(intent)
    }
}