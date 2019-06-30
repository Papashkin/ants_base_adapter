package com.papashkin.antsadaptersample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: TestAdapter
    private val callback = TestCallback()
    private var users: ArrayList<UserModel> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initAdapter()
        iniList()
        initListeners()
    }

    private fun initAdapter() {
        adapter = TestAdapter()
        rvUsers.adapter = adapter
    }
    private fun iniList() {
        users.addAll(
            listOf(
            UserModel("Kurt", "Cobain", 27),
            UserModel("Jimi", "Hendrix", 27),
            UserModel("Amy", "Winehouse", 27)
            )
        )
        adapter.addAll(users)
    }

    private fun initListeners() {
        btnAdd.setOnClickListener {
            if (etInputText.text.isNotEmpty()) {
                val text = etInputText.editableText.toString()
                val user = UserModel(text, surname = "Testman", age = 27)
                adapter.add(user)
                etInputText.editableText.clear()
            }
        }
    }


}
