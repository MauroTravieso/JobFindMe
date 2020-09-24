package com.example.jobfindme.activity

import android.Manifest.permission
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.jobfindme.R
import com.example.jobfindme.model.User
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_profile.*
import kotlinx.android.synthetic.main.activity_sign_in.*
import kotlinx.android.synthetic.main.app_bar_main.*
import org.w3c.dom.Text

class ProfileActivity : AppCompatActivity() {
    lateinit var cam : Button
    val REQUEST_IMAGE_CAPTURE :Int = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val address = "shirazshrestha008@gmail.com"
        val text = "Hello there, \nThis is a JobFindMe app.  "
        val subject = "Greetings"

        cam = findViewById<Button>(R.id.camera)
        if (ContextCompat.checkSelfPermission(this,
                permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            cam.isEnabled = false
            ActivityCompat.requestPermissions(
                this,
                arrayOf(
                    permission.CAMERA,
                    permission.WRITE_EXTERNAL_STORAGE
                ),
                0 // Directly use the request code
            )
        }

        val emailButton = findViewById<FloatingActionButton>(R.id.email_button)
        emailButton.setOnClickListener(View.OnClickListener {
            val myIntent = Intent(Intent.ACTION_SENDTO)
            myIntent.data = Uri.parse("mailto:") // only email apps should handle this
            myIntent.putExtra(Intent.EXTRA_EMAIL, address)
            myIntent.putExtra(Intent.EXTRA_TEXT, text)
            myIntent.putExtra(Intent.EXTRA_SUBJECT, subject)
            if (myIntent.resolveActivity(packageManager) != null) {
                startActivity(myIntent)
            }
        })

    }
    // Check permission of the camera Intent & External Storage
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 0) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                cam.isEnabled = true
            }
        }
    }
    fun camera(view: View){
        // Standard Intent action that can be sent to have the camera application capture an image and return it.
        val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        if (takePictureIntent.resolveActivity(packageManager) != null) {
            startActivityForResult(takePictureIntent,REQUEST_IMAGE_CAPTURE)
        }
    }
    fun gallery(view: View){
        val i = Intent()
        // Activity Action for the intent : Pick an item from the data, returning what was selected.
        i.action = Intent.ACTION_PICK
        i.type = "image/*"
        // Start the Gallery Intent activity with the request_code 2
        startActivityForResult(i, 2)
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // Logic to get from Bundle
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            /*The Android Camera application encodes the photo in the return Intent delivered to onActivityResult() 
            as a small Bitmap in the extras, under the key "data".*/
            val extras = data!!.extras
            val imageBitmap = extras!!.get("data") as Bitmap // Similar java code is  Bitmap imageBitmap = (Bitmap) extras.get("data");
            iv.setImageBitmap(imageBitmap)
        } else if (requestCode == 2) { // For Clicking Gallery button
            // Set the selected image from the device image gallery to the ImageView component
            iv.setImageURI(data!!.data)
        }
    }
}
