package com.test.mapper;

import com.test.entity.Borrow;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BorrowMapper {
    @Select("select * from db_borrow where uid = #{uid}")
    List<Borrow> getBorrowByUid(int uid);

    @Select("select * from db_borrow where bid = #{bid}")
    List<Borrow> getBorrowByBid(int bid);

    @Select("select * from db_borrow where bid=#{bid} and uid = #{uid}")
    Borrow getBorrow(int uid, int bid);
}
