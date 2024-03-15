package com.example.myfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button


class CategoriFragment : Fragment(), View.OnClickListener {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_categori, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnCategory : Button = view.findViewById(R.id.btn_detail_categori)

        btnCategory.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.btn_detail_categori){
            val detailCategoriFragment = DetailCategoriFragment()


            //mengirim data dengan menggunakan bundel
            val bundle = Bundle()
            bundle.putString(DetailCategoriFragment.EXTRA_NAME,"Bayu Ganteng")
            //mengirimkan dengan set dan get
            val description = "Kategori ini akan berisi produk-produk bran Bayu Ganteng"

            //mengirimkan dengan bundel
            detailCategoriFragment.arguments = bundle

            //mengirimkan dengan set dan get
            detailCategoriFragment.description = description

            val fragmentManager = parentFragmentManager
            fragmentManager.beginTransaction().apply {
                replace(R.id.frame_container, detailCategoriFragment,DetailCategoriFragment::class.java.simpleName)
                addToBackStack(null)
                commit()
            }
        }
    }

}