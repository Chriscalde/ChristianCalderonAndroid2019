package com.example.christiancalderonandroid2019

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_dialog.*
import kotlinx.android.synthetic.main.login_dialog.view.*

class Dialog : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog)

        btnShow.setOnClickListener{
            val myDialogView = layoutInflater.inflate(R.layout.login_dialog,null)
            val mBuilder = AlertDialog.Builder(this).setView(myDialogView).setTitle("Login Form").show()

            myDialogView.btnLogin.setOnClickListener{
                val name = myDialogView.txtName.text.toString()
                val email = myDialogView.txtEmail.text.toString()
                val password = myDialogView.txtPassword.text.toString()

                txtDialog.setText("Nombre:${name} \n Email:${email} \n Password:${password}")

                mBuilder.dismiss()
            }

            myDialogView.btnCancelar.setOnClickListener {
                mBuilder.dismiss()
            }
        }
    }
}
