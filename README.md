
  <h1>Projeto de Cadastro de Shows, Bandas e Locais - Java EE</h1>

  <h2>Descrição do Projeto</h2>
  <p>Este é um projeto Java EE utilizando JSP e Hibernate, desenvolvido para gerenciar informações relacionadas a shows, bandas e locais. O sistema utiliza o MySQL como banco de dados para armazenar os dados relevantes.</p>

  <h2>Tecnologias Utilizadas</h2>
  <ul>
      <li>Java EE</li>
      <li>JSP (JavaServer Pages)</li>
      <li>Servlets</li>
      <li>Hibernate</li>
      <li>MySQL</li>
      <li>HTML, CSS, JavaScript</li>
  </ul>

  <h2>Configuração do Ambiente</h2>
  <ol>
      <li><strong>Java Development Kit (JDK):</strong> Certifique-se de ter o JDK instalado. Recomenda-se a versão 8 ou superior. <a href="https://www.oracle.com/java/technologies/javase-downloads.html">Download do JDK</a></li>
      <li><strong>Servidor de Aplicação:</strong> Utilize um servidor de aplicação compatível com Java EE, como Apache Tomcat ou WildFly.</li>
      <li><strong>Banco de Dados:</strong> Instale e configure o MySQL. Crie um banco de dados chamado <code>cadastro_shows</code>. Configure as informações de conexão no arquivo <code>persistence.xml</code>.</li>
      <li><strong>IDE (Ambiente de Desenvolvimento Integrado):</strong> Use uma IDE Java EE, como Eclipse ou IntelliJ, para facilitar o desenvolvimento.</li>
  </ol>

  <h2>Configuração do Banco de Dados</h2>
  <ol>
      <li>Execute o script SQL <code>create_tables.sql</code> localizado na pasta <code>database</code> para criar as tabelas necessárias.</li>
  </ol>

  <h2>Configuração do Hibernate</h2>
  <ol>
      <li>Configure as informações de conexão com o banco de dados no arquivo <code>persistence.xml</code> localizado em <code>src/main/resources/META-INF</code>.</li>
  </ol>

  <h2>Executando o Projeto</h2>
  <ol>
      <li>Importe o projeto para sua IDE.</li>
      <li>Certifique-se de que o servidor de aplicação está configurado corretamente.</li>
      <li>Deploy o projeto no servidor de aplicação.</li>
      <li>Acesse o aplicativo pelo navegador: <code>http://localhost:8080/nome-do-projeto</code></li>
  </ol>

  <h2>Funcionalidades</h2>
  <ul>
      <li>Cadastro, edição e exclusão de shows, bandas e locais.</li>
      <li>Visualização de informações detalhadas sobre shows, bandas e locais.</li>
  </ul>
