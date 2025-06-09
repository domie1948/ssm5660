package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.RemenshangpinEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.RemenshangpinVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.RemenshangpinView;


/**
 * 热门商品
 *
 * @author 
 * @email 
 * @date 2021-02-22 14:13:00
 */
public interface RemenshangpinService extends IService<RemenshangpinEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<RemenshangpinVO> selectListVO(Wrapper<RemenshangpinEntity> wrapper);
   	
   	RemenshangpinVO selectVO(@Param("ew") Wrapper<RemenshangpinEntity> wrapper);
   	
   	List<RemenshangpinView> selectListView(Wrapper<RemenshangpinEntity> wrapper);
   	
   	RemenshangpinView selectView(@Param("ew") Wrapper<RemenshangpinEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<RemenshangpinEntity> wrapper);
   	
}

