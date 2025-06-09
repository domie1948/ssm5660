package com.entity.view;

import com.entity.RemenshangpinEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 热门商品
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-02-22 14:13:00
 */
@TableName("remenshangpin")
public class RemenshangpinView  extends RemenshangpinEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public RemenshangpinView(){
	}
 
 	public RemenshangpinView(RemenshangpinEntity remenshangpinEntity){
 	try {
			BeanUtils.copyProperties(this, remenshangpinEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
