package org.java.practice.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisCluster;

import java.util.Random;
import java.util.UUID;

/**
 * @author yang.jin
 * date: 15/01/2018
 * desc:
 */
@Component
public class TaskProducer implements Runnable {

    @Autowired
    private JedisCluster redis;

    @Override
    public void run() {
        Random random = new Random();
        while(true){
            try{
                Thread.sleep(random.nextInt(600) + 600);
                // 模拟生成一个任务
                UUID taskid = UUID.randomUUID();
                //将任务插入任务队列：task-queue
                redis.lpush("task-queue", taskid.toString());
                System.out.println("插入了一个新的任务：" + taskid);

            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
