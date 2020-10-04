package com.zj.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.zj.product.entity.FlowerType;
import com.zj.product.entity.ResponseJson;
import com.zj.product.service.IFlowerTypeService;

@RestController
@RequestMapping("flowerType")
public class FlowerTypeController{
	@Autowired
	IFlowerTypeService flowerTypeService;

	
	@RequestMapping("/findAll")
	public ResponseJson findAll() {
		return flowerTypeService.findAll();
	}

	
	@RequestMapping("/find")
	public ResponseJson find() {
		return flowerTypeService.find();
	}

	
	@PostMapping("/insert")
	public ResponseJson insert(@RequestParam("pic") MultipartFile file, @RequestParam String tname, @RequestParam String description) {
		return flowerTypeService.insert(file, tname, description);
	}

	
	@PostMapping("/update")
	public ResponseJson update(@RequestBody FlowerType flowerType) {
		System.out.println(flowerType);
		return flowerTypeService.update(flowerType);
	}
}
