## Xây dựng ứng dụng quản lý user với các chức năng sau

### 1. Lấy danh sách users (có phân trang - pagination)

`GET http://localhost:8080/api/v1/users` (mặc định **page** = 1, **limit** = 10)

**Dữ liệu trả về ví dụ :**

```javascript
// GET http://localhost:8080/api/v1/users
// Tương đương GET http://localhost:8080/api/v1/users?page=1&amp;limit=10

{
   "data" : [
       {
           "id": 1,
           "name": "Bùi Hiên",
           "email": "buihien01091997@gmail.com",
           "phone": "0344005816",
           "address": "Tỉnh Thái Bình",
           "avatar": null
       },
         ...
   ],
    "currentPage" : 1,
    "size" : 10,
    "totalPage" : 5
}
```

### 2. Tìm kiếm user theo tên

`GET http://localhost:8080/api/v1/search?name={nameValue}`

**Dữ liệu trả về ví dụ :**

```javascript
// GET http://localhost:8080/api/v1/users/search?name=hiên

[
    {
        "id": 1,
        "name": "Bùi Hiên",
        "email": "buihien01091997@gmail.com",
        "phone": "0344005816",
        "address": "Tỉnh Thái Bình",
        "avatar": null
    },
   ...
]
```

### 3. Lấy chi tiết user theo id

`GET http://localhost:8080/api/v1/users/{id}`

**Dữ liệu trả về ví dụ :**

```javascript
// GET http://localhost:8080/api/v1/users/2
{
    "id": 2,
    "name": "Nguyễn Thu Hằng",
    "email": "thuhangvnua@gmail.com",
    "phone": "0123456789",
    "address": "Tỉnh Nam Định",
    "avatar": null
}
```

### 4. Tạo mới user

`POST http://localhost:8080/api/v1/users`

Cấu trúc request body

```json
{
    name : ${nameValue}
    email : ${emailValue}
    phone : ${phoneValue}
    address : ${addressValue}
    password :  ${passwordValue}
}
```

- `id` : Sinh ngẫu nhiên, k trùng nhau

**Ví dụ**

```javascript
// POST http://localhost:8080/api/v1/users

// Dữ liệu gửi lên
{
    "name" : "Nguyễn Văn A",
    "email" : "a@gmail.com",
    "phone" : "0987654321",
    "address" : "Tỉnh Nam Định",
    "password" :  "111"
}

// Dữ liệu trả về
{
    "id": 4,
    "name": "Nguyễn Văn A",
    "email": "a@gmail.com",
    "phone": "0987654321",
    "address": "Tỉnh Nam Định",
    "avatar": null
}
```

### 5. Cập nhật thông tin user

`PUT http://localhost:8080/api/v1/users/{id}`

Cấu trúc request body

```json
{
    name : ${nameValue}
    phone : ${phoneValue}
    address : ${addressValue}
}
```

Ví dụ

```json
// PUT http://localhost:8080/api/v1/users/4

// Dữ liệu gửi lên
{
    "name" : "Nguyễn Văn A",
    "phone" : "0988888888",
    "address" : "Thành Phố Hà Nội",
}

// Dữ liệu trả về
{
    "id": 4,
    "name": "Nguyễn Văn A",
    "email": "a@gmail.com",
    "phone": "0988888888",
    "address": "Thành Phố Hà Nội",
    "avatar": null
}
```

### 6. Xóa user

`DELETE http://localhost:8080/api/v1/users/{id}`

> Không cần trả về gì cả


### 7. Thay đổi ảnh avatar

`PUT http://localhost:8080/api/v1/users/{id}/update-avatar`

Cấu trúc request body

```json
{
    avatar : ${avatarValue}
}
```

**Ví dụ**

```javascript
// PUT http://localhost:8080/api/v1/users/1/update-avatar

// Dữ liệu gửi lên
{
    "avatar" : "/api/v1/users/1/files/1"
}
```

> Không cần trả về gì cả


### 8. Thay đổi mật khẩu

`PUT http://localhost:8080/api/v1/users/{id}/update-password`

Cấu trúc request body

```json
{
    oldPassword : ${oldPasswordValue}
    newPassword : ${newPasswordValue}
}
```

**Ví dụ**

```javascript
// POST http://localhost:8080/api/v1/users/1/update-password

// Dữ liệu gửi lên
{
    "oldPassword" : "111",
    "newPassword" : "222",
}
```

Dữ liệu cần kiểm tra

- Mật khẩu cũ nếu không chính xác --> exception
- Mật khẩu mới giống mật khẩu cũ --> exception

> Không cần trả về gì cả

### 9. Quên mật khẩu

`POST http://localhost:8080/api/v1/users/{id}/fotgot-password`

> Trả về Password mới
