package com.familycircle.controller;

import com.familycircle.dto.MoodDTO;
import com.familycircle.dto.MoodFormDTO;
import com.familycircle.model.Mood;
import com.familycircle.model.User;
import com.familycircle.service.MoodService;
import com.familycircle.service.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/mood")
public class MoodController {

    @Autowired
    private MoodService moodService;

    @GetMapping
    public String showMoodForm(Model model) {
        model.addAttribute("moodForm", new MoodFormDTO());
        model.addAttribute("moodOptions", List.of("Happy", "Excited", "Bored", "Sad", "Angry"));
        return "mood";
    }

    @PostMapping
    public String submitMood(@ModelAttribute("moodForm") MoodFormDTO form,
                             @AuthenticationPrincipal UserDetailsImpl userDetails) {
        try {
            Mood mood = new Mood();
            mood.setMood(form.getMood());
            mood.setUser(userDetails.getUser());
            mood.setDate(LocalDate.now());
            mood.setTimestamp(LocalDateTime.now());

            moodService.saveMood(mood);
            return "redirect:/home";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/mood?error=true";
        }
    }

    @GetMapping("/history")
    public String moodHistory(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        User currentUser = userDetails.getUser();
        List<MoodDTO> moodList = moodService.getMoodsForUser(currentUser)
                .stream()
                .map(m -> new MoodDTO(
                        m.getDate(),
                        m.getMood(),
                        m.getTimestamp(),
                        mapMoodToIndex(m.getMood())
                ))
                .collect(Collectors.toList());

        model.addAttribute("moods", moodList);
        return "mood-history";
    }

    @GetMapping("/chart")
    public String moodChart(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        User currentUser = userDetails.getUser();
        List<MoodDTO> moodList = moodService.getMoodsForUser(currentUser)
                .stream()
                .map(m -> new MoodDTO(
                        m.getDate(),
                        m.getMood(),
                        m.getTimestamp(),
                        mapMoodToIndex(m.getMood())
                ))
                .collect(Collectors.toList());

        model.addAttribute("moods", moodList);
        return "mood-chart";
    }

    private int mapMoodToIndex(String mood) {
        return switch (mood) {
            case "Happy" -> 5;
            case "Excited" -> 4;
            case "Bored" -> 3;
            case "Sad" -> 2;
            case "Angry" -> 1;
            default -> 0;
        };
    }
}
