package com.mjc813.swimpool_app.swimpool.apicontroller;

import com.mjc813.swimpool_app.common.ResponseDto;
import com.mjc813.swimpool_app.common.ResponseEnum;
import com.mjc813.swimpool_app.swimpool.dto.SwimpoolDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/swimpool")
public class SwimpoolApiController {

    @GetMapping("/list")
    public ResponseEntity<ResponseDto> list() {
        List<SwimpoolDto> list = new ArrayList<>();
        list.add(new SwimpoolDto(1, "n1", 4, "25", "111", ""));
        list.add(new SwimpoolDto(2, "n2", 6, "50", "222", ""));

        return ResponseEntity.ok(new ResponseDto(ResponseEnum.Success, "OK", list));
    }
}
