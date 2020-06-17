package com.little.core.guava;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.Test;
import lombok.extern.slf4j.Slf4j;


/**
 * @Comment
 * @Author LiYuan
 * @Date 2020-6-17
 */
@Slf4j
public class MyGuavaApiTest {

  @Test
  public void test_collection_creat() {
    // 普通Collection的创建
    List<String> list = Lists.newArrayList();
    Set<String> set = Sets.newHashSet();
    Map<String, String> map = Maps.newHashMap();

// 不变Collection的创建
    ImmutableList<String> iList = ImmutableList.of("a", "b", "c");
    ImmutableSet<String> iSet = ImmutableSet.of("e1", "e2");
    ImmutableMap<String, String> iMap = ImmutableMap.of("k1", "v1", "k2", "v2");
  }


  @Test
  public void test_collection_create2() {

    log.info("NORMAL");
    Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();
    List<Integer> list = new ArrayList<Integer>();
    list.add(1);
    list.add(2);
    map.put("aa", list);
    System.out.println(map.get("aa"));//[1, 2]

    log.info("GUAVA CREATE");

    Multimap<String, Integer> multimap = ArrayListMultimap.create();
    multimap.put("aa", 1);
    multimap.put("aa", 2);
    System.out.println(multimap.get("aa"));
  }

  @Test
  public void test_list_to_string(){
    //use guava
    List<String> list = new ArrayList<String>();
    list.add("aa");
    list.add("bb");
    list.add("cc");
    String result = Joiner.on("-").join(list);
    //result为  aa-bb-cc
    System.out.println(result);

    Map<String, Integer> map = Maps.newHashMap();
    map.put("xiaoming", 12);
    map.put("xiaohong",13);
    String result2 = Joiner.on(",").withKeyValueSeparator("=").join(map);
    System.out.println(result2);
  }

//  public void test_string_to_list(){
//    String str = "1-2-3-4-5-6";
//
////    List<String> list = Splitter.on("-").splitToList(str);
//    List<String> dingList = Splitter.on(",").trimResults().splitToList(str);
//  }



}
