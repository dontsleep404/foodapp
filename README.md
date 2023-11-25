GUEST : không cần đăng nhập vào thẳng giao diện đặt món
USER : cần đăng nhập vào giao diện đặt món có thể đặt món, xem lịch sử đặt món
ADMIN : cần đăng nhập vào giao diện quản lý có thể thêm, sửa, xóa món ăn, thức uống, loại món ăn, loại thức uống, tài khoản, đơn hàng, thống kê
STAFF : cần đăng nhập vào giao diện nhân viên có thể xem đơn hàng, thống kê


///
các biến lưu trữ ở server chính
- danh sách tài khoản online [USER, ADMIN, STAFF]
- danh sách 

// database
- tài khoản {id, username, password, role, name} [Mặc định có 1 tài khoản admin]
- loại món ăn {id, name, description}
- món ăn {id, name, price, point, canusepoint, type, image, description}
- hóa đơn {id, user_id, status, time}
- chi tiết đặt món {id, order_id, food_id, quantity}
