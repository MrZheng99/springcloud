package com.zj.product.service;

import org.springframework.web.multipart.MultipartFile;

import com.zj.product.entity.FlowerType;
import com.zj.product.entity.ResponseJson;

public interface IFlowerTypeService {
	public ResponseJson findAll();

	public ResponseJson update(FlowerType flowerType);

	public ResponseJson insert(MultipartFile file, String tname, String description);

	/***
	 * 查询可用类别
	 * 
	 * @return
	 */
	public ResponseJson find();

}
