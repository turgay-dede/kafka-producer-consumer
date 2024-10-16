package com.turgaydede.controller;

import com.turgaydede.model.request.Order;
import com.turgaydede.publisher.KafkaPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class KafkaController {

	private final KafkaPublisher kafkaPublisher;
	String topicName = "order-create";

	@PostMapping
	public void sendEvent(@RequestBody Order order) {
		kafkaPublisher.publish(topicName, order);
	}
}
