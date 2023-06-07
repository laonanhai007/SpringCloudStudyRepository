package com.test.service.impl;

import com.test.entity.Book;
import com.test.entity.Borrow;
import com.test.entity.User;
import com.test.entity.UserBorrowDetail;
import com.test.mapper.BorrowMapper;
import com.test.service.BorrowService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class BorrowServiceImpl implements BorrowService {
    @Resource
    BorrowMapper borrowMapper;
    @Resource
    RestTemplate template;
    @Override
    public UserBorrowDetail getUserBorrowDetailByUid(int uid) {
        List<Borrow> borrow = borrowMapper.getBorrowByUid(uid);
        User user = template.getForObject("http://user-service/user/" + uid, User.class);
        List<Book> bookList = borrow.stream()
                .map(b -> template.getForObject("http://book-service/book/" + b.getBid(), Book.class))
                .toList();
        return new UserBorrowDetail(user,bookList);
    }
}
