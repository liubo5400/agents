package cn.lbo.javaagent;

import cn.lbo.javaagent.jvm.JvmStact;

import java.lang.instrument.Instrumentation;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Author bjliubo
 * @Date 2023/3/17 14:28
 * @PackageName:cn.lbo.agent
 * @ClassName: MyAgent
 * @Description: TODO
 * @Version 1.0
 */
public class MyAgent {

    /**
     * jvm 参数形式启动，运行此方法
     *
     * @param agentArgs
     * @param inst
     */
    public static void premain(String agentArgs, Instrumentation inst) {
        System.out.println("premain");
        Executors.newScheduledThreadPool(1).scheduleAtFixedRate(new Runnable() {
            public void run() {
                JvmStact.printGCInfo();
                JvmStact.printMemoryInfo();
                System.out.println("============================================================");
            }
        }, 0, 10000, TimeUnit.MILLISECONDS);
    }

    /**
     * 动态 attach 方式启动，运行此方法
     *
     * @param agentArgs
     * @param inst
     */
    public static void agentmain(String agentArgs, Instrumentation inst) {
        System.out.println("agentmain");
    }

}
