package me.jdvp.librarytestexample

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Using findViewById so we don't have to worry about deprecations later
        val button1 = findViewById<Button>(R.id.button_1)
        val button2 = findViewById<Button>(R.id.button_2)

        button1.setOnClickListener {
            MaterialAlertDialogBuilder(this)
                .setTitle(R.string.button_1_dialog_title)
                .setMessage(R.string.button_1_dialog_message)
                .setPositiveButton(R.string.ok) { dialog, _ ->
                    dialog.dismiss()
                }.show()
        }

        button2.setOnClickListener {
            MaterialAlertDialogBuilder(this)
                .setTitle(R.string.button_2_dialog_title)
                .setMessage(R.string.button_2_dialog_message)
                .setPositiveButton(R.string.ok) { dialog, _ ->
                    dialog.dismiss()
                }.show()
        }
    }
}