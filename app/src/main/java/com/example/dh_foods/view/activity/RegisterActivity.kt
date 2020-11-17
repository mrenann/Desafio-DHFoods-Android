package com.example.dh_foods.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.ViewModelProvider
import com.example.dh_foods.R
import com.example.dh_foods.models.User
import com.example.dh_foods.models.repository.UserRepository
import com.example.dh_foods.viewModel.UsersViewModel
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputLayout
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.activity_register.tilEmail
import kotlinx.android.synthetic.main.activity_register.tilSenha

class RegisterActivity : AppCompatActivity() {
    private lateinit var viewModel: UsersViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        ibRegisterBack.setOnClickListener {
            finish()
        }

        viewModel = ViewModelProvider(this).get(UsersViewModel::class.java)
        viewModel.getUsers()

        findViewById<TextInputLayout>(R.id.tilNome)?.editText?.addTextChangedListener{ nomeError(findViewById(
            R.id.tilNome
        ))}
        findViewById<TextInputLayout>(R.id.tilEmail)?.editText?.addTextChangedListener{ emailError(findViewById(
            R.id.tilEmail
        ))}
        findViewById<TextInputLayout>(R.id.tilSenha)?.editText?.addTextChangedListener{ senhaError(findViewById(
            R.id.tilSenha
        ))}

        findViewById<AppCompatButton>(R.id.btCardRegister).setOnClickListener {

            if(!nomeError(tilNome) && !emailError(tilEmail) && !senhaError(tilSenha) && !confirmarSenhaError(tilConfirmarSenha,tilSenha)){
                UserRepository.UsersLogin.usersList.add(User(tilEmail.editText?.text.toString(),tilNome.editText?.text.toString(),tilSenha.editText?.text.toString()))

                Snackbar.make(findViewById(R.id.activity_register), getString(R.string.usuarioCadastrado), Snackbar.LENGTH_LONG)
                        .setDuration(300)
                        .show()
                finish()

            }
        }

    }

    private fun nomeError(til: TextInputLayout): Boolean{
        return if(til.editText?.length() == 0){
            til.error = activity_register.context.getString(R.string.erroVazio,"Nome" )
            true
        }else {
            til.isErrorEnabled = false
            false
        }
    }

    private fun emailError(til: TextInputLayout): Boolean{
        return if(til.editText?.length() == 0){
            til.error = activity_register.context.getString(R.string.erroVazio,"Email" )
            true
        }
        else if(!android.util.Patterns.EMAIL_ADDRESS.matcher(til.editText?.text.toString()).matches()){
            til.error = activity_register.context.getString(R.string.campoInvalido,"Email" )
            true
        }else {
            til.isErrorEnabled = false
            false
        }
    }

    private fun senhaError(til: TextInputLayout): Boolean{
        return if(til.editText?.length() == 0){
            til.error = activity_register.context.getString(R.string.erroVazio,"Senha" )
            true
        }else {
            til.isErrorEnabled = false
            false
        }
    }

    private fun confirmarSenhaError(til: TextInputLayout,tilSenha: TextInputLayout): Boolean{
        return when {
            til.editText?.length() == 0 -> {
                til.error = activity_register.context.getString(R.string.erroVazio,"Confirmação de Senha" )
                true
            }
            til.editText?.text.toString() != tilSenha.editText?.text.toString() -> {
                til.error = getString(R.string.senhasDiferentes)
                tilSenha.error = getString(R.string.senhasDiferentes)
                true
            }
            else -> {
                til.isErrorEnabled = false
                tilSenha.isErrorEnabled = false
                false
            }
        }
    }

}