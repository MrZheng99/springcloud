package com.zj.product.service;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.zj.product.entity.Flower;
import com.zj.product.entity.ResponseJson;

public interface IFlowerService {
	public ResponseJson findAll();

	public ResponseJson find(Flower flower);

	public ResponseJson find(Integer fid);

	public ResponseJson update(Flower flower);

	public Map<String, Object> uploadImage(MultipartFile file);

	public ResponseJson insert(MultipartFile[] files, String fname, String description, String flowerLan,
			String deliveryDesc, Double price, String sale, Integer store, String intro, String pack, Integer sid,
			Integer tid);

	public ResponseJson findIdAndName();

	ResponseJson myLucenceNumber(String name);

	ResponseJson myLucence(String goodsName, Integer pageNum);

}
