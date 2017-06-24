#!/usr/bin/env kscript
//DEPS com.offbytwo.jenkins:jenkins-client:0.3.7

import java.net.HttpURLConnection
import java.net.URL
import java.util.*

class App {
    val jenkinsUrl = URL("http://localhost:8080/job/itemTest/build?token=whalemareToken")

    fun main() {

        jenkinsUrl.openConnection()
        val response = (jenkinsUrl.openConnection() as HttpURLConnection).apply {
            requestMethod = "GET"
            addRequestProperty(
                    "User-Agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0)"
            )
        }.inputStream

        val scanner = Scanner(response)
        println(scanner.useDelimiter("\\A").next())
    }
}

App().main()

println("Script success-full")