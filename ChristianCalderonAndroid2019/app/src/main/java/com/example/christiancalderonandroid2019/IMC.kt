package com.example.christiancalderonandroid2019

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.google.zxing.integration.android.IntentIntegrator
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_imc.*
import org.json.JSONException
import org.json.JSONObject

class IMC : AppCompatActivity() {

    internal var textName: TextView? = null

    internal var textLastName: TextView? = null

    internal var textHeight: TextView? = null

    internal var textWeight: TextView? = null

    internal var imgUser: ImageView? = null

    internal var btnScanQR: Button? = null

    internal var qrScanIntegrator: IntentIntegrator? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc)

        btnCalculateIMC.setOnClickListener {
            var heightString = textHeight?.text.toString()
            var weightString = textWeight?.text.toString()
            var heightDouble = heightString.toDouble()
            var weightDouble = weightString.toDouble()
            Log.d("Chris",heightString)
            Log.d("Chris",weightString)

            var bmi = weightDouble / (heightDouble*heightDouble)
            Log.d("Chris",bmi.toString())

            if(bmi>=19&&bmi<24.9){
                Toast.makeText(this, "The pacient is in the correct weight", Toast.LENGTH_LONG).show()
            Log.d("Chris","The pacient is in the correct weight")
        }
            else{
                Log.d("Chris","You are not in the correct weight")
                Toast.makeText(this, "The pacient is not in the correct weight", Toast.LENGTH_LONG).show()
            }
        }
        textName = findViewById(R.id.textName)
        textLastName = findViewById(R.id.textLastName)
        textHeight = findViewById(R.id.textHeight)
        textWeight = findViewById(R.id.textWeight)
        imgUser = findViewById(R.id.user)

        btnScanQR = findViewById(R.id.btnScanQR)
        btnScanQR!!.setOnClickListener { performAction() }

        qrScanIntegrator = IntentIntegrator(this)

        }
    private fun performAction() {
        qrScanIntegrator?.initiateScan()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
        if (result != null) {
            // If QRCode has no data.
            if (result.contents == null) {
                Toast.makeText(this, getString(R.string.result_not_found), Toast.LENGTH_LONG).show()
            } else {
                // If QRCode contains data.
                try {
                    // Converting the data to json format
                    val obj = JSONObject(result.contents)

                    // Show values in UI.
                    textName?.text = obj.getString("name")
                    textLastName?.text = obj.getString("lastName")
                    textHeight?.text = obj.getString("height")
                    textWeight?.text = obj.getString("weight")
//                    imgUser?.src = obj.getString("imgDir")
                    Picasso.get().load(obj.getString("imgDir")).into(imgUser);


                } catch (e: JSONException) {
                    e.printStackTrace()

                    // Data not in the expected format. So, whole object as toast message.
                    Toast.makeText(this, result.contents, Toast.LENGTH_LONG).show()
                }

            }
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }


    }}

