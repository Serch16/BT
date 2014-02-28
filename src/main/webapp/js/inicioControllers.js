'use strict';

/* Controllers */

var moduloInicio = angular.module('myApp.inicioControllers', []);



moduloInicio.controller('controlInicioList', function($scope, $routeParams, serverService) {
    $scope.clase = "inicio";
    $scope.accion = "list";


    $scope.numPagina = $routeParams.numpage;
    $scope.nrpp = $routeParams.numrpp;
    $scope.botoneraNrpp = serverService.getNrppBar($scope.clase, $scope.accion, $scope.numPagina, $scope.nrpp);

    $scope.pages = serverService.getPages($scope.clase, $scope.nrpp, null, null, null, null, null, null).then(function(datos5) {
        $scope.pages = datos5['data'];
        if (parseInt($scope.numPagina) > parseInt($scope.pages))
            $scope.numPagina = $scope.pages;
        //$location.path( "#/inicios/" +$scope.pages + "/" + $scope.pages);
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

    $scope.numInicios = serverService.getRegisters($scope.clase).then(function(datos4) {
        $scope.numInicios = datos4['data'];
    });

    $scope.inicios = serverService.getPage($scope.clase, $scope.numPagina, null, null, $scope.nrpp, null, null, null, null, null, null).then(function(datos3) {
        $scope.inicios = datos3['list'];

    });

    $scope.fieldNames = serverService.getFieldNames($scope.clase).then(function(datos6) {
        $scope.fieldNames = datos6['data'];
        $scope.selectedFilterFieldName = null;
    });


    $scope.$watch('numPagina', function() {
        $scope.$broadcast('myApp.construirPagina');
    }, true)

    $scope.$on('myApp.construirPagina', function() {

        $scope.inicios = serverService.getPage($scope.clase, $scope.numPagina, null, null, $scope.nrpp, null, null, null, null, null, null).then(function(datos3) {
            $scope.inicios = datos3['list'];

        });

    })
});

moduloInicio.controller('controlInicioView', function($scope, $routeParams, serverService) {
    $scope.back = function() {
        window.history.back();
    };
    $scope.id = $routeParams.id;
    $scope.objeto = serverService.get('inicio', $scope.id).then(function(datos4) {
        $scope.objeto = datos4;
    });
});


moduloInicio.controller('controlInicioRemove', function($scope, $routeParams, serverService) {
    $scope.result = "";
    $scope.back = function() {
        window.history.back();
    };
    $scope.id = $routeParams.id;
    $scope.objeto = serverService.get('inicio', $scope.id).then(function(datos4) {
        $scope.objeto = datos4;
    });

    $scope.remove = function() {
        $scope.result = serverService.remove('inicio', $scope.id).then(function(datos5) {
            $scope.result = datos5;
        });
    };
});




moduloInicio.controller('controlInicioEdit', function($scope, $routeParams, serverService) {
    $scope.back = function() {
        window.history.back();
    };
    $scope.id = $routeParams.id;
    $scope.objeto = serverService.get('inicio', $scope.id).then(function(datos4) {
        $scope.objeto = datos4;
    });

    $scope.save = function() {
        $scope.result = serverService.save('inicio', $scope.objeto).then(function(datos5) {
            $scope.result = datos5;
        });
    };


});









moduloInicio.controller('MyCtrl2', function($scope) {
    $scope.flores = [{nombre: 'margarita'}, {nombre: 'jazmin'}];
});




moduloInicio.controller('controlInicioCompra', function($scope, $routeParams, serverService) {
    $scope.clase = "compra";
    $scope.accion = "compra";

    $scope.id_inicio = $routeParams.id;
    $scope.numPagina = $routeParams.numpage;
    $scope.nrpp = $routeParams.numrpp;
    $scope.botoneraNrpp = serverService.getNrppBar($scope.clase, $scope.accion, $scope.numPagina, $scope.nrpp);

    $scope.pages = serverService.getPages($scope.clase, $scope.nrpp, null, null, null, null, null, null).then(function(datos5) {
        $scope.pages = datos5['data'];
        if (parseInt($scope.numPagina) > parseInt($scope.pages))
            $scope.numPagina = $scope.pages;
        //$location.path( "#/inicios/" +$scope.pages + "/" + $scope.pages);
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

        $scope.inicios = serverService.getPage($scope.clase, $scope.numPagina, null, null, $scope.nrpp, null, null, null, null, null, null).then(function(datos3) {
            $scope.inicios = datos3['list'];

        });

    })


});