Create Database R_DTH
go
use R_DTH

go
create table tbl_admin(
	adminID int primary key,
	adminName nvarchar(100),
	adminPass nvarchar(100)
)

go
create table tbl_FAQ(
	faqID int primary key,
	faqQuestion ntext,
	faqAnswer ntext
)

go
create table tbl_user(
	userID int primary key,
	userPass nvarchar(100),
	cardNumber nvarchar(100)
)
go
create table tbl_package
(
	packageID int primary key,
	packageName nvarchar(100),
	packagePrice float,
	packageDetail ntext,
)
go
test commit alo alo
