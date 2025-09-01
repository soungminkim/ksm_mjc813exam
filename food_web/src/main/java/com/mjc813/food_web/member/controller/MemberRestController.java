package com.mjc813.food_web.member.controller;

import com.mjc813.food_web.common.CommonRestController;
import com.mjc813.food_web.common.ResponseCode;
import com.mjc813.food_web.common.ResponseDto;
import com.mjc813.food_web.common.exception.MyDataNotFoundException;
import com.mjc813.food_web.common.exception.MyRequestException;
import com.mjc813.food_web.member.dto.IMember;
import com.mjc813.food_web.member.dto.MemberDto;
import com.mjc813.food_web.member.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/member")
public class MemberRestController  extends CommonRestController {
    @Autowired
    private MemberService memberService;

    @PostMapping("")
    public ResponseEntity<ResponseDto> insert(
            @Validated @RequestBody MemberDto dto
    ) {
        try {
            IMember iMember = this.memberService.insert(dto);
            return this.getReponseEntity(ResponseCode.SUCCESS, "OK", iMember, null);
        } catch (MyRequestException e) {
            log.error(e.toString());
            return this.getReponseEntity(ResponseCode.REQUEST_FAIL, e.getMessage(), dto, e);
        } catch (Throwable th) {
            log.error(th.toString());
            return this.getReponseEntity(ResponseCode.INSERT_FAIL, "Error", dto, th);
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ResponseDto> update(
            @PathVariable Long id
            , @Validated @RequestBody MemberDto dto
    ) {
        try {
            IMember iMember = this.memberService.update(dto);
            return this.getReponseEntity(ResponseCode.SUCCESS, "OK", iMember, null);
        } catch (MyRequestException e) {
            log.error(e.toString());
            return this.getReponseEntity(ResponseCode.REQUEST_FAIL, e.getMessage(), dto, e);
        } catch (MyDataNotFoundException e) {
            log.error(e.toString());
            return this.getReponseEntity(ResponseCode.NOTFOUND_FAIL, e.getMessage(), dto, e);
        } catch (Throwable th) {
            log.error(th.toString());
            return this.getReponseEntity(ResponseCode.UPDATE_FAIL, "Error", dto, th);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto> delete(
            @PathVariable Long id
    ) {
        try {
            Boolean bResult = this.memberService.deleteById(id);
            return this.getReponseEntity(ResponseCode.SUCCESS, "OK", bResult, null);
        } catch (MyRequestException e) {
            log.error(e.toString());
            return this.getReponseEntity(ResponseCode.REQUEST_FAIL, e.getMessage(), id, e);
        } catch (MyDataNotFoundException e) {
            log.error(e.toString());
            return this.getReponseEntity(ResponseCode.NOTFOUND_FAIL, e.getMessage(), id, e);
        } catch (Throwable th) {
            log.error(th.toString());
            return this.getReponseEntity(ResponseCode.DELETE_FAIL, "Error", id, th);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto> findById(@PathVariable Long id) {
        try {
            IMember find = this.memberService.findById(id);
            return this.getReponseEntity(ResponseCode.SUCCESS, "OK", find, null);
        } catch (MyRequestException e) {
            log.error(e.toString());
            return this.getReponseEntity(ResponseCode.REQUEST_FAIL, e.getMessage(), id, e);
        } catch (MyDataNotFoundException e) {
            log.error(e.toString());
            return this.getReponseEntity(ResponseCode.NOTFOUND_FAIL, e.getMessage(), id, e);
        } catch (Throwable th) {
            log.error(th.toString());
            return this.getReponseEntity(ResponseCode.SELECT_FAIL, "Error", id, th);
        }
    }

    @GetMapping("")
    public ResponseEntity<ResponseDto> findAll() {
        try {
            List<MemberDto> all = this.memberService.findAll();
            return this.getReponseEntity(ResponseCode.SUCCESS, "OK", all, null);
        } catch (Throwable th) {
            log.error(th.toString());
            return this.getReponseEntity(ResponseCode.SELECT_FAIL, "Error", null, th);
        }
    }

    @GetMapping("/search")
    public ResponseEntity<ResponseDto> findBySearch(
            @RequestParam("username") String username
            , @RequestParam("nickName") String nickName
            , @RequestParam("role") String role
            , @PageableDefault(size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        try {
            Page<MemberDto> pageList = this.memberService.findByUsernameContainsAndNickNameContains(username, nickName, role, pageable);
            return this.getReponseEntity(ResponseCode.SUCCESS, "OK", pageList, null);
        } catch (MyRequestException e) {
            log.error(e.toString());
            return this.getReponseEntity(ResponseCode.REQUEST_FAIL, e.getMessage(), null, e);
        } catch (Throwable th) {
            log.error(th.toString());
            return this.getReponseEntity(ResponseCode.SELECT_FAIL, "Error", null, th);
        }
    }
}
