package com.mjc813.mpacrud.animal.controller;

import com.mjc813.mpacrud.animal.dto.AnimalDto;
import com.mjc813.mpacrud.animal.dto.SearchRequestDto;
import com.mjc813.mpacrud.animal.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/animal")
public class AnimalController {
//    @Autowired
//    private AnimalMybatisMapper animalMapper; // 이 밥법은 사용 가능하더라도 추천하지 않는다.
    @Autowired
    private AnimalService animalService;

    @GetMapping("/a")    // 클라이언트의 요청 url 주소와 method
    public String testA(Model model
        , @RequestParam("name1") String name1   // @RequestParam : http 클라이언트에서 보낸 변수=값 형태를 받아들일수 있다.
        , @RequestParam("name2") String name2
        , @RequestParam("n3") String nm3
    ) {
        model.addAttribute("name1", name1); // 화면텝플릿의 name1 이라는 키단어를 name1 변수값으로 치환한다.
        model.addAttribute("name2", name2); // 화면텝플릿의 name2 이라는 키단어를 name2 변수값으로 치환한다.
        model.addAttribute("nam3", nm3); // 화면텝플릿의 nam3 이라는 키단어를 nm3 변수값으로 치환한다.
        return "/a";    // src/main/resources/ 화면템플릿 root 폴더 기준의 a.html 파일 전체 경로 (화면)
    }

    @GetMapping("/{name1}/{name2}/{n3}")    // 클라이언트의 요청 url 주소와 method
    public String testB(Model model
            , @PathVariable("name1") String name1   // @RequestParam : http 클라이언트에서 보낸 변수=값 형태를 받아들일수 있다.
            , @PathVariable("name2") String name2
            , @PathVariable("n3") String nm3
    ) {
        model.addAttribute("name1", name1); // 화면텝플릿의 name1 이라는 키단어를 name1 변수값으로 치환한다.
        model.addAttribute("name2", name2); // 화면텝플릿의 name2 이라는 키단어를 name2 변수값으로 치환한다.
        model.addAttribute("nam3", nm3); // 화면텝플릿의 nam3 이라는 키단어를 nm3 변수값으로 치환한다.
        return "/a";    // src/main/resources/ 화면템플릿 root 폴더 기준의 a.html 파일 전체 경로 (화면)
    }

    @GetMapping("/addview")
    public String addView() {
        return "/animal/addview";
    }

    @PostMapping("/insert")
    public String insert(
//            @RequestParam("name") String name   // @RequestParam : http 클라이언트에서 보낸 변수=값 형태를 받아들일수 있다.
//            , @RequestParam("age") Integer age    // POST 방식의 데이터 전달은 @ModealAttribute 로 받을 수 있으므로 이 방식은 추천하지 않는다.
//            , @RequestParam("kind") String kind
            @ModelAttribute AnimalDto animal
    ) {
        // 화면에서 전달 받은 값이 유효한지 valid 체크 해야한다.
        // 화면에서 받은 값을 DB 까지 저장해야 한다.

//        AnimalDto animal = AnimalDto.builder()
//                .name(name)
//                .kind(kind).build();
//        AnimalDto animal2 = new AnimalDto(0L, name, age, kind);
//          추천하지 않는 방식을 사용할려면 new 인스턴스 필요함.
//        this.animalMapper.insertAnimal(animal);   // mybatis 매퍼를 바로 호출하는 방법은 추천 하지 않는다.

        try {
            this.animalService.insert(animal);
        } catch (Throwable th) {
            System.err.println(th.toString());
        }
        return "redirect:./list?searchType=name&searchWord=";
    }

    @GetMapping("/list")
    public String list(Model model
            , @RequestParam("searchType") @DefaultValue("name") String searchType
            , @RequestParam("searchWord") @DefaultValue("") String searchWord) {
        try {
            SearchRequestDto searchRequestDto = new SearchRequestDto(searchType, searchWord);
            List<AnimalDto> all = this.animalService.findWhere(searchRequestDto);
//            List<AnimalDto> all = this.animalService.findAll();
            model.addAttribute("listWord", all);
        } catch (Throwable e) {
            System.err.println(e.toString());
        }
        return "/animal/list";
    }

    @GetMapping("/view")
    public String view1(Model model
            , @RequestParam("id") Long id) {
        try {
            AnimalDto byId = this.animalService.findById(id);
            model.addAttribute("data", byId);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return "/animal/view";
    }

    @GetMapping("/modify")
    public String modify(Model model
            , @RequestParam("id") Long id) {
        try {
            AnimalDto byId = this.animalService.findById(id);
            model.addAttribute("data", byId);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return "/animal/modify";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute AnimalDto dto) {
        try {
            this.animalService.update(dto);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return "redirect:./list?searchType=name&searchWord=";
    }

    @PostMapping("/delete")
    public String delete(Long id) {
        try {
            this.animalService.delete(id);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return "redirect:./list?searchType=name&searchWord=";
    }
}
