package io;

import java.io.Serializable;

public class Alien implements Serializable {
    /**
     * ���л�������
     *
     * ��������ļ���froest.serializable.xfile���棬��Alien.java,FreezeAlien.java,ThawAlien.java������һ��
     * ���п������е�
     * ���ǰ�Alien.java�ƶ���froest.serializable.findĿ¼����
     * FreezeAlien.java�����룬ֱ������ThawAlien.java
     * �����׳��쳣ClassNotFoundException��froest.serializable.xfiles.Alien��������in.readObject()��
     * ����Alien.class�Ѿ�������bin.froest.serializable.findĿ¼���棬�������ⲻ�ǳ���Alien.class���棬������files����
     * files�ļ���Alien.java��froest.serializable.xfile�����������ģ�����files�еĶ������ڵ�λ������froest.serializable.xfile�У�
     * ������froest.serializable.xfile���в������ҵ�Alien.class�ļ������Ա�ClassNotFoundException
     */
}