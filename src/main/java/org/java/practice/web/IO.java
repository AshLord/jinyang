package org.java.practice.web;

import sun.plugin2.message.Serializer;

import java.io.FileDescriptor;
import java.io.SyncFailedException;

/**
 * Created by yang.jin on 24/10/2017.
 */
public class IO {

    FileDescriptor fd = new FileDescriptor();

    public void func() {
        try {
            //将OS缓存Cache中的数据强制刷新到物理磁盘Disk中
            fd.sync();
        } catch (SyncFailedException e) {
            e.printStackTrace();
        }
    }

}
