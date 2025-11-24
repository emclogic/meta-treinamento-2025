#!/bin/bash

docker run --privileged --rm tonistiigi/binfmt --install all

docker buildx build \
    --platform linux/arm64/v8 \
    -t led-act-backend:latest \
    --output "type=docker,dest=./led_act_backend.tar" .
