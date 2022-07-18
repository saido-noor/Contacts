package dev.saido.contacts

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import dev.saido.contacts.databinding.ActivityMainBinding
import dev.saido.contacts.databinding.ContactListItemBinding

class ContactRvAdaptor(var contactList:List<Contacts>):RecyclerView.Adapter<ContactViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        var binding = ContactListItemBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        var contactsViewHolder = ContactViewHolder(binding)
        return  contactsViewHolder

    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        var currentContact = contactList.get(position)
        holder.binding.tvName.text = currentContact.name
        holder.binding.tvEmail.text = currentContact.email
        holder.binding.tvPhone.text = currentContact.number
        holder.binding.tvAddress.text = currentContact.address
        Picasso.get().load(currentContact.image)
            .placeholder(R.drawable.ic_baseline_person_add_alt_1_24)
            .error(R.drawable.ic_baseline_error_24)
            .resize(120,120)
            .centerCrop()
            .into(holder.binding.imageView)
            var context = holder.itemView.context
            holder.binding.imageView.setOnClickListener {
                Toast.makeText(context,"you have clicked ${currentContact.name} the image", Toast.LENGTH_SHORT).show()

            }
        holder.binding.cvCard.setOnClickListener {
            val intent = Intent(context, ViewContactActivity::class.java)
            intent.putExtra("NAME", currentContact.name)
            intent.putExtra("EMAIL", currentContact.email)
            intent.putExtra("PHONE", currentContact.number)
            intent.putExtra("ADDRESS", currentContact.address)
            intent.putExtra("IMAGE", currentContact.image)
            context.startActivity(intent)

        }

    }

    override fun getItemCount(): Int {
        return contactList.size
    }
}

class ContactViewHolder(var binding:ContactListItemBinding):RecyclerView.ViewHolder(binding.root)
