ab -n100000 -c 32 http://127.0.0.1:8080/sync?name=world
ab -n100000 -c 32 http://127.0.0.1:8080/async?name=world
