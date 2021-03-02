// Configurando as rotas
matrixc.config(function($routeProvider) {
    $routeProvider

        // route for the home page
        .when('/', {
            templateUrl : 'pages/home.html',
            controller  : 'mainController'
        })

        .when('/admin', {
            templateUrl : 'pages/admins.html',
            controller  : 'adminController'
        })

        // route for the about page alunoController
        .when('/aluno', {
            templateUrl : 'pages/alunos.html',
            controller  : 'alunoController'
        })

        .when('/coordenador', {
            templateUrl : 'pages/coordenadores.html',
            controller  : 'coordenadorController'
        })

        .when('/professor', {
            templateUrl : 'pages/professores.html',
            controller  : 'professorController'
        })
});