FROM alpine:latest

# Define variáveis de ambiente
ENV PYTHONUNBUFFERED=1

RUN apk update && \
    apk add --no-cache python3 py3-flask py3-flask-cors && \
    rm -rf /var/cache/apk/*

WORKDIR /app

COPY app.py /app/app.py

EXPOSE 5000

CMD ["python3", "/app/app.py"]