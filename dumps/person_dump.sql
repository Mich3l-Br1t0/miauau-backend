-- Inserting into person table with UUIDs and Brazilian names
INSERT INTO person
(id, cpf, created_at, date_of_birth, email, landline, name, phone, profession, rg, volunteer)
VALUES('c56a4180-65aa-42ec-a945-5fd21dec0538', '12345678900', '2024-10-05', '1980-12-15', 'joao.silva@example.com', '1134567890', 'João Silva', '11987654321', 'Engenheiro', '123456789', true);

INSERT INTO person
(id, cpf, created_at, date_of_birth, email, landline, name, phone, profession, rg, volunteer)
VALUES('e56a3180-78cd-42bc-a946-6fd22dec0667', '23456789012', '2024-10-05', '1985-03-22', 'maria.oliveira@example.com', '1123456789', 'Maria Oliveira', '11986543210', 'Médica', '234567890', true);

INSERT INTO person
(id, cpf, created_at, date_of_birth, email, landline, name, phone, profession, rg, volunteer)
VALUES('f56b4181-85ab-48fa-a947-7fd23dec0776', '34567890123', '2024-10-05', '1995-07-10', 'pedro.souza@example.com', '1132345678', 'Pedro Souza', '11985432109', 'Professor', '345678901', true);

INSERT INTO person
(id, cpf, created_at, date_of_birth, email, landline, name, phone, profession, rg, volunteer)
VALUES('d78a6182-95cc-43cb-b959-8fd24dec0885', '45678901234', '2024-10-05', '1992-12-05', 'ana.santos@example.com', '1121234567', 'Ana Santos', '11984321098', 'Enfermeira', '456789012', true);

INSERT INTO person
(id, cpf, created_at, date_of_birth, email, landline, name, phone, profession, rg, volunteer)
VALUES('a9f060dd-41bd-44dc-8e68-1bab24ad3ca2', '56789012345', '2024-10-05', '1988-04-30', 'carlos.pereira@example.com', '1143210987', 'Carlos Pereira', '11983210987', 'Advogado', '567890123', true);

INSERT INTO person
(id, cpf, created_at, date_of_birth, email, landline, name, phone, profession, rg, volunteer)
VALUES('96ca5758-9353-4263-a62c-41105b29a904', '67890123456', '2024-10-05', '1993-09-15', 'juliana.costa@example.com', '1134567899', 'Juliana Costa', '11982109876', 'Arquiteta', '678901234', true);

INSERT INTO person
(id, cpf, created_at, date_of_birth, email, landline, name, phone, profession, rg, volunteer)
VALUES('e7a1f995-afe8-4a1b-b624-1a6295c447b6', '78901234567', '2024-10-05', '1990-06-20', 'lucas.rocha@example.com', '1176543210', 'Lucas Rocha', '11981098765', 'Desenvolvedor de Software', '789012345', true);

INSERT INTO person
(id, cpf, created_at, date_of_birth, email, landline, name, phone, profession, rg, volunteer)
VALUES('f1f8fe56-8d35-4886-b1e6-be1132f1c40b', '89012345678', '2024-10-05', '1991-11-25', 'fernanda.lima@example.com', '1187654321', 'Fernanda Lima', '11980987654', 'Farmacêutica', '890123456', true);

INSERT INTO person
(id, cpf, created_at, date_of_birth, email, landline, name, phone, profession, rg, volunteer)
VALUES('6d1b1c3d-2e30-49bb-a34f-5aaad83cc63c', '90123456789', '2024-10-05', '1994-02-10', 'bruno.martins@example.com', '1198765432', 'Bruno Martins', '11979876543', 'Contador', '901234567', true);

INSERT INTO person
(id, cpf, created_at, date_of_birth, email, landline, name, phone, profession, rg, volunteer)
VALUES('03756a83-792d-4449-b2d6-02584546068e', '01234567890', '2024-10-05', '1987-08-14', 'carla.ferreira@example.com', '1129876543', 'Carla Ferreira', '11978765432', 'Gerente de Marketing', '012345678', true);

-- Inserting into address table with Brazilian addresses
INSERT INTO address
(id, complement, neighborhood, number, street, zip_code, person_id)
VALUES('a1d9bce5-9c45-4c4d-a614-6155ab850f0e', 'Apt 101', 'Centro', '123', 'Rua das Flores', '01000-000', 'c56a4180-65aa-42ec-a945-5fd21dec0538');

INSERT INTO address
(id, complement, neighborhood, number, street, zip_code, person_id)
VALUES('81142383-0f70-4f31-8a94-612179dfcaf5', 'Casa 12', 'Jardins', '456', 'Avenida Paulista', '01310-000', 'e56a3180-78cd-42bc-a946-6fd22dec0667');

INSERT INTO address
(id, complement, neighborhood, number, street, zip_code, person_id)
VALUES('12af668e-64fc-4895-94e1-964b1d820399', '', 'Vila Madalena', '789', 'Rua Harmonia', '05435-000', 'f56b4181-85ab-48fa-a947-7fd23dec0776');

INSERT INTO address
(id, complement, neighborhood, number, street, zip_code, person_id)
VALUES('e9ebb8fe-eabf-4597-a96a-13db0125b1c3', '', 'Pinheiros', '321', 'Rua dos Pinheiros', '05422-010', 'd78a6182-95cc-43cb-b959-8fd24dec0885');

INSERT INTO address
(id, complement, neighborhood, number, street, zip_code, person_id)
VALUES('8bc10beb-9bb0-4499-a001-642af8f0d888', '', 'Moema', '654', 'Avenida Ibirapuera', '04029-000', 'a9f060dd-41bd-44dc-8e68-1bab24ad3ca2');

INSERT INTO address
(id, complement, neighborhood, number, street, zip_code, person_id)
VALUES('6daff992-d9ab-47a1-a769-d337ddf61002', 'Apt 202', 'Jardim América', '987', 'Rua Augusta', '01413-000', '96ca5758-9353-4263-a62c-41105b29a904');

INSERT INTO address
(id, complement, neighborhood, number, street, zip_code, person_id)
VALUES('4b02d9bb-99b8-4f03-a768-54d450683a86', '', 'Liberdade', '432', 'Rua Galvão Bueno', '01506-000', 'e7a1f995-afe8-4a1b-b624-1a6295c447b6');

INSERT INTO address
(id, complement, neighborhood, number, street, zip_code, person_id)
VALUES('931d7c15-d35d-4886-b7c0-32c7fcaabb7b', '', 'Vila Mariana', '555', 'Rua Domingos de Morais', '04010-000', 'f1f8fe56-8d35-4886-b1e6-be1132f1c40b');

INSERT INTO address
(id, complement, neighborhood, number, street, zip_code, person_id)
VALUES('a6f58cf6-cfb7-481c-b15c-5c2bc2f3a32f', '', 'Bela Vista', '678', 'Rua Treze de Maio', '01327-000', '6d1b1c3d-2e30-49bb-a34f-5aaad83cc63c');

INSERT INTO address
(id, complement, neighborhood, number, street, zip_code, person_id)
VALUES('dad897a7-2b87-45ac-887b-fd64da79d1a0', 'Apt 303', 'Vila Olímpia', '987', 'Rua Funchal', '04551-060', '03756a83-792d-4449-b2d6-02584546068e');

-- Inserting into occupation table
INSERT INTO occupation
(id, other, studying, unemployed, working, person_id)
VALUES('b4d9c0e5-7c45-6c5d-d914-1234ab850d2e', '', false, false, true, 'c56a4180-65aa-42ec-a945-5fd21dec0538');

INSERT INTO occupation
(id, other, studying, unemployed, working, person_id)
VALUES('d5e9d1f6-4d65-5d7e-e024-2345bc850e3e', '', false, true, false, 'e56a3180-78cd-42bc-a946-6fd22dec0667');

INSERT INTO occupation
(id, other, studying, unemployed, working, person_id)
VALUES('8b2a8b7c-77e1-4d33-9a34-02ed1c255362', '', false, true, true, 'f56b4181-85ab-48fa-a947-7fd23dec0776');

INSERT INTO occupation
(id, other, studying, unemployed, working, person_id)
VALUES('0d3fa7fb-5318-43ca-bd25-03265f144a12', '', false, true, false, 'd78a6182-95cc-43cb-b959-8fd24dec0885');

INSERT INTO occupation
(id, other, studying, unemployed, working, person_id)
VALUES('7eb5ce3d-2685-4e47-ad4b-dd1c66a0176f', '', true, false, true, 'a9f060dd-41bd-44dc-8e68-1bab24ad3ca2');

INSERT INTO occupation
(id, other, studying, unemployed, working, person_id)
VALUES('8ed948db-d736-44e3-b0d2-ce9a0dae72c7', '', true, false, false, '96ca5758-9353-4263-a62c-41105b29a904');

INSERT INTO occupation
(id, other, studying, unemployed, working, person_id)
VALUES('7dccf158-e46d-4d2f-abd7-0bfb422aaa90', '', true, true, true, 'e7a1f995-afe8-4a1b-b624-1a6295c447b6');

INSERT INTO occupation
(id, other, studying, unemployed, working, person_id)
VALUES('741b6081-4b7e-4a15-8063-908d6f6b9670', '', true, true, false, 'f1f8fe56-8d35-4886-b1e6-be1132f1c40b');

INSERT INTO occupation
(id, other, studying, unemployed, working, person_id)
VALUES('162b9e79-f215-4f94-bc9c-80cfbd34b5d0', '', false, false, true, '6d1b1c3d-2e30-49bb-a34f-5aaad83cc63c');

INSERT INTO occupation
(id, other, studying, unemployed, working, person_id)
VALUES('b3f90436-9490-4779-aee1-90572d618fe7', '', false, true, false, '03756a83-792d-4449-b2d6-02584546068e');