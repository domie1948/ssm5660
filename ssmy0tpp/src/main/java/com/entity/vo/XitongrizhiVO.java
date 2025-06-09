package com.entity.vo;

import com.entity.XitongrizhiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
 

/**
 * 系统日志
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2021-02-22 14:13:01
 */
public class XitongrizhiVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 日志内容
	 */
	
	private String rizhineirong;
		
	/**
	 * 日志日期
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date rizhiriqi;
		
	/**
	 * 日志备注
	 */
	
	private String rizhibeizhu;
				
	
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
