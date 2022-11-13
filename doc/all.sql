drop table if exists `test`;
create table `test` (
    `id` bigint not null comment 'id',
    `name` varchar(50) comment '名称',
    `password` varchar(50) comment '密码',
    primary key (`id`)
) engine = innodb default charset=utf8mb4 comment='测试';
drop table if exists `demo`;
create table `demo` (
                        `id` bigint not null comment 'id',
                        `name` varchar(50) comment '名称',
                        `password` varchar(50) comment '密码',
                        primary key (`id`)
) engine = innodb default charset=utf8mb4 comment='测试'
drop table if exists `ebook`;
create table `ebook` (
    `id` bigint not null comment 'id',
    `name` varchar(50) comment '名称',
    `category_1` bigint  comment '分类1',
    `category_2` bigint  comment '分类2',
    `description` varchar(200) comment '描述',
    `cover` varchar(200) comment '封面',
    `doc_count` int comment '文档树',
    `view_count` int comment '阅读树',
    `vote_count` int comment '点赞树',
    primary key (`id`)
) engine = innodb default charset=utf8mb4 comment='电子书';
insert into `ebook` (id, name,description) values (1,'Spring Boot 入门教程','零基础入门java开发,企业级应用,首选框架');
insert into `ebook` (id, name,description) values (2,'Vue 入门教程','零基础入门javascript开发,企业级应用,首选框架');