package com.example.myapplication

import android.R.attr.password
import android.text.TextUtils
import java.util.regex.Matcher
import java.util.regex.Pattern


object Util {
    var pattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
    var userList= listOf<UserList>(
        UserList("renuka@gmail.com","123456"),
        UserList("renuka21@gmail.com","123890"),
    )

    /*fun validEmail(email:String):Boolean
    {

        return email.matches(pattern)
    }*/

    fun validEmail(email: String): Boolean {
        val EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"
        val pattern: Pattern = Pattern.compile(EMAIL_PATTERN)
        val matcher: Matcher = pattern.matcher(email)
        return matcher.matches()
    }

    fun validPwd(pwd:String):Boolean
    {
        return pwd.length >= 6
    }

    fun validSpecialCharacter(pwd:String):Boolean
    {
        val pattern: Pattern
        val PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{4,}$"
        pattern = Pattern.compile(PASSWORD_PATTERN)
        val matcher: Matcher = pattern.matcher(pwd)

        return matcher.matches()
    }

    fun verifyUser(email:String,pwd:String):Boolean
    {
        userList.forEach()
        {
            if (email==it.email && pwd==it.pwd)
            {
                return true;
            }
        }
        return false;
    }

    fun checkFields(email:String,pwd:String):Boolean
    {
        return (email.isEmpty() || pwd.isEmpty())
    }

}