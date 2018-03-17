package com.njfu.ia.sys.mapper;

import com.njfu.ia.sys.domain.Block;
import com.njfu.ia.sys.domain.Crop;
import com.njfu.ia.sys.domain.Field;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class FieldMapperTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(FieldMapperTest.class);

    @Resource
    private FieldMapper fieldMapper;

    @Test
    public void selectFields() throws Exception {
        Field field = new Field();
        field.setBlock(new Block());
        field.setCrop(new Crop());
        field.setUseStatus("");

        List<Field> fields = fieldMapper.selectFields(field);
        LOGGER.info("fields: {}", fields);
    }

    @Test
    public void insertField() throws Exception {
        Field field = new Field();
        field.setFieldId("f1700001");
        field.setFieldName("test");

        Block block = new Block();
        block.setBlockId("b01");
        field.setBlock(block);

        field.setCrop(new Crop());
        field.setUseStatus("0");
        field.setFieldPs("test");

        int res = fieldMapper.insertField(field);

        Assert.assertEquals(1, res);
    }

    @Test
    public void updateField() throws Exception {
        Field field = new Field();
        field.setFieldId("f1701001");
        field.setFieldName("test");
        field.setUseStatus("0");

        Block block = new Block();
        block.setBlockId("b01");
        field.setBlock(block);

        int res = fieldMapper.updateField(field);
        Assert.assertEquals(1, res);
    }

    @Test
    public void deleteField() throws Exception {
        Field field = new Field();
        field.setFieldId("f1701001");
        int res = fieldMapper.deleteField(field);

        Assert.assertEquals(1, res);
    }

}