package com.mjc813.food_web.common;

import com.mjc813.food_web.common.dto.FileTestDto;
import com.mjc813.food_web.food.dto.FoodIngsResponseDto;
import com.mjc813.food_web.food.service.FoodJpaTransactionService;
import com.mjc813.food_web.member.dto.MemberDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Slf4j
@Controller
public class MenuController {
    @Autowired
    private ResourceLoader resourceLoader;

    @Autowired
    private FoodJpaTransactionService foodJpaTransactionService;

    @GetMapping("/food_category")
    public String menuFoodCategory() {
        return "/food/food_category";
    }

    @GetMapping("/ingredient_category")
    public String menuIngredientCategory() {
        return "/food/ingredient_category";
    }

    @GetMapping("/ingredient")
    public String menuIngredient() {
        return "/food/ingredient";
    }

    @GetMapping("/food")
    public String menuFood() {
        return "/food/food";
    }

    @GetMapping("/member")
    public String member() {
        return "member/members";
    }

    @GetMapping("/signpage")
    public String everyone(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if ( authentication.getPrincipal() instanceof MemberDto ) {
            MemberDto loginUser = (MemberDto) authentication.getPrincipal();
            model.addAttribute("loginUser", loginUser);
        } else {
            model.addAttribute("loginUser", null);
        }
        return "signpage/home";
    }

    @GetMapping("/main")
    public String mainHome(Model model) {
        try {
            List<FoodIngsResponseDto> all = this.foodJpaTransactionService.getFoodsAndIngredientList();
            model.addAttribute("foodList", all);
            return "main/home";
        } catch ( Throwable e ) {
            return "error/500";
        }
    }

    @GetMapping("/file_mpa")
    public String fileMpa() {
        return "/file/filetest";
    }

    @PostMapping("/file/upload_mpa")    // SpringBoot 파일업로드 기본, MPA 방식
    public String updloadMpa(Model model, @ModelAttribute FileTestDto fileTestDto) throws IOException {
        if( fileTestDto == null ) {
            return "redirect:/file_mpa";
        }
        log.debug("fileTestdto.username = {}", fileTestDto.getUsername());
        log.debug("fileTestdto.profilePicture = {}", fileTestDto.getProfilePicture().size());

        Resource resource = resourceLoader.getResource("classpath:static/images");
        String uploadDir = resource.getFile().getPath();
        List<MultipartFile> result = new ArrayList<>();
        for ( MultipartFile mf : fileTestDto.getProfilePicture() ) {
            if ( mf == null || Objects.requireNonNull(mf.getOriginalFilename()).isEmpty() ) {
                continue;
            }
            Path copyLocation = Paths.get(uploadDir + "/" + mf.getOriginalFilename());
            Files.copy(mf.getInputStream(), copyLocation, StandardCopyOption.REPLACE_EXISTING);
            result.add(mf);
        }
        fileTestDto.setProfilePicture(result);
        model.addAttribute("templateFilePrint", fileTestDto);
        return "/file/filedone";
    }
}
