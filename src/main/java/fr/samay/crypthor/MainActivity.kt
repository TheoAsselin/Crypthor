package fr.samay.crypthor

import android.content.ClipData
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import fr.samay.crypthor.fragments.CryptageFragment
import fr.samay.crypthor.fragments.DecryptageFragment
import fr.samay.crypthor.fragments.HomeFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadFragment(HomeFragment(this))
        

        // importer la barre de navigation
        val navigationView=findViewById<BottomNavigationView>(R.id.navigation_bar)
        navigationView.setOnNavigationItemSelectedListener {
            when(it.itemId)
            {
                R.id.home_page ->{
                    loadFragment(HomeFragment(this))
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.lock_page -> {
                    loadFragment(CryptageFragment(this))
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.unlock_page -> {
                    loadFragment(DecryptageFragment(this))
                    return@setOnNavigationItemSelectedListener true
                }
                else -> false
            }
        }

        loadFragment(HomeFragment(this))
    }

    private fun loadFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragmentcontainer, fragment)
        transaction.addToBackStack(null)
        transaction.commit()

    }

}