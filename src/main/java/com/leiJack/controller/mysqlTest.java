package com.leiJack.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;

@RestController
@RequestMapping("/mysql")
public class mysqlTest {

	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	
	@RequestMapping("/getUsers")
    public List<Map<String, Object>> getDbType(){
        String sql = "select * from user";
        List<Map<String, Object>> list =  jdbcTemplate.queryForList(sql);
        for (Map<String, Object> map : list) {
            Set<Entry<String, Object>> entries = map.entrySet( );
                if(entries != null) {
                    Iterator<Entry<String, Object>> iterator = entries.iterator( );
                    while(iterator.hasNext( )) {
                    Entry<String, Object> entry =(Entry<String, Object>) iterator.next( );
                    Object key = entry.getKey( );
                    Object value = entry.getValue();
                    System.out.println(key+":"+value);
                }
            }
        }
        return list;
    }
	
	
	@RequestMapping("/insertData")
	public String insertData(int id) {
		boolean flag = false;
		String sql = "insert into user values ("+id+")";
		try {
			jdbcTemplate.execute(sql);
		}catch(Exception e) {
			return String.valueOf(flag+e.getMessage());
		}
		flag = true;
		return String.valueOf(flag);
	}
	
	
	@RequestMapping("/getTablesCount")
	public Long getTablesCount() {
		String sql = "select count(1) from user";
		return jdbcTemplate.queryForObject(sql, Long.class);
	}
	
	
	
	@RequestMapping("/getTableData")
	public String getTableData() {
		String sql = "select * from user";
		List<Object> lists = new ArrayList<Object>();
		int size = 0;
		do {
			List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
			size = list.size();
			if(size == 0) {
				break;
			}
			lists.add(list);
		} while (size == 0);
		return JSONObject.toJSONString(lists);
	}
	
	@RequestMapping("/deleteTableData")
	public String deleteTableData(int id) {
		boolean flag = false;
		String sql = "delete from user where id="+id;
		try {
			jdbcTemplate.execute(sql);
		}catch(Exception e) {
			return String.valueOf(flag+e.getMessage());
		}
		flag = true;
		return String.valueOf(flag);
	}
}
