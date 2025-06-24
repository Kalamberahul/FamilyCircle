package com.familycircle.controller;

import com.familycircle.model.BondingPoint;
import com.familycircle.model.User;
import com.familycircle.service.BondingPointService;
import com.familycircle.service.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/points")
public class BondingPointController {

    @Autowired
    private BondingPointService bondingPointService;

    @GetMapping("/history")
    public String showBondingPoints(@AuthenticationPrincipal UserDetailsImpl userDetails, Model model) {
        User currentUser = userDetails.getUser();
        List<BondingPoint> pointsList = bondingPointService.getPointsForUser(currentUser);

        // Calculate total points
        int totalPoints = pointsList.stream().mapToInt(BondingPoint::getPoints).sum();

        model.addAttribute("pointsList", pointsList);
        model.addAttribute("totalPoints", totalPoints);

        return "bonding-point-history";
    }
}
