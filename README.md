# CRUD Estoque de Veículos — Spring Boot + Next.js

## Como executar

1) MySQL

```sql
CREATE DATABASE vehicledb CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;
CREATE USER 'vehuser'@'%' IDENTIFIED BY 'vehpass';
GRANT ALL PRIVILEGES ON vehicledb.* TO 'vehuser'@'%';
FLUSH PRIVILEGES;
```

2) Backend

```bash
cd backend
mvn spring-boot:run
```

3) Frontend

```bash
cd frontend
npm install
npm run dev
```

Configure `API_BASE_URL`/`NEXT_PUBLIC_API_BASE_URL` no `.env.local` do frontend se necessário.

## Estrutura

- Backend: `backend/` (Spring Boot 3 + JPA + MySQL)
- Frontend: `frontend/` (Next.js 14)

Endpoints principais:
- POST `/api/brands`, GET `/api/brands`
- POST `/api/models`, GET `/api/models?brandId=`
- POST `/api/vehicles`, GET `/api/vehicles`, GET `/api/vehicles/{id}`, PATCH `/api/vehicles/{id}`, DELETE `/api/vehicles/{id}`

Filtros suportados em `/api/vehicles`:
`brandId`, `modelId`, `year`, `status`, `minPrice`, `maxPrice`, paginação e ordenação via `page`, `size`, `sort`.


