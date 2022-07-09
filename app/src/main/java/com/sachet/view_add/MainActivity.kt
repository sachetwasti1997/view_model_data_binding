package com.sachet.view_add

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.sachet.view_add.databinding.ActivityMainBinding
import com.sachet.view_add.view_modal.MainActivityViewModal

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModal: MainActivityViewModal
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModal = ViewModelProvider(this)[MainActivityViewModal::class.java]
        viewModal.result.observe(this, Observer {
            binding.result.text = it.toString()
        })
        binding.button.setOnClickListener {
            val input = binding.intInput.text.toString()
            var num = 0
            if(input != "")num = input.toInt()
            viewModal.addNum(num)
        }
    }
}

/**
 * Live Data
 * It is a lifecycle aware observable data holder class
 * In android we have three app components with lifecycle: - Activities, Fragments and Services
 * So these 3 can be used as the observers of live data object
 * LiveData only updates observers in an active lifecycle state
 * It automatically updates the UI when the app data changes
 * We do not need to write codes to handle lifecycle manually
 */