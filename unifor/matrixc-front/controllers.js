// create the controller and inject Angular's $scope
matrixc.controller('mainController', function($scope) {
});

matrixc.controller('adminController', function($scope, $location, adminService, usuarioService) {

    $scope.sexos = ['M', 'F'];

    // é feita a busca de todos os admins
    if(!$scope.admins){
        adminService.obterTodosAdmins().then(function (response){
            $scope.admins = response.data;
        }).catch(function(response) {
          console.error('Erro:', response.status, response.data);
        }).finally(function() {
             console.log("Admins listados.");
        });
    }

    // é feita a inserção de um admin
    $scope.adicionarAdmin = function () {

        var adminParaAdicionar = {nome:$scope.nome,matricula:$scope.matricula,sexo:$scope.sexo};

        if(usuarioService.validarUsuario(adminParaAdicionar)){
            adminService.inserirAdmin(adminParaAdicionar).then(function (response){
                $scope.admins.push(response.data);
                $scope.id = '';
                $scope.nome = '';
                $scope.matricula= '';
                $scope.sexo = '';
            }).catch(function(response) {
              console.error('Erro:', response.status, response.data);
            }).finally(function() {
                 console.log("Admin adicionado.");
            });
        }
    }

    $scope.selecionarAdminEditar = function (id) {
        
        var index = getIndexSelecionado(id);
        var admin = $scope.admins[index];
        $scope.id = admin.id;
        $scope.nome = admin.nome;
        $scope.matricula = admin.matricula;
        $scope.sexo = admin.sexo;
    }

    $scope.editarAdmin = function () {     
        var index = getIndexSelecionado($scope.id);
        var admin = $scope.admins[index];

        admin.id = $scope.id;
        admin.nome = $scope.nome;
        admin.matricula = $scope.matricula;
        admin.sexo = $scope.sexo;

        if(usuarioService.validarUsuario(admin)){

            adminService.editarAdmin(admin).then(function (response){
            }).catch(function(response) {
                console.error('Erro:', response.status, response.data);
            }).finally(function() {
                    console.log("Admin editado.");
            });
        }
    }

    $scope.deletarAdmin = function (id) {
        var resultado = confirm('Tem certeza que deseja deletar?');
        if(resultado === true){
            adminService.deletarAdmin(id).then(function (response){
                if($scope.admins){
                    var index = getIndexSelecionado(id);
                    $scope.admins.splice(index,1);
                }
            }).catch(function(response) {
              console.error('Erro:', response.status, response.data);
            }).finally(function() {
                 console.log("Admin deletado.");
            });
        }
    }

    function getIndexSelecionado(id){
        for (var i = 0; i < $scope.admins.length; i++) {           
            if($scope.admins[i].id === id){
                return i;
            }
        }
    }
});


matrixc.controller('alunoController', function($scope, $location, alunoService, usuarioService) {

    $scope.sexos = ['M', 'F'];

    // é feita a busca de todos os alunos
    if(!$scope.alunos){
        alunoService.obterTodosAlunos().then(function (response){
            $scope.alunos = response.data;
        }).catch(function(response) {
          console.error('Erro:', response.status, response.data);
        }).finally(function() {
             console.log("Alunos listados.");
        });
    }

    // é feita a inserção de um aluno
    $scope.adicionarAluno = function () {

        var alunoParaAdicionar = {nome:$scope.nome,matricula:$scope.matricula,sexo:$scope.sexo};

        if(usuarioService.validarUsuario(alunoParaAdicionar)){
            alunoService.inserirAluno(alunoParaAdicionar).then(function (response){
                $scope.alunos.push(response.data);
                $scope.id = '';
                $scope.nome = '';
                $scope.matricula= '';
                $scope.sexo = '';
            }).catch(function(response) {
              console.error('Erro:', response.status, response.data);
            }).finally(function() {
                 console.log("Aluno adicionado.");
            });
        }
    }

    $scope.selecionarAlunoEditar = function (id) {
        
        var index = getIndexSelecionado(id);
        var aluno = $scope.alunos[index];
        $scope.id = aluno.id;
        $scope.nome = aluno.nome;
        $scope.matricula = aluno.matricula;
        $scope.sexo = aluno.sexo;
    }

    $scope.editarAluno = function () {     
        var index = getIndexSelecionado($scope.id);
        var aluno = $scope.alunos[index];

        aluno.id = $scope.id;
        aluno.nome = $scope.nome;
        aluno.matricula = $scope.matricula;
        aluno.sexo = $scope.sexo;

        if(usuarioService.validarUsuario(aluno)){

            alunoService.editarAluno(aluno).then(function (response){
            }).catch(function(response) {
                console.error('Erro:', response.status, response.data);
            }).finally(function() {
                    console.log("Aluno editado.");
            });
        }
    }

    $scope.deletarAluno = function (id) {
        var resultado = confirm('Tem certeza que deseja deletar?');
        if(resultado === true){
            alunoService.deletarAluno(id).then(function (response){
                if($scope.alunos){
                    var index = getIndexSelecionado(id);
                    $scope.alunos.splice(index,1);
                }
            }).catch(function(response) {
              console.error('Erro:', response.status, response.data);
            }).finally(function() {
                 console.log("Aluno deletado.");
            });
        }
    }

    function getIndexSelecionado(id){
        for (var i = 0; i < $scope.alunos.length; i++) {           
            if($scope.alunos[i].id === id){
                return i;
            }
        }
    }
});

matrixc.controller('coordenadorController', function($scope, $location, coordenadorService, usuarioService) {

    $scope.sexos = ['M', 'F'];

    // é feita a busca de todos os coordenadores
    if(!$scope.coordenadores){
        coordenadorService.obterTodosCoordenadores().then(function (response){
            $scope.coordenadores = response.data;
        }).catch(function(response) {
          console.error('Erro:', response.status, response.data);
        }).finally(function() {
             console.log("Coordenadors listados.");
        });
    }

    // é feita a inserção de um coordenador
    $scope.adicionarCoordenador = function () {

        var coordenadorParaAdicionar = {nome:$scope.nome,matricula:$scope.matricula,sexo:$scope.sexo};

        if(usuarioService.validarUsuario(coordenadorParaAdicionar)){
            coordenadorService.inserirCoordenador(coordenadorParaAdicionar).then(function (response){
                $scope.coordenadores.push(response.data);
                $scope.id = '';
                $scope.nome = '';
                $scope.matricula= '';
                $scope.sexo = '';
            }).catch(function(response) {
              console.error('Erro:', response.status, response.data);
            }).finally(function() {
                 console.log("Coordenador adicionado.");
            });
        }
    }

    $scope.selecionarCoordenadorEditar = function (id) {
        
        var index = getIndexSelecionado(id);
        var coordenador = $scope.coordenadores[index];
        $scope.id = coordenador.id;
        $scope.nome = coordenador.nome;
        $scope.matricula = coordenador.matricula;
        $scope.sexo = coordenador.sexo;
    }

    $scope.editarCoordenador = function () {     
        var index = getIndexSelecionado($scope.id);
        var coordenador = $scope.coordenadores[index];

        coordenador.id = $scope.id;
        coordenador.nome = $scope.nome;
        coordenador.matricula = $scope.matricula;
        coordenador.sexo = $scope.sexo;

        if(usuarioService.validarUsuario(coordenador)){

            coordenadorService.editarCoordenador(coordenador).then(function (response){
            }).catch(function(response) {
                console.error('Erro:', response.status, response.data);
            }).finally(function() {
                    console.log("Coordenador editado.");
            });
        }
    }

    $scope.deletarCoordenador = function (id) {
        var resultado = confirm('Tem certeza que deseja deletar?');
        if(resultado === true){
            coordenadorService.deletarCoordenador(id).then(function (response){
                if($scope.coordenadores){
                    var index = getIndexSelecionado(id);
                    $scope.coordenadores.splice(index,1);
                }
            }).catch(function(response) {
              console.error('Erro:', response.status, response.data);
            }).finally(function() {
                 console.log("Coordenador deletado.");
            });
        }
    }

    function getIndexSelecionado(id){
        for (var i = 0; i < $scope.coordenadores.length; i++) {           
            if($scope.coordenadores[i].id === id){
                return i;
            }
        }
    }
});

matrixc.controller('professorController', function($scope, $location, professorService, usuarioService) {

    $scope.sexos = ['M', 'F'];

    // é feita a busca de todos os professores
    if(!$scope.professores){
        professorService.obterTodosProfessores().then(function (response){
            $scope.professores = response.data;
        }).catch(function(response) {
          console.error('Erro:', response.status, response.data);
        }).finally(function() {
             console.log("Professores listados.");
        });
    }

    // é feita a inserção de um professor
    $scope.adicionarProfessor = function () {

        var professorParaAdicionar = {nome:$scope.nome,matricula:$scope.matricula,sexo:$scope.sexo};

        if(usuarioService.validarUsuario(professorParaAdicionar)){
            professorService.inserirProfessor(professorParaAdicionar).then(function (response){
                $scope.professores.push(response.data);
                $scope.id = '';
                $scope.nome = '';
                $scope.matricula= '';
                $scope.sexo = '';
            }).catch(function(response) {
              console.error('Erro:', response.status, response.data);
            }).finally(function() {
                 console.log("Professor adicionado.");
            });
        }
    }

    $scope.selecionarProfessorEditar = function (id) {
        
        var index = getIndexSelecionado(id);
        var professor = $scope.professores[index];
        $scope.id = professor.id;
        $scope.nome = professor.nome;
        $scope.matricula = professor.matricula;
        $scope.sexo = professor.sexo;
    }

    $scope.editarProfessor = function () {     
        var index = getIndexSelecionado($scope.id);
        var professor = $scope.professores[index];

        professor.id = $scope.id;
        professor.nome = $scope.nome;
        professor.matricula = $scope.matricula;
        professor.sexo = $scope.sexo;

        if(usuarioService.validarUsuario(professor)){

            professorService.editarProfessor(professor).then(function (response){
            }).catch(function(response) {
                console.error('Erro:', response.status, response.data);
            }).finally(function() {
                    console.log("Professor editado.");
            });
        }
    }

    $scope.deletarProfessor = function (id) {
        var resultado = confirm('Tem certeza que deseja deletar?');
        if(resultado === true){
            professorService.deletarProfessor(id).then(function (response){
                if($scope.professores){
                    var index = getIndexSelecionado(id);
                    $scope.professores.splice(index,1);
                }
            }).catch(function(response) {
              console.error('Erro:', response.status, response.data);
            }).finally(function() {
                 console.log("Professor deletado.");
            });
        }
    }

    function getIndexSelecionado(id){
        for (var i = 0; i < $scope.professores.length; i++) {           
            if($scope.professores[i].id === id){
                return i;
            }
        }
    }
});