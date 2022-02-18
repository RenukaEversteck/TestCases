package com.example.myapplication


import org.junit.Assert
import org.junit.Test

class MainActivityTest
{

    @Test
    fun `should return false if given email id does not match with email pattern`()
    {
        //given
        val email="renukagmail.com"

        //when
        val isValid=Util.validEmail(email)

        //then
        Assert.assertFalse(isValid)
    }

    @Test
    fun `should return true if given email id match with email pattern`()
    {
        //given
        val email="renuka@gmail.com"

        //when
        val isValid=Util.validEmail(email)

        //then
        Assert.assertTrue(isValid)
    }

    @Test
    fun `should return true if given password match with minimum length 6`()
    {
        //given
        val pwd="renuuu"

        //when
        val isValid=Util.validPwd(pwd)

        //then
        Assert.assertTrue(isValid)
    }

    @Test
    fun `should return false if given password do not match with minimum length 6`()
    {
        //given
        val pwd="renu"

        //when
        val isValid=Util.validPwd(pwd)

        //then
        Assert.assertFalse(isValid)
    }


    @Test
    fun `should return false if both values are not empty`()
    {
        //give values
        val pwd="123456"
        val email="renuka@gmail.com"

        //when
        val isEmpty=Util.checkFields(email,pwd);

        //then
        Assert.assertFalse(isEmpty)
    }

    @Test
    fun `should return true if both values are empty`()
    {
        //give values
        val pwd=""
        val email=""

        //when
        val isEmpty=Util.checkFields(email,pwd);

        //then
        Assert.assertTrue(isEmpty)
    }

    @Test
    fun `should return true if email value is empty`()
    {
        //give values
        val pwd="123456"
        val email=""

        //when
        val isEmpty=Util.checkFields(email,pwd);

        //then
        Assert.assertTrue(isEmpty)
    }

    @Test
    fun `should return true if password value is empty`()
    {
        //give values
        val pwd=""
        val email="renuka@gmail.com"

        //when
        val isEmpty=Util.checkFields(email,pwd);

        //then
        Assert.assertTrue(isEmpty)
    }

    @Test
    fun `should return true if user is valid`()
    {
        //give values
        val pwd="123456"
        val email="renuka@gmail.com"

        //when
        val isVerify=Util.verifyUser(email,pwd);

        //then
        Assert.assertTrue(isVerify)
    }

    @Test
    fun `should return false if user is invalid`()
    {
        //give values
        val pwd="123457"
        val email="renuka@gmail.com"

        //when
        val isVerify=Util.verifyUser(email,pwd);

        //then
        Assert.assertFalse(isVerify)
    }
}