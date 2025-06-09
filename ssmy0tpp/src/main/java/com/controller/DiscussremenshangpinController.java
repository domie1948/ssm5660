package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.DiscussremenshangpinEntity;
import com.entity.view.DiscussremenshangpinView;

import com.service.DiscussremenshangpinService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 热门商品评论表
 * 后端接口
 * @author 
 * @email 
 * @date 2021-02-22 14:13:01
 */
@RestController
@RequestMapping("/discussremenshangpin")
public class DiscussremenshangpinController {
    @Autowired
    private DiscussremenshangpinService discussremenshangpinService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiscussremenshangpinEntity discussremenshangpin, HttpServletRequest request){

        EntityWrapper<DiscussremenshangpinEntity> ew = new EntityWrapper<DiscussremenshangpinEntity>();
		PageUtils page = discussremenshangpinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussremenshangpin), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DiscussremenshangpinEntity discussremenshangpin, HttpServletRequest request){
        EntityWrapper<DiscussremenshangpinEntity> ew = new EntityWrapper<DiscussremenshangpinEntity>();
		PageUtils page = discussremenshangpinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussremenshangpin), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiscussremenshangpinEntity discussremenshangpin){
       	EntityWrapper<DiscussremenshangpinEntity> ew = new EntityWrapper<DiscussremenshangpinEntity>();
      	ew.allEq(MPUtil.allEQMapPre( discussremenshangpin, "discussremenshangpin")); 
        return R.ok().put("data", discussremenshangpinService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiscussremenshangpinEntity discussremenshangpin){
        EntityWrapper< DiscussremenshangpinEntity> ew = new EntityWrapper< DiscussremenshangpinEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discussremenshangpin, "discussremenshangpin")); 
		DiscussremenshangpinView discussremenshangpinView =  discussremenshangpinService.selectView(ew);
		return R.ok("查询热门商品评论表成功").put("data", discussremenshangpinView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscussremenshangpinEntity discussremenshangpin = discussremenshangpinService.selectById(id);
        return R.ok().put("data", discussremenshangpin);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscussremenshangpinEntity discussremenshangpin = discussremenshangpinService.selectById(id);
        return R.ok().put("data", discussremenshangpin);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiscussremenshangpinEntity discussremenshangpin, HttpServletRequest request){
    	discussremenshangpin.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discussremenshangpin);

        discussremenshangpinService.insert(discussremenshangpin);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DiscussremenshangpinEntity discussremenshangpin, HttpServletRequest request){
    	discussremenshangpin.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discussremenshangpin);

        discussremenshangpinService.insert(discussremenshangpin);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody DiscussremenshangpinEntity discussremenshangpin, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discussremenshangpin);
        discussremenshangpinService.updateById(discussremenshangpin);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        discussremenshangpinService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<DiscussremenshangpinEntity> wrapper = new EntityWrapper<DiscussremenshangpinEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = discussremenshangpinService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	


}
