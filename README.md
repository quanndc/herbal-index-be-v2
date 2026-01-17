# 🌿 Herbal Index Backend

Herbal Index là hệ thống backend phục vụ **quản lý, tra cứu và khám phá dữ liệu dược liệu**, hỗ trợ:
- Người dùng tra cứu thông tin dược liệu
- Admin / người nhập liệu quản lý dữ liệu

---

## 🏗️ Công nghệ & Kiến trúc

- **Backend**: Spring Boot
- **Architecture**: Clean Architecture + Domain-Driven Design (DDD)
- **API**: RESTful API
- **Database**: PostgreSQL
- **Migration**: Flyway
- **Deployment / DB**: Supabase

---

## 🧩 Bounded Contexts

- `herb` – Quản lý dược liệu
- `user` – Quản lý người dùng
- `auth` – Xác thực & phân quyền
- `report` – Báo cáo, thống kê

---

## 🎯 Nguyên tắc thiết kế

- Domain độc lập, không phụ thuộc framework
- Use case điều phối nghiệp vụ
- Infrastructure là adapter (DB, Spring, JPA)
- Interface xử lý HTTP, DTO, API contrac

---

## 📦 Value Object & Enum

- Value Object: immutable, không ID, validate trong constructor
- Enum: là một dạng Value Object, dùng cho tập giá trị hữu hạn  
  (Ví dụ: `ScientificName`, `Dosage`, `HerbStatus`, `UserRole`)

---

## 🔁 API Response & Exception

- Response chung: `common/dto/ApiResponse`
- Exception generic: `common/exception`
- Exception domain-specific: trong từng context
- Xử lý lỗi tập trung bằng Global Exception Handler

---

## 🗄️ Database

- PostgreSQL
- Migration bằng Flyway (`src/main/resources/db/migration`)

---

## 🚀 Mục tiêu

- Dễ mở rộng
- Dễ bảo trì
- Phù hợp cho Web (React) & Mobile (Flutter)

---

© Herbal Index Backend
