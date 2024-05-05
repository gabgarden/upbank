CREATE TABLE users (
                       id BIGSERIAL PRIMARY KEY,
                       first_name VARCHAR(255),
                       last_name VARCHAR(255),
                       document VARCHAR(255) UNIQUE,
                       email VARCHAR(255) UNIQUE,
                       password VARCHAR(255),
                       balance DECIMAL(19, 2),
                       user_type VARCHAR(20) -- Para PostgreSQL, ENUM não é suportado diretamente, então você pode usar VARCHAR ou criar um tipo ENUM personalizado.
);

CREATE TABLE transactions (
                              id BIGSERIAL PRIMARY KEY,
                              amount DECIMAL(19, 2),
                              sender_id BIGINT,
                              receiver_id BIGINT,
                              timestamp TIMESTAMP,
                              FOREIGN KEY (sender_id) REFERENCES users(id),
                              FOREIGN KEY (receiver_id) REFERENCES users(id)
);
