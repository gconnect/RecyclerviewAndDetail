package com.africinnovate.recyclerviewclass

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import de.hdodenhof.circleimageview.CircleImageView

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        var profileImage: CircleImageView = findViewById(R.id.profile_image)
        val name : TextView = findViewById(R.id.contactName)
        val phone : TextView = findViewById(R.id.contactPhone)


        // Using parcelable to get the data
        val intent = intent
        val position = intent.getIntExtra("contacts", 0)
        val data = data.dataSource()[position]
        Toast.makeText(this, "You clicked ${data.name} and ${data.phoneNumber}", Toast.LENGTH_LONG).show()
//        profileImage.setImageResource(data.profileImage)
        name.text = data.name
        phone.text = data.phoneNumber

    }
}