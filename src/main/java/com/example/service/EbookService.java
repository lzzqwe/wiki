package com.example.service;

import com.example.domain.Ebook;
import com.example.domain.EbookExample;
import com.example.mapper.EbookMapper;
import com.example.req.EbookReq;
import com.example.resp.EbookResp;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.List;

// @Service 这个注解意思是 这个service教给spring来管理
@Service
public class EbookService {
    private static final Logger LOG = LoggerFactory.getLogger(EbookService.class);
    @Resource
    private EbookMapper ebookMapper;
    public List<EbookResp> list(EbookReq req){
//        System.out.println(name);

        EbookExample ebookExample = new EbookExample();
        EbookExample.Criteria criteria = ebookExample.createCriteria();
        if (!ObjectUtils.isEmpty(req.getName())) {
            criteria.andNameLike("%" + req.getName() + "%");
        }
        PageHelper.startPage(1,1);
        List<Ebook> ebookList= ebookMapper.selectByExample(ebookExample);
        PageInfo<Ebook> pageInfo = new PageInfo<>(ebookList);
        LOG.info("总行数：{}", pageInfo.getTotal());
        LOG.info("总页数：{}", pageInfo.getPages());
        List<EbookResp> respList = new ArrayList<>();
        for (Ebook ebook : ebookList) {
            EbookResp ebookResp = new EbookResp();
//            ebookResp.setId(ebook.getId());
            BeanUtils.copyProperties(ebook,ebookResp);
            respList.add(ebookResp);
        }
        return  respList;
    }
}
