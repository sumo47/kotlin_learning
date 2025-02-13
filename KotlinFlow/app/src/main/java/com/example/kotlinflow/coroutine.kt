package com.example.kotlinflow

import kotlinx.coroutines.delay

 suspend fun getUserNames(): List<String> {
    val list = mutableListOf<String>()
    list.add(getUser(1))
    list.add(getUser(2))
    list.add(getUser(3))
    list.add(getUser(4))
    return list
}

 suspend fun getUser(id: Int): String {
    delay(1000)
    return "User$id"
}