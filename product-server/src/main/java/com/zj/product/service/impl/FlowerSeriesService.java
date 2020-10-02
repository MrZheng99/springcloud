package com.zj.product.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zj.product.dao.IFlowerSeriesDao;
import com.zj.product.entity.FlowerSeries;
import com.zj.product.entity.ResponseJson;
import com.zj.product.service.IFlowerSeriesService;
import com.zj.product.util.UploadImg;

@Service
public class FlowerSeriesService implements IFlowerSeriesService {
	@Autowired
	IFlowerSeriesDao flowerSeriesDao;
	@Autowired
	UploadImg uploadImg;

	@Override
	public ResponseJson findAll() {
		List<FlowerSeries> listFlowerSeries;
		try {
			listFlowerSeries = flowerSeriesDao.findAll();
			return new ResponseJson(200, "获取成功", listFlowerSeries, true);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseJson(500, "获取失败", null, false);
		}
	}

	@Override
	public ResponseJson update(FlowerSeries flowerSeries) {
		Integer row = 0;
		try {
			row = flowerSeriesDao.update(flowerSeries);
			if (row > 0)
				return new ResponseJson(200, "修改成功", row, true);
			return new ResponseJson(200, "修改失败", -1, false);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return new ResponseJson(500, "修改失败", -1, false);
		}
	}

	@Override
	public ResponseJson insert(String sname) {
		Integer row = 0;
		try {
			row = flowerSeriesDao.insert(new FlowerSeries(sname));
			if (row > 0)
				return new ResponseJson(200, "插入成功", row, true);
			return new ResponseJson(200, "插入失败", -1, false);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return new ResponseJson(500, "插入失败", -1, false);
		}
	}

}
