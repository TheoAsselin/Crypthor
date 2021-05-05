package fr.samay.crypthor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import fr.samay.crypthor.fragments.CryptageFragment
import fr.samay.crypthor.fragments.HomeFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //injecter le fragment dans la boite (fragment_container)
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragmentcontainer, HomeFragment())
        transaction.addToBackStack(null)
        transaction.commit()
    }
}