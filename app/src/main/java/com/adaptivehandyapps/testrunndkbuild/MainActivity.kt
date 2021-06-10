package com.adaptivehandyapps.testrunndkbuild

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

//import com.adaptivehandyapps.testrunndkbuild.CWrapper.main

class MainActivity : AppCompatActivity() {
//    external fun main(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        System.loadLibrary("main.out")
//        var result = main()   // main unresolved

//        var result = CWrapper.main()
//        Log.d("TEST", "result -> " + result)

//        executeReaderCommand("/storage/emulated/0/Download/main.out") // permission denied
//        executeReaderCommand("/data/local/tmp/main.out") // permission denied
//        executeCommand("/data/local/tmp/main.out") // permission denied

//        executeReaderCommand("su /data/local/tmp/main.out") // error=2, No such file or directory
//        executeReaderCommand("sh /data/local/tmp/main.out") // exitcode 1

//        executeCommand("ping -w 1 google.com") // mExitValue 0
//        executePingCommand()    // mExitValue 0
//        executeReaderCommand("/system/bin/ping -w 1 google.com")   // success result -> PING google.com (172.217.9.206) 56(84) bytes of data
    }

    fun executeReaderCommand(cmd: String): String? {
        println("executeReaderCommand->" + cmd)
        try {
            var p: Process
            p = Runtime.getRuntime().exec(cmd)
            p.waitFor();
            if (p.exitValue() == 0) {
                val stdInput = BufferedReader(InputStreamReader(p.inputStream))
                var s: String
                var result = ""
                result = stdInput.readLine()
                Log.d("TEST", " success result -> " + result)
                return result
            }
            p.destroy()
            Log.d("TEST", "fail w/ exitcode = " + p.exitValue())
            return "---nada---"
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return "---exception---"
    }
    private fun executeCommand(cmd: String): Boolean {
        println("executeCommand->" + cmd)
        val runtime = Runtime.getRuntime()
        try {
            val p = runtime.exec(cmd)
            val mExitValue = p.waitFor()
            println(" mExitValue $mExitValue")
            return mExitValue == 0
        } catch (ignore: InterruptedException) {
            ignore.printStackTrace()
            println(" Exception:$ignore")
        } catch (e: IOException) {
            e.printStackTrace()
            println(" Exception:$e")
        }
        return false
    }
    private fun executePingCommand(): Boolean {
        println("executePingCommand")
        val runtime = Runtime.getRuntime()
        try {
            val mIpAddrProcess = runtime.exec("/system/bin/ping -c 1 8.8.8.8")
            val mExitValue = mIpAddrProcess.waitFor()
            println(" mExitValue $mExitValue")
            return mExitValue == 0
        } catch (ignore: InterruptedException) {
            ignore.printStackTrace()
            println(" Exception:$ignore")
        } catch (e: IOException) {
            e.printStackTrace()
            println(" Exception:$e")
        }
        return false
    }
}

//Cannot resolve corresponding JNI function Java_com_adaptivehandyapps_testrunndkbuild_CWrapper_main.
// Could not find an existing file with JNI definitions in it.
// Please add a file with JNI definitions to the project in order to get suggestions.
//object CWrapper {
//    external fun main(): Int
//
//    init {
//        System.loadLibrary("main.out")
//    }
//}