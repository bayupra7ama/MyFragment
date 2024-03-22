package com.example.myfragment

import OptionDialogFragment
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class DetailCategoriFragment : Fragment() {

    private lateinit var tvCategoriName : TextView
    private lateinit var tvCategoriDescription : TextView
    private lateinit var btnProfile : Button
    private lateinit var btnShowDialog : Button
    var description:String? = null

    companion object{
        val EXTRA_NAME = "extra_name"

    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_categori, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvCategoriName = view.findViewById(R.id.tv_categori_name)
        tvCategoriDescription = view.findViewById(R.id.tv_categori_description)
        btnProfile = view.findViewById(R.id.btn_profile)
        btnShowDialog = view.findViewById(R.id.btn_show_dialog)

//        mendemonstrasikan bagaimana melakukan penampilan data yang dikirim melalui perpindahan fragment.

//        if (savedInstanceState != null){
//            val descFromBundel = savedInstanceState.getString(EXTRA_DESCRIPTION)
//            description = descFromBundel
//        }
        if (arguments != null){
            //menangkap data bundle dengan menggunakan argument
            val categoryName = arguments?.getString(EXTRA_NAME)
            tvCategoriName.text = categoryName

//menangkap data menggunakan get and set
            tvCategoriDescription.text = description



        }

        btnShowDialog.setOnClickListener{
            val optionDialogFragment = OptionDialogFragment()
            val fragmentManager = childFragmentManager
//             digunakan untuk menampilkan obyek OptionDialogFragment ke layar.
            optionDialogFragment.show(fragmentManager, OptionDialogFragment::class.java.simpleName)
        }


        //berpindah ke activity lain
        btnProfile.setOnClickListener{

            //requireAtivity() sebagai contex untuk fragment
            val intent = Intent(requireActivity(), ProfileActivity::class.java)
            startActivity(intent)
        }


    }
    internal var optionDialogListener:OptionDialogFragment.OnOptionDialogListener = object :OptionDialogFragment.OnOptionDialogListener{
        override fun onOptionChosen(text: String?) {
            Toast.makeText(requireActivity(), text, Toast.LENGTH_SHORT).show()
        }


    }
}