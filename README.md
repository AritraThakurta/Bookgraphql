# 📘 GraphQL Spring Boot CRUD Example with DTOs & MySQL

This is a simple Spring Boot application demonstrating how to build a GraphQL CRUD API using:
- Custom **DTO-based input**
- **MySQL database**
- **Spring GraphQL**, **Spring Data JPA**, and **Lombok**

---

## 🧰 Technologies Used

- Java 17+
- Spring Boot 3.x
- Spring for GraphQL
- Spring Data JPA
- MySQL
- Lombok
- Maven

---

## 🗃️ Features

- Full CRUD with GraphQL (Query + Mutation)
- Custom `BookInputDTO` for input
- Auto DB schema generation
- Uses `schema.graphqls` file
- Simple service-controller-repo-layered architecture

---

## 🚀 How to Run

### 🔧 Prerequisites

- Java 17+
- MySQL 8+
- Maven

### ⚙️ Setup MySQL

```sql
CREATE DATABASE BookDB;
```

Update `src/main/resources/application.properties` with your MySQL credentials:

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/BookDB
    username: root
    password: YOUR_PASSWORD
```

### ▶️ Run the App

```bash
mvn spring-boot:run
```

Access GraphQL Playground:
```
http://localhost:8080/graphiql
```

---

## 🧩 GraphQL Schema

```graphql
type Query {
  getAllBooks: [Book]
  getBookById(id: ID!): Book
}

type Mutation {
  createBook(input: BookInput!): Book
}

type Book {
  id: ID
  title: String
  author: String
  pages: Int
}

input BookInput {
  title: String!
  author: String!
  pages: Int!
}
```

---

## 📥 Sample GraphQL Queries

### Create Book
```graphql
mutation {
  createBook(input: { title: "Spring Boot", author: "Rod Johnson", pages: 300 }) {
    id
    title
  }
}
```

### Get All Books
```graphql
query {
  getAllBooks {
    id
    title
    author
    pages
  }
}
```



---

## 📁 Project Structure

```
src/
├── main/
│   ├── java/com/example/demo/
│   │   ├── controller/
│   │   ├── dto/
│   │   ├── entity/
│   │   ├── repository/
│   │   ├── service/
│   │   └── DemoApplication.java
│   └── resources/
│       ├── application.yml
│       └── graphql/schema.graphqls
```

---

## 📄 License

This project is open source and free to use under the [MIT License](LICENSE).
