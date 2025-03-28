-- Only insert if table exists (H2 compatible)
INSERT  INTO leave_type (type_name, description) KEY(type_name) VALUES
('Vacation', 'Annual paid leave'),
('Medical', 'Sick leave with medical certificate'),
('WFH', 'Work from home arrangement'),
('Training', 'Professional development leave'),
('Biz Trip', 'Official business travel');