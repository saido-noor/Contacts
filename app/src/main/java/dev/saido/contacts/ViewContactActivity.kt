package dev.saido.contacts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.squareup.picasso.NetworkPolicy
import com.squareup.picasso.Picasso
import dev.saido.contacts.databinding.ActivityMainBinding
import dev.saido.contacts.databinding.ActivityViewContactBinding
import dev.saido.contacts.databinding.ContactListItemBinding

class ViewContactActivity : AppCompatActivity() {
    lateinit var binding: ActivityViewContactBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewContactBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getExtras()
    }
    fun getExtras() {
        val extras = intent.extras
//        val name = extras?.getString("NAME", "")
//        var email = extras?.getString("EMAIL", "")
//        val intent = Intent()
        val name= extras?.getString("NAME", "name")
        binding.tvName1.text = name
        val email = extras?.getString("EMAIL", "email")
        binding.tvEmail1.text = email
        val location = extras?.getString("LOCATION", "location")
        binding.tvAddress1.text = location
        val phone = extras?.getString("PHONE", "phone")
        binding.tvNumber1.text = phone
        val image = extras?.getString("IMAGE", "")





        Picasso.get()
            .load(image)
            .resize(300, 300)
            .centerCrop()
            .networkPolicy(NetworkPolicy.OFFLINE)
            .into(binding.imgPerson)


        Toast.makeText(this,"$name:$email", Toast.LENGTH_SHORT).show()


    }
    }
