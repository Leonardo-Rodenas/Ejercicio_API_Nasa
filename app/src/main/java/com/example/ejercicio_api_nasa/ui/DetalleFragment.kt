package com.example.ejercicio_api_nasa.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ejercicio_api_nasa.databinding.FragmentDetalleBinding
import com.example.ejercicio_api_nasa.viewmodel.TerrenosViewModel

class DetalleFragment : Fragment() {

    private var _binding: FragmentDetalleBinding? = null
    private val binding get() = _binding!!
    //val vmodel: TerrenosViewModel by activityViewModels()
    lateinit var vmodel : TerrenosViewModel


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetalleBinding.inflate(inflater, container, false)
        return binding.root
    }

}