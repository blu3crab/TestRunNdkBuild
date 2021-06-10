# TestRunNdkBuild
 Run NDK native build from Android app.
 
//        executeReaderCommand("/storage/emulated/0/Download/main.out") // permission denied
//        executeReaderCommand("/data/local/tmp/main.out") // permission denied
//        executeCommand("/data/local/tmp/main.out") // permission denied

//        executeReaderCommand("su /data/local/tmp/main.out") // error=2, No such file or directory
//        executeReaderCommand("sh /data/local/tmp/main.out") // exitcode 1
        
//        executeCommand("ping -w 1 google.com") // mExitValue 0
//        executePingCommand()    // mExitValue 0
//        executeReaderCommand("/system/bin/ping -w 1 google.com")   // success result -> PING google.com (172.217.9.206) 56(84) bytes of data

