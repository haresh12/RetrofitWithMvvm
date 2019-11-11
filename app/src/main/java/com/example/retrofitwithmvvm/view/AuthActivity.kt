package com.example.retrofitwithmvvm.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.retrofitwithmvvm.R
import com.example.retrofitwithmvvm.view_model.AuthViewModel
import androidx.lifecycle.ViewModelProviders
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableBoolean
import androidx.lifecycle.Observer
import com.example.retrofitwithmvvm.model.User
import com.example.retrofitwithmvvm.repository.AuthRepository
import com.example.retrofitwithmvvm.retrofit.AuthResource
import kotlinx.android.synthetic.main.activity_main.*


class AuthActivity : AppCompatActivity() {
    private lateinit var viewModel: AuthViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProviders.of(this).get(AuthViewModel::class.java)
        login_button.setOnClickListener {
            progress_bar.visibility = View.VISIBLE
            Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show()
            observeViewModel()
        }
    }

    private fun observeViewModel() {
        viewModel.getAuthUserDetails(Integer.parseInt(user_id_input.text.toString()))
            .observe(this, Observer<User> {
                progress_bar.visibility = View.GONE
                redirectToHomeScreen()
            })
    }
    private fun redirectToHomeScreen() {
        startActivity(Intent(this, HomeActivity::class.java))
        finish()
    }


}
