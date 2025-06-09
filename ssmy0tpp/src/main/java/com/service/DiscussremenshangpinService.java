package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussremenshangpinEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussremenshangpinVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussremenshangpinView;


/**
 * 热门商品评论表
 *
 * @author 
 * @email 
 * @date 2021-02-22 14:13:01
 */
public interface DiscussremenshangpinService extends IService<DiscussremenshangpinEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussremenshangpinVO> selectListVO(Wrapper<DiscussremenshangpinEntity> wrapper);
   	
   	DiscussremenshangpinVO selectVO(@Param("ew") Wrapper<DiscussremenshangpinEntity> wrapper);
   	
   	List<DiscussremenshangpinView> selectListView(Wrapper<DiscussremenshangpinEntity> wrapper);
   	
   	DiscussremenshangpinView selectView(@Param("ew") Wrapper<DiscussremenshangpinEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussremenshangpinEntity> wrapper);
   	
}

