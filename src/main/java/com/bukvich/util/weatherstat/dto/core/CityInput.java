package com.bukvich.util.weatherstat.dto.core;

import java.util.UUID;

public record CityInput(UUID publicId, String name, String region, String country) {}
