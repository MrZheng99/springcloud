package com.zj.product.controller;

import org.springframework.web.multipart.MultipartFile;

import com.zj.product.entity.FlowerType;
import com.zj.product.entity.ResponseJson;

public interface IFlowerTypeController {
	public ResponseJson findAll();

	public ResponseJson update(FlowerType flowerType);

	public ResponseJson find();

	public ResponseJson insert(MultipartFile file, String tname, String description);
}
