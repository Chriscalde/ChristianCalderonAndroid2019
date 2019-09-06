package com.example.christiancalderonandroid2019

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_dialog_manager.*
import kotlinx.android.synthetic.main.dialog_image.view.*
import kotlinx.android.synthetic.main.dialog_sign_out.view.*

class DialogManager : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog_manager)

        btnShowDialog.setOnClickListener{
            val myDialogView = layoutInflater.inflate(R.layout.dialog_image,null)
            val mBuilder = AlertDialog.Builder(this).setView(myDialogView).setTitle("Image Form").show()

            myDialogView.btnAccept.setOnClickListener {
                mBuilder.dismiss()
            }
        }

        btnSignOut.setOnClickListener {
            val myDialogView = layoutInflater.inflate(R.layout.dialog_sign_out,null)
            val mBuilder = AlertDialog.Builder(this).setView(myDialogView).setTitle("Sign Out Form").show()

            myDialogView.btnNo.setOnClickListener {
                mBuilder.dismiss()
            }
        }


    }
}
