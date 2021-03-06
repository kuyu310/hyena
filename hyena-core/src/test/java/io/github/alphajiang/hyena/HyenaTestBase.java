/*
 *  Copyright (C) 2019 Alpha Jiang. All rights reserved.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */

package io.github.alphajiang.hyena;

import io.github.alphajiang.hyena.biz.point.PointUsage;
import io.github.alphajiang.hyena.biz.point.PointUsageFacade;
import io.github.alphajiang.hyena.ds.service.PointTableService;
import io.github.alphajiang.hyena.model.po.PointPo;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = HyenaTestMain.class)
@Transactional
public abstract class HyenaTestBase {
    private final Logger logger = LoggerFactory.getLogger(HyenaTestBase.class);

    @Autowired
    private PointTableService pointTableService;

    @Autowired
    private PointUsageFacade pointUsageFacade;

    private String pointType;

    private String uid;

    private PointUsage initialPointUsage;

    public HyenaTestBase() {
        String random = UUID.randomUUID().toString().replace("-", "");
        this.pointType = random.substring(0, 6);
        this.uid = random.substring(7, 12);
        this.initialPointUsage = new PointUsage();
        this.initialPointUsage.setType(this.pointType).setUid(this.uid).setPoint(99887L);
    }


    public void init() {
        pointTableService.getOrCreateTable(this.pointType);

        PointPo ret = this.pointUsageFacade.increase(this.initialPointUsage);
        logger.info("point = {}", ret);
        Assert.assertNotNull(ret);

    }

    public String getPointType() {
        return this.pointType;
    }

    public String getUid() {
        return this.uid;
    }

    public PointUsage getInitialPointUsage() {
        return initialPointUsage;
    }
}
