package com.fastcampus.springboottoyboard.controller;

import com.fastcampus.springboottoyboard.dto.ProductJoinResult;
import com.fastcampus.springboottoyboard.service.ProductJoinResultService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/api/v1.0.0")
public class ProductJoinResultController {
    private final ProductJoinResultService productJoinResultService;
    ProductJoinResultController(ProductJoinResultService productJoinResultService) {
        this.productJoinResultService = productJoinResultService;
    }

    @GetMapping("jdbc")
    private String getAllByJDBC(Model model) {
        List<Long> timeList = new ArrayList<>();

        for (int i = 0; i < 15; i++) {
            Long startTime = System.currentTimeMillis();
            List<ProductJoinResult> __ = productJoinResultService.getAllByJDBC();
            Long endTime = System.currentTimeMillis();
            timeList.add(endTime - startTime);
        }

        List<ProductJoinResult> result = productJoinResultService.getAllByJDBC();

        model.addAttribute("result", result);
        model.addAttribute("count", result.size());
        model.addAttribute("timeList", timeList);
        return "JdbcProduct";
    }

    @GetMapping("jpa")
    private String getAllByJPA(Model model) {
        List<Long> timeList = new ArrayList<>();

        for (int i = 0; i < 15; i++) {
            Long startTime = System.currentTimeMillis();
            List<Object[]> __ = productJoinResultService.getAllByJPA();
            Long endTime = System.currentTimeMillis();
            timeList.add(endTime - startTime);
        }

        List<Object[]> result = productJoinResultService.getAllByJPA();

        model.addAttribute("result", result);
        model.addAttribute("count", result.size());
        model.addAttribute("timeList", timeList);

        return "JpaProduct";
    }
    @GetMapping("spring_data_jpa")
    private String getAllBySpringDataJPA(Model model) {
        List<Long> timeList = new ArrayList<>();

        for (int i = 0; i < 15; i++) {
            Long startTime = System.currentTimeMillis();
            List<Object[]> __ = productJoinResultService.getAllBySpringDataJPA();
            Long endTime = System.currentTimeMillis();
            timeList.add(endTime - startTime);
        }

        List<Object[]> result = productJoinResultService.getAllBySpringDataJPA();

        model.addAttribute("result", result);
        model.addAttribute("count", result.size());
        model.addAttribute("timeList", timeList);

        return "SpringDataJpaProduct";
    }
}
