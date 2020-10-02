package com.zj.product.service.impl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.zj.product.dao.IFlowerTypeDao;
import com.zj.product.entity.FlowerType;
import com.zj.product.entity.ResponseJson;
import com.zj.product.service.IFlowerTypeService;
import com.zj.product.util.UploadImg;

@Service
public class FlowerTypeService implements IFlowerTypeService {
	@Autowired
	IFlowerTypeDao flowerTypeDao;
	@Autowired
	UploadImg uploadImg;
	@Value("${file.types.path}")
	private String path;
	@Value("${file.types.uploadPath}")
	private String uploadPath;

	@Override
	public ResponseJson findAll() {
		List<FlowerType> listFlowerType;
		try {
			listFlowerType = flowerTypeDao.findAll();
			return new ResponseJson(200, "获取成功", listFlowerType, true);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseJson(500, "获取失败", null, false);
		}
	}

	@Override
	public ResponseJson find() {
		List<FlowerType> listFlowerType;
		try {
			listFlowerType = flowerTypeDao.find();
			return new ResponseJson(200, "获取成功", listFlowerType, true);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseJson(500, "获取失败", null, false);
		}
	}

	@Override
	public ResponseJson update(FlowerType flowerType) {
		Integer row = 0;
		try {
			row = flowerTypeDao.update(flowerType);
			if (row > 0)
				return new ResponseJson(200, "修改成功", row, true);
			return new ResponseJson(200, "修改失败", -1, false);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return new ResponseJson(500, "修改失败", -1, false);
		}
	}

	@Override
	public ResponseJson insert(MultipartFile file, String tname,String description) {
		if (file.isEmpty())
			return new ResponseJson(200, "添加失败,图片不能为空", null, false);
		if (!(file.getContentType().indexOf("image") >= 0))
			return new ResponseJson(200, "添加失败,格式不正确", null, false);
		String typeImg;
		try {
			typeImg = path + uploadImg.uploadWaterLogoImg(file, uploadPath);
		} catch (IOException e) {
			e.printStackTrace();
			return new ResponseJson(500, "添加失败", null, false);
		}
		FlowerType flowerType = new FlowerType();
		flowerType.setTname(tname);
		flowerType.setTypeImg(typeImg);
		flowerType.setDescription(description);
		Integer row = flowerTypeDao.insert(flowerType);
		if (row > 0)
			return new ResponseJson(200, "添加成功", row, true);
		return new ResponseJson(200, "添加失败", null, false);
	}

}
