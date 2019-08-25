package com.xuecheng.manage_cms;

import org.bson.types.ObjectId;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestGridFsTemplate {

    @Autowired
    GridFsTemplate gridFsTemplate;

    @Test
    public void testGrieFsTemplate() throws FileNotFoundException {
        //定义要存储的文件
        InputStream is= new FileInputStream(new File("d:/index_banner.html"));

        //存储文件到gridFs
        ObjectId objectId = gridFsTemplate.store(is, "测试");

        //得到文件的id
        String fileId = objectId.toString();
        System.out.println("文件id："+fileId);

        /**
         * 存储原理说明：
         * 文件存储成功得到一个文件id 此文件id是fs.ﬁles集合中的主键。
         * 可以通过文件id查询fs.chunks表中的记录，得到文件的内容。
         */
    }
}
