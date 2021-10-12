package com.app.spacex.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.model.DataClass
import com.app.spacex.Api.ClientRetrofit
import com.app.spacex.Api.SpaceXApi
import com.app.spacex.R
import com.app.spacex.adapter.MainRecycleViewAdapter
import com.app.spacex.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.view.Gravity
import android.widget.Toast
import com.app.Sorting

class MainActivity : AppCompatActivity() {

    private lateinit var messageApi: SpaceXApi
    private lateinit var recyclerView: RecyclerView
    private lateinit var myAdapter: MainRecycleViewAdapter
    private var sorting = Sorting()
    private lateinit var binding: ActivityMainBinding
    private lateinit var dataResponse: List<DataClass>

    companion object{
        private var isReversed: Boolean = true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dataResponse = emptyList()

        initRecyclerView()
        buttonActions()
    }

    override fun onResume() {
        super.onResume()
        if (dataResponse == null || dataResponse.isEmpty()){
            showData()
        }
    }

    private fun buttonActions() {
        binding.buttonSorted.setOnClickListener {
            isReversed = !isReversed
            dataResponse = sorting.sortByDate(dataResponse, isReversed)
            var boolean = isReversed
            myAdapter.dataArrayList = dataResponse
            myAdapter.notifyDataSetChanged()
        }
    }

    private fun initRecyclerView() {
        myAdapter = MainRecycleViewAdapter()
        recyclerView = findViewById<RecyclerView>(R.id.recycler_view)

        showData()
    }

    private fun showData(){
        messageApi = ClientRetrofit.getRetrofitClient("https://api.spacexdata.com/")
            ?.create(SpaceXApi::class.java) as SpaceXApi

        messageApi.message.enqueue(object : Callback<List<DataClass>> {
            override fun onFailure(call: Call<List<DataClass>>, t: Throwable) {
                Log.v("retrofit", "call failed")
                toast()
            }

            override fun onResponse(
                call: Call<List<DataClass>>,
                response: Response<List<DataClass>>
            ) {

                response.body()?.let {
                    dataResponse = sorting.sortByDate(it, isReversed)
                    myAdapter.loadDataList(dataResponse)

                }
                recyclerView.adapter = myAdapter
                recyclerView.layoutManager = LinearLayoutManager(applicationContext)
            }
        })
    }

    private fun toast() {
        val text = "Нет соеденинея с сервером. Проверьте соединение с интернетом"
        val duration = Toast.LENGTH_SHORT

        val toast = Toast.makeText(applicationContext, text, duration)
        toast.setGravity(Gravity.CENTER, 0, 0)
        toast.show()
    }
}