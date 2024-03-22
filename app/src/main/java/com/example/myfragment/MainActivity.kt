package com.example.myfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//         pada MainActivity, kita tanamkan HomeFragment ke dalam activity
    //         tersebut sehingga bisa tampil ke layar pengguna dengan menambahkan beberapa baris berikut:

        val fragmentManager = supportFragmentManager
        val homeFragment = HomeFragment()
        val fragment  = fragmentManager.findFragmentByTag(HomeFragment::class.java.simpleName)

        if (fragment !is HomeFragment){

//           instalsais fragment dengan fragment ktx

            fragmentManager.commit{
                add(R.id.frame_container,homeFragment,HomeFragment::class.java.simpleName)
            }
        }
    }
}