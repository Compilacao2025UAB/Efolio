README: Como preparar e correr o projeto ANTLR4 no VSCode e IntelliJ

1. Pré-requisitos
	*Java JDK instalado (recomendado: 11 ou superior)
	*Ficheiro antlr-4.x-complete.jar na pasta do projeto
2. Estrutura do Projeto
	O projeto é um compilador para uma linguagem tipo C, chamado MOC, e está dividido em vários módulos principais:

		a) src/: Código-fonte Java do compilador

		b) src/parser/: Ficheiros gerados pelo ANTLR4 a partir da gramática MOC.g4

		c) src/lib/: Biblioteca ANTLR4 (antlr-4.13.2-complete.jar)

		d) out/: Repartição de saída para os ficheiros .class

		e) testes/: Ficheiros de teste .moc

		f) compile.bat: Script para compilar e correr testes automaticamente

3. Como correr no IntelliJ IDEA
	a) Importar o projeto

		o Abrir IntelliJ IDEA
		o Selecionar "Open" e escolher a pasta do projeto
		o O projeto deve ser reconhecido como "Java Project"

	b) Adicionar o JAR do ANTLR4

		o Clicar com o botão direito na pasta do projeto → Open Module Settings (F4)
		o Ir a Libraries → "+" → Java → selecionar o ficheiro antlr-4.x-complete.jar
		o Aplicar e fechar

4. Configuração no VSCode (com botão de executar)
	a) Adicionar o JAR ao classpath do projeto
		o Criar (ou editar) o ficheiro .vscode/settings.json na raiz do projeto:
		{ 
  		"java.project.referencedLibraries": [ 
    		"antlr-4.x-complete.jar" 
  			] 
		} 
		> Usar / em vez de \ no caminho, se necessário.

	b) Reiniciar o VSCode para garantir que as alterações são reconhecidas.
		o Configurar o botão de executar (Run/Debug)
		1.Abrir o ficheiro Main.java.
		2.Se o botão de executar ainda n o funcionar, criar o ficheiro .vscode/launch.json 
		com o seguinte conteúdo:
		{ 
  		"version": "0.2.0", 
  		"configurations": [ 
    		{ 
      		"type": "java", 
      		"name": "Executar Main", 
      		"request": "launch", 
      		"mainClass": "Main", 
      		"projectName": "EfolioA", 
      		"vmArgs": "-cp .;antlr-4.x-complete.jar" 
    			} 
  		    ] 
		}
		o Garantir que "mainClass" corresponde ao nome da classe principal.
		o Se o projeto estiver numa subpasta, ajustar o caminho do JAR.
		o O botão de executar (Run) no topo do VSCode deve funcionar e incluir o JAR do 
		ANTLR4 no classpath.


5. Notas Importantes
	* Se os imports estiverem a vermelho, confirmar o caminho do JAR e reiniciar o VSCode.
 	* Usar sempre a mesma versão do ANTLR4 para gerar e correr o projeto.
	* A visualização da AST usa Swing/JFrame – pode ser necessário permitir popups.
	* O script compile.bat só funciona em Windows. Para Linux/Mac, adapta os comandos manualmente.
6. Resolução de problemas
	* Erro "cannot be resolved to a type": O JAR do ANTLR4 não está no classpath.
	* Programa compila no IntelliJ mas n o no VSCode: VSCode precisa de configuração manual do classpath.
	* Caminhos com espaços: Usa aspas ou / em vez de \ nos caminhos.
	* Erro de ficheiro não encontrado: Verifica o nome e extensão do ficheiro de entrada.





Execução do Programa: Descrição do Processo

O programa foi preparado para ser executado a partir do botão de "executar" do IDE 
(VSCode ou IntelliJ), assumindo que todas as dependências estão corretamente 
configuradas.
1. Estrutura de Pastas e Ficheiros de Teste
	* Existe uma pasta chamada testes na raiz do projeto.
	* Dentro desta pasta, encontras vários ficheiros de teste.
	* Cada ficheiro de teste tem um nome específico e extensão incluída (por 
	exemplo: exemplo1.moc, exemplo2.moc, etc).
2. Como Executar
 	* Abrir o projeto no VSCode ou IntelliJ.
 	* Abrir o ficheiro compile.bat.
	* Na linha 12 do ficheiro compile.bat alterar o nome do teste consoante o teste a executar (exemplo:"TEST_FILE=testes\teste22-io-stringsOK.moc" )
	* Clicar no botão de executar (Run) do IDE.
	* O ficheiro deve estar dentro da pasta testes.
3. O que acontece durante a execução
	* O programa lê o ficheiro de teste indicado.
	* Se existirem erros de sintaxe ou semântica, estes são exibidos na consola.
	* Se não houver erros, o programa:
		- gera e exibe a AST (árvore Sintática Abstrata) usando as ferramentas do ANTLR4;
		- mostra a tabela de símbolos;
		- gera e imprime o código TAC simples e otimizado, em formato de tabela e linha a linha;
		- a conversão de literais char/string para ASCII é feita automaticamente pelo pré-processador.
