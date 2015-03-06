package io;

import java.io.Serializable;

public class Alien implements Serializable {
    /**
     * 序列化搜索类
     *
     * 若果这个文件在froest.serializable.xfile下面，把Alien.java,FreezeAlien.java,ThawAlien.java都编译一下
     * 运行可以运行的
     * 但是把Alien.java移动到froest.serializable.find目录下面
     * FreezeAlien.java不编译，直接运行ThawAlien.java
     * 发现抛出异常ClassNotFoundException：froest.serializable.xfiles.Alien，发生在in.readObject()处
     * 但是Alien.class已经存在在bin.froest.serializable.find目录下面，所以问题不是出在Alien.class上面，而是在files上面
     * files文件是Alien.java在froest.serializable.xfile下面编译产生的，所以files中的对象所在的位置是在froest.serializable.xfile中，
     * 而现在froest.serializable.xfile包中并不能找到Alien.class文件，所以报ClassNotFoundException
     */
}