package com.max.alfabanktesttask;

import lombok.Data;

import java.util.List;


@Data
public class MyObject {
    String s;
    List<String> values;

    public MyObject(List<String> values) {
        this.values = values;
    }
}
