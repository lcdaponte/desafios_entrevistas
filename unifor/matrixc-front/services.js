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


matrixc.factory("alunoService", function($http){
    function obterTodosAlunos(){
        return $http.get('http://localhost:8080/alunos');
    }

    function inserirAluno(aluno){
        return $http.post('http://localhost:8080/alunos', aluno);
    }

    function editarAluno(aluno){
        return $http.put('http://localhost:8080/alunos/' + aluno.id, aluno);
    }

    function deletarAluno(id){
        return $http.delete('http://localhost:8080/alunos/' + id);
    }

    return {
        obterTodosAlunos: obterTodosAlunos,
        inserirAluno: inserirAluno,
        editarAluno: editarAluno,
        deletarAluno: deletarAluno
    }
});

matrixc.factory("coordenadorService", function($http){
    function obterTodosCoordenadores(){
        return $http.get('http://localhost:8080/coordenador');
    }

    function inserirCoordenador(coordenador){
        return $http.post('http://localhost:8080/coordenador', coordenador);
    }

    function editarCoordenador(coordenador){
        return $http.put('http://localhost:8080/coordenador/' + coordenador.id, coordenador);
    }

    function deletarCoordenador(id){
        return $http.delete('http://localhost:8080/coordenador/' + id);
    }

    return {
        obterTodosCoordenadores: obterTodosCoordenadores,
        inserirCoordenador: inserirCoordenador,
        editarCoordenador: editarCoordenador,
        deletarCoordenador: deletarCoordenador
    }
});

matrixc.factory("professorService", function($http){
    function obterTodosProfessores(){
        return $http.get('http://localhost:8080/professor');
    }

    function inserirProfessor(aluno){
        return $http.post('http://localhost:8080/professor', aluno);
    }

    function editarProfessor(aluno){
        return $http.put('http://localhost:8080/professor/' + aluno.id, aluno);
    }

    function deletarProfessor(id){
        return $http.delete('http://localhost:8080/professor/' + id);
    }

    return {
        obterTodosProfessores: obterTodosProfessores,
        inserirProfessor: inserirProfessor,
        editarProfessor: editarProfessor,
        deletarProfessor: deletarProfessor
    }
});


matrixc.factory("usuarioService", function($http){
    function validarUsuario(usuarioParaValidar){
        var validarSomenteNumeros = new RegExp('^[0-9]+$');
        var validarCaracteres = new RegExp('^[a-zA-Z\s]+$');

        if(usuarioParaValidar.nome === '' || usuarioParaValidar.nome === undefined){
            alert("O campo nome está vazio. Corrija e tente novamente.");
            return false;
        }

        if(!validarCaracteres.test(usuarioParaValidar.nome)){
            alert("O campo nome deve conter apenas caracteres. Corrija e tente novamente.");
            return false;
        }

        if(usuarioParaValidar.matricula === '' || usuarioParaValidar.matricula === undefined){
            alert("O campo matricula está vazio. Corrija e tente novamente.");
            return false;
        }

        if(!validarSomenteNumeros.test(usuarioParaValidar.matricula)){
            alert("O campo matricula deve conter apenas números. Corrija e tente novamente.");
            return false;
        }

        if(usuarioParaValidar.sexo === '' || usuarioParaValidar.sexo === undefined){
            alert("O campo sexo está vazio. Corrija e tente novamente.");
            return false;
        }

        return true;
    }


    return {
        validarUsuario: validarUsuario
    }
});

