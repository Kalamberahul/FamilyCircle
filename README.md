# 👨‍👩‍👧‍👦 FamilyCircle: Smart Family Bonding & Wellness App

**FamilyCircle** is a full-stack Java Spring Boot web application designed to strengthen family bonds and emotional well-being. The app allows family members (Dad, Mom, Kid1, Kid2) to interact through gratitude sharing, mood tracking, bonding tasks, and wellness dashboards.

---

## 💡 Why FamilyCircle?

In today’s fast-paced world, families often struggle to spend quality time together or understand each other's emotional needs. **FamilyCircle** provides a structured and interactive way for all family members to:
- Stay emotionally connected 💞
- Understand each other’s moods 😄😢
- Appreciate each other more 💌
- Build stronger daily habits 💪

---

## 🔧 Technologies Used

| Layer            | Tools Used                         |
|------------------|------------------------------------|
| 💻 Frontend      | Thymeleaf, HTML, CSS, Bootstrap    |
| ⚙️ Backend       | Java, Spring Boot, Spring Security |
| 🛢️ Database      | MySQL                              |
| 🔐 Security      | Spring Security + Role-based Login |
| 📊 Charts        | Chart.js (Mood & Bonding Graphs)   |

---

## 🧩 Features

✅ Role-based login (Dad, Mom, Kid1, Kid2)  
✅ Gratitude journaling  
✅ Mood tracking with history  
✅ Daily bonding tasks  
✅ Weekly bonding points system  
✅ Personalized dashboards  
✅ Family bonding score with progress charts  
✅ Reminder system (Optional)

---

## 📁 Project Structure
FamilyCircle/
├── src/
│ ├── controller/
│ ├── service/
│ ├── repository/
│ ├── model/
│ └── security/
├── resources/
│ ├── templates/ (Thymeleaf HTML files)
│ └── application.properties
├── pom.xml
├── README.md
└── familycircle_db.sql

---

## ⚙️ How to Run

1. **Clone the repo**  
   ```bash
   git clone https://github.com/Kalamberahul/FamilyCircle.git

Import into Eclipse / IntelliJ

As Maven Project

MySQL Setup

Create DB: familycircle_db

Run: familycircle_db.sql to create tables

Run the app

SpringBootApplication class → Right click → Run As → Spring Boot App

Access App

Open: http://localhost:8080/login

🔐 Default Roles
Username	Role	Password
dad	ROLE_DAD	(set manually or register)
mom	ROLE_MOM	(set manually or register)
kid1	ROLE_KID1	(set manually or register)
kid2	ROLE_KID2	(set manually or register)


💼 Author
👤 Rahul Kalambe
MCA Student | Passionate about AI, ML & Full Stack
GitHub

📌 Note
This is an academic/final year project focused on social-emotional intelligence and digital family wellness. All logic is original and built using standard Java Spring Boot practices.

