package com.africinnovate.recyclerviewclass

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), ContactAdapter.onContactClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView : RecyclerView = findViewById(R.id.recyclerview)
        var contactAdapter = ContactAdapter(this)

        recyclerView.adapter = contactAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        contactAdapter.setData(data.dataSource(), this)

       }

    override fun onItemClicked(position: Int) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("contacts", position)
        startActivity(intent)    }
}

object data{
//    fun dataSource() : ArrayList<Contacts>{
//        val contactList = ArrayList<Contacts>()
//        contactList.add(Contacts("Mike Prince", "1234546547657", R.drawable.ic_launcher_background))
//        contactList.add(Contacts("Agatevure Glory", "07032313948", R.drawable.mike))
//        contactList.add(Contacts("Timothy Bassey", "543645654756", R.drawable.ic_launcher_foreground))
//        return  contactList
//    }

    fun dataSource() : ArrayList<Contacts>{
        val contactList = ArrayList<Contacts>()
        contactList.add(Contacts("Mike Prince", "1234546547657"))
        contactList.add(Contacts("Agatevure Glory", "07032313948"))
        contactList.add(Contacts("Timothy Bassey", "543645654756"))
        return  contactList
    }
}

