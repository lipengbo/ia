package com.njfu.wa.sys.service;

import com.njfu.wa.sys.domain.Block;
import com.njfu.wa.sys.domain.Crop;
import com.njfu.wa.sys.domain.Field;
import com.njfu.wa.sys.util.Message;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class FieldServiceTest {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private FieldService fieldService;

    @Test
    public void getFields() throws Exception {
        List<Field> fields = fieldService.getFields(new Field(), new Block(), new Crop());
        log.info("fields: {}", fields);
    }

    @Test
    public void addField() throws Exception {
        Field field = new Field();
        field.setFieldId("f1700001");
        field.setFieldName("test");
        field.setUseStatus("0");
        field.setFieldPs("test");

        Block block = new Block();
        block.setBlockId("b01");

        Message message = fieldService.addField(field, block, new Crop());
        log.info("message: {}", message);
    }


    @Test
    public void modifyField() throws Exception {
        Field field = new Field();
        field.setFieldId("f1701001");
        field.setFieldName("test");
        field.setUseStatus("0");

        Block block = new Block();
        block.setBlockId("b01");

        Message message = fieldService.modifyField(new Field(), block, new Crop());
        log.info("message: {}", message);
    }

    @Test
    public void removeField() throws Exception {
        Field field = new Field();
        field.setFieldId("f1701001");

        Message message = fieldService.removeField(field);
        log.info("message: {}", message);
    }
}