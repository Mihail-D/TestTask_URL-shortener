CREATE TABLE links_vault (
    id INT AUTO_INCREMENT PRIMARY KEY,
    short_link VARCHAR(255) NOT NULL,
    original_link VARCHAR(2048) NOT NULL,
    rank INT DEFAULT 0,
    count INT DEFAULT 0
);
