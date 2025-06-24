package com.familycircle.controller;

import com.familycircle.model.Gratitude;
import com.familycircle.model.User;
import com.familycircle.service.GratitudeService;
import com.familycircle.service.BondingPointService;
import com.familycircle.service.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Controller
@RequestMapping("/gratitude")
public class GratitudeController {

    @Autowired
    private GratitudeService gratitudeService;

    @Autowired
    private BondingPointService bondingPointService;

    @GetMapping
    public String showGratitudeForm(Model model) {
        model.addAttribute("gratitude", new Gratitude());
        return "gratitude";
    }

    @PostMapping
    public String submitGratitude(@ModelAttribute("gratitude") Gratitude gratitude,
                                  @AuthenticationPrincipal UserDetailsImpl userDetails) {
        User currentUser = userDetails.getUser();
        gratitude.setUser(currentUser);
        gratitude.setDate(LocalDate.now());
        gratitude.setTime(LocalTime.now());
        gratitudeService.saveGratitude(gratitude);

        bondingPointService.addPoints(currentUser, 10, "Wrote Gratitude");
        return "redirect:/home";
    }

    @GetMapping("/history")
    public String gratitudeHistory(Model model,
                                   @AuthenticationPrincipal UserDetailsImpl userDetails) {
        User currentUser = userDetails.getUser();
        List<Gratitude> gratitudes = gratitudeService.getGratitudesForUser(currentUser);
        model.addAttribute("gratitudes", gratitudes);
        return "gratitude-history";
    }
}
