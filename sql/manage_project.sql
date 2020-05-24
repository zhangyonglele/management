-- admin const value
insert into admin_const_data values ('fineRate',1.0,1,now());
insert into admin_const_data values ('returnPeriod',30,1,now());

create table favorite_book(
    `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户唯一标识符',
    `book_info_id` int(11) NOT NULL COMMENT '书基本信息id',
    primary key (user_id,book_info_id),
    foreign key (user_id) references user(user_id),
    foreign key (book_info_id) references book_info(book_info_id)
)
