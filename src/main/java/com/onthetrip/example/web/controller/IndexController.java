package com.onthetrip.example.web.controller;

import com.google.common.collect.Lists;
import com.onthetrip.example.web.controller.view.ApiResponse;
import com.onthetrip.example.web.controller.view.TronHistory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Slf4j
@Controller
public class IndexController {
    private List<TronHistory> tronHistories = Lists.newArrayList(
        new TronHistory(1, "tron01"),
            new TronHistory(2, "tron02"),
            new TronHistory(3, "tron03"),
            new TronHistory(4, "tron04")
    );

    @GetMapping
    public ModelAndView index() {
        ModelAndView mnv = new ModelAndView("index");
        return mnv;
    }

    @GetMapping("/api/tron/history")
    @ResponseBody
    public ApiResponse<List<TronHistory>> getTronHistory(@RequestParam(required = false) String id) {
        log.info("tron id: {}", id);
        return ApiResponse.success(this.tronHistories);
    }
}
