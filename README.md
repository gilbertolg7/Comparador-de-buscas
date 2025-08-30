🔎 **Comparador de Buscas – Projeto Spring Boot**

Este projeto é um serviço web desenvolvido com Spring Boot que compara o desempenho de diferentes algoritmos de busca (não-informada e informada) em dois grafos distintos: um rodoviário e outro aéreo.

✅ **Funcionalidades principais**

Compara algoritmos de busca em grafos, incluindo:

Busca em Largura

Busca em Profundidade

Busca de Custo Uniforme

Busca Gulosa

Busca A*

Permite encontrar e comparar o caminho mais eficiente entre uma cidade de origem e uma de destino.

Disponibiliza uma API REST para realizar as buscas com base nos parâmetros fornecidos.

▶️ **Como usar**

1. Pré-requisitos
Java JDK 17 ou superior

Maven

Uma IDE Java compatível com Maven (VS Code, Eclipse, IntelliJ IDEA, etc.)

2. Executar o projeto
Clone ou extraia o projeto em sua máquina.

Importe como um projeto Maven na sua IDE.

Execute a classe principal da aplicação para iniciar o servidor web.

🧪 **Guia de uso **

O serviço expõe uma pagina Web onde o usuário pode interagir escolhendo Destino, Origem e Algoritmo de Busca.

origem: O nome da cidade de partida (ex: São Paulo)

destino: O nome da cidade de chegada (ex: Rio de Janeiro)

algoritmo: O nome do algoritmo de busca a ser utilizado (opções: largura, profundidade, uniforme, gulosa, a)


👤 **Autor**

Projeto desenvolvido para fins didáticos, focado no estudo e aplicação de algoritmos de busca e estruturas de dados em Sistemas inteligentes.
