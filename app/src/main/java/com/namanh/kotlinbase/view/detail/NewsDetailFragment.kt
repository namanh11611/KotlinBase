package com.namanh.kotlinbase.view.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.google.gson.Gson
import com.namanh.kotlinbase.data.model.News
import com.namanh.kotlinbase.databinding.FragmentNewsDetailBinding
import com.namanh.kotlinbase.utils.AppUtils
import com.namanh.kotlinbase.view.main.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsDetailFragment : BaseFragment<FragmentNewsDetailBinding>() {

    private val viewModel: NewsDetailViewModel by viewModels()

    override fun viewBindingInflate(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentNewsDetailBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val news = Gson().fromJson(arguments?.getString(AppUtils.NAV_NEWS_ITEM), News::class.java)
        binding.txtDetail.text = news.title
    }

}