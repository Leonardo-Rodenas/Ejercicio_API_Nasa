package com.example.ejercicio_api_nasa.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ejercicio_api_nasa.R
import com.example.ejercicio_api_nasa.databinding.FragmentDetalleBinding
import com.example.ejercicio_api_nasa.model.TerrenosModelItem
import com.example.ejercicio_api_nasa.viewmodel.Factory
import com.example.ejercicio_api_nasa.viewmodel.TerrenosViewModel
import com.squareup.picasso.Picasso

class DetalleFragment : Fragment() {

    private var _binding: FragmentDetalleBinding? = null
    private val binding get() = _binding!!
    lateinit var vmodel : TerrenosViewModel


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetalleBinding.inflate(inflater, container, false)

        vmodel = Factory(requireActivity().application).create(TerrenosViewModel::class.java)

        var recuperarTerreno = arguments?.getSerializable("terreno") as TerrenosModelItem

        binding.tvCompraRenta.text = recuperarTerreno.type.toString()
        binding.tvPrecio.text = recuperarTerreno.price.toString()

        Picasso.get().load(recuperarTerreno.img_src).fit().centerCrop()
            .placeholder(R.drawable.user_placeholder)
            .error(R.drawable.user_placeholder_error)
            .into(binding.ivDetalle)

        return binding.root
    }

}