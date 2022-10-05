package com.example.bakjoon

fun main() = with(System.`in`.bufferedReader()) {
    var word = readln()
    val croatia = arrayOf("c=","c-","dz=","d-","lj","nj","s=","z=")

    for (i in croatia){
        word=word.replace(i,"+")
    }
    print(word.length)

}

