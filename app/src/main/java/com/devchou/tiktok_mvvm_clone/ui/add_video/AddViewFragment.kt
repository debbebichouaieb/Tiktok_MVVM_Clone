package com.devchou.tiktok_mvvm_clone.ui.add_video

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.devchou.tiktok_mvvm_clone.R

class AddViewFragment : Fragment() {

    companion object {
        fun newInstance() = AddViewFragment()
    }

    private lateinit var viewModel: AddViewViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add_view, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(AddViewViewModel::class.java)
        // TODO: Use the ViewModel
    }

}