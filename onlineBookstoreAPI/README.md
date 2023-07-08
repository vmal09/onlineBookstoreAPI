

# Online Bookstore API

This is a RESTful API for an online bookstore, built with Spring Boot.

---

## Setup

This project uses the H2 in-memory database. No additional setup is required to use the database.

## Running the Server

You can run the server directly from IntelliJ IDEA by following these steps:

1. Open the project in IntelliJ IDEA.
2. Navigate to the `OnlineBookstoreApiApplication.java` file in the Project Explorer.
3. Right-click on the file and select 'Run OnlineBookstoreApiApplication'.
4. The server will start and listen for requests at `http://localhost:8080/api/books`.

Alternatively, you can run the server from the command line:

```powershell
./mvnw spring-boot:run
```

## API Endpoints

### GET /api/books

Retrieves a list of all books. You can add query parameters to search for books by title, author, or ISBN, and to paginate the results.

Example usage:

```powershell
# Get all books
$response = Invoke-WebRequest -Uri http://localhost:8080/api/books

# Search for books with "Example" in the title
$response = Invoke-WebRequest -Uri "http://localhost:8080/api/books?title=Example"

```

### GET /api/books/{id}

Retrieves a specific book by its ID.

Example usage:

```powershell
$response = Invoke-WebRequest -Uri http://localhost:8080/api/books/1
```

### POST /api/books

Adds a new book to the bookstore.

Example usage:

```powershell
$body = @{
    title = "Example Book"
    author = "Example Author"
    isbn = "1234567890"
    price = 19.99
    publicationYear = 2023
} | ConvertTo-Json

$response = Invoke-WebRequest -Uri http://localhost:8080/api/books -Method POST -Body $body -ContentType "application/json"
```

### PUT /api/books/{id}

Updates an existing book's information.

Example usage:

```powershell
$body = @{
    title = "Updated Title"
    author = "Updated Author"
    isbn = "1234567890"
    price = 19.99
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

