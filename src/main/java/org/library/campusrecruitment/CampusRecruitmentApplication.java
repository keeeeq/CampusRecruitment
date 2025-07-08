package org.library.campusrecruitment;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.library.campusrecruitment.mapper")
public class CampusRecruitmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(CampusRecruitmentApplication.class, args);
    }

}
