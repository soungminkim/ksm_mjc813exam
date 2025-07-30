package com.mjc813.swimpool_app.swimpool.apicontroller;

import com.mjc813.swimpool_app.common.ResponseDto;
import com.mjc813.swimpool_app.common.ResponseEnum;
import com.mjc813.swimpool_app.swimpool.dto.SwimpoolDto;
import com.mjc813.swimpool_app.swimpool.dto.SwimpoolPageResponseDto;
import com.mjc813.swimpool_app.swimpool.service.SwimpoolService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/swimpool")
public class SwimpoolApiController {
    @Autowired
    private SwimpoolService swimpoolService;

    // 데이터 목록 + 페이징 출력 RestFull API
    @GetMapping("/list")
    public ResponseEntity<ResponseDto> list(
            @RequestParam(value = "page", required = false) Integer page,
            @RequestParam(value = "row", required = false) Integer row,
            @RequestParam(value = "search", required = false) String search) {
        try {
            long totalRows = swimpoolService.countBySearch(search);

            // DTO만들기 (계산/보정X)
            SwimpoolPageResponseDto result = SwimpoolPageResponseDto.builder()
                    .search(search)
                    .row(row)
                    .page(page)
                    .totalRows(totalRows)
                    .build();

            // 실제 데이터 목록: 반드시 DTO에서 보정된 값 사용!
            List<SwimpoolDto> list = swimpoolService.findBySearch(
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
    public ResponseEntity<ResponseDto> getOne(@PathVariable Integer id) {
        try {
            SwimpoolDto one = this.swimpoolService.getOne(id);   // id 번호로 DB 에서 찾아서 리턴해야 한다.
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
    @PostMapping("")
    public ResponseEntity<ResponseDto> insert(@RequestBody SwimpoolDto dto) {
        try {
            SwimpoolDto result = this.swimpoolService.insert(dto);   // DB 에 insert 쿼리 실행 결과를 리턴한다.
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
    public ResponseEntity<ResponseDto> update(@PathVariable("id") Integer id
            , @RequestBody SwimpoolDto dto) {
        try {
            SwimpoolDto result = this.swimpoolService.update(dto);   // DB 에 update 쿼리 실행 결과를 리턴한다.
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
    public ResponseEntity<ResponseDto> delete(@PathVariable("id") Integer id) {
        try {
            this.swimpoolService.delete(id);   // DB 에 update 쿼리 실행 결과를 리턴한다.
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
