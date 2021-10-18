[![Maven Test](https://github.com/barabelo/Sales_Data_Analyser/actions/workflows/maven-publish.yml/badge.svg)](https://github.com/barabelo/Sales_Data_Analyser/actions/workflows/maven-publish.yml)

# Sales_Data_Analyser

Este software lê arquivos CSV contendo relatórios de vendas. Cada venda possui as seguintes informações (em inglês): region, country, item type, sales channel, order priority, order date, order ID, ship date, units sold, unit price, unit cost, total revenue, total cost and total profit. Feita a leitura, o usuário poderá gerar novos arquivos CSV, cada um contendo uma lista de vendas filtrada por region, country ou item type. A pasta [Sales Reports](https://github.com/barabelo/Sales_Data_Analyser/tree/main/Sales%20Reports) do repositório contém alguns relatórios para testar o programa. Para obter mais relatórios, acesse [este site](https://eforexcel.com/wp/downloads-18-sample-csv-files-data-sets-for-testing-sales/).

### Importante: atualmente o programa tem apresentado um grande consumo de memória ao abrir arquivos muito grandes.

## Instalação
1. Instale o [maven](https://maven.apache.org/download.cgi) e o [Java 11](https://adoptium.net/?variant=openjdk11&jvmVariant=hotspot) no seu computador.
2. Clone o repositório ou baixe como zip.
3. Abra o terminal de sua preferência na pasta do repositório baixado.
4. Execute o comando ```mvn clean package```.
5. O programa (sales-data-analyser-jar-with-dependencies.jar) estará na pasta target.
6. Copie o programa para o diretório que preferir e, para executá-lo, digite no terminal ```java -jar sales-data-analyser-jar-with-dependencies.jar```.
