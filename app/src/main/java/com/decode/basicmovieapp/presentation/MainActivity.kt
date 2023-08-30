package com.decode.basicmovieapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.decode.basicmovieapp.R
import com.decode.basicmovieapp.databinding.ActivityMainBinding
import com.decode.basicmovieapp.presentation.di.Injector
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: ViewModelFactory
    private lateinit var movieViewModel: ViewModel
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setSupportActionBar(binding.toolbar)
        (application as Injector).createMovieSubComponent().inject(this)

        movieViewModel = ViewModelProvider(this, factory)[ViewModel::class.java]

        initRecyclerView()


    }

    private fun initRecyclerView() {
        binding.rv.layoutManager = LinearLayoutManager(this)
        adapter = MovieAdapter()
        binding.rv.adapter = adapter
        displayPopularMovies()


    }

    private fun displayPopularMovies() {
        binding.progressBar.visibility = View.VISIBLE
        val response = movieViewModel.getMovies()

        response.observe(this) {
            Log.e("Main", it.toString())
            if (it != null) {
                adapter.differ.submitList(it)

                binding.progressBar.visibility = View.GONE
            } else {
                binding.progressBar.visibility = View.GONE
                Toast.makeText(applicationContext, "No Data Available", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.update, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_update -> {
                updateMovies()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun updateMovies() {
        binding.progressBar.visibility = View.VISIBLE
        val response = movieViewModel.updateMovies()

        response.observe(this) {
            if (it != null) {
                adapter.differ.submitList(it)
                binding.progressBar.visibility = View.GONE
            } else {
                binding.progressBar.visibility = View.GONE

            }
        }
    }
}