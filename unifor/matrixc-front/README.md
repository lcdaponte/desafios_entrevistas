## Matrixc-front
Matrixc-front consiste em um sistema responsável por lidar com a vizualização de Matrizes Curriculares, assim como gerenciar usuários(Aluno, Professor, Coordenador e Admin), cursos, semestres e disciplinas. 

## Motivação
Motivado por um desafio de implementação, o Matrixc-front deverá completar esse desafio. Com isso, acarretará em um crescimento pessoal e profissional.

## Decisões de Projeto

Vamos iniciar essa sessão explicando um pouco de como foi o processo de desenvolvimento e depois aprofundar em como ele está no momento:

- O Angularjs foi escolhido devido a familiaridade e com isso a esperança de alcançar uma maior produtividade.
- Isso se mostrou verdade logo no inicio do desenvolvimento.
- Foi escolhido a biblioteca http-server para poder servir a aplicação devido a sua simplicidade e facilidade em seu manuseio. Por exemplo, para modificar a porta em que a aplicação sobe, basta colocar o <code>-p {novaPorta} </code>
- A estrutura do projeto está disposta muito pela praticidade, tendo ajudado no desenvolvimento. Mas a principio havia imaginado a estrutura do projeto de maneira diferente. Uma feature será aberta com o intuito de reorganizar o projeto.
- No <code>package.json</code> fica todas as informações do projeto e vale chamar atenção para o campo <code>"scripts": {"server": "http-server -p 4000"}</code>. Com essa declaração, é possível executar o servidor via linha de comando com <code>npm run server</code>, onde server é o nome dado ao comando.
- No momento, devido a problemas com os imports das bibliotecas do <code>node_modules</code>, o import no arquivo <code>index.html</code> está sendo feito via CDN.
- Já no arquivo <code>app.js</code> é feita a declaração do objeto do angular. Tal objeto será essencial na criação de controllers, services, rotas e muito mais.
- As declarações das rotas estão no arquivo <code>routes.js</code>. Lá o angular-route, por meio do <code>$routeProvider</code>, define as rotas da aplicação.
- As declarações dos controllers estão no arquivo <code>controllers.js</code>. Lá é feito o manuseio das informações oriundas do model, declarado nas páginas html. Em breve, será aberto uma feature para separar os controllers para que cada arquivo cuide de sua entidade.
- Já as declarações da camada se serviço estão no arquivo <code>services.js</code>. Lá é onde separamos a lógica, por exemplo, das chamadas ao backend. Também foi feito um serviço de validação chamado de <code>usuarioService</code>. Serviço esse que no futuro também poderia ser responsável por cuidar da parte de login/logout.
- É importante também deixar registrado que devido aos imports via CDN no index.html, é possível que uma biblioteca ou outra demore para carregar. Em caso de demora, analisar na aba network do navegador chrome.

## Tecnologias/frameworks utilizados
Foram utilizadas tecnologias mais familiares de maneira a tirar melhor proveito e aumentar a produtividade.

<b>Desenvolvido com</b>
- [Nodejs v10.4.1](https://nodejs.org/pt-br/)
- [Angularjs 1.2.25](https://angularjs.org/)
- [http-server 0.11.1](https://www.npmjs.com/package/http-server)

## Instalação
1. Instalar o Nodejs e garantir que está corretamente instalado. Pode verificar a instalação executando o comando <code>node -v</code> e <code>npm -v</code>. As respectivas versões de node e npm aparecerão em caso de instalação bem sucedida.
2. Fazer o fork do projeto e em seguida baixá-lo <code>git clone https://github.com/lcdaponte/matrixc-front.git</code>
3. Navegar até a raiz do projeto e executar via linha de comando, o seguinte comando: <code>npm install</code>. Isso fará o download das dependências do projeto, localizadas no <code>package.json</code>
4. Ainda na raiz do projeto, executar o seguinte comando para iniciar o servidor local: <code>npm run server</code>. Isso subirá o servidor local e a aplicação estará acessível via <code>http://localhost:4000/</code>. Em caso de mudança da porta do servidor, o backend deverá ser modificado de tal maneira que a nova porta seja liberada, para que não haja problema de cors.


## Exemplo do código

É possível fazer um controller de maneira bem simples:
      
    matrixc.controller('mainController', function($scope, alunoService) {
        // create a message to display in our view
        $scope.message = 'Everyone come and see how good I look!';
    });
No exemplo acima, o <code>matrixc</code> representa o angular e chamamos o metodo <code>controller</code> para registrar um controller.

Para criar um Service para a acesso a banco é ainda mais simples:

    matrixc.factory("adminService", function($http){
        function obterTodosAdmins(){
            return $http.get('http://localhost:8080/admin');
        }

        function inserirAdmin(admin){
            return $http.post('http://localhost:8080/admin', admin);
        }

        function editarAdmin(admin){
            return $http.put('http://localhost:8080/admin/' + admin.id, admin);
        }

        function deletarAdmin(id){
            return $http.delete('http://localhost:8080/admin/' + id);
        }

        return {
            obterTodosAdmins: obterTodosAdmins,
            inserirAdmin: inserirAdmin,
            editarAdmin: editarAdmin,
            deletarAdmin: deletarAdmin
        }
    });
No angularjs, apenas um objeto pode ser retornado e nesse objeto deve conter os métodos do Service. Criamos os métodos e neles colocamos uma lógica especifica da entidade de que se trata. No exemplo acima, podemos ver os métodos responsáveis por fazer as requisições para o backend.


MIT © [lcdaponte](https://github.com/lcdaponte)