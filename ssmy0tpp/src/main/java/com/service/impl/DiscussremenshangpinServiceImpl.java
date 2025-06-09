package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.DiscussremenshangpinDao;
import com.entity.DiscussremenshangpinEntity;
import com.service.DiscussremenshangpinService;
import com.entity.vo.DiscussremenshangpinVO;
import com.entity.view.DiscussremenshangpinView;

@Service("discussremenshangpinService")
public class DiscussremenshangpinServiceImpl extends ServiceImpl<DiscussremenshangpinDao, DiscussremenshangpinEntity> implements DiscussremenshangpinService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussremenshangpinEntity> page = this.selectPage(
                new Query<DiscussremenshangpinEntity>(params).getPage(),
                new EntityWrapper<DiscussremenshangpinEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussremenshangpinEntity> wrapper) {
		  Page<DiscussremenshangpinView> page =new Query<DiscussremenshangpinView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscussremenshangpinVO> selectListVO(Wrapper<DiscussremenshangpinEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussremenshangpinVO selectVO(Wrapper<DiscussremenshangpinEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussremenshangpinView> selectListView(Wrapper<DiscussremenshangpinEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussremenshangpinView selectView(Wrapper<DiscussremenshangpinEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
