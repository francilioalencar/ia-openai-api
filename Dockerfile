# Usa uma imagem oficial do OpenJDK 17
FROM openjdk:17-slim

# Define o diretório de trabalho dentro do contêiner
WORKDIR /workspace

# Mantém o contêiner rodando para que possa ser usado pelo VS Code
CMD ["tail", "-f", "/dev/null"]
