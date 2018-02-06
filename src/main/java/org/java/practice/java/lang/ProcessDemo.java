package org.java.practice.java.lang;

import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author yang.jin
 * date: 06/02/2018
 * desc:
 */
public class ProcessDemo {

    public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {

        //before java 5
        Runtime.getRuntime().exec("notepad.exe");

        //after java 5
        Process p0 = new ProcessBuilder("notepad.exe").start();
        System.out.println(p0.pid());

        //获取并输出过程信息
        ProcessDemo demo = new ProcessDemo();
        demo.dumpProcessInfo(ProcessHandle.current()); //获取当前进程的句柄
        Process p = new ProcessBuilder("notepad.exe","C:\\temp\\names.txt").start();
        demo.dumpProcessInfo(p.toHandle());
        p.waitFor();

        //获取并输出有关当前进程可见的四个进程的信息
        ProcessHandle.allProcesses().filter(ph -> ph.info().command().isPresent()).limit(4).forEach((process)-> demo.dumpProcessInfo(process));

        //当进程终止时，获取和输出进程的PID
        ProcessHandle ph = p.toHandle();
        CompletableFuture<ProcessHandle> onExit = ph.onExit();
        onExit.get();
        onExit.thenAccept(ph_ ->System.out.printf("PID %d terminated%n",ph_.pid()));
    }

    public void dumpProcessInfo(ProcessHandle ph) {
        System.out.println("PROCESS INFORMATION");
        System.out.println("========================");
        System.out.printf("Process id: %d%n", ph.pid());
        ProcessHandle.Info info = ph.info();
        System.out.printf("Command: %s%n", info.command().orElse(""));
        String[] args = info.arguments().orElse(new String[]{});
        System.out.println("Arguments:");
        for(String arg: args) {
            System.out.printf(" %s%n", arg);
        }
        System.out.printf("Command line: %s%n", info.commandLine().orElse(""));
        System.out.printf("Start time: %s%n",
                info.startInstant().orElse(Instant.now()).toString());
        System.out.printf("Run time duration: %sms%n",
                info.totalCpuDuration()
                        .orElse(Duration.ofMillis(0)).toMillis());
        System.out.printf("Owner: %s%n", info.user().orElse(""));
        System.out.println();
    }
}
