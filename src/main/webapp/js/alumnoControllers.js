'use strict';

/* Controllers */

var moduloAlumno = angular.module('myApp.alumnoControllers', []);



moduloAlumno.controller('controlAlumnoList', function($scope, $routeParams, serverService) {
    $scope.clase = "alumno";
    $scope.accion = "list";


    $scope.numPagina = $routeParams.numpage;
    $scope.nrpp = $routeParams.numrpp;
    $scope.botoneraNrpp = serverService.getNrppBar($scope.clase, $scope.accion, $scope.numPagina, $scope.nrpp);

    $scope.pages = serverService.getPages($scope.clase, $scope.nrpp, null, null, null, null, null, null).then(function(datos5) {
        $scope.pages = datos5['data'];
        if (parseInt($scope.numPagina) > parseInt($scope.pages))
            $scope.numPagina = $scope.pages;
        //$location.path( "#/alumnos/" +$scope.pages + "/" + $scope.pages);
    });

    $scope.$watch('pages', function() {
        $scope.$broadcast('myApp.construirBotoneraPaginas');
    }, true)

    $scope.$on('myApp.construirBotoneraPaginas', function() {

        $scope.botoneraPaginas = serverService.getPaginationBar($scope.clase, $scope.accion, $scope.numPagina, $scope.pages, 2, $scope.nrpp);
    })

    $scope.prettyFieldNames = serverService.getPrettyFieldNames($scope.clase).then(function(datos4) {
        datos4['data'].push('acciones');
        $scope.prettyFieldNames = datos4['data'];
    });

    $scope.numAlumnos = serverService.getRegisters($scope.clase).then(function(datos4) {
        $scope.numAlumnos = datos4['data'];
    });

    $scope.alumnos = serverService.getPage($scope.clase, $scope.numPagina, null, null, $scope.nrpp, null, null, null, null, null, null).then(function(datos3) {
        $scope.alumnos = datos3['list'];

    });

    $scope.fieldNames = serverService.getFieldNames($scope.clase).then(function(datos6) {
        $scope.fieldNames = datos6['data'];
        $scope.selectedFilterFieldName = null;
    });


    $scope.$watch('numPagina', function() {
        $scope.$broadcast('myApp.construirPagina');
    }, true)

    $scope.$on('myApp.construirPagina', function() {

        $scope.alumnos = serverService.getPage($scope.clase, $scope.numPagina, null, null, $scope.nrpp, null, null, null, null, null, null).then(function(datos3) {
            $scope.alumnos = datos3['list'];

        });

    })
});

moduloAlumno.controller('controlAlumnoView', function($scope, $routeParams, serverService) {
    $scope.back = function() {
        window.history.back();
    };
    $scope.id = $routeParams.id;
    $scope.objeto = serverService.get('alumno', $scope.id).then(function(datos4) {
        $scope.objeto = datos4;
    });

    $scope.provincias = serverService.getPage("provincia", $scope.numPagina, null, null, 52, null, null, null, null, null, null).then(function(datos3) {
        $scope.provincias = datos3['list'];
    });

    $scope.familias = serverService.getPage("familia", $scope.numPagina, null, null, 4, null, null, null, null, null, null).then(function(datos3) {
        $scope.familias = datos3['list'];
    });
});


moduloAlumno.controller('controlAlumnoRemove', function($scope, $routeParams, serverService) {
    $scope.result = "";
    $scope.back = function() {
        window.history.back();
    };
    $scope.id = $routeParams.id;
    $scope.objeto = serverService.get('alumno', $scope.id).then(function(datos4) {
        $scope.objeto = datos4;
    });

    $scope.remove = function() {
        $scope.result = serverService.remove('alumno', $scope.id).then(function(datos5) {
            $scope.result = datos5;
        });
    };
});




moduloAlumno.controller('controlAlumnoEdit', function($scope, $routeParams, serverService) {
    $scope.back = function() {
        window.history.back();
    };
    $scope.id = $routeParams.id;
    $scope.objeto = serverService.get('alumno', $scope.id).then(function(datos4) {
        $scope.objeto = datos4;
    });

    $scope.save = function() {
        $scope.result = serverService.save('alumno', $scope.objeto).then(function(datos5) {
            $scope.result = datos5;
        });
    };

    $scope.provincias = serverService.getPage("provincia", $scope.numPagina, null, null, 52, null, null, null, null, null, null).then(function(datos3) {
        $scope.provincias = datos3['list'];
    });

});









moduloAlumno.controller('MyCtrl2', function($scope) {
    $scope.flores = [{nombre: 'margarita'}, {nombre: 'jazmin'}];
});




moduloAlumno.controller('controlAlumnoCompra', function($scope, $routeParams, serverService) {
    $scope.clase = "compra";
    $scope.accion = "compra";

    $scope.id_alumno = $routeParams.id;
    $scope.numPagina = $routeParams.numpage;
    $scope.nrpp = $routeParams.numrpp;
    $scope.botoneraNrpp = serverService.getNrppBar($scope.clase, $scope.accion, $scope.numPagina, $scope.nrpp);

    $scope.pages = serverService.getPages($scope.clase, $scope.nrpp, null, null, null, null, null, null).then(function(datos5) {
        $scope.pages = datos5['data'];
        if (parseInt($scope.numPagina) > parseInt($scope.pages))
            $scope.numPagina = $scope.pages;
        //$location.path( "#/alumnos/" +$scope.pages + "/" + $scope.pages);
    });

    $scope.$watch('pages', function() {
        $scope.$broadcast('myApp.construirBotoneraPaginas');
    }, true)

    $scope.$on('myApp.construirBotoneraPaginas', function() {

        $scope.botoneraPaginas = serverService.getPaginationBar($scope.clase, $scope.accion, $scope.numPagina, $scope.pages, 2, $scope.nrpp);
    })

//    $scope.prettyFieldNames = serverService.getPrettyFieldNames($scope.clase).then(function(datos4) {
//        datos4['data'].push('acciones');
//        $scope.prettyFieldNames = datos4['data'];
//    });

    $scope.objeto = serverService.getPage($scope.clase, $scope.numPagina, null, null, $scope.nrpp, null, null, null, null, null, null).then(function(datos3) {
        $scope.objeto = datos3['list'];
    });

    $scope.fieldNames = serverService.getFieldNames($scope.clase).then(function(datos6) {
        $scope.fieldNames = datos6['data'];
        $scope.selectedFilterFieldName = null;
    });


    $scope.$watch('numPagina', function() {
        $scope.$broadcast('myApp.construirPagina');
    }, true)

    $scope.$on('myApp.construirPagina', function() {

        $scope.alumnos = serverService.getPage($scope.clase, $scope.numPagina, null, null, $scope.nrpp, null, null, null, null, null, null).then(function(datos3) {
            $scope.alumnos = datos3['list'];

        });

    })


});