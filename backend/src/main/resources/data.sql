-- Seed data for Vehicle Inventory System
-- This file contains initial data for brands, models, and vehicles

-- Insert Brands (using IGNORE to avoid errors if data already exists)
INSERT IGNORE INTO brand (name) VALUES
('Toyota'),
('Honda'),
('Ford'),
('Chevrolet'),
('Volkswagen'),
('BMW'),
('Mercedes-Benz'),
('Audi'),
('Nissan'),
('Hyundai'),
('Kia'),
('Fiat'),
('Renault'),
('Peugeot'),
('Volvo');

-- Insert Models (using IGNORE to avoid errors if data already exists)
-- Assuming brand IDs are 1-15 in order
INSERT IGNORE INTO model (name, brand_id) VALUES
-- Toyota (brand_id = 1)
('Corolla', 1),
('Camry', 1),
('RAV4', 1),
('Hilux', 1),
('Yaris', 1),
-- Honda (brand_id = 2)
('Civic', 2),
('Accord', 2),
('CR-V', 2),
('HR-V', 2),
('Fit', 2),
-- Ford (brand_id = 3)
('Fiesta', 3),
('Focus', 3),
('Fusion', 3),
('Ranger', 3),
('EcoSport', 3),
-- Chevrolet (brand_id = 4)
('Onix', 4),
('Cruze', 4),
('Tracker', 4),
('S10', 4),
('Spin', 4),
-- Volkswagen (brand_id = 5)
('Gol', 5),
('Polo', 5),
('Jetta', 5),
('Tiguan', 5),
('Amarok', 5),
-- BMW (brand_id = 6)
('320i', 6),
('X3', 6),
('X5', 6),
('118i', 6),
('520i', 6),
-- Mercedes-Benz (brand_id = 7)
('C180', 7),
('GLA', 7),
('GLC', 7),
('A200', 7),
('E200', 7),
-- Audi (brand_id = 8)
('A3', 8),
('A4', 8),
('Q3', 8),
('Q5', 8),
('A1', 8),
-- Nissan (brand_id = 9)
('Versa', 9),
('Sentra', 9),
('Kicks', 9),
('Frontier', 9),
('March', 9),
-- Hyundai (brand_id = 10)
('HB20', 10),
('Creta', 10),
('Tucson', 10),
('i30', 10),
('Santa Fe', 10),
-- Kia (brand_id = 11)
('Rio', 11),
('Cerato', 11),
('Sportage', 11),
('Sorento', 11),
('Picanto', 11),
-- Fiat (brand_id = 12)
('Uno', 12),
('Palio', 12),
('Strada', 12),
('Toro', 12),
('Argo', 12),
-- Renault (brand_id = 13)
('Kwid', 13),
('Sandero', 13),
('Duster', 13),
('Logan', 13),
('Captur', 13),
-- Peugeot (brand_id = 14)
('208', 14),
('2008', 14),
('3008', 14),
('Partner', 14),
('Expert', 14),
-- Volvo (brand_id = 15)
('XC40', 15),
('XC60', 15),
('XC90', 15),
('S60', 15),
('V40', 15);

-- Insert Vehicles (at least 100 vehicles)
-- Using IGNORE to avoid errors if data already exists
-- Using model_id references (models are inserted in order, so model_id 1-75)
INSERT IGNORE INTO vehicle (model_id, year, color, price, mileage, status) VALUES
-- Toyota Corolla (model_id = 1)
(1, 2020, 'Branco', 85000.00, 45000, 'AVAILABLE'),
(1, 2021, 'Prata', 92000.00, 32000, 'AVAILABLE'),
(1, 2019, 'Preto', 78000.00, 58000, 'SOLD'),
(1, 2022, 'Vermelho', 98000.00, 25000, 'AVAILABLE'),
(1, 2020, 'Azul', 82000.00, 52000, 'AVAILABLE'),
-- Toyota Camry (model_id = 2)
(2, 2021, 'Branco', 145000.00, 35000, 'AVAILABLE'),
(2, 2020, 'Prata', 135000.00, 48000, 'AVAILABLE'),
(2, 2022, 'Preto', 155000.00, 20000, 'AVAILABLE'),
(2, 2019, 'Cinza', 125000.00, 62000, 'SOLD'),
-- Toyota RAV4 (model_id = 3)
(3, 2021, 'Branco', 165000.00, 40000, 'AVAILABLE'),
(3, 2022, 'Prata', 175000.00, 28000, 'AVAILABLE'),
(3, 2020, 'Preto', 155000.00, 55000, 'AVAILABLE'),
(3, 2021, 'Vermelho', 168000.00, 38000, 'SOLD'),
-- Honda Civic (model_id = 6)
(6, 2020, 'Branco', 95000.00, 42000, 'AVAILABLE'),
(6, 2021, 'Prata', 102000.00, 30000, 'AVAILABLE'),
(6, 2019, 'Preto', 88000.00, 60000, 'AVAILABLE'),
(6, 2022, 'Azul', 108000.00, 22000, 'AVAILABLE'),
(6, 2020, 'Vermelho', 92000.00, 50000, 'SOLD'),
-- Honda Accord (model_id = 7)
(7, 2021, 'Branco', 140000.00, 36000, 'AVAILABLE'),
(7, 2020, 'Prata', 130000.00, 49000, 'AVAILABLE'),
(7, 2022, 'Preto', 150000.00, 18000, 'AVAILABLE'),
-- Honda CR-V (model_id = 8)
(8, 2021, 'Branco', 160000.00, 38000, 'AVAILABLE'),
(8, 2022, 'Prata', 170000.00, 25000, 'AVAILABLE'),
(8, 2020, 'Preto', 150000.00, 52000, 'AVAILABLE'),
(8, 2021, 'Azul', 165000.00, 35000, 'SOLD'),
-- Ford Fiesta (model_id = 11)
(11, 2019, 'Branco', 55000.00, 65000, 'AVAILABLE'),
(11, 2020, 'Prata', 60000.00, 48000, 'AVAILABLE'),
(11, 2021, 'Preto', 65000.00, 35000, 'AVAILABLE'),
(11, 2018, 'Vermelho', 50000.00, 75000, 'SOLD'),
-- Ford Focus (model_id = 12)
(12, 2020, 'Branco', 75000.00, 45000, 'AVAILABLE'),
(12, 2021, 'Prata', 80000.00, 32000, 'AVAILABLE'),
(12, 2019, 'Preto', 70000.00, 58000, 'AVAILABLE'),
-- Chevrolet Onix (model_id = 16)
(16, 2020, 'Branco', 65000.00, 50000, 'AVAILABLE'),
(16, 2021, 'Prata', 70000.00, 35000, 'AVAILABLE'),
(16, 2022, 'Preto', 75000.00, 20000, 'AVAILABLE'),
(16, 2019, 'Vermelho', 60000.00, 65000, 'AVAILABLE'),
(16, 2020, 'Azul', 68000.00, 48000, 'SOLD'),
-- Chevrolet Cruze (model_id = 17)
(17, 2021, 'Branco', 95000.00, 38000, 'AVAILABLE'),
(17, 2020, 'Prata', 90000.00, 52000, 'AVAILABLE'),
(17, 2022, 'Preto', 100000.00, 25000, 'AVAILABLE'),
-- Volkswagen Gol (model_id = 21)
(21, 2019, 'Branco', 50000.00, 70000, 'AVAILABLE'),
(21, 2020, 'Prata', 55000.00, 55000, 'AVAILABLE'),
(21, 2021, 'Preto', 60000.00, 40000, 'AVAILABLE'),
(21, 2018, 'Vermelho', 45000.00, 80000, 'SOLD'),
(21, 2020, 'Azul', 58000.00, 50000, 'AVAILABLE'),
-- Volkswagen Polo (model_id = 22)
(22, 2020, 'Branco', 70000.00, 48000, 'AVAILABLE'),
(22, 2021, 'Prata', 75000.00, 35000, 'AVAILABLE'),
(22, 2022, 'Preto', 80000.00, 22000, 'AVAILABLE'),
(22, 2019, 'Cinza', 68000.00, 60000, 'AVAILABLE'),
-- BMW 320i (model_id = 26)
(26, 2020, 'Branco', 180000.00, 40000, 'AVAILABLE'),
(26, 2021, 'Prata', 195000.00, 30000, 'AVAILABLE'),
(26, 2022, 'Preto', 210000.00, 15000, 'AVAILABLE'),
(26, 2019, 'Azul', 170000.00, 55000, 'SOLD'),
-- BMW X3 (model_id = 27)
(27, 2021, 'Branco', 250000.00, 35000, 'AVAILABLE'),
(27, 2022, 'Prata', 270000.00, 20000, 'AVAILABLE'),
(27, 2020, 'Preto', 240000.00, 48000, 'AVAILABLE'),
-- Mercedes-Benz C180 (model_id = 31)
(31, 2020, 'Branco', 200000.00, 42000, 'AVAILABLE'),
(31, 2021, 'Prata', 215000.00, 30000, 'AVAILABLE'),
(31, 2022, 'Preto', 230000.00, 18000, 'AVAILABLE'),
(31, 2019, 'Cinza', 190000.00, 58000, 'SOLD'),
-- Mercedes-Benz GLA (model_id = 32)
(32, 2021, 'Branco', 220000.00, 38000, 'AVAILABLE'),
(32, 2022, 'Prata', 240000.00, 25000, 'AVAILABLE'),
(32, 2020, 'Preto', 210000.00, 50000, 'AVAILABLE'),
-- Audi A3 (model_id = 36)
(36, 2020, 'Branco', 185000.00, 40000, 'AVAILABLE'),
(36, 2021, 'Prata', 200000.00, 30000, 'AVAILABLE'),
(36, 2022, 'Preto', 215000.00, 20000, 'AVAILABLE'),
(36, 2019, 'Azul', 175000.00, 55000, 'AVAILABLE'),
-- Audi A4 (model_id = 37)
(37, 2021, 'Branco', 240000.00, 35000, 'AVAILABLE'),
(37, 2020, 'Prata', 230000.00, 48000, 'AVAILABLE'),
(37, 2022, 'Preto', 255000.00, 22000, 'AVAILABLE'),
-- Nissan Versa (model_id = 41)
(41, 2020, 'Branco', 60000.00, 50000, 'AVAILABLE'),
(41, 2021, 'Prata', 65000.00, 35000, 'AVAILABLE'),
(41, 2019, 'Preto', 55000.00, 65000, 'AVAILABLE'),
(41, 2020, 'Vermelho', 62000.00, 48000, 'SOLD'),
-- Nissan Kicks (model_id = 43)
(43, 2021, 'Branco', 95000.00, 40000, 'AVAILABLE'),
(43, 2022, 'Prata', 100000.00, 28000, 'AVAILABLE'),
(43, 2020, 'Preto', 90000.00, 55000, 'AVAILABLE'),
(43, 2021, 'Azul', 98000.00, 38000, 'AVAILABLE'),
-- Hyundai HB20 (model_id = 46)
(46, 2020, 'Branco', 58000.00, 52000, 'AVAILABLE'),
(46, 2021, 'Prata', 63000.00, 38000, 'AVAILABLE'),
(46, 2022, 'Preto', 68000.00, 25000, 'AVAILABLE'),
(46, 2019, 'Vermelho', 55000.00, 68000, 'AVAILABLE'),
(46, 2020, 'Azul', 60000.00, 50000, 'SOLD'),
-- Hyundai Creta (model_id = 47)
(47, 2021, 'Branco', 110000.00, 40000, 'AVAILABLE'),
(47, 2022, 'Prata', 120000.00, 28000, 'AVAILABLE'),
(47, 2020, 'Preto', 105000.00, 55000, 'AVAILABLE'),
-- Kia Rio (model_id = 51)
(51, 2020, 'Branco', 55000.00, 50000, 'AVAILABLE'),
(51, 2021, 'Prata', 60000.00, 35000, 'AVAILABLE'),
(51, 2019, 'Preto', 50000.00, 65000, 'AVAILABLE'),
(51, 2020, 'Vermelho', 57000.00, 48000, 'AVAILABLE'),
-- Kia Sportage (model_id = 53)
(53, 2021, 'Branco', 130000.00, 40000, 'AVAILABLE'),
(53, 2022, 'Prata', 140000.00, 28000, 'AVAILABLE'),
(53, 2020, 'Preto', 125000.00, 55000, 'AVAILABLE'),
(53, 2021, 'Azul', 135000.00, 38000, 'SOLD'),
-- Fiat Uno (model_id = 56)
(56, 2019, 'Branco', 40000.00, 70000, 'AVAILABLE'),
(56, 2020, 'Prata', 45000.00, 55000, 'AVAILABLE'),
(56, 2021, 'Preto', 50000.00, 40000, 'AVAILABLE'),
(56, 2018, 'Vermelho', 38000.00, 80000, 'AVAILABLE'),
-- Fiat Palio (model_id = 57)
(57, 2020, 'Branco', 48000.00, 52000, 'AVAILABLE'),
(57, 2021, 'Prata', 53000.00, 38000, 'AVAILABLE'),
(57, 2019, 'Preto', 45000.00, 65000, 'SOLD'),
-- Renault Kwid (model_id = 61)
(61, 2020, 'Branco', 42000.00, 55000, 'AVAILABLE'),
(61, 2021, 'Prata', 47000.00, 40000, 'AVAILABLE'),
(61, 2022, 'Preto', 52000.00, 25000, 'AVAILABLE'),
(61, 2019, 'Vermelho', 40000.00, 68000, 'AVAILABLE'),
-- Renault Sandero (model_id = 62)
(62, 2020, 'Branco', 50000.00, 52000, 'AVAILABLE'),
(62, 2021, 'Prata', 55000.00, 38000, 'AVAILABLE'),
(62, 2022, 'Preto', 60000.00, 25000, 'AVAILABLE'),
(62, 2019, 'Azul', 48000.00, 65000, 'AVAILABLE'),
-- Renault Duster (model_id = 63)
(63, 2021, 'Branco', 90000.00, 42000, 'AVAILABLE'),
(63, 2022, 'Prata', 95000.00, 30000, 'AVAILABLE'),
(63, 2020, 'Preto', 85000.00, 58000, 'AVAILABLE'),
(63, 2021, 'Vermelho', 92000.00, 40000, 'SOLD'),
-- Peugeot 208 (model_id = 66)
(66, 2020, 'Branco', 65000.00, 50000, 'AVAILABLE'),
(66, 2021, 'Prata', 70000.00, 35000, 'AVAILABLE'),
(66, 2019, 'Preto', 60000.00, 65000, 'AVAILABLE'),
(66, 2020, 'Azul', 68000.00, 48000, 'AVAILABLE'),
-- Peugeot 2008 (model_id = 67)
(67, 2021, 'Branco', 95000.00, 40000, 'AVAILABLE'),
(67, 2022, 'Prata', 100000.00, 28000, 'AVAILABLE'),
(67, 2020, 'Preto', 90000.00, 55000, 'AVAILABLE'),
-- Volvo XC40 (model_id = 71)
(71, 2021, 'Branco', 220000.00, 38000, 'AVAILABLE'),
(71, 2022, 'Prata', 240000.00, 25000, 'AVAILABLE'),
(71, 2020, 'Preto', 210000.00, 50000, 'AVAILABLE'),
(71, 2021, 'Azul', 230000.00, 35000, 'SOLD'),
-- Volvo XC60 (model_id = 72)
(72, 2021, 'Branco', 280000.00, 40000, 'AVAILABLE'),
(72, 2022, 'Prata', 300000.00, 28000, 'AVAILABLE'),
(72, 2020, 'Preto', 270000.00, 55000, 'AVAILABLE'),
-- Additional vehicles to reach 100+
(1, 2018, 'Cinza', 72000.00, 75000, 'DISCONTINUED'),
(6, 2018, 'Cinza', 80000.00, 70000, 'DISCONTINUED'),
(11, 2017, 'Azul', 42000.00, 90000, 'DISCONTINUED'),
(16, 2018, 'Cinza', 55000.00, 75000, 'DISCONTINUED'),
(21, 2017, 'Amarelo', 40000.00, 95000, 'DISCONTINUED'),
(26, 2018, 'Cinza', 160000.00, 70000, 'DISCONTINUED'),
(31, 2018, 'Azul', 180000.00, 68000, 'DISCONTINUED'),
(36, 2018, 'Cinza', 165000.00, 70000, 'DISCONTINUED'),
(41, 2018, 'Azul', 50000.00, 80000, 'DISCONTINUED'),
(46, 2018, 'Cinza', 50000.00, 80000, 'DISCONTINUED'),
(51, 2018, 'Azul', 45000.00, 80000, 'DISCONTINUED'),
(56, 2017, 'Azul', 35000.00, 95000, 'DISCONTINUED'),
(61, 2018, 'Azul', 38000.00, 80000, 'DISCONTINUED'),
(66, 2018, 'Vermelho', 55000.00, 75000, 'DISCONTINUED'),
(71, 2019, 'Cinza', 200000.00, 60000, 'DISCONTINUED');

