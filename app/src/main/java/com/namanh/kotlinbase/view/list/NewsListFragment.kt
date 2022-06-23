package com.namanh.kotlinbase.view.list

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.namanh.kotlinbase.R
import com.namanh.kotlinbase.adapter.NewsAdapter
import com.namanh.kotlinbase.data.model.News
import com.namanh.kotlinbase.data.repository.ResourceState
import com.namanh.kotlinbase.databinding.FragmentNewsListBinding
import com.namanh.kotlinbase.utils.NetworkUtils
import com.namanh.kotlinbase.view.main.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsListFragment : BaseFragment<FragmentNewsListBinding>(), View.OnClickListener {

    enum class UiState {
        SUCCESS, LOADING, ERROR
    }

    private val viewModel: NewsListViewModel by viewModels()
    private val mNewsAdapter = NewsAdapter(emptyList())

    override fun viewBindingInflate(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentNewsListBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btReconnect.setOnClickListener(this)
        binding.listNews.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.listNews.adapter = mNewsAdapter

        observeNews()

        showWarningNoConnectionIfNeeded()
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.bt_reconnect -> {
                setUiState(UiState.LOADING)
                Handler(Looper.getMainLooper()).postDelayed({
                    viewModel.forceUpdate()
                    showWarningNoConnectionIfNeeded()
                }, 2000)
            }
        }
    }

    private fun observeNews() {
        viewModel.items.observe(viewLifecycleOwner) { result ->
            when {
                result is ResourceState.Success && result.data.isNotEmpty() -> {
                    setSuccessState(result.data)
                }
                result is ResourceState.Error -> setErrorState(result.message)
                else -> setErrorState(getString(R.string.other_error))
            }
        }
    }

    private fun setSuccessState(result: List<News>) {
        setUiState(UiState.SUCCESS)
        mNewsAdapter.dataSet = result
        mNewsAdapter.notifyDataSetChanged()
    }

    private fun setErrorState(errorMessage: String) {
        setUiState(UiState.ERROR)
        binding.txtError.text = errorMessage
    }

    private fun setUiState(uiState: UiState) {
        binding.listNews.visibility = if (uiState == UiState.SUCCESS) View.VISIBLE else View.GONE
        binding.pbLoading.visibility = if (uiState == UiState.LOADING) View.VISIBLE else View.GONE
        binding.txtError.visibility = if (uiState == UiState.ERROR) View.VISIBLE else View.GONE
        binding.btReconnect.visibility = if (uiState == UiState.ERROR) View.VISIBLE else View.GONE
    }

    private fun showWarningNoConnectionIfNeeded() {
        if (!NetworkUtils.isNetworkConnected(context)) {
            Toast.makeText(
                context,
                getString(R.string.please_check_internet_connect),
                Toast.LENGTH_LONG
            ).show()
        }
    }

}