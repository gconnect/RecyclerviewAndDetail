package com.africinnovate.recyclerviewclass

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.amulyakhare.textdrawable.TextDrawable
import com.amulyakhare.textdrawable.util.ColorGenerator
import kotlinx.android.synthetic.main.contact_list.view.*


class ContactAdapter internal constructor(private val listener : onContactClickListener) : RecyclerView.Adapter<ContactAdapter.ContactViewHolder>() {
    var contactList = ArrayList<Contacts>()
    lateinit var context : Context

    class ContactViewHolder(private val view : View) : RecyclerView.ViewHolder(view){

        init {
            view.setOnClickListener { this }
        }
        lateinit var contacts: Contacts
        fun bind(item: Contacts){
            // generate random color
            val generator = ColorGenerator.MATERIAL // or use DEFAULT
            val color1 = generator.randomColor
            val drawable = TextDrawable.builder()
                .buildRound(item.name.substring(0, 1), color1)
            this.contacts = item
            view.contactName.text = item.name
            view.profile_image.setImageDrawable(drawable)
//            view.profile_image.setImageResource(item.profileImage)
        }

    }

    interface onContactClickListener{
        fun onItemClicked(position : Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
    val view = LayoutInflater.from(parent.context).inflate(R.layout.contact_list, parent, false)
    return ContactViewHolder(view)

    }

    override fun getItemCount(): Int {
        return contactList.size
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int){

        holder.bind(contactList[position])

        holder.itemView.setOnClickListener {
            listener.onItemClicked(position)
        }
    }

    fun setData(contacts : ArrayList<Contacts>, context: Context){
        this.contactList = contacts
        this.context = context
        notifyDataSetChanged()
    }

}