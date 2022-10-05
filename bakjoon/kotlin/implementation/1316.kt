package com.example.bakjoon

fun main() = with(System.`in`.bufferedReader()) {
    val n = readln().toInt()
    var ans = 0
    repeat(n) {
        val word = readLine().toCharArray()
        var is_true = false
        for (i in 0..word.size-2){
            if (word[i]!=word[i+1]){
                val cur = word[i]
                for (j in i+1..word.size-1){
                    if (cur==word[j]){
                        is_true=true
                        break
                    }
                }
                if (is_true){
                    break
                }
            }
        }
        if (!is_true){
            ans++
        }

    }
    print(ans)
}