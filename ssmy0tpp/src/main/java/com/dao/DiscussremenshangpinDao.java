package com.dao;

import com.entity.DiscussremenshangpinEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussremenshangpinVO;
import com.entity.view.DiscussremenshangpinView;


/**
 * 热门商品评论表
 * 
 * @author 
 * @email 
 * @date 2021-02-22 14:13:01
 */
public interface DiscussremenshangpinDao extends BaseMapper<DiscussremenshangpinEntity> {
	
	List<DiscussremenshangpinVO> selectListVO(@Param("ew") Wrapper<DiscussremenshangpinEntity> wrapper);
	
	DiscussremenshangpinVO selectVO(@Param("ew") Wrapper<DiscussremenshangpinEntity> wrapper);
	
	List<DiscussremenshangpinView> selectListView(@Param("ew") Wrapper<DiscussremenshangpinEntity> wrapper);

	List<DiscussremenshangpinView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussremenshangpinEntity> wrapper);
	
	DiscussremenshangpinView selectView(@Param("ew") Wrapper<DiscussremenshangpinEntity> wrapper);
	
}
