package com.chenfei.cfgo.study.web.service.test.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chenfei.cfgo.study.web.entity.test.People;
import com.chenfei.cfgo.study.web.service.test.service.PeopleService;
import com.chenfei.cfgo.study.web.mapper.test.PeopleMapper;
import org.springframework.stereotype.Service;

/**
* @author chenfei
* @description 针对表【people】的数据库操作Service实现
* @createDate 2022-10-23 08:37:44
*/
@Service
public class PeopleServiceImpl extends ServiceImpl<PeopleMapper, People>
    implements PeopleService{

}




