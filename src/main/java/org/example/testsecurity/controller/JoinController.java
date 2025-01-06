package org.example.testsecurity.controller;

import org.example.testsecurity.dto.JoinDTO;
import org.example.testsecurity.service.JoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class JoinController {

    @Autowired
    private JoinService joinService; //생성자 주입 방식으로 바꿔야함!

    @GetMapping("/join")
    public String joinP() {
        return "join";
    }

    @PostMapping("/joinProc")
    public String joinProcess(JoinDTO joinDTO) {

        //db에 이미 동일한 username을 가진 회원이 존재?

        System.out.println(joinDTO.getUsername());

        joinService.joinProcess(joinDTO);

        //로그인 재설정 return
        return "redirect:/login";
    }
}
