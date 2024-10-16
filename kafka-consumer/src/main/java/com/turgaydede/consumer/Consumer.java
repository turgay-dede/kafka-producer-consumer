package com.turgaydede.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.turgaydede.event.OrderEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class Consumer {
	private static final String TOPIC_NAME = "order-create";
	private static final String GROUP_ID = "KafkaOrderConsumer-GroupId";
	private final ObjectMapper objectMapper;

	@KafkaListener(topics = {TOPIC_NAME}, groupId = GROUP_ID, containerFactory = "kafkaListenerContainerFactory")
	public void listener(@Payload OrderEvent event, ConsumerRecord c) throws Exception {
		log.info(event.toString());
		log.info(c.toString());
	}

}
