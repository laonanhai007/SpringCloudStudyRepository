package com.test.controller;

import com.test.entity.UserBorrowDetail;
import com.test.service.BorrowService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BorrowController {

    @Resource
    BorrowService borrowService;

    @GetMapping("/borrow/{uid}")
    UserBorrowDetail findUserBorrows(@PathVariable("uid") int uid){
        return borrowService.getUserBorrowDetailByUid(uid);
    }
}
