-- schema-h2.sql
CREATE TABLE IF NOT EXISTS leave_type (
    leave_type_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    type_name VARCHAR(50) NOT NULL UNIQUE,
    description VARCHAR(200)
);

CREATE TABLE IF NOT EXISTS leave_application (
    application_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    staff_name VARCHAR(100) NOT NULL,
    leave_type_id BIGINT,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    hours_taken DOUBLE NOT NULL,
    manager_approved BOOLEAN DEFAULT FALSE,
    application_manager_name VARCHAR(100),
    location_during_leave VARCHAR(200),
    remarks VARCHAR(500),
    created_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP(),
    updated_time TIMESTAMP,
    created_by VARCHAR(100),
    updated_by VARCHAR(100),
    FOREIGN KEY (leave_type_id) REFERENCES leave_type(leave_type_id)
);

CREATE TABLE IF NOT EXISTS leave_attachment (
    attachment_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    application_id BIGINT NOT NULL,
    file_name VARCHAR(255) NOT NULL,
    file_size BIGINT,
    file_type VARCHAR(50),
    storage_path VARCHAR(500) NOT NULL,
    upload_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP(),
    upload_by VARCHAR(100),
    FOREIGN KEY (application_id) REFERENCES leave_application(application_id)
);

-- Insert initial data
INSERT INTO leave_type (type_name, description) VALUES
('Vacation', 'Annual paid leave'),
('Medical', 'Sick leave with medical certificate'),
('WFH', 'Work from home arrangement'),
('Training', 'Professional development leave'),
('Biz Trip', 'Official business travel')
ON CONFLICT(type_name) DO NOTHING;