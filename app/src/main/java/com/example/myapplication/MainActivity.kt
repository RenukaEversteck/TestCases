package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.myapplication.databinding.ActivityMainBinding
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {
    lateinit var databinding:ActivityMainBinding
    var pattern: Pattern = Patterns.EMAIL_ADDRESS


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        databinding=DataBindingUtil.setContentView(this,R.layout.activity_main)
        //setContentView(R.layout.activity_main)
        databinding.btnSubmit.setOnClickListener(View.OnClickListener {
            if (Util.checkFields(databinding.edtEmail.text.toString().trim(),databinding.edtPwd.text.toString().trim()))
            {
                databinding.resultTxt.text=Constant.EmptyField
                Toast.makeText(this,"Both the field are required",Toast.LENGTH_SHORT).show()
            }
            else if (!Util.validEmail(databinding.edtEmail.text.toString().trim()))
            {
                databinding.resultTxt.text=Constant.InvalidEmail
                Toast.makeText(this,"Enter Valid Email",Toast.LENGTH_SHORT).show()
            }
            else if (!Util.validPwd(databinding.edtPwd.text.toString().trim()))
            {
                databinding.resultTxt.text=Constant.InvalidPwd
                Toast.makeText(this,"Enter Valid Password",Toast.LENGTH_SHORT).show()
            }
            else if (Util.verifyUser(databinding.edtEmail.text.toString().trim(),databinding.edtPwd.text.toString().trim()))
            {
                databinding.resultTxt.text=Constant.LoginSuccess
                Toast.makeText(this,"Login SuccessFul",Toast.LENGTH_SHORT).show()
            }
            else{
                databinding.resultTxt.text=Constant.LoginFail
                Toast.makeText(this,"Login Failed",Toast.LENGTH_SHORT).show()
            }
        })

    }
}