package com.turgaydede.event;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class OrderEvent {

	private String id;
	private String username;
	private String price;
	private String createdTime;

	@Override
	public String toString() {
		return "OrderEvent{" +
				"id='" + id + '\'' +
				", username='" + username + '\'' +
				", price='" + price + '\'' +
				", createdTime='" + createdTime + '\'' +
				'}';
	}
}
