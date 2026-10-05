FROM mcr.microsoft.com/devcontainers/java:1-21-bookworm

USER root

# Remove outdated Yarn repository from the base image
RUN rm -f /etc/apt/sources.list.d/yarn.list \
    /etc/apt/sources.list.d/yarnpkg.list

# Install Chromium and ChromeDriver
RUN apt-get update \
    && apt-get install -y \
        chromium \
        chromium-driver \
    && apt-get clean \
    && rm -rf /var/lib/apt/lists/*

USER vscode