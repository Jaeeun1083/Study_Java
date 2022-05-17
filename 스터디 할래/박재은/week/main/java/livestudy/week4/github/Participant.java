package com.livestudy.week4.github;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class Participant {

    String userName;
    Map<Integer, Boolean> ParticipatedResult;

    public Participant(String userName) {
        this.userName = userName;
        ParticipatedResult = new HashMap<>();
    }

    public void hasParticipated(int index) {
        this.ParticipatedResult.put(index, true);
    }

    public Double getRate(int total) {

        long count = ParticipatedResult.values().stream().filter(value -> value).count();
        double rate = count * 100 / total;

        return Double.parseDouble(String.format("%.2f",rate));
    }
}
