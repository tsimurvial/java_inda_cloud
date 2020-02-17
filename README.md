# java_inda_cloud
- Service discovery
- Api-gateway
- Circuit breaker

### Build

```bash
mvn clean package
```

### Deploy

```bash
docker-compose up -d

```

### Use

```bash
curl --request POST \
  --url http://localhost:8762/pc/catalog \
  --header 'content-type: application/json' \
  --data '{
	"name": "Internet",
	"price": 500
}'
```

```bash
curl --request GET \
  --url http://localhost:8762/pc/catalog/{specification_id}
```

```bash
curl --request PUT \
  --url http://localhost:8762/po/catalog/{specification_id}/order
```


