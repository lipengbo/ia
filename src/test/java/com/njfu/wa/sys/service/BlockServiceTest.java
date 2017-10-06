package com.njfu.wa.sys.service;

import com.njfu.wa.sys.domain.Block;
import com.njfu.wa.sys.domain.util.Result;
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
public class BlockServiceTest {

    private static final Logger log = LoggerFactory.getLogger(BlockServiceTest.class);

    @Autowired
    private BlockService blockService;

    @Test
    public void getBlocks() throws Exception {
        List<Block> blocks = blockService.getBlocks(new Block());
        log.info("blocks: {}", blocks);
    }

    @Test
    public void getBlocksAndFields() throws Exception {
        List<Block> blocksAndFields = blockService.getBlocksAndFields();
        log.info("blocksAndFields: {}", blocksAndFields);
    }

    @Test
    public void addBlock() throws Exception {
        Block block = new Block();
//        block.setBlockId("test");
//        block.setBlockName("test");
//        block.setBlockLoc("test");
//        block.setBlockPs("test");

        Result result = blockService.addBlock(block);
        log.info("result: {}", result);
    }

    @Test
    public void modifyBlock() throws Exception {
        Block block = new Block();
        block.setBlockId("b01");
        block.setBlockName("test");
        block.setBlockLoc("test");
        block.setBlockPs("test");

        Result result = blockService.modifyBlock(block);
        log.info("result: {}", result);
    }

    @Test
    public void removeBlock() throws Exception {
        Block block = new Block();
        block.setBlockId("b01");

        Result result = blockService.removeBlock(block);
        log.info("result: {}", result);
    }

}