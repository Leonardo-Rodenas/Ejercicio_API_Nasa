package com.example.ejercicio_api_nasa.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ejercicio_api_nasa.R
import com.example.ejercicio_api_nasa.adapter.AdaptadorRV
import com.example.ejercicio_api_nasa.databinding.FragmentListaBinding
import com.example.ejercicio_api_nasa.model.TerrenosModelItem
import com.example.ejercicio_api_nasa.viewmodel.Factory
import com.example.ejercicio_api_nasa.viewmodel.TerrenosViewModel


class ListaFragment : Fragment() {

    private var _binding: FragmentListaBinding? = null
    private val binding get() = _binding!!
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
            vmodel.traemeLoDelServer()

            adapter.setearListener(object : AdaptadorRV.alClickearItemRV {
                override fun itemClick(terreno: TerrenosModelItem) {
                    //hey listen!!! poner acá lo que quiero que haga al clickear

                    var miBundle = Bundle()
                    miBundle.putSerializable("terreno", terreno)


                    findNavController().navigate(R.id.action_listaFragment_to_detalleFragment, miBundle /*meter budle*/)


                }
            })
        }

        vmodel.exponeDatosDeDB().observe(viewLifecycleOwner, Observer {

            Log.d("RecyclerViewImagenes", it.toString())
            adapter.setTerrenos(it)
          /*  adapter.setearListener(object : AdaptadorRV.alClickearItemRV {
                override fun itemClick(position: Int) {
                    //hey listen!!! poner acá lo que quiero que haga al clickear

                    var miBundle = Bundle()
                    miBundle.putSerializable("terreno", it)


                    findNavController().navigate(R.id.action_listaFragment_to_detalleFragment *//*meter budle*//*)


                }
            })*/

        })

        return binding.root
    }
}