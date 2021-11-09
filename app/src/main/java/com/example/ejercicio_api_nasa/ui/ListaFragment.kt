package com.example.ejercicio_api_nasa.ui

import android.R
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ejercicio_api_nasa.adapter.AdaptadorRV
import com.example.ejercicio_api_nasa.databinding.FragmentListaBinding
import com.example.ejercicio_api_nasa.viewmodel.Factory
import com.example.ejercicio_api_nasa.viewmodel.TerrenosViewModel


class ListaFragment : Fragment() {

    private var _binding: FragmentListaBinding? = null
    private val binding get() = _binding!!

    //val vmodel: TerrenosViewModel by activityViewModels()
    lateinit var vmodel: TerrenosViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListaBinding.inflate(inflater, container, false)

        vmodel = Factory(requireActivity().application).create(TerrenosViewModel::class.java)
        var adapter = AdaptadorRV()

        with(binding)
        {
            //rvImgTerrenos.layoutManager = LinearLayoutManager(context)
            rvImgTerrenos.layoutManager = GridLayoutManager(context, 2)
            rvImgTerrenos.adapter = adapter

            Log.v("imgagenesRV", "Imagenes estan?")
            vmodel.exponeDatosDelServer()
        }

        vmodel.exponeDatosDelServer().observe(viewLifecycleOwner, Observer {

            Log.d("RecyclerViewImagenes", it.toString())
            adapter.setTerrenos(it)

        })

        return binding.root
    }
}