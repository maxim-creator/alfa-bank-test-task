package com.max.alfabanktesttask;

import java.util.LinkedHashMap;
import java.util.Map;

public class MapConverter {
    public Map<String, Double> toStringDoubleMap(Map<String, ? extends Comparable<?>> map){
        Map<String, Double> doubleValues = new LinkedHashMap<>();
        for(Map.Entry<String, ? extends Comparable<?>> entry: map.entrySet()){
            doubleValues.put(entry.getKey(), Double.valueOf(String.valueOf(entry.getValue())) );
        }
        return doubleValues;
    }
}
