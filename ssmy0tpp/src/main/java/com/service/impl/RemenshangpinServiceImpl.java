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


import com.dao.RemenshangpinDao;
import com.entity.RemenshangpinEntity;
import com.service.RemenshangpinService;
import com.entity.vo.RemenshangpinVO;
import com.entity.view.RemenshangpinView;

@Service("remenshangpinService")
public class RemenshangpinServiceImpl extends ServiceImpl<RemenshangpinDao, RemenshangpinEntity> implements RemenshangpinService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<RemenshangpinEntity> page = this.selectPage(
                new Query<RemenshangpinEntity>(params).getPage(),
                new EntityWrapper<RemenshangpinEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<RemenshangpinEntity> wrapper) {
		  Page<RemenshangpinView> page =new Query<RemenshangpinView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<RemenshangpinVO> selectListVO(Wrapper<RemenshangpinEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public RemenshangpinVO selectVO(Wrapper<RemenshangpinEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<RemenshangpinView> selectListView(Wrapper<RemenshangpinEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public RemenshangpinView selectView(Wrapper<RemenshangpinEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
