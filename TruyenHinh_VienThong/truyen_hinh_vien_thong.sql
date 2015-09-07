-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Sep 07, 2015 at 07:06 AM
-- Server version: 5.6.21
-- PHP Version: 5.6.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `truyen_hinh_vien_thong`
--

-- --------------------------------------------------------

--
-- Table structure for table `dealer`
--

CREATE TABLE IF NOT EXISTS `dealer` (
`id` int(11) NOT NULL,
  `username` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `password` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `name` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `sex` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `email` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `phone` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `address` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `mien` varchar(20) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `dealer`
--

INSERT INTO `dealer` (`id`, `username`, `password`, `name`, `sex`, `email`, `phone`, `address`, `mien`) VALUES
(1, 'tien', 'minhlatien', 'Phan Tien Tung', 'Nam', 'nguyenvantien6789@gmail.com', '078954287', 'Ha Noi', 'bac'),
(2, 'minh', 'minhlaminh', 'Pham Minh', 'Nam', 'minh@gmail.com ', '0904878532', 'Vinh ', 'trung'),
(3, 'dat', 'minhladat', 'Nguyen Dat', 'Nam', 'dat6789@gmail.com ', '09784125888', 'Vung Tau ', 'nam'),
(4, 'vu', 'minhlavu', 'Nguyen Vu', 'Nam', 'vu6789@gmail.com', '0165332170', 'Ha Noi', 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `dich_vu`
--

CREATE TABLE IF NOT EXISTS `dich_vu` (
`id` int(11) NOT NULL,
  `ten_dich_vu` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `gia` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `mo_ta` text COLLATE utf8_unicode_ci,
  `dealer_id` int(11) DEFAULT NULL,
  `trang_thai` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `vung` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `dich_vu`
--

INSERT INTO `dich_vu` (`id`, `ten_dich_vu`, `gia`, `mo_ta`, `dealer_id`, `trang_thai`, `vung`) VALUES
(1, 'Goi SD+ Phim truyen va The thao', '100000', '163 Kenh truyen trinh chuan SD tot nhat cua dia phuong, danh cho nguoi ham mo the thao, xem phim tai nha', 1, 'accepted', 'bac'),
(2, 'Goi SD+ Sieu gia tri', '120000', 'Hon 172 Kenh truyen hinh chuan SD bao gom tat ca tin tuc va giai tri', 1, 'accepted', 'bac'),
(3, 'Goi SD+ The gioi', '140000', 'Hon 167 Kenh truyen hinh chuan SD bao gom cac kenh giai tri, giao duc, phim truyen, the thao tren khap the gioi', 1, 'accepted', 'bac'),
(4, 'Goi SD+ Sieu Khuyen Mai', '150000', 'Hon 208 Kenh truyen hinh chuan SD bao gom phim truyen, ca nhac, thong tin kinh te, thoi su, the thao, giai tri, tuong tac nguoi dung ...khong gioi han tren toan the gioi', 1, 'accepted', 'bac'),
(5, 'Goi HD+ Sieu gia tri', '200000', 'Hon 178 kenh chuan HD bao gom cac thong tin thoi su va giai tri ', 2, 'accepted', 'trung'),
(6, 'Goi HD+ The gioi', '250000', 'Hon 178 kenh truyen hinh chuan HD bao gom cac kenh giai tri, giao duc, dinh huong, xem phim, the thao tren toan the gioi ', 3, 'accepted', 'nam'),
(7, 'Goi HD+ Sieu Khuyen Mai', '300000', 'Hon 210 kenh chuan HD bao gom cac kenh thoi su, thong tin kinh te, giai tri, ca nhac, thoi trang, khoa hoc, phim truyen, giao duc, tre em... vo cung dac sac', 3, 'accepted', 'nam'),
(8, 'Goi HD+ Giai tri', '200000', 'Hon 178 kenh truyen hinh chuan HD bao gom cac kenh giai tri, ca nhac, thoi trang, phim truyen, the thao song dong', 2, 'accepted', 'trung');

-- --------------------------------------------------------

--
-- Table structure for table `fqa`
--

CREATE TABLE IF NOT EXISTS `fqa` (
`id` int(11) NOT NULL,
  `question` text COLLATE utf8_unicode_ci,
  `answer` text COLLATE utf8_unicode_ci,
  `username` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `status` varchar(10) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `fqa`
--

INSERT INTO `fqa` (`id`, `question`, `answer`, `username`, `status`) VALUES
(1, 'Khái niệm truyền hình DTH?', '(Direct – To – Home) thuật ngữ chính thức của ngành công nghiệp truyền hình và truyền hình vệ tinh. DTH là phương thức nhận tín hiệu truyền trực tiếp từ vệ tinh bằng cách sử dụng một chảo thu cá nhân, đầu thu giải mã và thiết bị chuyển đổi tín hiệu LNB.\r\nBan đầu DTH được phát triển nhằm kết nối các khu vực xa xôi nơi truyền hình cáp không vươn tới được, đến nay công nghệ này với chất lượng hình ảnh và âm thanh vượt trội so với truyền hình cáp đang ngày càng trở nên phổ biến trên toàn thế giới.', '0', 'finish'),
(2, 'Tôi muốn tìm thông tin danh sách kênh?', 'Hiện tại chúng tôi có vô số các kênh được đặt ở các gói. Mời quý khách lựa chọn Các gói dịch vụ để biết thêm thông tin chi tiết', '0', 'finish'),
(3, 'Tôi có thể tìm thấy đại lý DTH ở đâu?', 'Mạng lưới phân phối DTH trải rộng toàn quốc bao gồm:\r\n• 14 Showroom trưng bày và bán hàng DTH tại các thành phố lớn như Hà Nội, Hải Phòng, Hạ Long, Vinh, Đà Nẵng, Cần Thơ, Hồ Chí Minh;\r\n• Trên 2000 đại lý chính thức ở khắp 63 tỉnh và thành phố. Gọi 1900 1592 hoặc nhấn vào ĐÂY để tìm đại lý gần nhà bạn nhất.\r\n• Trên 80 siêu thị danh tiếng trải rộng trên cả nước như Pico Plaza, Media Mart, HC, Metro, Big C, Việt Long, Phan Khang, ...;\r\n• Các điểm phân phối thẻ cào DTH như:\r\nMạng lưới siêu thị công nghệ di động Viễn Thông A nằm ở nhiều tỉnh, thành phố', '0', 'finish'),
(4, 'Quy định về việc Bảo hành thiết bị của DTH?', 'I. Thiết bị được bảo hành là Đầu thu mới và Thẻ giải mã mới do DTH cung cấp.\r\n\r\nII. Thời gian bảo hành: 12 tháng tính từ ngày kích hoạt thuê bao đầu tiên theo hệ thống quản lý thuê bao của DTH.\r\nIII. Địa điểm nhận bảo hành: Trạm bảo hành do DTH ủy quyền (tham khảo câu hỏi số 1 trong mục FAQ/ Lắp đặt - Bảo hành)\r\n- Thiết bị trong điều kiện bảo hành là thiết bị có lỗi phát sinh do lỗi của Nhà sản xuất và trong thời hạn bảo hành.\r\n- Thiết bị ngoài điều kiện bảo hành là thiết bị hết thời hạn bảo hành hoặc trong thời hạn bảo hành nhưng lỗi do người sử dụng gây ra (chập điện, nước đổ vào, mở tem niêm phong, đầu thu biến dạng… ) hoặc do các nguyên nhân khách quan khác (thiên tai, lũ lụt, cháy nổ… ).\r\n- Chính sách bảo hành theo Hợp đồng thuê bao cá nhân không được áp dụng cho các trường hợp sau:\r\n1. Thiết bị được bảo hành đã bị quản lý kém, sử dụng không đúng cách hoặc bị sửa đổi hoặc bị sửa chữa bởi khách hàng hoặc bất kỳ bên nào không được DTH ủy quyền;\r\n2. Việc bảo trì kỹ thuật bên trong Thiết bị được bảo hành do người sử dụng và/ hoặc bên thứ ba chưa được DTH chấp thuận thực hiện;\r\n3. Thiết bị được bảo hành bị người sử dụng hoặc bất kỳ người nào khác không được DTH ủy quyền làm thay đổi hoặc cố gắng sửa chữa nên làm cho Thiết bị được bảo hành bị hỏng;\r\n4. Chính sách bảo hành không bao gồm các hoạt động bảo trì định kỳ, chuyển đổi hoặc thay thế phụ kiện do hao mòn tự nhiên;\r\n5. Thiết bị được bảo hành bị hỏng do sự cố, sự kiện bất khả kháng, thay đổi về cấu trúc Thiết bị được bảo hành so với cấu trúc ban đầu của nhà sản xuất;\r\n6. Thiết bị được bảo hành không phải do DTG cung cấp;\r\n7. Sử dụng không đúng cách hoặc sử dụng hoặc lắp Thiết bị được bảo hành không theo tài liệu hướng dẫn sử dụng Thiết bị được bảo hành;\r\n8. “Tem bảo hành” không được gắn/ bị bong/ bị rách hoặc ”Tem bảo hành” giả được gắn trên đầu thu tại thời điểm nhận đầu thu tại Trung tâm bảo hành của DTH;\r\n9. Số seri của Thiết bị được bảo hành đã bị gỡ bỏ hoặc mờ;\r\n10. Bảo quản Thiết Bị được bảo hành trong điều kiện không phù hợp (trừ khi việc bảo quản đó là do DTH hoặc một trong các Đại lý bán lẻ của DTH);\r\n11. Ảnh hưởng trực tiếp của sét đánh.\r\nV. Hình thức bảo hành:\r\n- Các thiết bị là đầu thu hỏng trong và ngoài phạm vi bảo hành đều được đổi thay thế bằng một Đầu thu DTH khác đã qua sử dụng, có hình thức tương đương và đảm bảo chất lượng do DTH thẩm định.\r\n- Thẻ giải mã sẽ được đổi thay thế bằng thẻ mới.', '0', 'finish'),
(5, 'Tôi có thể mang thiết bị hỏng đến đâu ngoài các trạm bảo hành?', 'Ngoài các trạm bảo hành DTH, khách hàng nên mang thiết bị hỏng tới đại lý chính thức của DTH gần nhất để được kiểm tra và sửa chữa. Gọi 1900 1592 hoặc nhấn vào đây để tìm đại lý gần nhất.\r\n', '0', 'finish'),
(6, 'Khiếu nại là gì?', 'Đối với DTH và khách hàng của DTH hay cá nhân/tổ chức sử dụng sản phẩm và/hoặc dịch vụ do DTH cung cấp tại Việt Nam, khiếu nại là bất kỳ câu hỏi/yêu cầu/phản hồi nào của khách hàng khi khách hàng cho rằng DTH đã vi phạm các quyền của khách hàng, được:\r\n- quy định trong các thỏa thuận/hợp đồng đã ký kết giữa khách hàng và DTH;\r\n- DTH cam kết đối với khách hàng;\r\n- pháp luật Việt Nam quy định.\r\nVới những yêu cầu khác, khách hàng có thể gửi thư điện tử qua mục Liên hệ trên trang web của DTH tại địa chỉ www.truyenhinhvienthong.vn hoặc gọi Tổng đài DTH 1900 1592 để nhận thông tin.', '0', 'finish');

-- --------------------------------------------------------

--
-- Table structure for table `lien_he`
--

CREATE TABLE IF NOT EXISTS `lien_he` (
`id` int(11) NOT NULL,
  `dia_chi` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `dien_thoai` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ten_cong_ty` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `email` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `skype` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `lien_he`
--

INSERT INTO `lien_he` (`id`, `dia_chi`, `dien_thoai`, `ten_cong_ty`, `email`, `skype`) VALUES
(1, 'Toa nha Detech, so 8 Ton That Thuyet, phuong My Dinh 2, quan Nam Tu Liem, TP.Ha Noi', '04. 7300 22 66', 'Cong ty dich vu truyen thong DTH', 'dthbroadcast@gmail.com', 'dthbroadcast');

-- --------------------------------------------------------

--
-- Table structure for table `order`
--

CREATE TABLE IF NOT EXISTS `order` (
`id` int(11) NOT NULL,
  `username` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ten_dich_vu` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `mien` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `dia_chi_nap_dat` text COLLATE utf8_unicode_ci,
  `hinh_thuc_thanh_toan` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `thoi_luong` int(10) DEFAULT NULL,
  `gia_tien` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `status` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `date_register` date DEFAULT NULL,
  `date_begin` date DEFAULT NULL,
  `date_end` date DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=116 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
`id` int(11) NOT NULL,
  `username` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `password` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `name` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `card_id` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `phone_number` varchar(11) COLLATE utf8_unicode_ci DEFAULT NULL,
  `email` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `address` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `package_id` int(50) DEFAULT NULL,
  `dealer_id` int(11) DEFAULT NULL,
  `mien` varchar(20) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `username`, `password`, `name`, `card_id`, `phone_number`, `email`, `address`, `package_id`, `dealer_id`, `mien`) VALUES
(1, 'tungphan', 'passthepj', 'Phan Tien Tung', '013219705', '01659972368', 'caubenuoc1995@gmail.com', 'so 2 ngo 69 Truong Chinh, phuong 14, Tan Phu, TP.HCM', 0, 0, 'nam'),
(2, 'datbui', 'nomorepj', 'Bui Tien Dat', '019785264', '0197786542', 'datbuicc@gmail.com', '25 Dao Duy Tu, TP.Vinh, Nghe An', 0, 0, 'trung'),
(3, 'vuvidai', 'vumuonlamnuhoang', 'Nguyen Tuan Vu', '097836487', '0916687452', 'vuntgc00978@fpt.edu.vn', '108 A2 Hoang Cau, Dong Da, Ha Noi', 0, 0, 'bac'),
(4, 'minhminh', 'mcjackson', 'Pham Thuc Minh', '047895123', '01574862578', 'minhmuonminh@gmail.com', '300 Giang Vo, Ba Dinh, Ha Noi', 0, 0, 'bac'),
(5, 'khanhtuton', 'yeumoinguoi', 'Nguyen Khanh', '098773485', '0165777899', 'khanhntthich@gmail.com', '1 Hang Bai, Hoan Kiem, Ha Noi', 0, 0, 'bac'),
(6, 'bboyccxx', 'madafaka', 'Hoang Ho Hoi', '048741325', '0972365841', 'hoangnnhh@gmail.com', '102 Hoang Dieu, Thanh Hoa', 0, 0, 'trung'),
(7, 'roccat', 'meomeo', 'Pasha the Bicep', '087594621', '0978506807', 'pasha@gmail.com', '72 La Thanh, Ba Dinh, Ha Noi', 0, 0, 'bac');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `dealer`
--
ALTER TABLE `dealer`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `dich_vu`
--
ALTER TABLE `dich_vu`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `fqa`
--
ALTER TABLE `fqa`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `lien_he`
--
ALTER TABLE `lien_he`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `order`
--
ALTER TABLE `order`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
 ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `dealer`
--
ALTER TABLE `dealer`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT for table `dich_vu`
--
ALTER TABLE `dich_vu`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=53;
--
-- AUTO_INCREMENT for table `fqa`
--
ALTER TABLE `fqa`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `lien_he`
--
ALTER TABLE `lien_he`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `order`
--
ALTER TABLE `order`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=116;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=9;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
