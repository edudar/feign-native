package com.example.feignnative;

import java.util.List;
import java.util.Map;
import java.util.Set;

public record Data(String id, String name, Set<String> sets, List<String> lists, Map<String, String> maps) {
}
