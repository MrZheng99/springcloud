package com.zj.product.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.zj.product.controller.IFlowerTypeController;
import com.zj.product.entity.FlowerType;
import com.zj.product.entity.ResponseJson;
import com.zj.product.service.IFlowerTypeService;

@RestController
@RequestMapping("flowerType")
public class FlowerTypeController implements IFlowerTypeController {
	@Autowired
	IFlowerTypeService flowerTypeService;

	@Override
	@RequestMapping("/findAll")
	public ResponseJson findAll() {
		return flowerTypeService.findAll();
	}

	@Override
	@RequestMapping("/find")
	public ResponseJson find() {
		return flowerTypeService.find();
	}

	@Override
	@PostMapping("/insert")
	public ResponseJson insert(@RequestParam("pic") MultipartFile file, @RequestParam String tname, @RequestParam String description) {
		return flowerTypeService.insert(file, tname, description);
	}

	@Override
	@PostMapping("/update")
	public ResponseJson update(@RequestBody FlowerType flowerType) {
		System.out.println(flowerType);
		return flowerTypeService.update(flowerType);
	}
}
