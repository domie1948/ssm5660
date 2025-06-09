package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 系统日志
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2021-02-22 14:13:01
 */
@TableName("xitongrizhi")
public class XitongrizhiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public XitongrizhiEntity() {
		
	}
	
	public XitongrizhiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 日志标题
	 */
					
	private String rizhibiaoti;
	
	/**
	 * 日志内容
	 */
					
	private String rizhineirong;
	
	/**
	 * 日志日期
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date rizhiriqi;
	
	/**
	 * 日志备注
	 */
					
	private String rizhibeizhu;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：日志标题
	 */
	public void setRizhibiaoti(String rizhibiaoti) {
		this.rizhibiaoti = rizhibiaoti;
	}
	/**
	 * 获取：日志标题
	 */
	public String getRizhibiaoti() {
		return rizhibiaoti;
	}
	/**
	 * 设置：日志内容
	 */
	public void setRizhineirong(String rizhineirong) {
		this.rizhineirong = rizhineirong;
	}
	/**
	 * 获取：日志内容
	 */
	public String getRizhineirong() {
		return rizhineirong;
	}
	/**
	 * 设置：日志日期
	 */
	public void setRizhiriqi(Date rizhiriqi) {
		this.rizhiriqi = rizhiriqi;
	}
	/**
	 * 获取：日志日期
	 */
	public Date getRizhiriqi() {
		return rizhiriqi;
	}
	/**
	 * 设置：日志备注
	 */
	public void setRizhibeizhu(String rizhibeizhu) {
		this.rizhibeizhu = rizhibeizhu;
	}
	/**
	 * 获取：日志备注
	 */
	public String getRizhibeizhu() {
		return rizhibeizhu;
	}

}
