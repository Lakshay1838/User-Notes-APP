# 📝 UserNotes App

Welcome to **UserNotes App**, a powerful and secure **backend application** that allows users to **register**, **authenticate**, and seamlessly **create, manage, and retrieve personal notes**. Built with performance and scalability in mind using **Spring Boot** and **MongoDB**, this application is ideal for building note-based systems with user-specific data handling.

---

## 🚀 Tech Stack

- **Java**
- **Spring Boot**
- **MongoDB**
- **Spring Security** (for authentication and authorization)
- **Maven** (project management)

---

## 🔐 Key Features

- ✅ **User Registration & Login**  
  Secure user signup and login with encrypted password storage.

- 🔒 **Authentication & Authorization**  
 ensure only authenticated users access their data.

- 🗒️ **Create & Manage Notes**  
  Logged-in users can **create**, **edit**, **delete**, and **view** their **personal notes**.

- 📁 **User & Note Entities**  
  Clean separation of data through dedicated MongoDB collections for users and their respective notes.

- 🔄 **Time-stamped Updates**  
  Notes automatically update their timestamp upon modification.

---

## 🌟 Highlight Feature

> **Every user has access only to their own personal notes.**  
> Once authenticated, the backend ensures that all note operations are scoped **only to the logged-in user**, keeping privacy and data isolation at the core.

---

📬 API Endpoints Overview
Method	Endpoint	Description	Auth Required
POST	/auth/register	Register a new user	❌
GET	/notes/	Get all personal notes	✅
POST	/notes/	Create a new personal note	✅
PUT	/notes/{id}	Update a note by ID	✅
DELETE	/notes/{id}	Delete a note by ID	✅

💡 Future Enhancements
🔍 Full-text search in notes

📎 File attachments

📅 Reminders or scheduling notes

🌐 Frontend integration (React/Vue)

🧑‍💻 Author
Lakshay Pahuja
github - (Lakshay1838)
