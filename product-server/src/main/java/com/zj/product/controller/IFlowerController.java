package com.zj.product.controller;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.zj.product.entity.Flower;
import com.zj.product.entity.ResponseJson;

public interface IFlowerController {

	public ResponseJson findAll();

	public ResponseJson find(Flower flower);

	public ResponseJson find(Integer fid);

	public ResponseJson update(Flower flower);

	/**
	 * 上传商品描述中的图片
	 * 
	 * @param file
	 * @return
	 */
	public Map<String, Object> uploadImage(MultipartFile file);

	public ResponseJson insert(MultipartFile[] files, String fname, String description, String flowerLan,
			String deliveryDesc, Double price, String sale, Integer store, String intro, String pack, Integer sid,
			Integer tid);
	
	public ResponseJson findIdAndName();

}
