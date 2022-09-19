package com.daffa.dailynews.ui.talk

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.daffa.dailynews.R
import com.daffa.dailynews.databinding.FragmentNewsBinding
import com.daffa.dailynews.databinding.FragmentTalkBinding
import com.daffa.dailynews.network.response.NewsResponseItem
import com.daffa.dailynews.network.response.TalkResponseItem
import com.daffa.dailynews.ui.news.NewsAdapter
import com.daffa.dailynews.ui.news.NewsViewModel

class TalkFragment : Fragment() {

    private var _binding : FragmentTalkBinding? = null
    private val binding get() = _binding as FragmentTalkBinding

    private var _viewmodel : TalkViewModel? = null
    private val viewModel get() = _viewmodel as TalkViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        _binding = FragmentTalkBinding.inflate(layoutInflater, container, false)

        _viewmodel = ViewModelProvider(this)[TalkViewModel::class.java]

        viewModel.getTalkModel()
        viewModel.getTalkNews().observe(viewLifecycleOwner){
            showData(it)
        }

        return binding.root
    }




    private fun showData(data: List<TalkResponseItem>?) {
        binding.rvTalk.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = data?.let { TalkAdapter(it) }
        }

    }
}