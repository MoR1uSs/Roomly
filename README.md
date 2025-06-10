# 🏠 Roomly

**Roomly** is a web application for booking rooms, created in **Java** using **Hibernate**, **Struts2**, **JSP**, and a **MySQL** database.  
The goal of the project is to provide users with a simple and effective way to book accommodations online.

---

## 🚀 Technologies

- **Java 21**
- **Hibernate**
- **Struts2**
- **JSP**
- **Tomcat 9.0.105**
- **MySQL**

---

# ⚙️ How to Run This App

> Make sure you have **Java 21**, **Tomcat**, and **MySQL** installed and configured.

## 1. Clone this repository

## 2. Adjust hibernate.cfh.xml
Edit the `hibernate.cfg.xml` file:

```xml
<session-factory>
    <property name="hibernate.connection.driver_class">com.mysql.cj.jdbc.Driver</property>
    <property name="hibernate.connection.url">jdbc:mysql://localhost:3306/yourdatabasename?useSSL=false</property>
    <property name="hibernate.connection.username">your_username</property>
    <property name="hibernate.connection.password">your_password</property>
</session-factory>
```

## 3. Run this project

> Open the project in your IDE (e.g., IntelliJ IDEA or Eclipse)

> Deploy it to Tomcat 9

> Start the Tomcat server

## 4. Pray (Recommended)
