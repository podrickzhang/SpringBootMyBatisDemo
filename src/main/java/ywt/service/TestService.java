package ywt.service;

import java.util.List;
import java.util.Map;

import org.apache.coyote.http11.filters.VoidInputFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import ywt.dao.MapTestDao;
import ywt.entity.DataList9;

@Component
public class TestService {

	@Autowired
	private MapTestDao mapTestDao;
	
	public List<DataList9> findData(){
		List<DataList9> list=mapTestDao.findData();
		return list;
	}
	
	public void print(){
		System.out.println("nihao");
	}
}
