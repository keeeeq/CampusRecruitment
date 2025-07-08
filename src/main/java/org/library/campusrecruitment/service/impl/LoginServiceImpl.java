package org.library.campusrecruitment.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.library.campusrecruitment.mapper.JobMapper;
import org.library.campusrecruitment.mapper.LoginMapper;
import org.library.campusrecruitment.pojo.Job;
import org.library.campusrecruitment.pojo.Login;
import org.library.campusrecruitment.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl extends ServiceImpl<LoginMapper, Login>  implements LoginService {

}