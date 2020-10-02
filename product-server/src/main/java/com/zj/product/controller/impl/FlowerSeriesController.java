package com.zj.product.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zj.product.controller.IFlowerSeriesController;
import com.zj.product.entity.FlowerSeries;
import com.zj.product.entity.ResponseJson;
import com.zj.product.service.IFlowerSeriesService;

@RestController
@RequestMapping("flowerSeries")
public class FlowerSeriesController implements IFlowerSeriesController {
	@Autowired
	IFlowerSeriesService service;

	@Override
	@RequestMapping("/findAll")
	public ResponseJson findAll() {
		return service.findAll();
	}

	@Override
	@PostMapping("/insert")
	public ResponseJson insert(@RequestParam String sname) {
		System.out.println(sname);
		return service.insert(sname);
	}

	@Override
	@PostMapping("/update")
	public ResponseJson update(@RequestBody FlowerSeries flowerSeries) {
		return service.update(flowerSeries);
	}
}
