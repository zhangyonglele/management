-- admin const value
insert into admin_const_data values ('borrow_days',30,1,now());
insert into admin_const_data values ('fine_number',30,1,now());
insert into admin_const_data values ('permit_number',15,1,now());

create table favorite_book(
    `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '�û�Ψһ��ʶ��',
    `book_info_id` int(11) NOT NULL COMMENT '�������Ϣid',
    primary key (user_id,book_info_id),
    foreign key (user_id) references user(user_id),
    foreign key (book_info_id) references book_info(book_info_id)
)
