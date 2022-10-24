@echo off
 docker pull selenoid/chrome:latest
 docker compose up -d
copy  browsers.json  C:\DockerVolumes\Test\Seleniod
PING -n 5 127.0.0.1>nul
 docker compose up -d