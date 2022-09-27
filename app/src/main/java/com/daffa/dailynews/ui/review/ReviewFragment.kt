package com.daffa.dailynews.ui.review

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.daffa.dailynews.R
import com.daffa.dailynews.databinding.FragmentHomeBinding
import com.daffa.dailynews.databinding.FragmentReviewBinding
import com.daffa.dailynews.network.response.HomeResponseItem
import com.daffa.dailynews.network.response.ReviewResponseItem
import com.daffa.dailynews.ui.home.HomeAdapter
import com.daffa.dailynews.ui.home.HomeViewModel

class ReviewFragment : Fragment() {

    private var _binding : FragmentReviewBinding? = null
    private val binding get() = _binding as FragmentReviewBinding

    private var _viewmodel : ReviewViewModel? = null
    private val viewModel get() = _viewmodel as ReviewViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        _binding = FragmentReviewBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _viewmodel = ViewModelProvider(this)[ReviewViewModel::class.java]

        viewModel.getRevModel()
        viewModel.getRevNews().observe(viewLifecycleOwner){
            showData(it)
        }
    }

    private fun showData(data: List<ReviewResponseItem>?) {
        binding.rvRev.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = data?.let { RevAdapter(it) }
        }

    }
}