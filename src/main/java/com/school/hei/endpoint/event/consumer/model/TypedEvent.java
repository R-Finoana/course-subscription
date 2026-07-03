package com.com.school.endpoint.event.consumer.model;

import com.com.school.PojaGenerated;
import com.com.school.endpoint.event.model.PojaEvent;

@PojaGenerated
public record TypedEvent(String typeName, PojaEvent payload) {}
