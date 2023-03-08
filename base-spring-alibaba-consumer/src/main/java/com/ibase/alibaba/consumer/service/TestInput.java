package com.ibase.alibaba.consumer.service;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

interface TestInput {
    String TEST_INPUT = "input";

    String TEST_DLQ_INPUT = "inputDlq";

    @Input(TEST_INPUT)
    SubscribableChannel input();

    @Input(TEST_DLQ_INPUT)
    SubscribableChannel inputDlq();
}
