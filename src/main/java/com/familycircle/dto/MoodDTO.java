package com.familycircle.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class MoodDTO {

    private LocalDate date;
    private String mood;
    private LocalDateTime timestamp;
    private int moodValue;

    public MoodDTO(LocalDate date, String mood, LocalDateTime timestamp, int moodValue) {
        this.date = date;
        this.mood = mood;
        this.timestamp = timestamp;
        this.moodValue = moodValue;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getMood() {
        return mood;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public int getMoodValue() {
        return moodValue;
    }

    // ✅ Add this for Chart.js to read moodIndex
    public int getMoodIndex() {
        return this.moodValue;
    }
}
