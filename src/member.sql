drop table member;
select * from member;
create table member
(
    id varchar2(20) primary key,
    pwd varchar2(20),
    email varchar2(20),
    age number(4),
    regdate date
);

commit;


select * from
    (
        select m.*, rownum rnum from
            (
                select * from member order by regdate desc
            )m
    )where rnum>=#{startRow} and rnum<=#{endRow};

