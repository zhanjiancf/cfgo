package com.chenfei.cfgo.test.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chenfei.cfgo.test.entity.People;
import com.chenfei.cfgo.test.service.PeopleService;
import com.chenfei.cfgo.test.mapper.PeopleMapper;
import org.springframework.stereotype.Service;

/**
* @author chenfei
* @description 针对表【people】的数据库操作Service实现
* @createDate 2022-11-15 10:57:37
*/
@Service
public class PeopleServiceImpl extends ServiceImpl<PeopleMapper, People>
    implements PeopleService {

}




