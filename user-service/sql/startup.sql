CREATE USER postgres with password 'password';
CREATE DATABASE users;
GRANT ALL PRIVILEGES ON DATABASE users TO postgres;