## Bắt Đầu

Link deploy: https://g-sneaker-vbvi.onrender.com

### Yêu Cầu Hệ Thống

Để chạy ứng dụng, bạn cần cài đặt các công cụ sau:

- [Java JDK](https://www.oracle.com/java/technologies/javase-downloads.html)
- [Maven](https://maven.apache.org/download.cgi)

### Clone Repository

Mở terminal và chạy lệnh sau để clone repository:

```bash
git clone https://github.com/tyteo1503/G-Sneaker.git
cd G-Sneaker
```

### Import vào IntelliJ IDEA

1. Mở IntelliJ IDEA và chọn "Open" từ menu hoặc màn hình chào mừng.
2. Chọn thư mục dự án và nhấn "Open."
3. Mở Maven Tool Window và chọn "Reload Project" để tải các phụ thuộc.

### Chạy Ứng Dụng

Mở src\main\java\com\example\gsneaker\GSneakerApplication.java.
Nhấn chuột phải và chọn "Run 'Application'" hoặc nhấn Shift + F10.

## Sử dụng Postman để test API:

### GET https://g-sneaker-vbvi.onrender.com/api/v1/products: Lấy danh sách tất cả sản phẩm
### GET https://g-sneaker-vbvi.onrender.com/api/v1/cart/items): Lấy danh sách tất cả sản phẩm có trong giỏ hàng
### POST https://g-sneaker-vbvi.onrender.com/api/v1/cart/add-item/2 : Thêm sản phẩm vào giỏ hàng
### PUT https://g-sneaker-vbvi.onrender.com/api/v1/cart/update-item/2?change_amount=1: Cập nhật số lượng sản phẩm trong giỏ hàng
### DELETE https://g-sneaker-vbvi.onrender.com/api/v1/cart/delete-item/2 : Xoá một sản phẩm trong giỏ hàng
