/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.os890.test.actor.cdi.akka;

import org.os890.actor.cdi.akka.api.CdiAwareUntypedActor;

import javax.inject.Inject;
import java.util.concurrent.CountDownLatch;

public class InjectionAwareActor extends CdiAwareUntypedActor
{
    @Inject
    private TestService testService;

    static final CountDownLatch TEST_LATCH = new CountDownLatch(1);

    @Override
    public void onReceive(Object o) throws Exception
    {
        testService.call();
        TEST_LATCH.countDown();
    }
}