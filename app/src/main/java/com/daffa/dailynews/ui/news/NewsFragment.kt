package com.daffa.dailynews.ui.news

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.daffa.dailynews.R
import com.daffa.dailynews.databinding.FragmentHomeBinding
import com.daffa.dailynews.databinding.FragmentNewsBinding
import com.daffa.dailynews.network.response.HomeResponseItem
import com.daffa.dailynews.network.response.NewsResponseItem
import com.daffa.dailynews.ui.home.HomeAdapter
import com.daffa.dailynews.ui.home.HomeViewModel

class NewsFragment : Fragment() {
    private var _binding : FragmentNewsBinding? = null
    private val binding get() = _binding as FragmentNewsBinding

    private var _viewmodel : NewsViewModel? = null
    private val viewModel get() = _viewmodel as NewsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        _binding = FragmentNewsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _viewmodel = ViewModelProvider(this)[NewsViewModel::class.java]

        viewModel.getNewsModel()
        viewModel.getListNews().observe(viewLifecycleOwner){
            showData(it)
        }
    }

    private fun showData(data: List<NewsResponseItem>?) {
        binding.rvNews.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = data?.let { NewsAdapter(it) }
        }

    }
}
