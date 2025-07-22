package com.mjc813.contact_web;

import com.mjc813.contact_web.dto.Contact;
import com.mjc813.contact_web.service.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/contact")
public class ContactController {
    @Autowired
    private ContactRepository contactRepository;

    @GetMapping("/add")
    public String addView() {
        return "contact/add";
    }

    @GetMapping("/list")
    public String listView(Model md) {
        List<Contact> arraylist = contactRepository.selectAll();
        md.addAttribute("contact_tbl", arraylist);
        return "contact/list";
    }

    @PostMapping("/addconfirm")
    public String addConfirm(@ModelAttribute Contact inputContact) {
        try {
            System.out.printf("DB insert 전 : %s\n", inputContact.getContactFullInfo());
            contactRepository.insert(inputContact);
            System.out.printf("DB insert 후 : %s\n", inputContact.getContactFullInfo());
        } catch (Throwable e) {
            System.out.println(e.toString());
        }
        return "redirect:/";
    }

    @GetMapping("/view")
    public String view(@RequestParam("id") Long id, Model model) {
        try {
            Contact result = this.contactRepository.selectOne(id);
            model.addAttribute("contact", result);
        } catch (Throwable e) {
            System.out.println(e.toString());
        }
        return "/contact/view";
    }

    @GetMapping("/modify")
    public String modify(@RequestParam("id") Long id, Model model) {
        try {
            Contact result = this.contactRepository.selectOne(id);
            model.addAttribute("dto", result);
        } catch (Throwable e) {
            System.out.println(e.toString());
        }
        return "/contact/modify";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Contact dto) {
        try {
            // sql 의 update 문장을 실행한다.
            this.contactRepository.update(dto);
        } catch (Throwable e) {
            System.out.println(e.toString());
        }
        return "redirect:./list";// 정상 실행하면 redirect:/contact/list
    }
}
