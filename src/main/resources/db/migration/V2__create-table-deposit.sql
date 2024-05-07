CREATE TABLE deposits (
                          id SERIAL PRIMARY KEY,
                          amount NUMERIC,
                          account_holder_id BIGINT,
                          timestamp TIMESTAMP,
                          FOREIGN KEY (account_holder_id) REFERENCES users(id)
);