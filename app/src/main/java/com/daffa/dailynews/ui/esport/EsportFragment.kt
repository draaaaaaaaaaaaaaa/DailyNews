package com.daffa.dailynews.ui.esport

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.daffa.dailynews.R
import com.daffa.dailynews.databinding.FragmentEsportBinding
import com.daffa.dailynews.network.response.EsportResponseItem

class EsportFragment : Fragment() {

    private lateinit var binding: FragmentEsportBinding


    private var _viewModel: EsportViewModel? = null
    private val viewModel get() = _viewModel as EsportViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentEsportBinding.inflate(layoutInflater, container, false)
        _viewModel = ViewModelProvider(this)[EsportViewModel::class.java]

        viewModel.getEsportModel()
        viewModel.getListEsport().observe(viewLifecycleOwner){
            showData(it)
        }

        return binding.root
    }

    private fun showData(data: List<EsportResponseItem>) {
        binding.rvesport.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = EsportAdapter(data)
        }
    }
}