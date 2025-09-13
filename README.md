# Freddit Backend - Enterprise Web API

A comprehensive, enterprise-level Reddit-like backend API built with Spring Boot 3.5.5 and Java 21.

## 🚀 Features

- **RESTful API** with Spring Boot Web
- **Security** with Spring Security and JWT authentication
- **Database** support for H2 (development) and PostgreSQL (production)
- **Caching** with Redis integration
- **API Documentation** with OpenAPI/Swagger
- **Monitoring** with Spring Boot Actuator and Prometheus metrics
- **Database Migrations** with Flyway
- **Validation** with Bean Validation
- **Testing** with TestContainers for integration tests
- **Code Generation** with MapStruct for DTO mapping
- **Reduced Boilerplate** with Lombok

## 📋 Prerequisites

- Java 21 or higher
- Maven 3.6 or higher
- Redis (for caching)
- PostgreSQL (for production)

## 🛠️ Installation & Setup

### 1. Clone the Repository
```bash
git clone <repository-url>
cd freddit-backend
```

### 2. Install Dependencies
```bash
mvn clean install
```

### 3. Configure Environment Variables (Optional)
Create a `.env` file or set environment variables:
```bash
export JWT_SECRET=your-secret-key-here
export DB_USERNAME=your-db-username
export DB_PASSWORD=your-db-password
```

### 4. Start Redis (Required for caching)
```bash
# Using Docker
docker run -d -p 6379:6379 redis:alpine

# Or install Redis locally
# macOS: brew install redis && brew services start redis
# Ubuntu: sudo apt install redis-server && sudo systemctl start redis
```

### 5. Run the Application
```bash
mvn spring-boot:run
```

The application will start on `http://localhost:8080`

## 🗄️ Database Setup

### Development (H2)
The application is configured to use H2 in-memory database for development. No additional setup required.

Access H2 Console: `http://localhost:8080/h2-console`
- JDBC URL: `jdbc:h2:mem:testdb`
- Username: `sa`
- Password: `password`

### Production (PostgreSQL)
1. Install PostgreSQL
2. Create a database named `freddit`
3. Uncomment PostgreSQL configuration in `application.properties`
4. Update database credentials

## 📚 API Documentation

Once the application is running, access the interactive API documentation:

- **Swagger UI**: `http://localhost:8080/api/swagger-ui.html`
- **OpenAPI JSON**: `http://localhost:8080/api/api-docs`

## 🔍 Monitoring & Health Checks

- **Health Check**: `http://localhost:8080/api/public/health`
- **Application Info**: `http://localhost:8080/api/public/info`
- **Actuator Health**: `http://localhost:8080/api/actuator/health`
- **Prometheus Metrics**: `http://localhost:8080/api/actuator/prometheus`

## 🏗️ Project Structure

```
src/main/java/com/example/demo/
├── config/          # Configuration classes
├── controller/      # REST controllers
├── service/         # Business logic
├── repository/      # Data access layer
├── model/           # JPA entities
├── dto/             # Data transfer objects
├── security/        # Security configuration
├── exception/       # Exception handling
└── util/            # Utility classes

src/main/resources/
├── db/migration/    # Flyway database migrations
└── application.properties
```

## 🧪 Testing

Run tests with:
```bash
mvn test
```

Integration tests use TestContainers for database testing.

## 🚀 Deployment

### Docker (Recommended)
```bash
# Build the application
mvn clean package

# Build Docker image
docker build -t freddit-backend .

# Run with Docker Compose
docker-compose up -d
```

### Traditional Deployment
1. Build the application: `mvn clean package`
2. Run the JAR: `java -jar target/demo-0.0.1-SNAPSHOT.jar`

## 🔧 Configuration

Key configuration options in `application.properties`:

- **Server**: Port, context path
- **Database**: Connection settings for H2/PostgreSQL
- **Redis**: Cache configuration
- **Security**: JWT settings
- **Logging**: Log levels and patterns
- **Actuator**: Monitoring endpoints

## 📦 Dependencies

### Core Dependencies
- Spring Boot Web Starter
- Spring Boot Data JPA
- Spring Boot Security
- Spring Boot Validation
- Spring Boot Actuator
- Spring Boot Cache

### Database
- H2 Database (development)
- PostgreSQL Driver (production)
- Flyway (migrations)

### Security & Authentication
- JWT (JSON Web Tokens)
- BCrypt password encoding

### Documentation & Monitoring
- OpenAPI/Swagger
- Micrometer Prometheus

### Development Tools
- Lombok
- MapStruct
- Redis
- TestContainers

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Add tests
5. Submit a pull request

## 📄 License

This project is licensed under the MIT License.

## 🆘 Support

For support and questions:
- Create an issue in the repository
- Contact the development team

## 🔄 Database Migrations

Database schema changes are managed with Flyway migrations in `src/main/resources/db/migration/`.

To create a new migration:
1. Create a new file: `V{version}__{description}.sql`
2. Add your SQL changes
3. Run the application to apply migrations

Example: `V2__Add_user_preferences.sql`
