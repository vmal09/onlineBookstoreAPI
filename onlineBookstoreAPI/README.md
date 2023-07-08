# Online Bookstore API

This project encapsulates a RESTful API designed for an online bookstore. It's built using Spring Boot and employs an H2 in-memory database.
---

## Getting Started

Prerequisites: There are no additional prerequisites for database setup as we utilize H2 in-memory database for simplicity.

## Running the Server

You can run the server directly from IntelliJ IDEA by following these steps:

1. Open the project in IntelliJ IDEA.
2. Go to the OnlineBookstoreApiApplication.java in the Project Explorer.
3. Right-click on this file and choose 'Run OnlineBookstoreApiApplication'.
4. The server starts up and awaits requests at `http://localhost:8080/api/books`.

## Running from command line:

```powershell
./mvnw spring-boot:run
```

## API Routes

### GET /api/books

Fetches all books. You can also search for specific books by title, author, or ISBN, and paginate the results with query parameters.

Usage:

```powershell
# Fetch all books
$response = Invoke-WebRequest -Uri http://localhost:8080/api/books

# Find books with "Example" in the title
$response = Invoke-WebRequest -Uri "http://localhost:8080/api/books?title=Reference"

```

### GET /api/books/{id}

Fetches a book by its ID.

Example usage:

```powershell
$response = Invoke-WebRequest -Uri http://localhost:8080/api/books/1
```

### POST /api/books

Inserts a new book into the bookstore.

Example usage:

```powershell
$body = @{
    title = "Reference Book 1"
    author = "Book Author"
    isbn = "123456789"
    price = 100.00
    publicationYear = 2023
} | ConvertTo-Json

$response = Invoke-WebRequest -Uri http://localhost:8080/api/books -Method POST -Body $body -ContentType "application/json"
```

### PUT /api/books/{id}

Updates the details of an existing book.

Example usage:

```powershell
$body = @{
    title = "Updated Book Title"
    author = "Updated Book Author"
    isbn = "123456789"
    price = 100.00
    publicationYear = 2023
} | ConvertTo-Json

$response = Invoke-WebRequest -Uri http://localhost:8080/api/books/1 -Method PUT -Body $body -ContentType "application/json"
```

### DELETE /api/books/{id}

Deletes a book from the bookstore.

Example usage:

```powershell
$response = Invoke-WebRequest -Uri http://localhost:8080/api/books/1 -Method DELETE
```

