package com.example.dh_foods.view.activity

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.widget.AppCompatButton
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.ViewModelProvider
import com.example.dh_foods.R
import com.example.dh_foods.models.repository.UserRepository
import com.example.dh_foods.viewModel.UsersViewModel
import com.google.android.material.textfield.TextInputLayout
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private lateinit var viewModel: UsersViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        window.statusBarColor = Color.TRANSPARENT

        viewModel = ViewModelProvider(this).get(UsersViewModel::class.java)
        viewModel.getUsers()

        findViewById<TextInputLayout>(R.id.tilEmail)?.editText?.addTextChangedListener{ emailError(findViewById(
            R.id.tilEmail
        ))}
        findViewById<TextInputLayout>(R.id.tilSenha)?.editText?.addTextChangedListener{ senhaError(findViewById(
            R.id.tilSenha
        ))}


        findViewById<AppCompatButton>(R.id.btLoginEntrar).setOnClickListener {
            if(!emailError(tilEmail) && !senhaError(tilSenha)){
                UserRepository.UsersLogin.usersList.forEach {
                    if(it.userEmail == tilEmail.editText?.text.toString() && it.userPass == tilSenha.editText?.text.toString()){
                        val mIntent = Intent(this, HomeActivity::class.java)
                        startActivity(mIntent)
                        finish()
                    }else if(it.userEmail == tilEmail.editText?.text.toString() && it.userPass != tilSenha.editText?.text.toString()){
                        tilSenha.error = "Senha está errada"
                    }else{
                        tilEmail.error = "Email está errado"
                    }
                }
            }

        }

        findViewById<AppCompatButton>(R.id.btLoginRegister).setOnClickListener {
            val mIntent = Intent(this, RegisterActivity::class.java)
            startActivity(mIntent)
        }
    }

    private fun emailError(til: TextInputLayout): Boolean{
        return if(til.editText?.length() == 0){
            til.error = activity_login.context.getString(R.string.erroVazio,"Email" )
            true
        }
        else if(!android.util.Patterns.EMAIL_ADDRESS.matcher(til.editText?.text.toString()).matches()){
            til.error =  activity_login.context.getString(R.string.campoInvalido,"Email" )
            true
        }else {
            til.isErrorEnabled = false
            false
        }
    }

    private fun senhaError(til: TextInputLayout): Boolean{
        return if(til.editText?.length() == 0){
            til.error = activity_login.context.getString(R.string.erroVazio,"Senha" )
            true
        }else {
            til.isErrorEnabled = false
            false
        }
    }


}