package ywt.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import ywt.entity.DataList9;

public interface QueryAccountListDao {
	
	public String findUrl(@Param("platform") String platform,@Param("remark") String remark);
	
	
}
