/*
 * Copyright 2025 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.alibaba.cloud.ai.observationhandlerexample.observationHandler;

import io.micrometer.common.KeyValue;
import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationHandler;
import org.springframework.ai.chat.observation.ChatModelObservationContext;

/**
 * @Author: XiaoYunTao
 * @Date: 2024/12/31
 */
public class CustomerObservationHandler implements ObservationHandler<ChatModelObservationContext> {

    @Override
    public void onStart(ChatModelObservationContext context) {
        context.addLowCardinalityKeyValue(new KeyValue() {
            @Override
            public String getKey() {
                return "test lowcardinality Key";
            }

            @Override
            public String getValue() {
                return "test lowcardinality value";
            }
        });
        System.out.println("exec CustomerObservationHandler onStart function! ChatModelObservationContext: " + context.toString() );
    }

    @Override
    public void onStop(ChatModelObservationContext context) {
        System.out.println("exec CustomerObservationHandler onStop function! ChatModelObservationContext: " + context.toString() );
    }

    @Override
    public boolean supportsContext(Observation.Context context) {
        return context instanceof ChatModelObservationContext;
    }
}
