package dev.saido.contacts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import dev.saido.contacts.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        displayContact()

    }

    fun displayContact(){
        var contact1 = Contacts("Khalid","https://images.unsplash.com/photo-1589156280159-27698a70f29e?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MXx8YmxhY2slMjBwZW9wbGV8ZW58MHx8MHx8&auto=format&fit=crop&w=500&q=60","khalidownd@gmail.com","07827663839","korongo616")
        var contact2 = Contacts("Omar","https://images.unsplash.com/photo-1570158268183-d296b2892211?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8N3x8YmxhY2slMjBwZW9wbGV8ZW58MHx8MHx8&auto=format&fit=crop&w=500&q=60","omarhor@gmail.com","07333i93839","korongo616")
        var contact3 = Contacts("Anis","https://images.unsplash.com/photo-1583994009785-37ec30bf9342?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTh8fGJsYWNrJTIwcGVvcGxlfGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=500&q=60","aniskd@gmail.com","07827663839","korongo616")
        var contact4 = Contacts("Shanaya","https://images.unsplash.com/photo-1531384441138-2736e62e0919?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTN8fGJsYWNrJTIwcGVvcGxlfGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=500&q=60","shanaya@gmail.com","07787663839","korongo616")
        var contact5 = Contacts("Sahra","https://media.istockphoto.com/photos/headshot-of-mature-black-woman-walking-on-city-street-picture-id1364683713?b=1&k=20&m=1364683713&s=170667a&w=0&h=rHN6wZG4STOTU3BpbcHyPDELoHFuTS63hbnWt47f7zc=","sahra@gmail.com","07227363839","korongo616")
        var contactList = listOf(contact1,contact2,contact3,contact4,contact5)
        var contactAdaptor = ContactRvAdaptor(contactList)
        binding.rvContact.layoutManager= LinearLayoutManager(this)
        binding.rvContact.adapter= contactAdaptor
    }
}