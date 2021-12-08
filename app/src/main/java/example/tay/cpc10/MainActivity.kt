package example.tay.cpc10

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationMenuView
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {

    lateinit var bottomNavigation: BottomNavigationView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val helloTextView: TextView = findViewById(R.id.start_text_view)
        helloTextView.text = "Welcome!"


        bottomNavigation = findViewById(R.id.bottom_navigation)

        bottomNavigation.setOnItemSelectedListener { item ->
            var fragment: Fragment? = null
            when (item.itemId) {
                R.id.fragment_1 -> {
                    fragment = FirstFragment()

                }
                R.id.fragment_2 -> {
                    fragment = SecondFragment()

                }
                R.id.fragment_3 -> {
                    fragment = ThirdFragment()
                }
            }
            replaceFragment(fragment!!)
            true

        }

    }

    fun replaceFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }

}





