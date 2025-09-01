package com.mjc813.swimpool_app.user.apicontroller;

import com.mjc813.swimpool_app.common.ResponseDto;
import com.mjc813.swimpool_app.common.ResponseEnum;
import com.mjc813.swimpool_app.common.PageResponseDto;
import com.mjc813.swimpool_app.user.dto.UserDto;
import com.mjc813.swimpool_app.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/user")
public class UserApiController {
    @Autowired
    private UserService UserService;

    // 데이터 목록 + 페이징 출력 RestFull API
    @GetMapping("/list")
    public ResponseEntity<ResponseDto> list(
            @RequestParam(value = "page", required = false) Integer page,
            @RequestParam(value = "row", required = false) Integer row,
            @RequestParam(value = "search", required = false) String search) {
        try {
            long totalRows = UserService.countUsersBySearch(search);

            // DTO만들기 (계산/보정X)
            PageResponseDto result = PageResponseDto.builder()
                    .search(search)
                    .row(row)
                    .page(page)
                    .totalRows(totalRows)
                    .build();

            // 실제 데이터 목록: 반드시 DTO에서 보정된 값 사용!
            List<UserDto> list = UserService.findUsersBySearch(
                    search,
                    result.getRow(),
                    result.getOffset()
            );
            result.setList(list);

            return ResponseEntity.ok(
                    new ResponseDto(ResponseEnum.Success, "OK", result)
            );
        } catch (Throwable e) {
            log.error(e.toString());
            return ResponseEntity.status(500).body(
                    new ResponseDto(ResponseEnum.SelectFail, "Error", e)
            );
        }
    }



    // 데이터 1개를 출력하는 RestFull API
    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto> getOne(@PathVariable Long id) {
        try {
            UserDto one = this.UserService.getOne(id);   // id 번호로 DB 에서 찾아서 리턴해야 한다.
            return ResponseEntity.ok().body(
                    new ResponseDto(ResponseEnum.Success, "OK", one)
                    // ResponseEntity 는 서버의 응답을 json 형식으로 문자열로 응답합니다.
            );
        } catch (Throwable e) {
            log.error(e.toString());
            return ResponseEntity.status(500).body(
                    new ResponseDto(ResponseEnum.SelectFail, "Error", e)
                    // ResponseEntity 는 서버의 응답을 json 형식으로 문자열로 응답합니다.
            );
        }
    }

    // 데이터 1개를 삽입하는 RestFull API
    @PostMapping("register")
    public ResponseEntity<ResponseDto> insert(@RequestBody UserDto dto) {
        try {
            UserDto result = this.UserService.insertUser(dto);   // DB 에 insert 쿼리 실행 결과를 리턴한다.
            return ResponseEntity.ok().body(
                    new ResponseDto(ResponseEnum.Success, "OK", result)
                    // ResponseEntity 는 서버의 응답을 json 형식으로 문자열로 응답합니다.
            );
        } catch (Throwable e) {
            log.error(e.toString());
            return ResponseEntity.status(500).body(
                    new ResponseDto(ResponseEnum.InsertFail, "Error", e)
                    // ResponseEntity 는 서버의 응답을 json 형식으로 문자열로 응답합니다.
            );
        }
    }

    // 데이터 1개를 U 수정하는 RestFull API
    @PatchMapping("/{id}")
    public ResponseEntity<ResponseDto> update(@PathVariable("id") Long id
            , @RequestBody UserDto dto) {
        try {
            dto.setId(id);
            UserDto result = this.UserService.updateUser(dto);   // DB 에 update 쿼리 실행 결과를 리턴한다.
            return ResponseEntity.ok().body(
                    new ResponseDto(ResponseEnum.Success, "OK", result)
                    // ResponseEntity 는 서버의 응답을 json 형식으로 문자열로 응답합니다.
            );
        } catch (Throwable e) {
            log.error(e.toString());
            return ResponseEntity.status(500).body(
                    new ResponseDto(ResponseEnum.UpdateFail, "Error", e)
                    // ResponseEntity 는 서버의 응답을 json 형식으로 문자열로 응답합니다.
            );
        }
    }

    // 데이터 1개를 D 삭제하는 RestFull API
    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto> delete(@PathVariable("id") Long id) {
        try {
            this.UserService.deleteUser(id);   // DB 에 update 쿼리 실행 결과를 리턴한다.
            return ResponseEntity.ok().body(
                    new ResponseDto(ResponseEnum.Success, "OK", null)
                    // ResponseEntity 는 서버의 응답을 json 형식으로 문자열로 응답합니다.
            );
        } catch (Throwable e) {
            log.error(e.toString());
            return ResponseEntity.status(500).body(
                    new ResponseDto(ResponseEnum.DeleteFail, "Error", e)
                    // ResponseEntity 는 서버의 응답을 json 형식으로 문자열로 응답합니다.
            );
        }
    }
}
