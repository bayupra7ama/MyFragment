package com.example.myfragment

import android.icu.lang.UCharacter.GraphemeClusterBreak.V
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.commit

//Berpindah Fragment
class HomeFragment : Fragment(), View.OnClickListener {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnCategory : Button = view.findViewById(R.id.btn_Categori)
        btnCategory.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
//        untuk berpindah fragment tanpa mengirim data
     if (v?.id == R.id.btn_Categori){
         val categoriFragment = CategoriFragment()
         val fragmentManager = parentFragmentManager
         fragmentManager.beginTransaction().apply {
//             replace fragment dengan fragment ktx
             fragmentManager.commit {
                 replace(R.id.frame_container ,categoriFragment,CategoriFragment::class.java.simpleName)
             }
         }
     }
    }

}