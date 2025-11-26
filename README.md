# Curso Selenium WebDriver — TargetTrust T1606335

Projeto de exemplos e testes automatizados com Selenium WebDriver como parte do curso da TargetTrust.

## Visão Geral
- Linguagem: Java
- Build/gestão de dependências: Maven
- Estrutura padrão de testes em `src/test/java`
- Exemplos de testes: `com.test.WebElementsTest`

## Requisitos
- Java 11+ (ou versão utilizada no curso)
- Maven 3.8+
- Navegador Google Chrome (recomendado para o curso)
- WebDriver gerenciado automaticamente via WebDriverManager

## Clonar o projeto
```bash
# Via HTTPS (recomendado)
git clone https://github.com/amtrindade/webdriver-T1606335.git
cd webdriver-T1606335

# Via SSH (se tiver chave SSH configurada)
git clone git@github.com:amtrindade/webdriver-T1606335.git
cd webdriver-T1606335
```

## Configuração do WebDriver

### Opção 1: WebDriverManager (Recomendado)
O projeto utiliza **WebDriverManager** para gerenciar automaticamente os drivers dos navegadores. Não é necessário baixar ou configurar drivers manualmente.

Adicione a dependência no `pom.xml` (se ainda não estiver presente):
```xml
<dependency>
    <groupId>io.github.bonigarcia</groupId>
    <artifactId>webdrivermanager</artifactId>
    <version>5.6.2</version>
</dependency>
```

No código do teste, inicialize o driver assim:
```java
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MeuTeste {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        // seu código de teste
        driver.quit();
    }
}
```

### Opção 2: ChromeDriver Manual
Caso prefira configurar manualmente:

1. **Download do ChromeDriver:**
   - Acesse: https://chromedriver.chromium.org/downloads
   - Baixe a versão compatível com seu Google Chrome
   - Verifique a versão do Chrome: `Menu > Ajuda > Sobre o Google Chrome`

2. **Instalação no macOS:**
   ```bash
   # Mover para /usr/local/bin
   mv ~/Downloads/chromedriver /usr/local/bin/
   chmod +x /usr/local/bin/chromedriver
   
   # Remover quarentena do macOS (se necessário)
   xattr -d com.apple.quarantine /usr/local/bin/chromedriver
   ```

3. **Configuração no código:**
   ```java
   System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
   WebDriver driver = new ChromeDriver();
   ```

## Executar os testes
```bash
# Na raiz do projeto
mvn clean test
```

- O Maven irá baixar dependências e executar os testes em `src/test/java`.
- Resultados e relatórios ficam em `target/surefire-reports`.

## Estrutura do Projeto
```
.
├── pom.xml
├── src
│   ├── main
│   │   ├── java
│   │   └── resources
│   └── test
│       ├── java
│       │   └── com/test/WebElementsTest.java
│       └── resources
└── target
```

## Dicas
- Use um ambiente virtual de desenvolvimento (IntelliJ/Eclipse/VS Code) com suporte a Maven.
- Verifique variáveis de ambiente como `JAVA_HOME` e `PATH`.
- Mantenha o navegador e o driver sempre compatíveis.

## Créditos
Este projeto faz parte do curso de Selenium WebDriver da TargetTrust.
