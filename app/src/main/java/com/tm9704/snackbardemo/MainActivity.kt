package com.tm9704.snackbardemo

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageButton: ImageButton = findViewById(R.id.image_button)
        imageButton.setOnClickListener {view ->
            Snackbar.make(view, "You have clicked image button.", Snackbar.LENGTH_LONG).show()
        }

        val btnAlertDialog: Button = findViewById(R.id.btn_alert_dialog)
        btnAlertDialog.setOnClickListener {view ->
            alertDialogFunction()
        }
    }

    private fun alertDialogFunction(){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Alert")
        builder.setMessage("This is Alert Dialog. Which is used to show alert")
        builder.setIcon(android.R.drawable.ic_dialog_alert)

        builder.setPositiveButton("Yes"){ dialogInterface, which ->
            Toast.makeText(applicationContext, "clicked yes", Toast.LENGTH_LONG).show()
            dialogInterface.dismiss()
        }

        builder.setNeutralButton("Cancel"){ dialogInterface, which ->
            Toast.makeText(
                applicationContext,
                "clicked cancle\n operation cancel",
                Toast.LENGTH_LONG
            ).show()
            dialogInterface.dismiss()
        }

        builder.setNegativeButton("NO"){ dialogInterface, which ->
            Toast.makeText(applicationContext, "clicked NO", Toast.LENGTH_LONG).show()
            dialogInterface.dismiss()
        }

        val alertDialog: AlertDialog = builder.create()

        alertDialog.setCancelable(false)
        alertDialog.show()
    }

    private fun customDialogFunction() {
        val customDialog = Dialog(this)

        customDialog.setContentView(R.layout.dialog_custom)
        customDialog.findViewById<TextView>(R.id.tv_submit).setOnClickListener {
            Toast.makeText(applicationContext, "clicked submit", Toast.LENGTH_LONG).show()
            customDialog.dismiss()
        }
        customDialog.findViewById<TextView>(R.id.tv_cancel).setOnClickListener {
            Toast.makeText(applicationContext, "clicked cancel", Toast.LENGTH_LONG).show()
            customDialog.dismiss()
        }

        customDialog.show()
    }
}

