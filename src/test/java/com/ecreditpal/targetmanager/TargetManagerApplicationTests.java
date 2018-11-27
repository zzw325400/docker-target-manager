package com.ecreditpal.targetmanager;

import com.ecreditpal.targetmanager.service.BasicCategoryService;
import com.ecreditpal.targetmanager.service.BasicCategoryServiceImp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TargetManagerApplicationTests {

    @Autowired
    BasicCategoryServiceImp basicCategoryService;
    @Test
    public void contextLoads() {

    }

}
