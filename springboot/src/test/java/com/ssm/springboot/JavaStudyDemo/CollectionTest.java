package com.ssm.springboot.JavaStudyDemo;

import com.ssm.springboot.DemoTests.Person;
import org.codehaus.groovy.util.ListHashMap;

import java.util.*;

/**
 * @author zhaohf
 * @date 2020/4/1 9:41
 */
public class CollectionTest {

    /**
     * 1.通过数组实现的（动态数组）
     * 2.查询快增删慢
     * 3.线程不安全的
     * 4.支持null元素
     * 5.元素可以重复
     */
    List<Person> arrayList=new ArrayList<>();

    /**
     * 1.通过链表实现的（有顺序 先进先出）
     * 2.查询慢增删快
     * 3.线程不安全的
     * 4.支持null元素
     * 5.元素可以重复
     */
    List<Person> linkedList=new LinkedList<>();

    /**
     * 1.是无序的
     * 2.所存的值是是唯一的
     * 3.线程不安全（使用Collections.synchronizedSet
     *   方法保证线程线程安全）
     * 4.支持null元素
     * 5.创建HashSet实例时会初始化HashMap
     * 6.存储对象需重写对象的equals和hashCode方法
     */
    Set<Person> hashSet=new HashSet<>();

    /**
     * 1.通过链表实现的(有顺序)
     * 2.继承自HashSet，拥有HashSet特性
     * 3.存储对象需重写对象的equals和hashCode方法
     */
    Set<Person> linkedHashSet=new LinkedHashSet<>();

    /**
     * 1.二叉树型结构（左大右小）
     * 2.对集合进行排序
     */
    Set<Person> threeSet=new TreeSet<>();

    /**
     * 1.底层主要是基于数组和链表实现的
     * 2.键值可以为空，但键不能重复，为了保证唯一需要重写equals方法hashCode方法
     * 3.线程不安全（使用Collections.synchronizedMap
     *   方法保证线程安全）
     * 4.实现了序列化Serializable接口
     * 5.有4种遍历方法
     */
    Map<String,Object> map=new HashMap<>();

    Map<String,Object> linked=new LinkedHashMap<>();

    Map<String,Object> listHashMap=new ListHashMap<>();

    /**
     * 1.不可以有null值和null键
     * 2.
     */
    Map<String,Object> hashtable=new Hashtable<>();
}
