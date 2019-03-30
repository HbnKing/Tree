package com.example.demo;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class AreaDaoTest {
	@Autowired
	private AreaDao areaDao;
	
	@Test
	@Ignore
	public void testQueryArea() {
		List<Area> areaList = areaDao.queryArea();
		System.out.println(areaList.size());
		assertEquals( 2,areaList.size());
	
	}

	@Test
	@Ignore
	public void testQueryAreaById() {
		Area area =areaDao.queryAreaById(1);
		assertEquals( "东苑",area.getAreaName());
		
	}
	
	/*
	 * 添加
	*/
	@Test
	@Ignore
	public void testInsertArea() {
		Area area = new Area();
		area.setAreaName("南苑");
		area.setPriority(1);
		int effectedNum = areaDao.insertArea(area);
		assertEquals(1,effectedNum);	
	}

	/*
	 * 修改
	*/
	@Test
	@Ignore
	public void testUpdateArea() {
		Area area = new Area();
		area.setAreaName("西苑");
		area.setAreaId(3);
		int effectedNum = areaDao.updateArea(area);
		assertEquals(1,effectedNum);
	
	}
	/*
	 * 删除
	*/
	@Test
		
	public void testDeleteArea() {
		int effectedNum = areaDao.deleteArea(4);
		assertEquals(1,effectedNum);
	}

}
