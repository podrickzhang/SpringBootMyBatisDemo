package ywt.test;

import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ywt.dao.MapTestDao;
import ywt.entity.DataList9;

@Component
public class MapperUtil {
	
	@Autowired
	private MapTestDao mapTestDao;
	
	public static MapperUtil mapperUtil;
	
	
	@PostConstruct
	public void init(){
		mapperUtil=this;
		mapperUtil.mapTestDao=this.mapTestDao;
	}
	
	public static List<DataList9> getMap(){
		return mapperUtil.mapTestDao.findData();
	}
	
}
