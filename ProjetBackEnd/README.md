# API Exemplo

Projeto Spring Boot minimal conforme solicitado.

Como rodar:

- Usando Maven instalado:

```powershell
mvn spring-boot:run
```

- Usando wrapper (se gerar):

```powershell
.\mvnw.cmd spring-boot:run
```

Endpoints principais:

- `GET /iniciativa` — lista todas iniciativas
- `POST /iniciativa` — cria iniciativa (body JSON)
- `DELETE /iniciativa/{id}` — deleta iniciativa por id
- `GET /atividades/{iniciativaId}` — lista atividades por iniciativa
- `POST /atividades` — cria atividade (use `AtividadeDTO` no body)
- `DELETE /atividades/{id}` — deleta atividade por id
- `GET /responsavel/{id}` — busca responsável por id
- `POST /responsavel` — cria responsável
- `POST /responsavel/{responsavelId}/iniciativa/{iniciativaId}` — associa responsável a iniciativa
- `DELETE /responsavel/{id}` — deleta responsável por id

H2 console disponível em: `/h2-console` (URL: `jdbc:h2:mem:schoolbd`)
